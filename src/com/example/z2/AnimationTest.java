package com.example.test;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.test.Gallery3DActivity;

public class AnimationTest extends Activity {
	Handler handler;        //产生滑块的线程
	Runnable task,task1;
	static int speed=1100;         //滑块滑动速度
	int Width,Height;       //屏幕宽高
	int colorrandom[] = {Color.BLACK,Color.WHITE};  //黑白随机数组
	Random r;
	int currentcolor;              //Random产生的随机数
	int count=0;		           //计算所按黑块的数量	
	Button left,right;             //左列和右列
	//ObjectAnimator objleft,objright;      
	Button start;                  //游戏启动
	FrameLayout.LayoutParams params;     
	TextView Viewcount;          //屏幕上方显示计数
	Button[] bgroup;                //铺满整个屏幕的按钮数组
	ObjectAnimator objgroup[];      //按钮对应动画数组
	MediaPlayer mp3;
	int groupIndex=0;               //判断按钮行数
	int isPressed = 0;
	ImageButton imagestart;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);   //设置取消安卓标题栏
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation_test);
		//start = (Button)this.findViewById(R.id.ccc);
		
		imagestart = (ImageButton)this.findViewById(R.id.imagestart);
		Display display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
        Viewcount = new TextView(AnimationTest.this);
        params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        bgroup = new Button[12];   //铺满界面的6行按钮
        for(int i=0;i<12;i++){
        	bgroup[i] = new Button(AnimationTest.this);
        }
        objgroup = new ObjectAnimator[12];    //12个按钮的动画
        for(int j=0;j<12;j++){
        	objgroup[j] = new ObjectAnimator();
        }
        
        
        handler = new Handler();                          //定时产生滑块
        task = new Runnable() {  
            public void run() {   
                    handler.postDelayed(this,speed/4-speed/36);//设置延迟时间
                    groupBlock();
            }   
        };
        
        task1 = new Runnable(){
        	public void run(){
        		mp3 = new MediaPlayer();
				mp3 = MediaPlayer.create(AnimationTest.this,R.raw.rnl);
				try {
					mp3.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				mp3.start();
        	}
        };
        
        
//		imagestart.setX(Width/4);
//		imagestart.setY(Height/2);
//		imagestart.setWidth(Width/2);
		imagestart.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {	
				//initBlock(bbb,ddd);
				 handler.post(task1);
				 handler.post(task);//立即调用
			}
		});
		
		this.addContentView(Viewcount, params);    //计数器
		Viewcount.setTextSize(Width/17);
	    Viewcount.setX(Width*5/12);
	    Viewcount.setTextColor(Color.RED);
		Viewcount.setY(0);
		
	}
	
	public void groupBlock(){
		switch (groupIndex%12) {
		case 0:
			initBlock(0,1,bgroup[0], bgroup[1]);
			groupIndex = groupIndex+2;
			break;
        case 2:
			initBlock(2,3,bgroup[2], bgroup[3]);
			groupIndex = groupIndex+2;
			break;
        case 4:
			initBlock(4,5,bgroup[4], bgroup[5]);
			groupIndex = groupIndex+2;
			break;
        case 6:
			initBlock(6,7,bgroup[6], bgroup[7]);
			groupIndex = groupIndex+2;
			break;
        case 8:
			initBlock(8,9,bgroup[8], bgroup[9]);
			groupIndex = groupIndex+2;
			break;
        case 10:
			initBlock(10,11,bgroup[10], bgroup[11]);
			groupIndex = groupIndex+2;
			break;
		}
			
	}
	

	
	public void ActionStop(){                          //暂停所有滑块
		for(int k=0;k<12;k++){
			objgroup[k].cancel();
		}
		mp3.stop();
		mp3.release();
	}
	
	
	
	
	public void initBlock(final int i,int j,Button bb1,Button bb2){ 
		Viewcount.bringToFront();
		bb1 = new Button(AnimationTest.this);
		bb2 = new Button(AnimationTest.this);
		
		r = new Random();
		currentcolor = r.nextInt(2);
		
    	
		if(currentcolor==0){
			bb1.setBackgroundColor(Color.BLACK);
			bb2.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==1){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.BLACK);
		}
		
		bb1.setWidth(Width/2);
        bb1.setHeight(Height/5);
		bb1.setX(0.5f*Width);
		bb1.setY(-500);
		this.addContentView(bb1, params);
		bb2.setWidth(Width/2);
        bb2.setHeight(Height/5);
		bb2.setX(0);
		bb2.setY(-500);
		this.addContentView(bb2, params);
		
		objgroup[i] = ObjectAnimator.ofFloat(bb1, "TranslationY", -Height/4,Height);
		objgroup[i].setInterpolator(new LinearInterpolator());
		objgroup[i].setDuration(speed/4*6);
		objgroup[i].start();
		objgroup[j] = ObjectAnimator.ofFloat(bb2, "TranslationY", -Height/4,Height);
		objgroup[j].setInterpolator(new LinearInterpolator());
		objgroup[j].setDuration(speed/4*6);
		objgroup[j].start();
		AnimatorSet as = new AnimatorSet();
		as.play(objgroup[i]).with(objgroup[j]);               //同时启动
		
		bb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(i!=(isPressed%12)){
					ActionStop();
					AnimationTest.this.onPause();
					AlertDialog.Builder builder = new Builder(AnimationTest.this);
					builder.setCancelable(false);
					builder.setMessage("最终成绩"+"\n"+count);
					builder.setTitle("还需要多加把劲哟~");
					
					builder.setPositiveButton("结束", new android.content.DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
			                Intent intent = new Intent(AnimationTest.this,Gallery3DActivity.class);
			                startActivity(intent);
			                AnimationTest.this.finish();
							// TODO Auto-generated method stub
							
						}
					});
					builder.setNegativeButton("重来", new android.content.DialogInterface.OnClickListener(){
						public void onClick(DialogInterface arg0, int arg1){
							arg0.dismiss();
							Intent intent1 = new Intent(AnimationTest.this,AnimationTest.class);
			                startActivity(intent1);
							count = 0;
							Viewcount.setText("00");
						}
					});
					builder.show();
					handler.removeCallbacks(task);
				}
				else{
					isPressed = isPressed+2;
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
					if(count<9){
						count = count+1;
						Viewcount.setText("0"+count);
					}
					else{
						count = count+1;
						Viewcount.setText(""+count);
					}
				}
				else{
					
	
					ActionStop();
					AnimationTest.this.onPause();
					AlertDialog.Builder builder = new Builder(AnimationTest.this);
					builder.setCancelable(false);
					builder.setMessage("最终成绩"+"\n"+count);
					builder.setTitle("还需要多加把劲哟~");
					
					builder.setPositiveButton("结束", new android.content.DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
			                Intent intent = new Intent(AnimationTest.this,Gallery3DActivity.class);
			                startActivity(intent);
			                AnimationTest.this.finish();
							// TODO Auto-generated method stub
							
						}
					});
					builder.setNegativeButton("重来", new android.content.DialogInterface.OnClickListener(){
						public void onClick(DialogInterface arg0, int arg1){
							arg0.dismiss();
							Intent intent1 = new Intent(AnimationTest.this,AnimationTest.class);
			                startActivity(intent1);
							count = 0;
							Viewcount.setText("00");
						}
					});
					builder.show();
					handler.removeCallbacks(task);
				}}
			}
		});
		bb2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
				if(i!=(isPressed%12)){
					ActionStop();

					AlertDialog.Builder builder = new Builder(AnimationTest.this);
					builder.setCancelable(false);
					builder.setMessage("最终成绩"+"\n"+count);
					builder.setTitle("还需要多加把劲哟~");
					
					builder.setPositiveButton("结束", new android.content.DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
			                Intent intent = new Intent(AnimationTest.this,Gallery3DActivity.class);
			                startActivity(intent);
			                AnimationTest.this.finish();
			              // TODO Auto-generated method stub
							
						}
					});
					builder.setNegativeButton("重来", new android.content.DialogInterface.OnClickListener(){
						public void onClick(DialogInterface arg0, int arg1){
							arg0.dismiss();
							Intent intent1 = new Intent(AnimationTest.this,AnimationTest.class);
			                startActivity(intent1);
							count = 0;
							Viewcount.setText("00");
						}
					});
					builder.show();
					handler.removeCallbacks(task);
				}
				else{
					isPressed = isPressed+2;
				if(color == getcolor){
					v.setBackgroundColor(Color.GRAY);
				
					if(count<9){
						count = count+1;
						Viewcount.setText("0"+count);
					}
					else{
						count = count+1;
						Viewcount.setText(""+count);
					}
				}
				else{
					ActionStop();

					AlertDialog.Builder builder = new Builder(AnimationTest.this);
					builder.setCancelable(false);
					builder.setMessage("最终成绩"+"\n"+count);
					builder.setTitle("还需要多加把劲哟~");
					
					builder.setPositiveButton("结束", new android.content.DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
			                Intent intent = new Intent(AnimationTest.this,Gallery3DActivity.class);
			                startActivity(intent);
			                AnimationTest.this.finish();
			              // TODO Auto-generated method stub
							
						}
					});
					builder.setNegativeButton("重来", new android.content.DialogInterface.OnClickListener(){
						public void onClick(DialogInterface arg0, int arg1){
							arg0.dismiss();
							Intent intent1 = new Intent(AnimationTest.this,AnimationTest.class);
			                startActivity(intent1);
							count = 0;
							Viewcount.setText("00");
						}
					});
					builder.show();
					handler.removeCallbacks(task);
				}}
			}
		});
		
    }
	
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animation_test, menu);
		return true;
	}

}
