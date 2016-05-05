package com.fr.game.Entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import finnstr.libgdx.liquidfun.ParticleDef;
import finnstr.libgdx.liquidfun.ParticleGroup;
import finnstr.libgdx.liquidfun.ParticleGroupDef;
import finnstr.libgdx.liquidfun.ParticleSystem;
import finnstr.libgdx.liquidfun.ParticleSystemDef;

/**
 * Created by syhussai on 4/29/2016.
 */

public class Bubble {

    public static final float BUBBLE_RADIUS = 0.225f;

    private static final float FORCE_MAGNITUDE = 5f;
    private static final float PARTICLE_LIFETIME = 10f;

    public ParticleSystem bubbleSystem;
    ParticleGroup bubbleGroup;

    Body surroundingBody;

    enum BubbleState {
        SPAWNED(),
        MOVING(),
        HIT(),
        DEAD()
    }

    private Vector2 linearVelocity;
    private Vector2 forceApplied;

    private float stateTime;
    private float startTime;

    private BubbleState currentState;

    public Bubble(World physicsWorld, Vector2 position, Color color) {
        CircleShape bubbleShape = new CircleShape();
        bubbleShape.setRadius(BUBBLE_RADIUS);
        bubbleShape.setPosition(position);
        ParticleSystemDef systemDef = new ParticleSystemDef();
        systemDef.radius = 0.03f;
        systemDef.density = 1f;
        bubbleSystem = new ParticleSystem(physicsWorld, systemDef);
        ParticleGroupDef bubbleDef = new ParticleGroupDef();
        bubbleDef.shape = bubbleShape;
        bubbleDef.flags.add(ParticleDef.ParticleType.b2_viscousParticle);
        bubbleGroup = bubbleSystem.createParticleGroup(bubbleDef);

        CircleShape border = new CircleShape();
        border.setRadius(BUBBLE_RADIUS);

        BodyDef def = new BodyDef();
        def.position.set(position);
        def.type = BodyDef.BodyType.DynamicBody;

        surroundingBody = physicsWorld.createBody(def);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 1;
        fixtureDef.isSensor = true;
        fixtureDef.shape = border;

        surroundingBody.createFixture(fixtureDef);

        this.linearVelocity = new Vector2();
        this.forceApplied = new Vector2();
        currentState = BubbleState.SPAWNED;
    }

    public void startMoving(float x, float y) {
        linearVelocity.set(x, y);
        Vector2 force = linearVelocity.cpy().nor().scl(FORCE_MAGNITUDE);
        forceApplied.set(force.x, force.y);
        currentState = BubbleState.MOVING;
    }

    public void gotHit() {
        stateTime = 0;
        currentState = BubbleState.HIT;
    }

    public void update(float deltaTime) {
        switch (currentState) {
            case DEAD:
                return;
            case SPAWNED:
                break;
            case MOVING:
//                surroundingBody.applyForce(forceApplied, surroundingBody.getLocalCenter(), true);
                bubbleGroup.applyForce(forceApplied);
                surroundingBody.setTransform(bubbleGroup.getCenter(), 0);
                break;
            case HIT:
                stateTime += deltaTime;
                if (stateTime >= PARTICLE_LIFETIME) {
                    currentState = BubbleState.DEAD;
                    bubbleGroup.destroyParticlesInGroup();
                }
                break;
        }
    }
}
