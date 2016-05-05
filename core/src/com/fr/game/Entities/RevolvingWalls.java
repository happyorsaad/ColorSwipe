package com.fr.game.Entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.math.MathUtils.degreesToRadians;

/**
 * Created by syhussai on 5/3/2016.
 */

public class RevolvingWalls {

    public enum REVOLVING_SPEED {
        SLOW(360 / 5f * degreesToRadians), MEDIUM(360 / 4f * degreesToRadians), FAST(360 / 3f * degreesToRadians);
        private REVOLVING_SPEED(float angularVelocity) {
            this.angularVelocity = angularVelocity;
        }
        private float angularVelocity;
        public float getAngularVelocity() {
            return angularVelocity;
        }
    }

    private int startingIndex;
    private int skipEvery;
    private Vector2 center;
    private float radius;

    private float rotateBy;
    private float rotateFor;

    private int numWalls;
    private float wallThickness;

    private World physicsWorld;
    private Color wallColors[];

    private REVOLVING_SPEED speed;

    private float totalRunTime;
    private Array<Body> wallBodies;
    private Array<RevoluteJoint> ropeJoints;

    private RevoluteJoint rope;

    private boolean isRevolving;

    private float runningTime;
    private float stillTime;

    private final float STILL_TIME = 0.5f;
    private Body centerBody;

    private boolean canRevolve;

    private RevolvingWalls(Builder builder) {
        this.startingIndex = builder.startingIndex;
        this.skipEvery = builder.skipEvery;
        this.center = new Vector2(builder.centerX, builder.centerY);
        this.radius = builder.radius;
        this.rotateFor = builder.rotateFor;
        this.numWalls = builder.numWalls;
        this.wallThickness = builder.wallThickness;
        this.physicsWorld = builder.physicsWorld;
        this.wallColors = builder.wallColors;
        this.speed = builder.speed;
        this.wallBodies = new Array<Body>();
        this.ropeJoints = new Array<RevoluteJoint>();
        this.rotateBy = builder.rotateBy;
        this.isRevolving = false;
        if (rotateBy > 0) {
            rotateFor = rotateBy * degreesToRadians / speed.getAngularVelocity();
        }
        this.createWalls();
    }

    private void createWalls() {

        float theta = 180f / numWalls;
        float boxWidth = radius * 2 * MathUtils.sinDeg(0.75f * theta);

        BodyDef anchor = new BodyDef();
        anchor.type = BodyDef.BodyType.StaticBody;
        anchor.position.set(center.x, center.y);

        CircleShape anchorShape = new CircleShape();
        anchorShape.setRadius(0.1f);

        FixtureDef def = new FixtureDef();
        def.density = 1.0f;
        def.isSensor = true;
        def.shape = anchorShape;

        centerBody = physicsWorld.createBody(anchor);
        centerBody.createFixture(def);

        float startAngle = 0;

        for (int i = 0; i < numWalls; i += 1 + skipEvery) {
            startAngle = 2 * theta * i;
            float wallCenterX = radius * MathUtils.cosDeg(startAngle) + center.x;
            float wallCenterY = radius * MathUtils.sinDeg(startAngle) + center.y;

            BodyDef wallDef = new BodyDef();
            wallDef.type = BodyDef.BodyType.DynamicBody;
            wallDef.position.set(wallCenterX, wallCenterY);
            wallDef.angle = degreesToRadians * (startAngle + 90);

            PolygonShape wallShape = new PolygonShape();
            wallShape.setAsBox(boxWidth / 2f, wallThickness / 2f);

            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.density = 1.0f;
            fixtureDef.shape = wallShape;

            Body wall = physicsWorld.createBody(wallDef);
            Fixture wallFix = wall.createFixture(fixtureDef);

            wallShape.dispose();
            wallBodies.add(wall);

            RevoluteJointDef jointDef = new RevoluteJointDef();

            jointDef.localAnchorA.set(wall.getLocalPoint(center));
            jointDef.localAnchorB.set(centerBody.getLocalCenter());

            jointDef.bodyA = wall;
            jointDef.bodyB = centerBody;

            jointDef.enableMotor = false;
            jointDef.motorSpeed = speed.getAngularVelocity();
            jointDef.maxMotorTorque = 1500;

            rope = (RevoluteJoint) physicsWorld.createJoint(jointDef);
            ropeJoints.add(rope);
        }

        canRevolve = rotateBy > 0 || rotateFor > 0;
    }

    public void update(float deltaTime) {
        if (!canRevolve) {
            return;
        }
        if (isRevolving) {
            runningTime += deltaTime;
            if (runningTime >= rotateFor) {
                System.out.println("RUNNING TIME" + runningTime);
                runningTime -= rotateFor;
                isRevolving = false;
                for (Body body : wallBodies) {
                    body.setType(BodyDef.BodyType.StaticBody);
                }
            }
        } else {
            stillTime += deltaTime;
            if (stillTime >= STILL_TIME) {
                stillTime -= STILL_TIME;
                isRevolving = true;
                for (Body body : wallBodies) {
                    body.setType(BodyDef.BodyType.DynamicBody);
                }
            }
        }
        for (RevoluteJoint rope : ropeJoints) {
            rope.enableMotor(isRevolving);
        }
        totalRunTime += deltaTime;
    }

    public void destroy() {
        for (RevoluteJoint joint : ropeJoints) {
            physicsWorld.destroyJoint(joint);
        }
        for (Body body : wallBodies) {
            physicsWorld.destroyBody(body);
        }
        if (centerBody != null) {
            physicsWorld.destroyBody(centerBody);
        }
    }

    public static class Builder {
        private int startingIndex = 0;
        private int skipEvery = 0;
        private float centerX = 0;
        private float centerY = 0;
        private float radius = 1;

        private float rotateFor = -1;
        private float rotateBy = -1;

        private Color wallColors[] = {Color.BLACK};
        private float wallThickness = 0.25f;

        private World physicsWorld = null;
        private int numWalls = 4;

        private REVOLVING_SPEED speed = REVOLVING_SPEED.SLOW;

        public Builder(World physicsWorld, int numWalls) {
            this.physicsWorld = physicsWorld;
            this.numWalls = numWalls;
        }

        public Builder rotateEverySpinBy(float angle) {
            this.rotateBy = angle;
            return this;
        }

        public Builder setSpeed(REVOLVING_SPEED speed) {
            this.speed = speed;
            return this;
        }

        public Builder setStartingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
            return this;
        }

        public Builder skipEvery(int skipEvery) {
            this.skipEvery = skipEvery;
            return this;
        }

        public Builder setCenter(float x, float y) {
            this.centerX = x;
            this.centerY = y;
            return this;
        }

        public Builder setRadius(float radius) {
            this.radius = radius;
            return this;
        }

        public Builder rotateFor(float rotateFor) {
            this.rotateFor = rotateFor;
            return this;
        }

        public Builder setWallColors(Color[] colors) {
            this.wallColors = colors;
            return this;
        }

        public Builder setWallThickness(float thickness) {
            this.wallThickness = thickness;
            return this;
        }

        public RevolvingWalls build() {
            return new RevolvingWalls(this);
        }

    }
}
