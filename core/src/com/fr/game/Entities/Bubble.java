//package com.fr.game.Entities;
//
//
//import com.google.fpl.liquidfun.CircleShape;
//import com.google.fpl.liquidfun.Color;
//import com.google.fpl.liquidfun.ParticleFlag;
//import com.google.fpl.liquidfun.ParticleGroup;
//import com.google.fpl.liquidfun.ParticleGroupDef;
//import com.google.fpl.liquidfun.ParticleSystem;
//import com.google.fpl.liquidfun.ParticleSystemDef;
//import com.google.fpl.liquidfun.Vec2;
//import com.google.fpl.liquidfun.World;
//
///**
// * Created by syhussai on 4/29/2016.
// */
//
//public class Bubble {
//
//    public static final float BUBBLE_RADIUS = 2.0f;
//
//    ParticleSystem bubbleSystem;
//    ParticleGroup bubbleGroup;
//
//    public Bubble(World physicsWorld, Vec2 position , Color color) {
//
//        CircleShape bubbleShape = new CircleShape();
//        bubbleShape.setRadius(BUBBLE_RADIUS);
//        bubbleShape.setPosition(position.getX(), position.getY());
//
//        ParticleSystemDef systemDef = new ParticleSystemDef();
//        bubbleSystem = physicsWorld.createParticleSystem(systemDef);
//
//        ParticleGroupDef bubbleDef = new ParticleGroupDef();
//        bubbleDef.setCircleShapes(bubbleShape);
//        bubbleDef.setFlags(ParticleFlag.waterParticle | ParticleFlag.colorMixingParticle);
//        bubbleGroup = bubbleSystem.createParticleGroup(bubbleDef);
//
//    }
//
//    public void update(float deltaTime){
//
//    }
//}
