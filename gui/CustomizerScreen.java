package com.texturecustomizer.gui;

import com.texturecustomizer.categories.TextureCategory;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class CustomizerScreen extends Screen {

    private TextureCategory selectedCategory = TextureCategory.ARMOR_GEAR;

    public CustomizerScreen() {
        super(Text.literal("02MAX | TEXTURE STYLES"));
    }

    @Override
    protected void init() {
        super.init();

        // Done Button unten rechts (wie im Referenzbild)
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Done"), button -> this.close())
                .dimensions(this.width - 110, this.height - 35, 90, 20)
                .build());

        // Settings Button oben rechts
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Settings"), button -> {})
                .dimensions(this.width - 110, 15, 90, 20)
                .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Semi-transparenter dunkler Glas-Hintergrund
        context.fillGradient(0, 0, this.width, this.height, 0xD00A0A0E, 0xE0050508);

        // Header Label "02MAX | TEXTURE STYLES"
        context.drawTextWithShadow(this.textRenderer, "02MAX", 20, 18, 0xFFFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "| TEXTURE STYLES", 65, 18, 0x88AAAAAA);

        // Aktuelle Kategorie & Untertitel
        context.drawTextWithShadow(this.textRenderer, selectedCategory.getDisplayName(), 20, 50, 0xFFFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "- Default", 120, 50, 0x88AAAAAA);

        // Kacheln-Grid (Rüstungen / Carts / Texturen)
        int cols = 9;
        int gridStartX = 20;
        int gridStartY = 75;
        int tileWidth = 72;
        int tileHeight = 85;
        int spacing = 8;

        String[] sampleNames = {"Default", "Black 2", "Black 7", "Black 12", "Black 13", "Black 14", "Brown 4", "Brown 5", "Dark Gray 3"};

        for (int i = 0; i < sampleNames.length; i++) {
            int col = i % cols;
            int row = i / cols;
            int x = gridStartX + col * (tileWidth + spacing);
            int y = gridStartY + row * (tileHeight + spacing);

            // Transparente Kachel mit Rand
            boolean isSelected = (i == 0);
            int bgColor = isSelected ? 0x603A2656 : 0x401A1A24;
            int borderColor = isSelected ? 0xFFA855F7 : 0x30FFFFFF;

            context.fill(x, y, x + tileWidth, y + tileHeight, bgColor);
            context.drawBorder(x, y, tileWidth, tileHeight, borderColor);

            // Name unter der Kachel
            context.drawCenteredTextWithShadow(this.textRenderer, sampleNames[i], x + (tileWidth / 2), y + tileHeight - 14, 0xDDDDDDDD);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
