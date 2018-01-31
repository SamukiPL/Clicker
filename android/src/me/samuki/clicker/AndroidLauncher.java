package me.samuki.clicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;

import org.jetbrains.annotations.Nullable;

import me.samuki.clicker.base.androidcommunication.SaveListenerImpl;
import me.samuki.clicker.base.interfaces.communication.AndroidAdsCommunicator;
import me.samuki.clicker.base.interfaces.communication.SaveListener;
import me.samuki.clicker.interfaces.IGameServicesHelper;

import static android.widget.RelativeLayout.ABOVE;
import static android.widget.RelativeLayout.ALIGN_TOP;

public class AndroidLauncher extends AndroidApplication implements AndroidAdsCommunicator {
	//Testowe zakomentowane
	final String AD_UNIT_ID_BANNER = "ca-app-pub-3940256099942544/6300978111";
	final String AD_UNIT_ID_INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712";
	final String AD_UNIT_ID_REWARDED = "ca-app-pub-3940256099942544/5224354917";

	private SaveListener saveListener;
	private IGameServicesHelper gameServicesHelper;

	private View gameView;
	private AdView adView;
	private RewardedVideoAd rewardedAd;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gameServicesHelper = new GameServicesHelper(this);
		saveListener = new SaveListenerImpl();

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		gameView = initializeForView(new CoreLauncher(this), config);

		RelativeLayout layout = new RelativeLayout(this);
		RelativeLayout.LayoutParams gameViewParams = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		layout.addView(gameView, gameViewParams);

		initAdView();
		initRewardedAd();

		RelativeLayout.LayoutParams adParams =  new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		adParams.setMargins(0, -AdSize.SMART_BANNER.getHeightInPixels(this), 0, 0);
		adParams.addRule(ALIGN_TOP);
		adParams.addRule(ABOVE, gameView.getId());
		layout.addView(adView, adParams);

		setContentView(layout);

		adView.setAdListener(getBannerAdListener(gameViewParams, adParams, AdSize.SMART_BANNER.getHeightInPixels(this)));
		startAdvertising();
	}

	private void initAdView() {
		adView = new AdView(this);
		adView.setVisibility(View.VISIBLE);
		adView.setBackgroundColor(0xff000000);
		adView.setAdUnitId(AD_UNIT_ID_BANNER);
		adView.setAdSize(AdSize.SMART_BANNER);
	}

	private void initRewardedAd() {
		rewardedAd = MobileAds.getRewardedVideoAdInstance(this);
		rewardedAd.setRewardedVideoAdListener(new RewardedAdListener() {

            @Override
            public void onRewardedVideoAdClosed() {
                loadRewardedAd();
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int p0) {
                loadRewardedAd();
            }

            @Override
            public void onRewarded(@Nullable RewardItem p0) {

            }
        });
        loadRewardedAd();
	}

    @Override
    public void showRewardedAd() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(rewardedAd.isLoaded()) {
                        rewardedAd.show();
                    }
                }
            });
        } catch (Exception ignored) {

        }
    }

    private void loadRewardedAd() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    rewardedAd.loadAd(AD_UNIT_ID_REWARDED, new AdRequest.Builder()
                            .addTestDevice("111799C3AA4FAD728F7A0E814E55273F").build());
                }
            });
        } catch (Exception ignored) {}
    }

	private void startAdvertising() {
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("111799C3AA4FAD728F7A0E814E55273F")
				.build();
		adView.loadAd(adRequest);
	}

	private AdListener getBannerAdListener(final RelativeLayout.LayoutParams gameViewParams,
										   final RelativeLayout.LayoutParams adParams,
										   final int adSizeInPixels) {
		return new AdListener() {
			@Override
			public void onAdClosed() {
				super.onAdClosed();
			}

			@Override
			public void onAdFailedToLoad(int i) {
				super.onAdFailedToLoad(i);
				hideSystemUI();
				gameViewParams.setMargins(0, 0, 0, 0);
				gameView.setLayoutParams(gameViewParams);
				adParams.setMargins(0, -adSizeInPixels, 0, 0);
				adView.setLayoutParams(adParams);
			}

			@Override
			public void onAdLeftApplication() {
				super.onAdLeftApplication();
			}

			@Override
			public void onAdOpened() {
				super.onAdOpened();
			}

			@Override
			public void onAdLoaded() {
				super.onAdLoaded();
				hideSystemUI();
				gameViewParams.setMargins(0, adSizeInPixels, 0, 0);
				gameView.setLayoutParams(gameViewParams);
				adParams.setMargins(0, 0, 0, 0);
				adView.setLayoutParams(adParams);
			}
		};
	}

	@Override
	protected void onResume() {
		super.onResume();
		rewardedAd.resume(this);
		hideSystemUI();
		gameServicesHelper.silentSignIn();
	}

    @Override
    protected void onPause() {
	    rewardedAd.pause(this);
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
	    rewardedAd.destroy(this);
	    saveListener.saveEverything();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        gameServicesHelper.onResult(requestCode, data);
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
