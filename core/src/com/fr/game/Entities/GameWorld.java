//package com.fr.game.Entities;
//
//import com.google.fpl.liquidfun.Color;
//import com.google.fpl.liquidfun.Vec2;
//import com.google.fpl.liquidfun.World;
//
///**
// * Created by syhussai on 4/29/2016.
// */
//public class GameWorld {
//
//    World physicsWorld;
//    Bubble bubble;
//    Wall wall;
//
//    public int score;
//
//    private float accumulator = 0;
//
//    private final float TIME_STEP = 1 / 60f;
//    private final int VELOCITY_ITERATIONS = 6;
//    private final int POSITION_ITERATIONS = 2;
//    private final int PARTICLE_ITERATIONS = 4;
//
//    public GameWorld() {
//        physicsWorld = new World(0, 0);
//        bubble = new Bubble(physicsWorld, new Vec2(), new Color(1, 0, 1));
//    }
//
//    public void update(float deltaTime) {
//        deltaTime = Math.min(deltaTime, 0.25f);
//        accumulator += deltaTime;
//        while (accumulator >= TIME_STEP) {
//            physicsWorld.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS, PARTICLE_ITERATIONS);
//            accumulator -= TIME_STEP;
//        }
//    }
//
//}
