package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Block.Block;

import java.util.List;

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
    public int hp, maxHp, stateTime;
    public Rectangle rectangle = null;
    public abstract void render(SpriteBatch batch);
    public abstract void update(float dt, OrthographicCamera camera);
    public abstract void updatePosition();
    public abstract void dispose();
    public abstract Rectangle getRectangle();

    public void Collision(List<Entity> entities, List<Block> blocks){
        Vector2 oldPosition = new Vector2(rectangle.getX(), rectangle.getY());
        for (Entity entity : entities) {
            entity.updatePosition();
            for (Block block : blocks) {
                if (Intersector.overlaps(entity.getRectangle(), block.getRectangle())) {
                    if (block.blockType == Block.BlockType.solid) {
                        entity.setPosition(oldPosition);
                    }
                    if (block.blockType == Block.BlockType.pricking) {
                        entity.getDamage(block.blockdamage);
                    }
                }
            }
        }
    }

    private void getDamage(int damage) {
        this.hp -= damage;
    }

    private void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }
    private void setPosition(Vector2 position) {
        this.position = position;
    }
}

