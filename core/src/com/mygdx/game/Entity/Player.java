package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Animator;
import com.mygdx.game.ResourseManager;

public class Player extends Entity{
    ResourseManager resourseManager;
    public static final Vector2 playerSize = new Vector2(100, 100);
    private static final int BASICSPEED = 5;
    private MoveState playerMoveState;
    Animator animation;
    public Player(ResourseManager resourseManager, Vector2 startPosition) {
        this.resourseManager = resourseManager;
        initPosition(startPosition);
        velocity = new Vector2();
        playerMoveState = MoveState.NONE;
        hp = maxHp = 100;
        size = playerSize;
        rectangle = new Rectangle(position.x, position.y, size.x, size.y);
        animation = new Animator(resourseManager.getTexture(ResourseManager.xuita), 2, 2, 0.5f, 0, 0);
    }


    void initPosition(Vector2 vector2) {
        position = vector2;
    }



    @Override
    public void render(SpriteBatch batch) {
        if(lifeState == LifeState.LIFE){
            batch.draw(animation.getFrame(), 0, 0);
        }
    }


    @Override
    public void update(float dt, OrthographicCamera camera) {
        float cameraSpeed = velocity.len();
        camera.position.set(position.x, position.y, 0);
        camera.translate(velocity.x * dt * cameraSpeed, velocity.y * dt * cameraSpeed);
    }

    @Override
    public void dispose() {

    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }
}
