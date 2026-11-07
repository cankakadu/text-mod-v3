package com.texturecustomizer.mixer;

import com.texturecustomizer.categories.TextureCategory;
import com.texturecustomizer.storage.StorageManager;

import java.util.HashMap;
import java.util.Map;

public class TextureMixerManager {
    private final StorageManager storageManager;
    private final Map<TextureCategory, String> activeSelections = new HashMap<>();

    public TextureMixerManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public void selectTexture(TextureCategory category, String assetIdentifier) {
        activeSelections.put(category, assetIdentifier);
    }

    public void loadActiveMixes() {
        // Läd gespeicherte Zuordnungen aus der JSON-Konfiguration
    }

    public Map<TextureCategory, String> getActiveSelections() {
        return activeSelections;
    }
}
