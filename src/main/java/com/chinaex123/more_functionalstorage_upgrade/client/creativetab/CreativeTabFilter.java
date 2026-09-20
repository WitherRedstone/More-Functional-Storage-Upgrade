package com.chinaex123.more_functionalstorage_upgrade.client.creativetab;

import com.chinaex123.more_functionalstorage_upgrade.MoreFunctionalStorageUpgrade;
import com.chinaex123.more_functionalstorage_upgrade.init.ModCreativeTabs;
import com.chinaex123.more_functionalstorage_upgrade.init.CustomUpgradeItem;
import com.chinaex123.more_functionalstorage_upgrade.mixins.accessor.CreativeModeInventoryScreenAccessor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 创造模式物品栏分类过滤器。
 * <p>
 * 在本模组的创造模式标签页打开时，于界面左侧添加分类按钮，
 * 用于在“基础物品”与“机械动力兼容物品”之间切换显示内容。
 * 仅在客户端生效，通过事件订阅自动注册。
 */
@EventBusSubscriber(modid = MoreFunctionalStorageUpgrade.MOD_ID, value = Dist.CLIENT)
public class CreativeTabFilter {
    /** 创造模式标签页按钮纹理位置 */
    private static final ResourceLocation VANILLA_TABS = MoreFunctionalStorageUpgrade.id("textures/gui/container/creative_inventory/tabs.png");

    /** 当前界面上的分类按钮列表 */
    private static final List<FilterButton> BUTTONS = new ArrayList<>();
    /** 上次记录的选中标签页，用于检测标签页切换 */
    private static CreativeModeTab lastTab;
    /** 当前选中的分类 */
    private static Category selectedCategory = Category.BASE;

