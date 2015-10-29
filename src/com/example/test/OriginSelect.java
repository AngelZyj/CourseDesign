package com.example.test;

import android.os.Bundle;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class OriginSelect extends Activity {
	Display display;
    int Width;
    int Height;
    Button bsingle,bdouble;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_origin_select);
		display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
        
        
        bsingle = (Button)this.findViewById(R.id.singlemode);
		bsingle.setWidth((Width*3)/4);
		bsingle.setHeight(Height/7);
		bsingle.setY(Height/5);
		ObjectAnimator objsingle = ObjectAnimator.ofFloat(bsingle, "translationX", Height,Width/12);
//		ObjectAnimator objsingle2 = ObjectAnimator.ofFloat(bsingle, "Alpha", 0,100);
		objsingle.setDuration(1000);
		objsingle.start();
        
        
        bdouble = (Button)this.findViewById(R.id.doublemode);
		bdouble.setWidth((Width*3)/4);
		bdouble.setHeight(Height/7);
		bdouble.setY((Height*4)/7);
		ObjectAnimator objdouble = ObjectAnimator.ofFloat(bdouble, "translationX", -Height,Width/12);
//		ObjectAnimator objdouble2 = ObjectAnimator.ofFloat(bdouble, "Alpha", 0,100);
		objdouble.setDuration(1000);
		objdouble.start();
		
		
		bsingle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intosingle = new Intent(OriginSelect.this,MusicList.class);
				startActivity(intosingle);
				OriginSelect.this.finish();
			}
		});
		bdouble.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intodouble = new Intent(OriginSelect.this,DoubleGame.class);
				startActivity(intodouble);
				OriginSelect.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.origin_select, menu);
		return true;
	}

}
