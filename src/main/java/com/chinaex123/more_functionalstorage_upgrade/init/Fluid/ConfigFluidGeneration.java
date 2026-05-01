package com.chinaex123.more_functionalstorage_upgrade.register.Fluid;

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

public record ConfigFluidGeneration(FluidStack fluid, int amountPerTick, int interval)
        implements FunctionalUpgradeBehavior {

    public static final MapCodec<ConfigFluidGeneration> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    FluidStack.CODEC.fieldOf("fluid").forGetter(ConfigFluidGeneration::fluid),
                    Codec.INT.fieldOf("amountPerTick").orElse(100).forGetter(ConfigFluidGeneration::amountPerTick),
                    Codec.INT.fieldOf("interval").orElse(20).forGetter(ConfigFluidGeneration::interval)
            ).apply(instance, ConfigFluidGeneration::new));

    /**
     * 执行流体生成逻辑
     *
     * @param level 游戏世界对象
     * @param pos 抽屉方块的位置
     * @param drawer 可控制的抽屉方块实体
     * @param upgradeStack 升级物品堆栈
     * @param upgradeSlot 升级槽位索引
     * <p>
     * 此方法负责在指定间隔时间内生成流体，并将其填充到合适的容器中。
     * 优先填充抽屉本身，其次检查上方容器的流体处理能力。
     */
    @Override
    public void work(Level level, BlockPos pos, ControllableDrawerTile<?> drawer,
                     ItemStack upgradeStack, int upgradeSlot) {
        if (level.isClientSide || level.getGameTime() % interval != 0) {
            return;
        }

        // 首先检查抽屉本身是否有流体处理能力
        var drawerCapability = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
        if (drawerCapability != null) {
            drawerCapability.fill(fluid.copy(), IFluidHandler.FluidAction.EXECUTE);
        } else {
            var aboveCapability = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, Direction.UP);
            if (aboveCapability != null) {
                aboveCapability.fill(fluid.copy(), IFluidHandler.FluidAction.EXECUTE);
            }
        }
    }

    @Override
    public MapCodec<? extends FunctionalUpgradeBehavior> codec() {
        return CODEC;
    }

    /**
     * 获取流体生成升级的工具提示信息
     *
     * @return List<Component> 包含工具提示信息的组件列表
     * <p>
     * 此方法扩展了父类的工具提示功能，添加了特定于流体生成的信息，
     * 显示每次生成的流体量和流体名称。
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