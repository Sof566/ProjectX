package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class ResourseManager {
    public static final String bcgLoading = "images/1.png";
    public static final String bcgMenu = "images/2.png";
    public static final String bcgSetting = "images/test.png";
    public static final String txtSettings = "images/button_setting.png";
    public static final String txtExit = "images/button_back.png";
    public static final String txtVolumePlus = "images/txtPlus.png";
    public static final String txtVolumeMinus = "images/txtMinus.png";
    public static final String txtPlayer = "images/player.png";
    public static final String bttPlay = "images/img_play.png";
    public Texture texture;
    public static final String music = "sound/music/audio_gameKapy.mp3";
    AssetManager assetManager;

    public void loading() {
        assetManager = new AssetManager();
        loadingImg();
        loadingMusic();
    }

    public void loadingImg() {
        assetManager.setLoader(Texture.class, new TextureLoader(new InternalFileHandleResolver()));
        assetManager.load(bcgLoading, Texture.class);
        assetManager.load(bcgMenu, Texture.class);
        assetManager.load(txtSettings, Texture.class);
        assetManager.load(txtExit, Texture.class);
        assetManager.load(bcgSetting, Texture.class);
        assetManager.load(txtVolumePlus, Texture.class);
        assetManager.load(txtVolumeMinus, Texture.class);
        assetManager.load(txtPlayer, Texture.class);
        assetManager.load(bttPlay, Texture.class);
    }

    public void loadingMusic() {
        assetManager.setLoader(Music.class, new MusicLoader(new InternalFileHandleResolver()));
        assetManager.load(music, Music.class);
    }

    public boolean isLoad() {
        return assetManager.update();
    }

    public void reload() {
        this.loading();
    }

    public Texture getTexture(String name) {
        return assetManager.get(name);
    }

    public Music getMusic(String name) {
        return  assetManager.get(name);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void dispose() {
        assetManager.clear();
        assetManager.dispose();
    }
}
