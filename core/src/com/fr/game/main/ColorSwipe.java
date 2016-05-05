package com.fr.game.main;

//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.fr.game.Entities.GameWorld;

/**
 * Created by syhussai on 4/29/2016.
 * <p/>
 * Entry Point Of The Game
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactFilter;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.fr.game.Entities.Bubble;
import com.fr.game.Entities.RevolvingWalls;

import finnstr.libgdx.liquidfun.ParticleBodyContact;
import finnstr.libgdx.liquidfun.ParticleContact;
import finnstr.libgdx.liquidfun.ParticleDebugRenderer;
import finnstr.libgdx.liquidfun.ParticleDef.ParticleType;
import finnstr.libgdx.liquidfun.ParticleGroup;
import finnstr.libgdx.liquidfun.ParticleGroupDef;
import finnstr.libgdx.liquidfun.ParticleSystem;
import finnstr.libgdx.liquidfun.ParticleSystemDef;

public class ColorSwipe extends ApplicationAdapter implements InputProcessor {

    private final static float BOX_TO_WORLD = 120.0f;
    private final static float WORLD_TO_BOX = 1f / BOX_TO_WORLD;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    private World mWorld;
    private ParticleSystem mParticleSystem;
    private ParticleDebugRenderer mParticleDebugRenderer;
    private Box2DDebugRenderer mDebugRenderer;

    private ParticleGroupDef mParticleGroupDef1;
    private ParticleGroupDef mParticleGroupDef2;
    private RevolvingWalls walls;

    @Override
    public void create() {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(width, height);
        camera.position.set(width / 2, height / 2, 0);
        camera.update();
        Gdx.input.setInputProcessor(this);

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);

        sprite = new Sprite(region);
        sprite.setSize(width, height);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(0, 0);

        createBox2DWorld(width, height);
//        createParticleStuff(width, height);

        /* Render stuff */
        mDebugRenderer = new Box2DDebugRenderer();
        mParticleDebugRenderer = new ParticleDebugRenderer(new Color(0, 1, 0, 1), bubble.bubbleSystem.getParticleCount());

        System.out.println("NOP" + bubble.bubbleSystem.getParticleCount());

        /* Version */
