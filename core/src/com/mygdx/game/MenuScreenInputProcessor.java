package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class MenuScreenInputProcessor implements InputProcessor {

    Sprite sprite;
    boolean isSpriteDrag = false;
    Game game;
    Vector2 prevCoords = new Vector2(0,0);



    static boolean spriteInCoords(Sprite s,int x,int y){
        y= Gdx.graphics.getHeight()-y;
        return x>=s.getX() && x<=s.getX()+s.getWidth() && y>=s.getY() && y<=s.getY()+s.getHeight();
    }

    public MenuScreenInputProcessor(Sprite sprite,Game game) {
        this.sprite = sprite;
        this.game=game;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        prevCoords.set(screenX,screenY);
        isSpriteDrag=spriteInCoords(sprite,screenX,screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(!isSpriteDrag){
            game.setScreen(new PlayScreen(game));
        }
        isSpriteDrag=false;


        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        int dx = (int) (screenX-prevCoords.x);
        int dy = -(int) (screenY-prevCoords.y);

        if(isSpriteDrag){
            sprite.setX(sprite.getX()+dx);
            sprite.setY(sprite.getY()+dy);
        }


        prevCoords.set(screenX,screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
