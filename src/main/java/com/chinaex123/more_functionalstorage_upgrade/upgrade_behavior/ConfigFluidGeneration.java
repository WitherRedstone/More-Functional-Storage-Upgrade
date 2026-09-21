package com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior;

import com.buuz135.functionalstorage.block.tile.ControllableDrawerTile;
import com.buuz135.functionalstorage.item.component.FunctionalUpgradeBehavior;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;

import java.util.List;

/**
 * 流体生成升级行为
 * <p>
 * 实现 FunctionalUpgradeBehavior，为功能性存储的抽屉提供流体生成能力。
 * 按配置的间隔时间，向抽屉本身或上方容器填充指定量的流体。
 * <p>
 * 注意：这里保存的是流体 ID 字符串而不是 FluidStack，
 * 因为 1.21.2+ 在 RegisterEvent 阶段不允许构造 FluidStack
 * （会访问 Holder.components() 触发 "Components not bound yet"）。
 *
 * @param fluidId       要生成的流体 ID
 * @param amountPerTick 每次生成的流体量（mB）
 * @param interval      生成间隔（tick）
 */
public record ConfigFluidGeneration(String fluidId, int amountPerTick, int interval) implements FunctionalUpgradeBehavior {

    /** 升级行为的编解码器，定义各配置字段的序列化方式 */
    public static final MapCodec<ConfigFluidGeneration> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Codec.STRING.fieldOf("fluid").forGetter(ConfigFluidGeneration::fluidId),
                    Codec.INT.fieldOf("amountPerTick").orElse(100).forGetter(ConfigFluidGeneration::amountPerTick),
                    Codec.INT.fieldOf("interval").orElse(20).forGetter(ConfigFluidGeneration::interval)
            ).apply(instance, ConfigFluidGeneration::new));

    /**
     * 运行时解析得到 FluidStack（此时组件已绑定）。
     *
     * @return 对应流体的 FluidStack
     */
    private FluidStack resolveFluid() {
        var holder = BuiltInRegistries.FLUID.get(Identifier.parse(fluidId))
                .orElseThrow(() -> new IllegalArgumentException("Unknown fluid: " + fluidId));
        return new FluidStack(holder, amountPerTick);
    }

    /**
     * 执行流体生成逻辑。
     *
     * @param level        游戏世界对象
     * @param pos          抽屉方块的位置
     * @param drawer       可控制的抽屉方块实体
     * @param upgradeStack 升级物品堆栈
     * @param upgradeSlot  升级槽位索引
     */
    @Override
    public void work(Level level, BlockPos pos, ControllableDrawerTile<?> drawer, ItemStack upgradeStack, int upgradeSlot) {
        // 仅在服务端且到达生成间隔时执行
        if (level.isClientSide() || level.getGameTime() % interval != 0) {
            return;
        }

        var fluid = resolveFluid();

        // 首先检查抽屉本身是否有流体处理能力
        var drawerCapability = level.getCapability(Capabilities.Fluid.BLOCK, pos, null);
        if (drawerCapability != null) {
            try (var tx = Transaction.openRoot()) {
                drawerCapability.insert(FluidResource.of(fluid.copy()), fluid.getAmount(), tx);
                tx.commit();
            }
        } else {
            // 抽屉本身无流体能力时，尝试填充上方容器
            var aboveCapability = level.getCapability(Capabilities.Fluid.BLOCK, pos, Direction.UP);
            if (aboveCapability != null) {
                try (var tx = Transaction.openRoot()) {
                    aboveCapability.insert(FluidResource.of(fluid.copy()), fluid.getAmount(), tx);
                    tx.commit();
                }
            }
        }
    }

    @Override
    public MapCodec<? extends FunctionalUpgradeBehavior> codec() {
        return CODEC;
    }

    /**
     * 获取流体生成升级的工具提示信息。
     * <p>
     * 此方法在客户端渲染 tooltip 时调用，那时组件已绑定，可以安全地构造 FluidStack。
     */
    @Override
    public List<Component> getTooltip() {
        var list = FunctionalUpgradeBehavior.super.getTooltip();
        var fluid = resolveFluid();
        list.add(Component.translatable("moreupgrade.desc.fluid_generation",
                amountPerTick,
                fluid.getHoverName().getString()));
        return list;
    }
}