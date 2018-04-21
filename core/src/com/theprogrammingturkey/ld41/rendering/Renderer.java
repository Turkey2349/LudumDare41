package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Renderer {

	private static SpriteBatch batch = new SpriteBatch();
	private static Texture spriteSheet = new Texture("badlogic.jpg");

	public static void startBatch() {
		batch.begin();
	}

	public static void endBatch() {
		batch.end();
	}
	
	public static void drawSprite(Sprite sprite) {
		sprite.draw(batch);
	}
	
	public static TextureRegion createTextureRegion(int x, int y, int w, int h) {
		return new TextureRegion(spriteSheet, x, y, w, h);
	}

	public static Sprite createSprite(int x, int y, int w, int h) {
		return new Sprite(spriteSheet, x, y, w, h);
	}

	public static Animation<TextureRegion> createAnimation() {
		Animation<TextureRegion> animation = new Animation<TextureRegion>(1,createTextureRegion(1,1,100,100));
		
		return animation;
	}
	
}
