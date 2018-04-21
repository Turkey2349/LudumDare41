package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class Renderer {

	private static SpriteBatch batch = new SpriteBatch();
	private static Texture spriteSheet = new Texture("guys.png");

	public static void startBatch() {
		batch.begin();
	}

	public static void endBatch() {
		batch.end();
	}

	public static void drawSprite(Sprite sprite) {
		sprite.draw(batch);
	}

	public static TextureRegion createTextureRegion(int x, int y, int w,
			int h) {
		return new TextureRegion(spriteSheet, x, y, w, h);
	}

	public static Sprite createSprite(int x, int y, int w, int h) {
		return new Sprite(spriteSheet, x, y, w, h);
	}

	public static Animation<TextureRegion> createAnimation(float animTime,
			int[] textureRegionData) {
		int numOfFrames = textureRegionData.length / 4;

		if (numOfFrames == 0) {
			System.err.println("NO DATA HERE");
			return null;
		}

		TextureRegion[] frames = new TextureRegion[numOfFrames];
		for (int i = 0; i < numOfFrames; i++) {
			frames[i] = createTextureRegion(textureRegionData[(i * 4)],
					textureRegionData[(i * 4) + 1],
					textureRegionData[(i * 4) + 2],
					textureRegionData[(i * 4) + 3]);
		}
		Animation<TextureRegion> animation = new Animation<TextureRegion>(
				animTime, frames);
		animation.setPlayMode(PlayMode.LOOP);

		return animation;
	}

	public static TextButton getCustomButton(String text) {
		BitmapFont font = new BitmapFont();
		Skin skin = new Skin();
		TextureAtlas buttonAtlas = new TextureAtlas(
				Gdx.files.internal("ui_components/ButtonPack.txt"));
		skin.addRegions(buttonAtlas);
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = font;
		textButtonStyle.up = skin.getDrawable("ButtonNormal");
		textButtonStyle.down = skin.getDrawable("ButtonSelected");
		textButtonStyle.checked = skin.getDrawable("ButtonChecked");
		return new TextButton(text, textButtonStyle);
	}
}
