package com.example.test;

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
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.test.Gallery3DActivity;

public class AnimationTest extends Activity {
	Handler handler;        //����������߳�
	Runnable task;
	int speed=1200;
	int Width,Height;       //��Ļ���
	int colorrandom[] = {Color.BLACK,Color.WHITE};  //�ڰ��������
	Random r;
	int currentcolor;
	int count=0;		//���������ڿ������	
	Button left,right;             //���к�����
	ObjectAnimator objleft,objright;       //���е��ƶ������е��ƶ�
	Button start;                  //��Ϸ����
	FrameLayout.LayoutParams params;     
	TextView Viewcount;          //��Ļ�Ϸ���ʾ����
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation_test);
		left = (Button)this.findViewById(R.id.bbb);
		start = (Button)this.findViewById(R.id.ccc);
		right = (Button)this.findViewById(R.id.ddd);
		Display display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
        Viewcount = new TextView(AnimationTest.this);
        params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        
        
        
        handler = new Handler();                          //��ʱ��������
        task = new Runnable() {  
            public void run() {   
                    handler.postDelayed(this,speed/4-speed/36);//�����ӳ�ʱ��
                    initBlock(left, right);
            }   
        };
        
        
		start.setX(Width/4);
		start.setY(Height/2);
		start.setWidth(Width/2);
		start.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {	
				//initBlock(bbb,ddd);
				 handler.post(task);//��������
			}
		});
		
		this.addContentView(Viewcount, params);
		Viewcount.setTextSize(Width/17);
	    Viewcount.setX(Width*5/12);
	    Viewcount.setTextColor(Color.RED);
		Viewcount.setY(0);
		
			
		
		
	}
	public void initBlock(Button bb1,Button bb2){ 
		Viewcount.bringToFront();
		bb1 = new Button(AnimationTest.this);
		bb2 = new Button(AnimationTest.this);
		
		r = new Random();
		currentcolor = r.nextInt(2);
		
    	bb1.setWidth(Width/2);
        bb1.setHeight(Height/5);
		bb1.setX(0.5f*Width);
		bb1.setY(-500);
		if(currentcolor==0){
			bb1.setBackgroundColor(Color.BLACK);
			bb2.setBackgroundColor(Color.WHITE);
		}
		else if(currentcolor==1){
			bb1.setBackgroundColor(Color.WHITE);
			bb2.setBackgroundColor(Color.BLACK);
			
		}
		
		
		this.addContentView(bb1, params);
		bb2.setWidth(Width/2);
        bb2.setHeight(Height/5);
		bb2.setX(0);
		bb2.setY(-500);
		this.addContentView(bb2, params);
		objleft = ObjectAnimator.ofFloat(bb1, "TranslationY", -Height/4,Height);
		objleft.setInterpolator(new LinearInterpolator());
		objleft.setDuration(speed/4*6);
		objleft.start();
		objright = ObjectAnimator.ofFloat(bb2, "TranslationY", -Height/4,Height);
		objright.setInterpolator(new LinearInterpolator());
		objright.setDuration(speed/4*6);
		objright.start();
		AnimatorSet as = new AnimatorSet();
		as.play(objleft).with(objright);               //ͬʱ����
		
		bb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Drawable background = v.getBackground();
				ColorDrawable colorDrawable = (ColorDrawable) background;
				int color = colorDrawable.getColor();
				int getcolor = Resources.getSystem().getColor(android.R.color.black);
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
					AlertDialog.Builder builder = new Builder(AnimationTest.this);
					builder.setMessage("���ճɼ�"+"\n"+count);
					builder.setTitle("����Ҫ��ӰѾ�Ӵ~");
					
					builder.setPositiveButton("����", new android.content.DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							
							arg0.dismiss();
			                Intent intent = new Intent(AnimationTest.this,Gallery3DActivity.class);
			                startActivity(intent);
							// TODO Auto-generated method stub
							
						}
					});
					builder.setNegativeButton("����", new android.content.DialogInterface.OnClickListener(){
						public void onClick(DialogInterface arg0, int arg1){
							count = 0;
							Viewcount.setText("00");
						}
					});
					builder.show();
					
					objleft.end();
					objright.end();
					handler.removeCallbacks(task);
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
					AlertDialog.Builder builder = new Builder(AnimationTest.this);
					builder.setMessage("���ճɼ�"+"\n"+count);
					builder.setTitle("����Ҫ��ӰѾ�Ӵ~");
					
					builder.setPositiveButton("����", new android.content.DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
			                Intent intent = new Intent(AnimationTest.this,Gallery3DActivity.class);
			                startActivity(intent);
			              // TODO Auto-generated method stub
							
						}
					});
					builder.setNegativeButton("����", new android.content.DialogInterface.OnClickListener(){
						public void onClick(DialogInterface arg0, int arg1){
							count = 0;
							Viewcount.setText("00");
						}
					});
					builder.show();
					objleft.end();
					objright.end();
					handler.removeCallbacks(task);
				}
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
