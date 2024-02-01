package com.mygdx.game.Block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.ResourseManager;

public class Shell extends Block{
    ResourseManager resourseManager;
    Texture texture1, texture2;
    public static final Vector2 Size = new Vector2(40, 40);

    public Shell(ResourseManager resourseManager, Vector2 startPosition) {
        this.resourseManager = resourseManager;
        initPosition(startPosition);
        size = Size;
        blockType = BlockType.pricking;
        rectangle = new Rectangle(position.x, position.y, Size.x, Size.y);
        texture = resourseManager.getTexture(ResourseManager.shell);
        stateTime = 0;
    }

    private void initPosition(Vector2 vector2) {
        position = vector2;
    }

    @Override
    public void render(SpriteBatch batch) {
        if(lifeStateblock == LifeStateBlock.LIFE){
            batch.draw(texture, position.x, position.y, size.x, size.y);
        }
    }

    @Override
    public void update(float dt) {
        if (lifeStateblock == LifeStateBlock.LIFE) {

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
