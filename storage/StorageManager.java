package com.texturecustomizer.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StorageManager {
    private final Path modDir;
    private final Path packsDir;
    private final Path profilesDir;
    private final Path cacheDir;
    private final Gson gson;

    public StorageManager() {
        this.modDir = FabricLoader.getInstance().getConfigDir().resolve("texturecustomizer");
        this.packsDir = modDir.resolve("packs");
        this.profilesDir = modDir.resolve("profiles");
        this.cacheDir = modDir.resolve("cache");
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void init() {
        try {
            Files.createDirectories(modDir);
            Files.createDirectories(packsDir);
            Files.createDirectories(profilesDir);
            Files.createDirectories(cacheDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Path getPacksDir() { return packsDir; }
    public Path getProfilesDir() { return profilesDir; }
    public Path getCacheDir() { return cacheDir; }
    public Gson getGson() { return gson; }
}
