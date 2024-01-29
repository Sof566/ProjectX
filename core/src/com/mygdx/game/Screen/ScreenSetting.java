package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Button;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ResourseManager;

public class ScreenSetting extends Screen{
    private GameScreenManager screenManager;
    private ResourseManager resourseManager;
    private Texture bcgtexture;
    private Button bttBack, bttVolumePlus, bttVolumeMinus;
    private Music music;
    Vector2 vectorExit = new Vector2(0,0);

    protected ScreenSetting(GameScreenManager screenManager, ResourseManager resourseManager) {
        super(screenManager, resourseManager);

        this.screenManager = screenManager;
        this.resourseManager = resourseManager;

        bcgtexture = resourseManager.getTexture(ResourseManager.bcgLoading);
        bttBack = new Button(resourseManager.getTexture(ResourseManager.txtExit), camera.position.x+ vectorExit.x, camera.position.y+vectorExit.y, 200, 100);
        bttVolumePlus = new Button(resourseManager.getTexture(ResourseManager.txtVolumePlus), 200, 200, 100, 100);
        bttVolumeMinus = new Button(resourseManager.getTexture(ResourseManager.txtVolumeMinus), 400, 400, 100, 100);


        music = resourseManager.getMusic(ResourseManager.music);
        music.setLooping(true);
        music.setVolume(MyGdxGame.VOLUME);
        music.play();
    }

    @Override
    protected void update(float dt) {
        camera.update();
        inputTap();
    }

    @Override
    protected void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bcgtexture, 0,0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        bttBack.render(batch);
        bttVolumeMinus.render(batch);
        bttVolumePlus.render(batch);
        batch.end();

        bttBack.update(camera);
        bttVolumePlus.update(camera);
        bttVolumeMinus.update(camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    protected void inputTap() {
        mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mousePosition);
        bttBack.setClickListener(new Button.onClickListener() {
            @Override
            public void click() {
                screenManager.setScreen(new ScreenMenu(screenManager, resourseManager));
                System.out.println("sjdbckszdbc");
            }
        });
        bttVolumePlus.setClickListener(new Button.onClickListener() {
            @Override
            public void click() {
                MyGdxGame.VOLUME += 0.1;
            }
        });
        bttVolumeMinus.setClickListener(new Button.onClickListener() {
            @Override
            public void click() {
                MyGdxGame.VOLUME -= 0.1;
            }
        });
    }
}


