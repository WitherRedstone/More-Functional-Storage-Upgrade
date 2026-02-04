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

    @Override
    public List<Component> getTooltip() {
        var list = FunctionalUpgradeBehavior.super.getTooltip();
        list.add(Component.translatable("moreupgrade.desc.fluid_generation",
                amountPerTick, // 每次生成时的流体量
                fluid.getHoverName().getString()));
        return list;
    }
}