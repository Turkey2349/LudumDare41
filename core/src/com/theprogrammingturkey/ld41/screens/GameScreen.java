package com.theprogrammingturkey.ld41.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.levels.Level;
import com.theprogrammingturkey.ld41.levels.LevelManager;
import com.theprogrammingturkey.ld41.rendering.Renderable;
import com.theprogrammingturkey.ld41.rendering.Renderer;
import com.theprogrammingturkey.ld41.rendering.models.AnimatedSpriteModel;
import com.theprogrammingturkey.ld41.rendering.models.SpriteModel;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

	private static final Color SKY_BLUE = Color.valueOf("87CEEB");
	private static final Texture GUY = new Texture("guys.png");

	private List<Renderable> buffer;

	private AnimatedSpriteModel guySpriteModel;

	public GameScreen() {
		buffer = new ArrayList<>();
		initGuy();
		initLevels();
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(SKY_BLUE.r, SKY_BLUE.g, SKY_BLUE.b, SKY_BLUE.a);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

		buffer.clear();
		buffer.add(guySpriteModel);

		for (Renderable renderable : buffer) {
			Renderer.draw(renderable, delta);
		}

	}

	private void initGuy() {
		Array<SpriteModel> sprites = new Array<>(true, 4);

		int x = 0;
		final int y = 0;
		final int width = 16;
		final int height = 16;
		for (int i = 0; i < 4; i++) {
			Sprite sprite = new Sprite(GUY, x + (width * i), y, width, height);
			sprite.setX(100);
			sprite.setY(100);
			sprite.scale(5);
			SpriteModel spriteModel = new SpriteModel(sprite);
			sprites.add(spriteModel);
		}
		Animation<SpriteModel> animation = new Animation<>(0.1f, sprites);
		animation.setPlayMode(Animation.PlayMode.LOOP);

		guySpriteModel = new AnimatedSpriteModel(animation);
	}

	private void initLevels() {
		Level level = new Level();
		level.addLayer(new Layer(20, 10));
		level.addLayer(new Layer(20, 10));
		level.addLayer(new Layer(20, 10));
		level.addLayer(new Layer(20, 10));
		level.addLayer(new Layer(20, 10));
		LevelManager.registerLevel("0", level);
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

	}

	@Override
	public void dispose() {

	}

}
