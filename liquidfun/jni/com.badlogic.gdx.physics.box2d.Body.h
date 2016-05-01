/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_badlogic_gdx_physics_box2d_Body */

#ifndef _Included_com_badlogic_gdx_physics_box2d_Body
#define _Included_com_badlogic_gdx_physics_box2d_Body
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniCreateFixture
 * Signature: (JJFFFZSSS)J
 */
JNIEXPORT jlong JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniCreateFixture__JJFFFZSSS
  (JNIEnv *, jobject, jlong, jlong, jfloat, jfloat, jfloat, jboolean, jshort, jshort, jshort);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniCreateFixture
 * Signature: (JJF)J
 */
JNIEXPORT jlong JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniCreateFixture__JJF
  (JNIEnv *, jobject, jlong, jlong, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniDestroyFixture
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniDestroyFixture
  (JNIEnv *, jobject, jlong, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetTransform
 * Signature: (JFFF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetTransform
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetTransform
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetTransform
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetPosition
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetPosition
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetAngle
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetAngle
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetWorldCenter
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetWorldCenter
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLocalCenter
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLocalCenter
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetLinearVelocity
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetLinearVelocity
  (JNIEnv *, jobject, jlong, jfloat, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLinearVelocity
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLinearVelocity
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetAngularVelocity
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetAngularVelocity
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetAngularVelocity
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetAngularVelocity
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniApplyForce
 * Signature: (JFFFFZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniApplyForce
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloat, jfloat, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniApplyForceToCenter
 * Signature: (JFFZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniApplyForceToCenter
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniApplyTorque
 * Signature: (JFZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniApplyTorque
  (JNIEnv *, jobject, jlong, jfloat, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniApplyLinearImpulse
 * Signature: (JFFFFZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniApplyLinearImpulse
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloat, jfloat, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniApplyAngularImpulse
 * Signature: (JFZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniApplyAngularImpulse
  (JNIEnv *, jobject, jlong, jfloat, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetMass
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetMass
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetInertia
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetInertia
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetMassData
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetMassData
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetMassData
 * Signature: (JFFFF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetMassData
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloat, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniResetMassData
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniResetMassData
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetWorldPoint
 * Signature: (JFF[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetWorldPoint
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetWorldVector
 * Signature: (JFF[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetWorldVector
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLocalPoint
 * Signature: (JFF[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLocalPoint
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLocalVector
 * Signature: (JFF[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLocalVector
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLinearVelocityFromWorldPoint
 * Signature: (JFF[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLinearVelocityFromWorldPoint
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLinearVelocityFromLocalPoint
 * Signature: (JFF[F)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLinearVelocityFromLocalPoint
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloatArray);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetLinearDamping
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetLinearDamping
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetLinearDamping
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetLinearDamping
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetAngularDamping
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetAngularDamping
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetAngularDamping
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetAngularDamping
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetType
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetType
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetType
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetType
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetBullet
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetBullet
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniIsBullet
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniIsBullet
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetSleepingAllowed
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetSleepingAllowed
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniIsSleepingAllowed
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniIsSleepingAllowed
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetAwake
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetAwake
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniIsAwake
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniIsAwake
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetActive
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetActive
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniIsActive
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniIsActive
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetFixedRotation
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetFixedRotation
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniIsFixedRotation
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniIsFixedRotation
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniGetGravityScale
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniGetGravityScale
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetGravityScale
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetGravityScale
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_badlogic_gdx_physics_box2d_Body
 * Method:    jniSetUseParticleBodyContactListener
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_Body_jniSetUseParticleBodyContactListener
  (JNIEnv *, jobject, jlong, jboolean);

#ifdef __cplusplus
}
#endif
#endif
