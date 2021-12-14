package com.itayfeder.restored_earth.client.gui.screen;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.utils.JournalEntry;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ChangePageButton;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;
import java.util.List;

public class JournalScreen extends Screen {
    public static final ResourceLocation BOOK_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/gui/journal.png");
    private int currentPage;
    private int cachedPage = -1;
    private ITextComponent pageMsg = StringTextComponent.EMPTY;
    private ChangePageButton forwardButton;
    private ChangePageButton backButton;
    private final boolean playTurnSound;
    private final World world;

    public JournalScreen(World world, boolean p_i51099_2_) {
        super(NarratorChatListener.NO_TITLE);
        this.world = world;
        this.playTurnSound = p_i51099_2_;
        this.currentPage = MathHelper.clamp(this.currentPage, 0, getPageCount());
        this.cachedPage = -1;
    }

    public static void open(World world) {
        Minecraft.getInstance().setScreen(new JournalScreen(world, true));
    }

    public boolean setPage(int p_214160_1_) {
        int i = MathHelper.clamp(p_214160_1_, 0, getPageCount() - 1);
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
        this.addButton(new Button(this.width / 2 - 100, 196, 200, 20, DialogTexts.GUI_DONE, (p_214161_1_) -> {
            this.minecraft.setScreen((Screen)null);
        }));
    }

    protected void createPageControlButtons() {
        int i = (this.width - 192) / 2;
        int j = 2;
        this.forwardButton = this.addButton(new ChangePageButton(i + 116, 159, true, (p_214159_1_) -> {
            this.pageForward();
        }, this.playTurnSound));
        this.backButton = this.addButton(new ChangePageButton(i + 43, 159, false, (p_214158_1_) -> {
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

    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(p_230430_1_);
        float xMouse = (float) p_230430_2_;
        float yMouse = (float) p_230430_3_;

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(BOOK_LOCATION);
        int i = (this.width - 192) / 2;
        int j = 2;
        this.blit(p_230430_1_, i, 2, 0, 0, 192, 192);
        if (this.cachedPage != this.currentPage) {
            this.pageMsg = new TranslationTextComponent("book.pageIndicator", this.currentPage + 1, Math.max(getPageCount(), 1));
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
        this.font.draw(p_230430_1_, new StringTextComponent("Name: " + getName("entity.restored_earth." + type.getRegistryName().getPath())), (float) (i + 36), (float) (32 + 8 * 9), 0);
        this.font.draw(p_230430_1_, new StringTextComponent(
                "Health: " + (GlobalEntityTypeAttributes.getSupplier(type).getValue(Attributes.MAX_HEALTH)/2) + "\uF900"
        ), (float) (i + 36), (float) (32 + 9 * 9), 0);
        this.font.draw(p_230430_1_, new StringTextComponent("Family: " + getName("entity.minecraft." + family.getRegistryName().getPath())), (float) (i + 36), (float) (32 + 10 * 9), 0);
        this.renderFloatingItem(new ItemStack(egg), (i + 40), (32 + 6 * 9), null);
        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
    }

    private String getName(String str) {
        LanguageMap languagemap = LanguageMap.getInstance();
        return languagemap.getOrDefault(str);
    }

    public boolean mouseClicked(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
        return super.mouseClicked(p_231044_1_, p_231044_3_, p_231044_5_);
    }

    public boolean handleComponentClicked(Style p_230455_1_) {
        ClickEvent clickevent = p_230455_1_.getClickEvent();
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
            boolean flag = super.handleComponentClicked(p_230455_1_);
            if (flag && clickevent.getAction() == ClickEvent.Action.RUN_COMMAND) {
                this.minecraft.setScreen((Screen)null);
            }

            return flag;
        }
    }

    private void renderFloatingItem(ItemStack p_146982_1_, int p_146982_2_, int p_146982_3_, String p_146982_4_) {
        RenderSystem.translatef(0.0F, 0.0F, 32.0F);
        this.setBlitOffset(200);
        this.itemRenderer.blitOffset = 200.0F;
        net.minecraft.client.gui.FontRenderer font = p_146982_1_.getItem().getFontRenderer(p_146982_1_);
        if (font == null) font = this.font;
        this.itemRenderer.renderAndDecorateItem(p_146982_1_, p_146982_2_, p_146982_3_);
        this.itemRenderer.renderGuiItemDecorations(font, p_146982_1_, p_146982_2_, p_146982_3_, p_146982_4_);
        this.setBlitOffset(0);
        this.itemRenderer.blitOffset = 0.0F;
    }
}
