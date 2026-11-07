package com.texturecustomizer.resource;

import com.texturecustomizer.categories.TextureCategory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ResourceAnalyzer {

    public static Map<TextureCategory, List<String>> analyzeZipPack(File zipFile) {
        Map<TextureCategory, List<String>> classifiedAssets = new HashMap<>();
        for (TextureCategory cat : TextureCategory.values()) {
            classifiedAssets.put(cat, new ArrayList<>());
        }

        try (ZipFile zip = new ZipFile(zipFile)) {
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String name = entry.getName().toLowerCase();

                if (name.contains("minecart") || name.contains("cart")) {
                    classifiedAssets.get(TextureCategory.PVP_CART).add(name);
                } else if (name.contains("sword")) {
                    classifiedAssets.get(TextureCategory.PVP_SWORD).add(name);
                } else if (name.contains("end_crystal") || name.contains("crystal")) {
                    classifiedAssets.get(TextureCategory.PVP_CRYSTAL).add(name);
                } else if (name.contains("obsidian")) {
                    classifiedAssets.get(TextureCategory.PVP_OBSIDIAN).add(name);
                } else if (name.contains("totem")) {
                    classifiedAssets.get(TextureCategory.PVP_TOTEM).add(name);
                } else if (name.contains("armor")) {
                    classifiedAssets.get(TextureCategory.ARMOR_GEAR).add(name);
                } else if (name.contains("sky")) {
                    classifiedAssets.get(TextureCategory.WORLD_ENVIRONMENT).add(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classifiedAssets;
    }
}
