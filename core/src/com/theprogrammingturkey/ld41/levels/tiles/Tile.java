package com.theprogrammingturkey.ld41.levels.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.theprogrammingturkey.ld41.rendering.Renderable;

public class Tile implements Renderable {
	public static final int WIDTH = 25;
	public static final int HEIGHT = 25;
	private Sprite sprite;

	public Tile(int x, int y, Sprite sprite) {
		this.sprite = sprite;
		sprite.setBounds(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
	}

	@Override
	public Sprite getSprite(float delta) {
		return sprite;
	}

	public boolean isSolid() {
		return true;
	}
}