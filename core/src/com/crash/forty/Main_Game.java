package com.crash.forty;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class Main_Game extends ApplicationAdapter implements InputProcessor, GestureDetector.GestureListener {

	private SpriteBatch batch;
	private TextureAtlas runnerAtlas;
	private Animation animation;
	private float timePassed = 0;

	private BitmapFont font;

	private Texture backgroundTexture;
	private Sprite backgroundSprite;

	private int screenWidth, screenHeight;
	private String message = "Press Touch to Start";
	private GlyphLayout glyphLayout;

	private OrthographicCamera camera;
	private Sprite sprite;


	// Initialization
	@Override
	public void create () {
		batch = new SpriteBatch();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

//		this.glyphLayout = new GlyphLayout();

		camera = new OrthographicCamera(screenWidth/4, screenHeight/4);

		backgroundTexture = new Texture(Gdx.files.internal("forty_background.png"));
		backgroundSprite = new Sprite(backgroundTexture);

		backgroundSprite.setPosition(-backgroundSprite.getWidth()/10 , -backgroundSprite.getHeight()/2);




//		font = new BitmapFont();
//		font.setColor(Color.BLACK);
//		font.getData().scale(5);

		Gdx.input.setInputProcessor(new GestureDetector(this));

		runnerAtlas = new TextureAtlas(Gdx.files.internal("runner.atlas"));
		animation = new Animation(1/15f, runnerAtlas.getRegions());



	}

	// Called at the end of the lifecycle... Use it to dispose of resources..Prevents memory leaks
	@Override
	public void dispose() {

		super.dispose();
		batch.dispose();
		runnerAtlas.dispose();
		backgroundTexture.dispose();
		font.dispose();

	}



	// Main game loop
	@Override
	public void render () {
		// Clear Screen
		Gdx.gl.glClearColor(1, 1, 1, 1);    // Clear the screen and paint it white
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//		glyphLayout.setText(font, message);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		backgroundSprite.draw(batch);
//		batch.draw(backgroundTexture, 0, 0);

		///////// Do all drawing here ////////////
//		font.draw(batch, glyphLayout, screenWidth/2 - glyphLayout.width/2, screenHeight/2 + glyphLayout.height/2);
		timePassed += (Gdx.graphics.getDeltaTime());

		batch.draw(animation.getKeyFrame(timePassed, true), -backgroundSprite.getWidth()/10 , -backgroundSprite.getHeight()/2);


		batch.end();
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
//		message = "Touch down at " + screenX + ", " + screenY;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//		message = "Touch Up at " + screenX + ", " + screenY;

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
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

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {

		camera.translate(15, 0);
		camera.update();
		return true;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {

		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
}