    /**
     * 界面初始化时创建分类按钮。
     * <p>
     * 仅在本模组标签页生效，按钮位于界面左侧。
     *
     * @param event 界面初始化事件
     */
    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (!(event.getScreen() instanceof CreativeModeInventoryScreen screen)) {
            return;
        }
        BUTTONS.clear();
        int x = screen.getGuiLeft() - 28;
        int top = screen.getGuiTop();
        BUTTONS.add(new FilterButton(x, top + 17, Category.BASE));
        BUTTONS.add(new FilterButton(x, top + 44, Category.CREATE_COMPAT));
        BUTTONS.forEach(event::addListener);
        onSwitchTab(CreativeModeInventoryScreenAccessor.mfu$getSelectedTab(), screen);
    }

    /**
     * 界面渲染时检测标签页切换。
     * <p>
     * 若当前选中的标签页与上次记录不同，则更新按钮可见性并刷新物品列表。
     *
     * @param event 界面渲染事件
     */
    @SubscribeEvent
    public static void onScreenRender(ScreenEvent.Render.Post event) {
        if (!(event.getScreen() instanceof CreativeModeInventoryScreen screen)) {
            return;
        }
        CreativeModeTab tab = CreativeModeInventoryScreenAccessor.mfu$getSelectedTab();
        if (lastTab != tab) {
            onSwitchTab(tab, screen);
            lastTab = tab;
        }
    }

    /**
     * 处理标签页切换。
     * <p>
     * 根据是否为本模组标签页设置按钮可见性，并在是本模组标签页时刷新物品列表。
     *
     * @param tab    当前标签页
     * @param screen 创造模式物品栏界面
     */
    private static void onSwitchTab(CreativeModeTab tab, CreativeModeInventoryScreen screen) {
        boolean isOurTab = tab == ModCreativeTabs.MORE_FUNCTIONALSTORAGE_UPGRADE_TAB.get();
        BUTTONS.forEach(button -> button.visible = isOurTab);
        if (isOurTab) {
            refreshItems(screen);
        }
    }

    /**
     * 切换选中的分类并刷新物品列表。
     *
     * @param category 目标分类
     */
    private static void select(Category category) {
        selectedCategory = category;
        if (Minecraft.getInstance().screen instanceof CreativeModeInventoryScreen screen) {
            refreshItems(screen);
        }
    }

    /**
     * 刷新界面中的物品列表为当前分类的内容。
     *
     * @param screen 创造模式物品栏界面
     */
    private static void refreshItems(CreativeModeInventoryScreen screen) {
        NonNullList<ItemStack> items = screen.getMenu().items;
        items.clear();
        for (ItemStack stack : selectedCategory.items) {
            items.add(stack.copy());
        }
        screen.getMenu().scrollTo(0);
    }

    /**
     * 分类枚举。
     * <p>
     * BASE 表示基础物品，CREATE_COMPAT 表示机械动力兼容物品。
     * 每个分类持有对应的物品列表、图标与标题。
     */
    private enum Category {
        BASE(ModCreativeTabs.BASE_ITEMS,
                () -> new ItemStack(CustomUpgradeItem.NETHER_STAR_UPGRADE.get()),
                Component.translatable("gui.more_functionalstorage_upgrade.filter.base")),
        CREATE_COMPAT(ModCreativeTabs.INTEGRATION_ITEMS,
                () -> new ItemStack(CustomUpgradeItem.COBBLESTONE_GENERATOR_UPGRADE_1.get()),
                Component.translatable("gui.more_functionalstorage_upgrade.filter.mod_integration"));

        /** 该分类包含的物品列表 */
        private final NonNullList<ItemStack> items;
        /** 该分类的图标提供者 */
        private final Supplier<ItemStack> icon;
        /** 该分类的显示标题 */
        private final Component title;

        /**
         * 构造分类。
         *
         * @param items 物品列表
         * @param icon  图标提供者
         * @param title 显示标题
         */
        Category(NonNullList<ItemStack> items, Supplier<ItemStack> icon, Component title) {
            this.items = items;
            this.icon = icon;
            this.title = title;
        }
    }

    /**
     * 分类过滤按钮。
     * <p>
     * 使用原版标签页纹理绘制，选中时使用不同纹理区域，
     * 并显示对应分类的图标与提示。
     */
    private static class FilterButton extends Button {

        /** 该按钮对应的分类 */
        private final Category category;

        /**
         * 构造分类过滤按钮。
         *
         * @param x        按钮 X 坐标
         * @param y        按钮 Y 坐标
         * @param category 对应分类
         */
        protected FilterButton(int x, int y, Category category) {
            super(x, y, 32, 26, CommonComponents.EMPTY, button -> select(category), DEFAULT_NARRATION);
            this.category = category;
            this.setTooltip(Tooltip.create(category.title));
        }

        /**
         * 渲染按钮。
         * <p>
         * 根据是否选中决定纹理区域，绘制旋转纹理后叠加分类图标。
         *
         * @param graphics     图形上下文
         * @param mouseX       鼠标 X 坐标
         * @param mouseY       鼠标 Y 坐标
         * @param partialTicks 部分 tick 插值
         */
        @Override
        public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
            boolean active = selectedCategory == this.category;
            int textureX = 26;
            int textureY = active ? 32 : 0;
            int textureWidth = active ? 32 : 28;
            int textureHeight = 26;
            RenderSystem.setShaderTexture(0, VANILLA_TABS);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
            this.drawRotatedTexture(graphics.pose().last().pose(), this.getX(), this.getY(),
                    textureX, textureY, textureWidth, textureHeight);
            graphics.renderItem(this.category.icon.get(), this.getX() + 8, this.getY() + 5);
        }

        /**
         * 绘制旋转后的纹理。
         * <p>
         * 手动构建顶点缓冲，将纹理旋转 90 度后绘制到指定位置。
         *
         * @param matrix4f      变换矩阵
         * @param x             绘制 X 坐标
         * @param y             绘制 Y 坐标
         * @param textureX      纹理起始 X 坐标
         * @param textureY      纹理起始 Y 坐标
         * @param textureWidth  纹理宽度
         * @param textureHeight 纹理高度
         */
        private void drawRotatedTexture(Matrix4f matrix4f, int x, int y,
                                        int textureX, int textureY,
                                        int textureWidth, int textureHeight) {
            float scaleX = 1f / 256;
            float scaleY = 1f / 256;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);

            BufferBuilder builder = Tesselator.getInstance().begin(
                    VertexFormat.Mode.QUADS,
                    DefaultVertexFormat.POSITION_TEX
            );

            // 按旋转后的顺序添加四个顶点及其 UV 坐标
            builder.addVertex(matrix4f, x, y + textureHeight, 0)
                    .setUv((textureX + textureHeight) * scaleX, textureY * scaleY);
            builder.addVertex(matrix4f, x + textureWidth, y + textureHeight, 0)
                    .setUv((textureX + textureHeight) * scaleX, (textureY + textureWidth) * scaleY);
            builder.addVertex(matrix4f, x + textureWidth, y, 0)
                    .setUv(textureX * scaleX, (textureY + textureWidth) * scaleY);
            builder.addVertex(matrix4f, x, y, 0)
                    .setUv(textureX * scaleX, textureY * scaleY);

            BufferUploader.drawWithShader(builder.buildOrThrow());
        }
    }
}