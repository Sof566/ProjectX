package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Button;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ResourseManager;

public class ScreenMenu extends Screen{
    GameScreenManager screenManager;
    ResourseManager resourseManager;
    Texture texture;
    Music music;

    Vector2 vectorExit = new Vector2(0,0);
    Vector2 vectorSettings = new Vector2(200, 200);
    Button bttExit, bttSettings, bttPlay;

    public ScreenMenu(GameScreenManager screenManager, ResourseManager resourseManager) {
        super(screenManager, resourseManager);
        camera.setToOrtho(false, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        texture = resourseManager.getTexture(ResourseManager.bcgMenu);
        bttExit = new Button(resourseManager.getTexture(ResourseManager.txtExit), camera.position.x+ vectorExit.x, camera.position.y+vectorExit.y, 200, 100);
        bttSettings = new Button(resourseManager.getTexture(ResourseManager.txtSettings), camera.position.x+ vectorSettings.x, camera.position.y+vectorSettings.y, 200, 100);
        bttPlay = new Button(resourseManager.getTexture(ResourseManager.bttPlay), 1000, 600, 100, 100);
        music = resourseManager.getMusic(ResourseManager.music);
        music.setLooping(true);
        music.setVolume(MyGdxGame.VOLUME);
        music.play();
    }

    @Override
    protected void update(float dt) {
        mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        inputTap();
        camera.update();
    }

    @Override
    protected void render(SpriteBatch batch) {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(texture, 0,0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        bttSettings.render(batch);
        bttExit.render(batch);
        batch.end();

        bttExit.update(camera);
        bttSettings.update(camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0,0,0,1);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        resourseManager.reload();
    }

    @Override
    public void hide() {

    }

    @Override
    public void inputTap() {
        mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mousePosition);
        bttExit.setClickListener(new Button.onClickListener() {
            @Override
            public void click() {
                music.stop();
                Gdx.app.exit();
            }
        });
        bttSettings.setClickListener(new Button.onClickListener() {
            @Override
            public void click() {
                music.stop();
                screenManager.setScreen(new ScreenSetting(screenManager, resourseManager));
            }
        });
        bttPlay.setClickListener(new Button.onClickListener() {
            @Override
            public void click() {
                //screenManager.setScreen(new ScreenPlay(screenManager, resourseManager));
            }
        });
    }

    @Override
    public void dispose() {

    }
}
