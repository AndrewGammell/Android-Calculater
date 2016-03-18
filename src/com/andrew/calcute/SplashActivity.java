package com.andrew.calcute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class SplashActivity extends Activity{

	private ImageView image;
	private float rotation = 1.0F;
	private long duration = 6*1000L;
	private long interval = 25L;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		createViews();

		new CountDownTimer(duration,interval){
			public void onTick(long millisUntilFinished) {
				new RotateThread((rotation+=2.0F)).run();


			}
			public void onFinish() {
				Intent i = new Intent(SplashActivity.this,MainActivity.class);
				startActivity(i);
			}
		}.start();
	}


	private void createViews(){
		image = (ImageView)findViewById(R.id.image);
	}
	
	
	private class RotateThread implements Runnable{
		float interval;

		public RotateThread(float interval){
			this.interval = interval;
		}
		@Override
		public void run() {
			image.setRotation(interval);

		}

	}

}
