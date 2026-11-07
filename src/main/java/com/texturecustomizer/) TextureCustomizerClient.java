package com.texturecustomizer;

import com.texturecustomizer.keybind.KeyInputHandler;
import com.texturecustomizer.mixer.TextureMixerManager;
import com.texturecustomizer.storage.StorageManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextureCustomizerClient implements ClientModInitializer {
    public static final String MOD_ID = "texturecustomizer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static StorageManager storageManager;
    private static TextureMixerManager textureMixerManager;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initialisiere 02MAX Texture Customizer für Minecraft 1.21.11 (Fabric)...");

        storageManager = new StorageManager();
        storageManager.init();

        textureMixerManager = new TextureMixerManager(storageManager);
        textureMixerManager.loadActiveMixes();

        KeyInputHandler.register();

        LOGGER.info("Texture Customizer erfolgreich bereit.");
    }

    public static StorageManager getStorageManager() {
        return storageManager;
    }

    public static TextureMixerManager getTextureMixerManager() {
        return textureMixerManager;
    }
}
