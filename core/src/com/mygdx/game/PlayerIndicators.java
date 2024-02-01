package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Screen.ScreenPlay;

public class PlayerIndicators {
    private OrthographicCamera camera;
    ResourseManager resourseManager;
    private int hp, numberHp;

    public PlayerIndicators(OrthographicCamera camera, ResourseManager resourseManager) {
        this.camera = camera;
        this.resourseManager = resourseManager;
        Viewport viewport = new FitViewport(MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT, camera);
    }

    public void update(float dt, int playerHp){
        numberHp = playerHp/10;
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        for (int i = 0; i < numberHp; i++) {
           batch.draw(resourseManager.getTexture(ResourseManager.life), (camera.position.x + camera.viewportWidth/2 - 200)+i*20, (camera.position.y + camera.viewportHeight/2-20));
        }
        batch.end();
    }
}
