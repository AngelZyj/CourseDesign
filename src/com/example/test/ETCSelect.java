package com.example.test;

import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class ETCSelect extends Activity {
	int Width;
	int Height;
	Display display;
	Button bnum,bcolorfont,bpic,bcolor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etcselect);
		display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
        bnum = (Button)this.findViewById(R.id.nummode);
		bnum.setWidth((Width*3)/4);
		bnum.setHeight(Height/7);
		bnum.setY(Height/12);
		ObjectAnimator objnum = ObjectAnimator.ofFloat(bnum, "translationX", Height,Width/12);
//		ObjectAnimator objsingle2 = ObjectAnimator.ofFloat(bsingle, "Alpha", 0,100);
		objnum.setDuration(1000);
		objnum.start();
		
		bcolorfont = (Button)this.findViewById(R.id.colorfontmode);
		bcolorfont.setWidth((Width*3)/4);
		bcolorfont.setHeight(Height/7);
		bcolorfont.setY((Height*3)/12);
		ObjectAnimator objcolorfont = ObjectAnimator.ofFloat(bcolorfont, "translationX", -Height,Width/12);
//		ObjectAnimator objsingle2 = ObjectAnimator.ofFloat(bsingle, "Alpha", 0,100);
		objcolorfont.setDuration(1000);
		objcolorfont.start();
		
		bpic = (Button)this.findViewById(R.id.picmode);
		bpic.setWidth((Width*3)/4);
		bpic.setHeight(Height/7);
		bpic.setY((Height*5)/12);
		ObjectAnimator objpic = ObjectAnimator.ofFloat(bpic, "translationX", Height,Width/12);
		objpic.setDuration(1000);
		objpic.start();
		
		
		bcolor = (Button)this.findViewById(R.id.colormode);
		bcolor.setWidth((Width*3)/4);
		bcolor.setHeight(Height/7);
		bcolor.setY((Height*7)/12);
		ObjectAnimator objcolor = ObjectAnimator.ofFloat(bcolor, "translationX", -Height,Width/12);
		objcolor.setDuration(1000);
		objcolor.start();
		
		
		bnum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ETC.star=1;
				Intent intent = new Intent(ETCSelect.this,ETC.class);
				startActivity(intent);
			}
		});
		bcolorfont.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ETC.star=2;
				Intent intent2 = new Intent(ETCSelect.this,ETC.class);
				startActivity(intent2);
			}
		});
		bpic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ETC.star=3;
				Intent intent3 = new Intent(ETCSelect.this,ETC.class);
				startActivity(intent3);
			}
		});
		bcolor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ETC.star=4;
				Intent intent4 = new Intent(ETCSelect.this,ETC.class);
				startActivity(intent4);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.etcselect, menu);
		return true;
	}

}
