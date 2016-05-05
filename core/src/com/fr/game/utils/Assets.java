package com.fr.game.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by syhussai on 5/5/2016.
 */
public class Assets {
    public static AssetManager assetManager;

    public static void load() {
        assetManager.load("", TextureAtlas.class);
    }

    public static void get() {
        assetManager.get("");
    }

    public static void unload() {
        assetManager.dispose();
    }
}
