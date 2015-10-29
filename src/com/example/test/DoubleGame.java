package com.example.test;

import java.util.Random;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DoubleGame extends Activity {
	Button doubleCenter;
	TextView topgradeview,btmgradeview;
	Display display;
	int Width,Height;
	Handler handler;
	Runnable task,task1;
	int colorrandom[] = {Color.BLACK,Color.WHITE};  //黑白随机数组
	Random r;
	int currentcolor;              //Random产生的随机数
	FrameLayout.LayoutParams params;
	Button[] bgroup,bgroup1;               //铺满整个屏幕的按钮数组
	ObjectAnimator objgroup[],objgroup1[];      //按钮对应动画数组
	int groupIndex=0;
	int topgrade=0;                     //玩家一成绩
	int bottomgrade=0;					//玩家二成绩
	int blockstopcount;					//控制滑块达到停止值
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_double_game);
		display = this.getWindowManager().getDefaultDisplay();
		Width = display.getWidth();
		Height = display.getHeight();
		//doubleCenter = (Button)this.findViewById(R.id.doubleCenter);
		params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
		doubleCenter = new Button(DoubleGame.this);
		this.addContentView(doubleCenter, params);
		doubleCenter.setX(0);
		doubleCenter.setY((Height*2)/5);
		doubleCenter.setWidth(Width);
		doubleCenter.setHeight(Height/7);
		doubleCenter.setBackgroundColor(Color.CYAN);
		doubleCenter.bringToFront();
		
		topgradeview = new TextView(DoubleGame.this);
		this.addContentView(topgradeview, params);
		topgradeview.setX((Width*3)/6);
		topgradeview.setY((Height*9)/16);
		topgradeview.setTextSize(22);
		topgradeview.setTextColor(Color.RED);
		topgradeview.setText("分数：0");
		
		
		btmgradeview = new TextView(DoubleGame.this);
		this.addContentView(btmgradeview, params);
		btmgradeview.setX(Width/3);
		btmgradeview.setY((Height*5)/16);
		btmgradeview.setTextSize(22);
		btmgradeview.setTextColor(Color.RED);
		btmgradeview.setText("分数：0");
		btmgradeview.setRotationX(180);
		btmgradeview.setRotationY(180);
		
		bgroup = new Button[12];                //下面6个按钮
		for(int i=0;i<12;i++){
        	bgroup[i] = new Button(DoubleGame.this);
        }
        objgroup = new ObjectAnimator[12];    //下面6个按钮的动画
        for(int j=0;j<12;j++){
        	objgroup[j] = new ObjectAnimator();
        }
        
        
        
        bgroup1 = new Button[12];                //下面6个按钮
		for(int i=0;i<12;i++){
        	bgroup1[i] = new Button(DoubleGame.this);
        }
        objgroup1 = new ObjectAnimator[12];    //下面6个按钮的动画
        for(int j=0;j<12;j++){
        	objgroup1[j] = new ObjectAnimator();
        }
        
        
		
		
		
		handler = new Handler();
		task = new Runnable(){
			public void run(){
				handler.postDelayed(this,500);//设置延迟时间
                groupBlock();
                blockstopcount = blockstopcount+1;
                if(blockstopcount==10){
                	ActionStop();
                }
			}
		};
		task1 = new Runnable(){
			public void run(){
				handler.postDelayed(this, 500);
				groupBlock1();
			}
		};
		
		doubleCenter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				handler.post(task);
				handler.post(task1);
			}
		});
	
		
	}
	public void groupBlock(){
		switch (groupIndex%12) {
		case 0:
			initBlock(0,1,2,3,bgroup[0], bgroup[1],bgroup[2],bgroup[3]);
			groupIndex = groupIndex+4;
			break;
        case 4:
			initBlock(4,5,6,7,bgroup[4], bgroup[5],bgroup[6],bgroup[7]);
			groupIndex = groupIndex+4;
			break;
        case 8:
			initBlock(8,9,10,11,bgroup[8], bgroup[9],bgroup[10],bgroup[11]);
			groupIndex = groupIndex+4;
			break;
        
		}
			
	}
	
	public void groupBlock1(){
		switch (groupIndex%12) {
		case 0:
			initBlock1(0,1,2,3,bgroup1[0], bgroup1[1],bgroup1[2],bgroup1[3]);
			groupIndex = groupIndex+4;
			break;
        case 4:
			initBlock1(4,5,6,7,bgroup1[4], bgroup1[5],bgroup1[6],bgroup1[7]);
			groupIndex = groupIndex+4;
			break;
        case 8:
			initBlock1(8,9,10,11,bgroup1[8], bgroup1[9],bgroup1[10],bgroup1[11]);
			groupIndex = groupIndex+4;
			break;
		}
			
	}
	public void initBlock(int i,int j,int o,int u,Button bb1,Button bb2,Button bb3,Button bb4){
		
		bb1 = new Button(DoubleGame.this);
		bb2 = new Button(DoubleGame.this);
		bb3 = new Button(DoubleGame.this);
		bb4 = new Button(DoubleGame.this);
		r = new Random();
		currentcolor = r.nextInt(4);
		if(currentcolor==0){
			bb1.setBackgroundColor(Color.BLACK);
			bb2.setBackgroundColor(Color.WHITE);
			bb3.setBackgroundColor(Color.WHITE);
			bb4.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==1){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.BLACK);
			bb3.setBackgroundColor(Color.WHITE);
			bb4.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==2){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.WHITE);
			bb3.setBackgroundColor(Color.BLACK);
			bb4.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==3){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.WHITE);
			bb3.setBackgroundColor(Color.WHITE);
			bb4.setBackgroundColor(Color.BLACK);
		}
		
		bb1.setWidth(Width/2);
        bb1.setHeight(Height/7);
		bb1.setX(0);
		bb1.setY((Height*3/5));
		this.addContentView(bb1, params);
		bb2.setWidth(Width/2);
        bb2.setHeight(Height/7);
		bb2.setX(0.25f*Width);
		bb2.setY((Height*3)/5);
		this.addContentView(bb2, params);
		bb3.setWidth(Width/2);
        bb3.setHeight(Height/7);
		bb3.setX(0.5f*Width);
		bb3.setY((Height*3)/5);
		this.addContentView(bb3, params);
		bb4.setWidth(Width/2);
        bb4.setHeight(Height/7);
		bb4.setX(0.75f*Width);
		bb4.setY((Height*3)/5);
		this.addContentView(bb4, params);
		
		objgroup[i] = ObjectAnimator.ofFloat(bb1, "TranslationY", (Height*2)/5,Height);
		objgroup[i].setInterpolator(new LinearInterpolator());
		objgroup[i].setDuration(2200);
		objgroup[i].start();
		objgroup[j] = ObjectAnimator.ofFloat(bb2, "TranslationY", (Height*2)/5,Height);
		objgroup[j].setInterpolator(new LinearInterpolator());
		objgroup[j].setDuration(2200);
		objgroup[j].start();
		objgroup[o] = ObjectAnimator.ofFloat(bb3, "TranslationY", (Height*2)/5,Height);
		objgroup[o].setInterpolator(new LinearInterpolator());
		objgroup[o].setDuration(2200);
		objgroup[o].start();
		objgroup[u] = ObjectAnimator.ofFloat(bb4, "TranslationY", (Height*2)/5,Height);
		objgroup[u].setInterpolator(new LinearInterpolator());
		objgroup[u].setDuration(2200);
		objgroup[u].start();
		AnimatorSet as = new AnimatorSet();
		as.play(objgroup[i]).with(objgroup[j]).with(objgroup[o]).with(objgroup[u]);
		doubleCenter.bringToFront();
		topgradeview.bringToFront();
		
		bb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					topgrade = topgrade+1;
					topgradeview.setText("分数："+topgrade);
					topgradeview.bringToFront();
				}
				else{
					topgrade = topgrade-1;
					topgradeview.setText("分数："+topgrade);
//					ActionStop();
//					DoubleGame.this.onPause();
//					handler.removeCallbacks(task);
				}
			}
		});
		bb2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					topgrade = topgrade+1;
					topgradeview.setText("分数："+topgrade);
					topgradeview.bringToFront();
				}
				else{
					topgrade = topgrade-1;
					topgradeview.setText("分数："+topgrade);
//					ActionStop();
//					DoubleGame.this.onPause();
//					handler.removeCallbacks(task);
				}
			}
		});
		bb3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					topgrade = topgrade+1;
					topgradeview.setText("分数："+topgrade);
					topgradeview.bringToFront();
				}
				else{
					topgrade = topgrade-1;
					topgradeview.setText("分数："+topgrade);
//					ActionStop();
//					DoubleGame.this.onPause();
//					handler.removeCallbacks(task);
				}
			}
		});
		bb4.setOnClickListener(new OnClickListener() {
	
		@Override
			public void onClick(View v) {
			Drawable background = v.getBackground();
			ColorDrawable colorDrawable = (ColorDrawable) background;
			int color = colorDrawable.getColor();
			int getcolor = Resources.getSystem().getColor(android.R.color.black);
			if(color == getcolor){
				v.setBackgroundColor(Color.GRAY);
				topgrade = topgrade+1;
				topgradeview.setText("分数："+topgrade);
				topgradeview.bringToFront();
			}
			else{
				topgrade = topgrade-1;
				topgradeview.setText("分数："+topgrade);
//				ActionStop();
//				DoubleGame.this.onPause();
//				handler.removeCallbacks(task);
				}
			}
		});
	}
	
	
	
	public void initBlock1(int i,int j,int o,int u,Button bb1,Button bb2,Button bb3,Button bb4){
		//doubleCenter.bringToFront();
		bb1 = new Button(DoubleGame.this);
		bb2 = new Button(DoubleGame.this);
		bb3 = new Button(DoubleGame.this);
		bb4 = new Button(DoubleGame.this);
		r = new Random();
		currentcolor = r.nextInt(4);
		
		if(currentcolor==0){
			bb1.setBackgroundColor(Color.BLACK);
			bb2.setBackgroundColor(Color.WHITE);
			bb3.setBackgroundColor(Color.WHITE);
			bb4.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==1){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.BLACK);
			bb3.setBackgroundColor(Color.WHITE);
			bb4.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==2){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.WHITE);
			bb3.setBackgroundColor(Color.BLACK);
			bb4.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==3){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.WHITE);
			bb3.setBackgroundColor(Color.WHITE);
			bb4.setBackgroundColor(Color.BLACK);
		}
		
		bb1.setWidth(Width/2);
        bb1.setHeight(Height/7);
		bb1.setX(0);
		bb1.setY((Height*3/5));
		this.addContentView(bb1, params);
		bb2.setWidth(Width/2);
        bb2.setHeight(Height/7);
		bb2.setX(0.25f*Width);
		bb2.setY((Height*3)/5);
		this.addContentView(bb2, params);
		bb3.setWidth(Width/2);
        bb3.setHeight(Height/7);
		bb3.setX(0.5f*Width);
		bb3.setY((Height*3)/5);
		this.addContentView(bb3, params);
		bb4.setWidth(Width/2);
        bb4.setHeight(Height/7);
		bb4.setX(0.75f*Width);
		bb4.setY((Height*3)/5);
		this.addContentView(bb4, params);
		
		
		
		objgroup1[i] = ObjectAnimator.ofFloat(bb1, "TranslationY", (Height*2)/5,-Height/5);
		objgroup1[i].setInterpolator(new LinearInterpolator());
		objgroup1[i].setDuration(2200);
		objgroup1[i].start();
		objgroup1[j] = ObjectAnimator.ofFloat(bb2, "TranslationY", (Height*2)/5,-Height/5);
		objgroup1[j].setInterpolator(new LinearInterpolator());
		objgroup1[j].setDuration(2200);
		objgroup1[j].start();
		objgroup1[o] = ObjectAnimator.ofFloat(bb3, "TranslationY", (Height*2)/5,-Height/5);
		objgroup1[o].setInterpolator(new LinearInterpolator());
		objgroup1[o].setDuration(2200);
		objgroup1[o].start();
		objgroup1[u] = ObjectAnimator.ofFloat(bb4, "TranslationY", (Height*2)/5,-Height/5);
		objgroup1[u].setInterpolator(new LinearInterpolator());
		objgroup1[u].setDuration(2200);
		objgroup1[u].start();
		AnimatorSet as = new AnimatorSet();
		as.play(objgroup1[i]).with(objgroup1[j]).with(objgroup1[o]).with(objgroup1[u]);
		
		doubleCenter.bringToFront();
		btmgradeview.bringToFront();
		
		bb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					bottomgrade = bottomgrade+1;
					btmgradeview.setText("分数："+bottomgrade);
				}
				else{
//					ActionStop();
//					DoubleGame.this.onPause();
//					handler.removeCallbacks(task1);
					bottomgrade = bottomgrade-1;
					btmgradeview.setText("分数："+bottomgrade);
				}
			}
		});
		bb2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					bottomgrade = bottomgrade+1;
					btmgradeview.setText("分数："+bottomgrade);
				}
				else{
//					ActionStop();
//					DoubleGame.this.onPause();
//					handler.removeCallbacks(task1);
					bottomgrade = bottomgrade-1;
					btmgradeview.setText("分数："+bottomgrade);
				}
			}
		});
		bb3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					bottomgrade = bottomgrade+1;
					btmgradeview.setText("分数："+bottomgrade);
				}
				else{
//					ActionStop();
//					DoubleGame.this.onPause();
//					handler.removeCallbacks(task1);
					bottomgrade = bottomgrade-1;
					btmgradeview.setText("分数："+bottomgrade);
				}
			}
		});
		bb4.setOnClickListener(new OnClickListener() {
	
		@Override
			public void onClick(View v) {
			Drawable background = v.getBackground();
			ColorDrawable colorDrawable = (ColorDrawable) background;
			int color = colorDrawable.getColor();
			int getcolor = Resources.getSystem().getColor(android.R.color.black);
			if(color == getcolor){
				v.setBackgroundColor(Color.GRAY);
				bottomgrade = bottomgrade+1;
				btmgradeview.setText("分数："+bottomgrade);
			}
			else{
//				ActionStop();
//				DoubleGame.this.onPause();
//				handler.removeCallbacks(task1);
				bottomgrade = bottomgrade-1;
				btmgradeview.setText("分数："+bottomgrade);
				}
			}
		});
	}
	
	public void ActionStop(){                          //暂停所有滑块
		for(int k=0;k<12;k++){
			objgroup[k].cancel();
			objgroup1[k].cancel();
		}
		AlertDialog.Builder builder = new Builder(DoubleGame.this);
		builder.setCancelable(false);
		builder.setTitle("最终成绩");
		if(topgrade>bottomgrade){
			builder.setMessage("玩家一获胜！");
		}
		else if(topgrade<bottomgrade){
			builder.setMessage("玩家二获胜！");
		}
		else{
			builder.setMessage("势均力敌");
		}
		builder.setPositiveButton("结束", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				arg0.dismiss();
                Intent intent = new Intent(DoubleGame.this,Gallery3DActivity.class);
                startActivity(intent);
                DoubleGame.this.finish();
              // TODO Auto-generated method stub
				
			}
		});
		builder.setNegativeButton("重来", new android.content.DialogInterface.OnClickListener(){
			public void onClick(DialogInterface arg0, int arg1){
				arg0.dismiss();
				DoubleGame.this.finish();
				Intent intent1 = new Intent(DoubleGame.this,DoubleGame.class);
                startActivity(intent1);
				
			}
		});
		builder.show();
		handler.removeCallbacks(task);
		handler.removeCallbacks(task1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.double_game, menu);
		return true;
	}

}
