package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;




public class MenuScreen implements Screen {
    SpriteBatch batch;
    Texture img;
    Sprite sp;
    Game game;

    public MenuScreen(Game game) {
        this.game=game;
    }

    @Override
    public void show() {
        System.out.print("show");
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        sp = new Sprite(img);

        Gdx.input.setInputProcessor(new MenuScreenInputProcessor(sp,game));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sp.draw(batch);
        batch.end();
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
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
