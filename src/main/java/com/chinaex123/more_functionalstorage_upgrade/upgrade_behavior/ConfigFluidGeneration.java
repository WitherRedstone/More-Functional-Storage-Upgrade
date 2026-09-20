package com.chinaex123.more_functionalstorage_upgrade.upgrade_behavior;

import com.buuz135.functionalstorage.block.tile.ControllableDrawerTile;
import com.buuz135.functionalstorage.item.component.FunctionalUpgradeBehavior;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

import java.util.List;

/**
 * 流体生成升级行为
 * <p>
 * 实现 FunctionalUpgradeBehavior，为功能性存储的抽屉提供流体生成能力。
 * 按配置的间隔时间，向抽屉本身或上方容器填充指定量的流体。
 * 通过记录类（record）持有流体类型、每次生成量与生成间隔三项配置。
 *
 * @param fluid        要生成的流体
 * @param amountPerTick 每次生成的流体量（mB）
 * @param interval     生成间隔（tick）
 */
public record ConfigFluidGeneration(FluidStack fluid, int amountPerTick, int interval) implements FunctionalUpgradeBehavior {

    /** 升级行为的编解码器，定义各配置字段的序列化方式 */
    public static final MapCodec<ConfigFluidGeneration> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    FluidStack.CODEC.fieldOf("fluid").forGetter(ConfigFluidGeneration::fluid),
                    Codec.INT.fieldOf("amountPerTick").orElse(100).forGetter(ConfigFluidGeneration::amountPerTick),
                    Codec.INT.fieldOf("interval").orElse(20).forGetter(ConfigFluidGeneration::interval)
            ).apply(instance, ConfigFluidGeneration::new));

    /**
     * 执行流体生成逻辑。
     * <p>
     * 此方法负责在指定间隔时间内生成流体，并将其填充到合适的容器中。
     * 优先填充抽屉本身，其次检查上方容器的流体处理能力。
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
        if (level.isClientSide || level.getGameTime() % interval != 0) {
            return;
        }

        // 首先检查抽屉本身是否有流体处理能力
        var drawerCapability = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
        if (drawerCapability != null) {
            drawerCapability.fill(fluid.copy(), IFluidHandler.FluidAction.EXECUTE);
        } else {
            // 抽屉本身无流体能力时，尝试填充上方容器
            var aboveCapability = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, Direction.UP);
            if (aboveCapability != null) {
                aboveCapability.fill(fluid.copy(), IFluidHandler.FluidAction.EXECUTE);
            }
        }
    }

    /**
     * 获取该升级行为的编解码器。
     *
     * @return 升级行为的编解码器
     */
    @Override
    public MapCodec<? extends FunctionalUpgradeBehavior> codec() {
        return CODEC;
    }

    /**
     * 获取流体生成升级的工具提示信息。
     * <p>
     * 此方法扩展了父类的工具提示功能，添加了特定于流体生成的信息，
     * 显示每次生成的流体量和流体名称。
     *
     * @return 包含工具提示信息的组件列表
     */
    @Override
    public List<Component> getTooltip() {
        var list = FunctionalUpgradeBehavior.super.getTooltip();
        list.add(Component.translatable("moreupgrade.desc.fluid_generation",
                amountPerTick,
                fluid.getHoverName().getString()));
        return list;
    }
}