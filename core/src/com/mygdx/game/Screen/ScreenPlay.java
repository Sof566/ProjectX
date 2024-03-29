package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.Block.Block;
import com.mygdx.game.Block.FernBush;
import com.mygdx.game.Block.Rock;
import com.mygdx.game.Block.Shell;
import com.mygdx.game.Block.Spike;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.PlayerIndicators;
import com.mygdx.game.ResourseManager;
import com.mygdx.game.TouchPad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ScreenPlay extends Screen{
    private GameScreenManager screenManager;
    private ResourseManager resourseManager;
    private Player player;
    private Rock rock;
    private Rock rock2;
    private Spike spike;
    private FernBush fernBush1;
    private Shell shell;
    private List<Entity> entities;
    private List<Block> blocks;
    Vector2 PlayerWorldStartPosition = new Vector2(0, 0);
    private TouchPad joystick;
    private PlayerIndicators playerInterface;
    protected ScreenPlay(GameScreenManager screenManager, ResourseManager resourseManager) {
        super(screenManager, resourseManager);
        this.screenManager = screenManager;
        this.resourseManager = resourseManager;
        loadingCreaturesAndBlocks();
        camera.setToOrtho(false, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        joystick = new TouchPad(camera, resourseManager);
        playerInterface = new PlayerIndicators(camera, resourseManager);
    }

    public void loadingCreaturesAndBlocks(){
        entities = new ArrayList<>();
        blocks = new ArrayList<>();

        player = new Player(resourseManager, PlayerWorldStartPosition);
        Vector2 pon = new Vector2(-100, 100);
        Vector2 pon2 = new Vector2(-300, 100);
        Vector2 pon3 = new Vector2(-500, 100);
        Vector2 pon4 = new Vector2(-700, 100);
        Vector2 pon5 = new Vector2(-100, -100);
        rock = new Rock(resourseManager, pon);
        rock2 = new Rock(resourseManager, pon2);
        spike = new Spike(resourseManager, pon3);
        fernBush1 = new FernBush(resourseManager, pon4);
        shell = new Shell(resourseManager, pon5);
        entities.add(player);
        blocks.add(rock);
        blocks.add(rock2);
        blocks.add(spike);
        blocks.add(shell);
        blocks.add(fernBush1);

    }

    @Override
    protected void update(float dt) {
        mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.update();
        inputTap();

        player.setVelocity(joystick.getKnobPercentWalk());
        player.update(dt, camera);
        rock.update(dt);
        rock2.update(dt);
        spike.update(dt);
        fernBush1.update(dt);
        shell.update(dt);
        playerInterface.update(dt, player.hp);
        player.setVelocity(joystick.getKnobPercentWalk());



        for (Entity entity : entities) {
            entity.Collision(entities, blocks);
            //entity.stateTime += 1;
        }
        /*for(Block block : blocks) {
            block.stateTime += 1;
        }*/
    }

    @Override
    protected void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        player.render(batch);
        rock.render(batch);
        rock2.render(batch);
        spike.render(batch);
        fernBush1.render(batch);
        shell.render(batch);
        batch.end();

        joystick.render(batch);
        playerInterface.render(batch);
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
    public void dispose() {

    }

    @Override
    protected void inputTap() {

    }
}
