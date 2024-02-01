package com.mygdx.game.Block;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Animator;
import com.mygdx.game.ResourseManager;

import java.util.Random;

public class FernBush extends Block{
    private ResourseManager resourseManager;
    public static final Vector2 Size = new Vector2(100, 100);
    private Animator animator;
    int breedingTime;
    Random random = new Random();

    public FernBush(ResourseManager resourseManager, Vector2 startPosition) {
        this.resourseManager = resourseManager;
        initPosition(startPosition);
        Strength = MaxStrength = 10;
        size = Size;
        blockType = BlockType.soft;
        rectangle = new Rectangle(position.x, position.y, Size.x, Size.y);
        stateTime = 0;
        animator = new Animator(resourseManager.getTexture(ResourseManager.lol), 3, 1, 0.25f, 100, 100);
        //breedingTime = random.nextInt(60, 601)/60;
    }
    private void initPosition(Vector2 vector2) {
        position = vector2;
    }

    @Override
    public void render(SpriteBatch batch) {
        if(lifeStateblock == LifeStateBlock.LIFE){
            batch.draw(animator.getFrame(), position.x, position.y, size.x, size.y);
        }
    }

    @Override
    public void update(float dt) {
        if (lifeStateblock == LifeStateBlock.LIFE) {
            if(stateTime > breedingTime) {

            }
        }
    }



    @Override
    public void dispose() {

    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }
}
