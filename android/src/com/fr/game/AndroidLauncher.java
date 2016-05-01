package com.fr.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.fr.game.main.ColorSwipe;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//		System.loadLibrary("liquidfun");
//		System.loadLibrary("liquidfun_jni");

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new ColorSwipe(), config);
	}

}
