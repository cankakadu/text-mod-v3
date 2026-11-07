package com.texturecustomizer.categories;

public enum TextureCategory {
    PVP_SWORD("Swords", "textures/item/sword"),
    PVP_CART("Carts", "textures/item/minecart"),
    PVP_CRYSTAL("End Crystals", "textures/item/end_crystal"),
    PVP_OBSIDIAN("Obsidian", "textures/block/obsidian"),
    PVP_TOTEM("Totems", "textures/item/totem_of_undying"),
    WEAPONS_TOOLS("Tools", "textures/item/pickaxe"),
    ARMOR_GEAR("Armor (100)", "textures/models/armor"),
    WORLD_ENVIRONMENT("Sky & World", "textures/environment/sky"),
    INVENTORY_HUD("HUD & GUI", "textures/gui/container");

    private final String displayName;
    private final String defaultPath;

    TextureCategory(String displayName, String defaultPath) {
        this.displayName = displayName;
        this.defaultPath = defaultPath;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDefaultPath() {
        return defaultPath;
    }
}
