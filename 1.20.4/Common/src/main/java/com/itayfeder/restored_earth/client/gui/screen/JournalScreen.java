package com.itayfeder.restored_earth.client.gui.screen;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.utils.JournalEntry;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Collections;
import java.util.List;

public class JournalScreen extends Screen {
    public static final ResourceLocation BOOK_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/gui/journal.png");
    private int currentPage;
    private int cachedPage = -1;
    private Component pageMsg = TextComponent.EMPTY;
    private PageButton forwardButton;
    private PageButton backButton;
    private final boolean playTurnSound;
    private final Level world;

    public JournalScreen(Level world, boolean p_i51099_2_) {
        super(NarratorChatListener.NO_TITLE);
        this.world = world;
        this.playTurnSound = p_i51099_2_;
        this.currentPage = Mth.clamp(this.currentPage, 0, getPageCount());
        this.cachedPage = -1;
    }

    public static void open(Level world) {
        Minecraft.getInstance().setScreen(new JournalScreen(world, true));
    }

    public boolean setPage(int p_214160_1_) {
        int i = Mth.clamp(p_214160_1_, 0, getPageCount() - 1);
        if (i != this.currentPage) {
            this.currentPage = i;
            this.updateButtonVisibility();
            this.cachedPage = -1;
            return true;
        } else {
            return false;
        }
    }

    protected boolean forcePage(int p_214153_1_) {
        return this.setPage(p_214153_1_);
    }

    protected void init() {
        this.createMenuControls();
        this.createPageControlButtons();
    }

    protected void createMenuControls() {
        this.addRenderableWidget(new Button(this.width / 2 - 100, 196, 200, 20, CommonComponents.GUI_DONE, (p_214161_1_) -> {
            this.minecraft.setScreen((Screen)null);
        }));
    }

    protected void createPageControlButtons() {
        int i = (this.width - 192) / 2;
        int j = 2;
        this.forwardButton = this.addRenderableWidget(new PageButton(i + 116, 159, true, (p_214159_1_) -> {
            this.pageForward();
        }, this.playTurnSound));
        this.backButton = this.addRenderableWidget(new PageButton(i + 43, 159, false, (p_214158_1_) -> {
            this.pageBack();
        }, this.playTurnSound));
        this.updateButtonVisibility();
    }

    protected void pageBack() {
        if (this.currentPage > 0) {
            --this.currentPage;
        }

        this.updateButtonVisibility();
    }

    protected void pageForward() {
        if (this.currentPage < this.getPageCount() - 1) {
            ++this.currentPage;
        }

        this.updateButtonVisibility();
    }


    private void updateButtonVisibility() {
        this.forwardButton.visible = this.currentPage < this.getPageCount() - 1;
        this.backButton.visible = this.currentPage > 0;
    }

    private static int getPageCount() {
        return EntityInit.JOURNAL_ENTRIES.length;
    }

    public boolean keyPressed(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
        if (super.keyPressed(p_231046_1_, p_231046_2_, p_231046_3_)) {
            return true;
        } else {
            switch(p_231046_1_) {
                case 266:
                    this.backButton.onPress();
                    return true;
                case 267:
                    this.forwardButton.onPress();
                    return true;
                default:
                    return false;
            }
        }
    }

    public void render(PoseStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(p_230430_1_);
        float xMouse = (float) p_230430_2_;
        float yMouse = (float) p_230430_3_;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BOOK_LOCATION);
        int i = (this.width - 192) / 2;
        int j = 2;
        this.blit(p_230430_1_, i, 2, 0, 0, 192, 192);
        if (this.cachedPage != this.currentPage) {
            this.pageMsg = new TranslatableComponent("book.pageIndicator", this.currentPage + 1, Math.max(getPageCount(), 1));
        }

        this.cachedPage = this.currentPage;
        int i1 = this.font.width(this.pageMsg);
        this.font.draw(p_230430_1_, this.pageMsg, (float) (i - i1 + 192 - 44), 18.0F, 0);

        //this.font.draw(p_230430_1_, ireorderingprocessor, (float)(i + 36), (float)(32 + 3 * 9), 0);
        float animalWidth = (this.width / 2) - 4;
        float animalHeight = (32 + 6 * 9);
        JournalEntry entry = EntityInit.JOURNAL_ENTRIES[this.currentPage];
        EntityType type = entry.type;
        float size = entry.size;
        EntityType family = entry.family;
        Item egg = entry.egg;
        InventoryScreen.renderEntityInInventory((int) animalWidth, (int) animalHeight, (int) size, (float) animalWidth - xMouse, (float) animalHeight - yMouse, (LivingEntity) type.create(this.world));
        this.font.draw(p_230430_1_, new TextComponent("Name: " + getName("entity.restored_earth." + type.getRegistryName().getPath())), (float) (i + 36), (float) (32 + 8 * 9), 0);
        this.font.draw(p_230430_1_, new TextComponent(
                "Health: " + (DefaultAttributes.getSupplier(type).getValue(Attributes.MAX_HEALTH)/2) + "\uF900"
        ), (float) (i + 36), (float) (32 + 9 * 9), 0);
        this.font.draw(p_230430_1_, new TextComponent("Family: " + getName("entity.minecraft." + family.getRegistryName().getPath())), (float) (i + 36), (float) (32 + 10 * 9), 0);
        this.renderFloatingItem(new ItemStack(egg), (i + 40), (32 + 6 * 9), null);

        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
    }

    private String getName(String str) {
        Language language = Language.getInstance();
        return language.getOrDefault(str);
    }

    public boolean mouseClicked(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
        return super.mouseClicked(p_231044_1_, p_231044_3_, p_231044_5_);
    }

    public boolean handleComponentClicked(Style p_98293_) {
        ClickEvent clickevent = p_98293_.getClickEvent();
        if (clickevent == null) {
            return false;
        } else if (clickevent.getAction() == ClickEvent.Action.CHANGE_PAGE) {
            String s = clickevent.getValue();

            try {
                int i = Integer.parseInt(s) - 1;
                return this.forcePage(i);
            } catch (Exception exception) {
                return false;
            }
        } else {
            boolean flag = super.handleComponentClicked(p_98293_);
            if (flag && clickevent.getAction() == ClickEvent.Action.RUN_COMMAND) {
                this.closeScreen();
            }

            return flag;
        }
    }

    protected void closeScreen() {
        this.minecraft.setScreen((Screen)null);
    }

    private void renderFloatingItem(ItemStack p_97783_, int p_97784_, int p_97785_, String p_97786_) {
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.translate(0.0D, 0.0D, 32.0D);
        RenderSystem.applyModelViewMatrix();
        this.setBlitOffset(200);
        this.itemRenderer.blitOffset = 200.0F;
        net.minecraft.client.gui.Font font = net.minecraftforge.client.RenderProperties.get(p_97783_).getFont(p_97783_);
        if (font == null) font = this.font;
        this.itemRenderer.renderAndDecorateItem(p_97783_, p_97784_, p_97785_);
        this.itemRenderer.renderGuiItemDecorations(font, p_97783_, p_97784_, p_97785_ - 0, p_97786_);
        this.setBlitOffset(0);
        this.itemRenderer.blitOffset = 0.0F;
    }
}
