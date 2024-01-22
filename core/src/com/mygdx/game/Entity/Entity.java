package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    protected Entity() {
    }
    public enum MoveState {
        LEFT, RIGHT, UP, DOWN, NONE
    }
    public enum LifeState {
        LIFE, DEAD, DYING
    }
    public LifeState lifeState = LifeState.LIFE;

    public Vector2 position = new Vector2(0,0);
    public Vector2 size = new Vector2(0,0);
    public Texture texture = null;
    public Vector2 velocity = new Vector2(0, 0);
    public int hp, maxHp;
    public Rectangle rectangle = null;
    public abstract void render(SpriteBatch batch);
    public abstract void update(float dt, OrthographicCamera camera);
    public abstract void dispose();
    public abstract Rectangle getRectangle();
}

