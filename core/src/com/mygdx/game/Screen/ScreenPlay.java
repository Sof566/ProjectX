package com.mygdx.game.Screen;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.math.Vector3;
        import com.mygdx.game.Entity.Player;
        import com.mygdx.game.MyGdxGame;
        import com.mygdx.game.ResourseManager;

public class ScreenPlay extends Screen{
    private GameScreenManager screenManager;
    private ResourseManager resourseManager;
    private Texture bcgTexture;
    Player player;
    protected ScreenPlay(GameScreenManager screenManager, ResourseManager resourseManager) {
        super(screenManager, resourseManager);
        this.screenManager = screenManager;
        this.resourseManager = resourseManager;

        bcgTexture = resourseManager.getTexture(ResourseManager.bcgLoading);


    }

    @Override
    protected void update(float dt) {

        mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.update();
        inputTap();
    }

    @Override
    protected void render(SpriteBatch batch) {

        batch.begin();
        batch.draw(bcgTexture, 0,0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.end();
        System.out.println("dbvcajshvb");

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
