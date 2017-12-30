package me.samuki.clicker;

import android.os.Bundle;
import android.view.View;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import me.samuki.clicker.base.androidcommunication.SaveListenerImpl;
import me.samuki.clicker.base.interfaces.communication.SaveListener;

public class AndroidLauncher extends AndroidApplication {
	private SaveListener saveListener;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		saveListener = new SaveListenerImpl();

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new CoreLauncher(), config);
	}

	@Override
	protected void onResume() {
		super.onResume();
		hideSystemUI();
	}

    @Override
    protected void onPause() {
	    saveListener.saveEverything();
        super.onPause();
    }

    @Override
    protected void onStop() {
	    saveListener.saveEverything();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
	    saveListener.saveEverything();
        super.onDestroy();
    }

    private void hideSystemUI() {
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}
}