//        Gdx.app.log("Running LiquidFun version", mParticleSystem.getVersionString());
        updateLog();
    }

    Bubble bubble;

    private void createBox2DWorld(float width, float height) {
        mWorld = new World(new Vector2(0, 0f), false);
        walls = new RevolvingWalls.Builder(mWorld, 12).setRadius(1.5f).skipEvery(1).setWallThickness(0.1f).setCenter(1.5f, 1.5f).rotateEverySpinBy(90).build();
        bubble = new Bubble(mWorld, new Vector2(1.5f, 1.5f), Color.BLACK);
    }

    private void createParticleStuff(float width, float height) {
        //First we create a new particlesystem and
        //set the radius of each particle to 6 / 120 m (5 cm)
        ParticleSystemDef systemDef = new ParticleSystemDef();
        systemDef.radius = 6f * WORLD_TO_BOX;
        systemDef.dampingStrength = 0.2f;

        mParticleSystem = new ParticleSystem(mWorld, systemDef);
        mParticleSystem.setParticleDensity(1.3f);

        //Create a new particlegroupdefinition and set some properties
        //For the flags you can set more than only one
        mParticleGroupDef1 = new ParticleGroupDef();
        mParticleGroupDef1.color.set(1f, 0, 0, 1);
        mParticleGroupDef1.flags.add(ParticleType.b2_waterParticle);
        mParticleGroupDef1.position.set(width * (30f / 100f) * WORLD_TO_BOX, height * (80f / 100f) * WORLD_TO_BOX);

        //Create a shape, give it to the definition and
        //create the particlegroup in the particlesystem.
        //This will return you a ParticleGroup instance, but
        //we don't need it here, so we drop that.
        //The shape defines where the particles are created exactly
        //and how much are created
        PolygonShape parShape = new PolygonShape();
        parShape.setAsBox(width * (20f / 100f) * WORLD_TO_BOX / 2f, width * (20f / 100f) * WORLD_TO_BOX / 2f);
        mParticleGroupDef1.shape = parShape;
        mParticleSystem.createParticleGroup(mParticleGroupDef1);

        //Exactly the same! This is the second group with a different
        //color and shifted on the x-Axis
        mParticleGroupDef2 = new ParticleGroupDef();
        mParticleGroupDef2.shape = mParticleGroupDef1.shape;
        mParticleGroupDef2.flags = mParticleGroupDef1.flags;
        mParticleGroupDef2.groupFlags = mParticleGroupDef1.groupFlags;
        mParticleGroupDef2.position.set(width * (70f / 100f) * WORLD_TO_BOX, height * (80f / 100f) * WORLD_TO_BOX);
        mParticleGroupDef2.color.set(0.2f, 1f, 0.3f, 1);

        ParticleGroup mGrpOne = mParticleSystem.createParticleGroup(mParticleGroupDef2);

        //Here we create a new shape and we set a
        //linear velocity. This is used in createParticles1()
        //and createParticles2()
        CircleShape partShape = new CircleShape();
        partShape.setRadius(18.5f * WORLD_TO_BOX);

        mParticleGroupDef1.shape = partShape;
        mParticleGroupDef2.shape = partShape;

        mParticleGroupDef1.linearVelocity.set(new Vector2(0, -10f));
        mParticleGroupDef2.linearVelocity.set(new Vector2(0, -10f));

    }

    @Override
    public void render() {
        //First update our InputProcessor
        this.inputUpdate(Gdx.graphics.getDeltaTime());

        //Now do the same as every year...
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        bubble.update(Gdx.graphics.getDeltaTime());
        walls.update(Gdx.graphics.getDeltaTime());
        mWorld.step(Gdx.graphics.getDeltaTime(), 10, 6, 2);


//        batch.setProjectionMatrix(camera.combined);
//        batch.begin();
//        sprite.draw(batch);
//        batch.end();

        //Get the combined matrix and scale it down to
        //our Box2D size
        Matrix4 cameraCombined = camera.combined.cpy();
        cameraCombined.scale(BOX_TO_WORLD, BOX_TO_WORLD, 1);

//        System.out.println(bubble.bubbleSystem.getParticleCount());
        //First render the particles and then the Box2D world
        mParticleDebugRenderer.render(bubble.bubbleSystem, BOX_TO_WORLD, cameraCombined);
        mDebugRenderer.render(mWorld, cameraCombined);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
        mParticleGroupDef1.shape.dispose();
        mWorld.dispose();
        mDebugRenderer.dispose();
    }

    public void createParticles1(float pX, float pY) {
        mParticleGroupDef1.position.set(pX * WORLD_TO_BOX, pY * WORLD_TO_BOX);
        mParticleSystem.createParticleGroup(mParticleGroupDef1);
        updateParticleCount();
        updateLog();
    }

    private void createParticles2(float pX, float pY) {
        mParticleGroupDef2.position.set(pX * WORLD_TO_BOX, pY * WORLD_TO_BOX);
        mParticleSystem.createParticleGroup(mParticleGroupDef2);
        updateParticleCount();
        updateLog();
    }

    private void updateParticleCount() {
        if (mParticleSystem.getParticleCount() > mParticleDebugRenderer.getMaxParticleNumber()) {
            mParticleDebugRenderer.setMaxParticleNumber(mParticleSystem.getParticleCount() + 1000);
        }
    }

    public void updateLog() {
        //Here we log the total particle count and the f/s
//        Gdx.app.log("", "Total particles: " + mParticleSystem.getParticleCount() + " FPS: " + Gdx.graphics.getFramesPerSecond()+"");
    }

    public void createCircleBody(float pX, float pY, float pRadius) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DynamicBody;
        bodyDef.position.set(pX * WORLD_TO_BOX, pY * WORLD_TO_BOX);
        Body body = mWorld.createBody(bodyDef);

        CircleShape shape = new CircleShape();
        shape.setRadius(pRadius * WORLD_TO_BOX);

        FixtureDef fixDef = new FixtureDef();
        fixDef.density = 0.5f;
        fixDef.friction = 0.2f;
        fixDef.shape = shape;
        fixDef.restitution = 0.3f;

        body.createFixture(fixDef);
    }

    /* +++ Input +++ */

    private final float CREATE_PARTICLE_FREQUENCY = 50f;
    private float mTotDelta = 0;

    private boolean mCreateParticles = false;
    private float mPointerPosX = 0;
    private float mPointerPosY = 0;
    private int mCurrentButton = -1;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT && button != Input.Buttons.RIGHT && button != Input.Buttons.MIDDLE)
            return false;

//        if(button == Input.Buttons.MIDDLE) {
//            this.createCircleBody(screenX, Gdx.graphics.getHeight() - screenY, MathUtils.random(10, 80));
//            return true;
//        }
//
//        mCreateParticles = true;
//        mCurrentButton = button;
//        mTotDelta = 0;
//
//        mPointerPosX = screenX;
//        mPointerPosY = screenY;

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT && button != Input.Buttons.RIGHT && button != Input.Buttons.MIDDLE)
            return false;
        bubble.startMoving(0.1f, 0);
//        walls.destroy();
//        mCreateParticles = false;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (!mCreateParticles) return false;

        mPointerPosX = screenX;
        mPointerPosY = screenY;

        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void inputUpdate(float pDelta) {
        if (!mCreateParticles) return;
        mTotDelta += pDelta;

        if (mTotDelta >= 1f / CREATE_PARTICLE_FREQUENCY) {
            mTotDelta -= 1 / CREATE_PARTICLE_FREQUENCY;
        } else return;

        float x = mPointerPosX + MathUtils.random(-Gdx.graphics.getWidth() * (1.5f / 100f), Gdx.graphics.getWidth() * (1.5f / 100f));
        float y = mPointerPosY + MathUtils.random(-Gdx.graphics.getHeight() * (1.5f / 100f), Gdx.graphics.getHeight() * (1.5f / 100f));

        if (mCurrentButton == Input.Buttons.LEFT) {
            this.createParticles1(x, Gdx.graphics.getHeight() - y);
        } else if (mCurrentButton == Input.Buttons.RIGHT) {
            this.createParticles2(x, Gdx.graphics.getHeight() - y);
        }
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

}
