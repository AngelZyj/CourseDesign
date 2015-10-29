package com.example.test;

import java.util.Random;

import com.example.test.R;
import com.example.test.R.drawable;

import android.os.Build;
import android.os.Bundle;
import android.renderscript.Font;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

@SuppressLint("NewApi")
public class ETC extends Activity {
	
	final Button[] b=new Button[30];
	int Width,Height;
	String [] T=new String[100];
	static int star = 0;
	
	//RandomMode1()随机数--数字
	String k="";
	int m,s;
	String mom="",son="";
	
	//RandomMode2()随机数--颜色字
	int [] Col = new int[30];
	String [] Ctt={"白色","粉红色","红色","淡紫色","深紫色","淡蓝色","深蓝色","浅绿色","深绿色","黄色","金色","灰色","黑色","棕色","青色"};
	int [] ct = new int[30];
	
	//RandomMode3()随机数--图片
	int [] pho=new int[100];
	int [] spho=new int[100];
	int [] so=new int[100];
	
	//边框
	GradientDrawable drawable1 = new GradientDrawable();
	GradientDrawable drawable2 = new GradientDrawable();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etc);
		
		Display display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
		int w=Width;
		
		//边框
		drawable1.setShape(GradientDrawable.RECTANGLE);
		drawable1.setStroke(10, Color.WHITE);
		drawable1.setColor(Color.LTGRAY);
		drawable1.setCornerRadius(10f);
		
		drawable2.setShape(GradientDrawable.RECTANGLE);
		drawable2.setStroke(10, Color.GREEN);
		drawable2.setColor(Color.green(TRIM_MEMORY_UI_HIDDEN));
		drawable2.setCornerRadius(10f);
		
		b[0]=(Button)findViewById(R.id.button0);
		b[1]=(Button)findViewById(R.id.button1);
		b[2]=(Button)findViewById(R.id.button2);
		b[3]=(Button)findViewById(R.id.button3);
		b[4]=(Button)findViewById(R.id.button4);
		b[5]=(Button)findViewById(R.id.button5);
		b[6]=(Button)findViewById(R.id.button6);
		b[7]=(Button)findViewById(R.id.button7);
		b[8]=(Button)findViewById(R.id.button8);
		b[9]=(Button)findViewById(R.id.button9);
		b[10]=(Button)findViewById(R.id.button10);
		b[11]=(Button)findViewById(R.id.button11);
		b[12]=(Button)findViewById(R.id.button12);
		b[13]=(Button)findViewById(R.id.button13);
		b[14]=(Button)findViewById(R.id.button14);
		b[15]=(Button)findViewById(R.id.button15);
		b[16]=(Button)findViewById(R.id.button16);
		b[17]=(Button)findViewById(R.id.button17);
		b[18]=(Button)findViewById(R.id.button18);
		b[19]=(Button)findViewById(R.id.button19);
		b[20]=(Button)findViewById(R.id.button20);
		b[21]=(Button)findViewById(R.id.button21);
		b[22]=(Button)findViewById(R.id.button22);
		b[23]=(Button)findViewById(R.id.button23);
		b[24]=(Button)findViewById(R.id.button24);
		
		pho[0]=R.drawable.pho000;
		pho[1]=R.drawable.p01;
		pho[2]=R.drawable.p02;
		pho[3]=R.drawable.p03;
		pho[4]=R.drawable.p04;
		pho[5]=R.drawable.p05;
		pho[6]=R.drawable.p06;
		pho[7]=R.drawable.p07;
		pho[8]=R.drawable.p08;
		pho[9]=R.drawable.p09;
		pho[10]=R.drawable.p10;
		pho[11]=R.drawable.p11;
		pho[12]=R.drawable.p12;
		pho[13]=R.drawable.p13;
		pho[14]=R.drawable.p14;
		pho[15]=R.drawable.p15;
		
		spho[0]=R.drawable.pho000;
		spho[1]=R.drawable.smallpho001;
		spho[2]=R.drawable.smallpho002;
		spho[3]=R.drawable.smallpho003;
		spho[4]=R.drawable.smallpho004;
		spho[5]=R.drawable.smallpho005;
		spho[6]=R.drawable.smallpho006;
		spho[7]=R.drawable.smallpho007;
		spho[8]=R.drawable.smallpho008;
		spho[9]=R.drawable.smallpho009;
		spho[10]=R.drawable.smallpho010;
		spho[11]=R.drawable.smallpho011;
		spho[12]=R.drawable.smallpho012;
		spho[13]=R.drawable.smallpho013;
		spho[14]=R.drawable.smallpho014;

		
		Col[0] = getResources().getColor(R.color.White);
		Col[1] = getResources().getColor(R.color.Pink);
		Col[2] = getResources().getColor(R.color.Red);
		Col[3] = getResources().getColor(R.color.Lavender);
		Col[4] = getResources().getColor(R.color.DarkVoilet);
		Col[5] = getResources().getColor(R.color.LightSkyBlue);
		Col[6] = getResources().getColor(R.color.DarkBlue);
		Col[7] = getResources().getColor(R.color.LightGreen);
		Col[8] = getResources().getColor(R.color.DarkGreen);
		Col[9] = getResources().getColor(R.color.LightYellow);
		Col[10] = getResources().getColor(R.color.Gold);	
		Col[11] = getResources().getColor(R.color.Gray);
		Col[12] = getResources().getColor(R.color.Black);
		Col[13] = getResources().getColor(R.color.Brown);
		Col[14] = getResources().getColor(R.color.Cyan);
		
		for(int i=1;i<=24;i++)
		{
			b[i].setWidth(Width/4);
			b[i].setHeight(Height/10);
			b[i].setText(" ");
			b[i].setBackgroundDrawable(drawable1);
			//b[i].setX(Width);		//b[i].setY(Height);
		}
		b[0].setWidth(Width);
		b[0].setHeight(Height/90*26);
		
		//b[1].setBackgroundResource(pho[1]);
		//b[0].setBackgroundColor(BIND_IMPORTANT);
		b[0].setBackgroundColor(Color.BLUE);
		b[0].setAlpha((float) 0.1);
	       
		
		for(int i=1;i<=12;i++)		//12个旋转180度
		{
			b[i].setRotationX(180);
			b[i].setRotationY(180);
		}
		
		//star=2;
		//选择4种模式之一	
		if(star==1)
		{
			RandomMode1();
			for(int i=1;i<=24;i++)
				b[i].setText(T[i]);	
		}
		else if(star==2)
		{
			RandomMode2();
			for(int i=1;i<=24;i++)
			{
				b[i].setText(T[i]);
				b[i].setTextColor(ct[i]);
			}
		}
		else if(star==3)
		{
			RandomMode3();
			for(int i=1;i<=24;i++)
			{
				b[i].setBackgroundResource(so[i]);
				b[i].setText("");
			}
		}
		else if(star==4)
		{
			RandomMode4();
			for(int i=1;i<=24;i++)
			{
				b[i].setBackgroundResource(so[i]);
				b[i].setText("");
			}
		}

		/*监听*/
		for(int i=1;i<=24;i++){
			final int j=i;
			b[j].setOnClickListener(new Button.OnClickListener(){
				public void onClick(View v){
					if(j<13)
					{
						b[j].setRotationX(0);
						b[j].setRotationY(0);
					}
					else
					{
						b[j].setRotationX(180);
						b[j].setRotationY(180);
					}
					if(star==3||star==4)
						judge1(j);
					else if(star==2||star==1)
						judge(j);
				}
			});
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.etc, menu);
		return true;
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	public void judge(int j){
		int i=j;
		if(i>12)
		{
			b[m].setBackgroundDrawable(drawable1);
			b[m].setRotationX(0);
			b[m].setRotationY(0);
			mom=T[i];
			m=i;
			b[i].setBackgroundDrawable(drawable2);
		}
		else
		{
			b[s].setBackgroundDrawable(drawable1);
			b[s].setRotationX(180);
			b[s].setRotationY(180);
			son=T[i];
			s=i;
			b[i].setBackgroundDrawable(drawable2);
		}
		
		if(son.equals(mom)&&m!=0)
		{
			b[m].setText("000");
			b[s].setText("000");
			b[m].setAlpha(0);
			b[s].setAlpha(0);
			b[m].setEnabled(false);
			b[s].setEnabled(false);
			m=0;
			s=0;
		}
		else
		{
			if((m!=0&&s!=0))
			{
				b[m].setRotationX(0);
				b[m].setRotationY(0);
				b[s].setRotationX(180);
				b[s].setRotationY(180);
				
				ObjectAnimator.ofFloat(b[m], "RotationX", 0,360).setDuration(1000).start();
				ObjectAnimator.ofFloat(b[s], "RotationX", 180,540).setDuration(1000).start();

				b[m].setBackgroundDrawable(drawable1);
				b[s].setBackgroundDrawable(drawable1);
				m=0;
				s=0;
				mom="";
				son="";
			}
		}	
	}
	
	public void judge1(int j){
		int i=j;
		if(i>12)
		{
			b[m].setRotationX(0);
			b[m].setRotationY(0);
			mom=T[i];
			m=i;
		}
		else
		{
			b[s].setRotationX(180);
			b[s].setRotationY(180);
			son=T[i];
			s=i;
		}
		
		if(son.equals(mom)&&m!=0)
		{
			b[m].setText("000");
			b[s].setText("000");
			b[m].setAlpha(0);
			b[s].setAlpha(0);
			m=0;
			s=0;
		}
		else
		{
			if((m!=0&&s!=0))
			{	
				b[m].setRotationX(0);
				b[m].setRotationY(0);
				b[s].setRotationX(180);
				b[s].setRotationY(180);
				m=0;
				s=0;
				mom="";
				son="";
			}	
		}	
	}
	
	//产生12位100以内不相同的随即整数 
	public void RandomMode1(){
		int n = 100;
		Random rand = new Random();
		boolean[]  bool = new boolean[n];
		int [] randInt = new int[100];
		for(int i=1; i<=12;i++) 
		{
			do 
			{
				randInt[i] = rand.nextInt(n);
		    }while(bool[randInt[i]]);
			bool[randInt[i]] = true;
			T[i]=k+randInt[i];
			//System.out.println(randInt[i]);
		}
		
		int [] a = new int[12] ;
		int [] b = new int[12] ;
		for(int i=0;i<12;i++)
		{
			b[i]=(int) (Math.random()*12);
			for(int j=0;j<i;j++)
			{
				if(j==0) 
					a[i]=b[i];
				if(a[i]==b[j])
				{
					i--;
					break; 
				}
			}
		}
		for(int i=0;i<12;i++)
			T[i+13]=T[(b[i]+1)];

	}
	
	public void RandomMode2(){
		int n = 14;
		Random rand = new Random();
		boolean[]  bool = new boolean[n];
		int [] randInt = new int[14];
		for(int i=1; i<=12;i++) 
		{
			do 
			{
				randInt[i] = rand.nextInt(n);
		    }while(bool[randInt[i]]);
			bool[randInt[i]] = true;
			T[i]=Ctt[randInt[i]];
			ct[i]=Col[randInt[i]];
			//System.out.println(randInt[i]);
		}
		int [] a = new int[14] ;
		int [] b = new int[14] ;
		for(int i=0;i<12;i++)
		{
			b[i]=(int) (Math.random()*12);
			for(int j=0;j<i;j++)
			{
				if(j==0) 
					a[i]=b[i];
				if(a[i]==b[j])
				{
					i--;
					break; 
				}
			}
		}
		for(int i=0;i<12;i++)
		{
			T[i+13]=T[(b[i])+1];
			ct[i+13]=ct[(b[i])+1];
		}
		
	}
	
	
	public void RandomMode3(){
		int n = 13;
		Random rand = new Random();
		boolean[]  bool = new boolean[n];
		int [] randInt = new int[13];
		for(int i=1; i<=12;i++) 
		{
			do 
			{
				randInt[i] = rand.nextInt(n);
		    }while(bool[randInt[i]]);
			bool[randInt[i]] = true;
			so[i]=spho[randInt[i]+1];
			T[i]=k+spho[randInt[i]+1];
			//System.out.println(randInt[i]);
		}
		
		int [] a = new int[12] ;
		int [] b = new int[12] ;
		for(int i=0;i<12;i++)
		{
			b[i]=(int) (Math.random()*12);
			for(int j=0;j<i;j++)
			{
				if(j==0) 
					a[i]=b[i];
				if(a[i]==b[j])
				{
					i--;
					break; 
				}
			}
		}
		for(int i=0;i<12;i++)
		{
			T[i+13]=T[(b[i]+1)];
			so[i+13]=so[b[i]+1];
		}
	}
	
	public void RandomMode4(){
		int n = 13;
		Random rand = new Random();
		boolean[]  bool = new boolean[n];
		int [] randInt = new int[13];
		for(int i=1; i<=12;i++) 
		{
			do 
			{
				randInt[i] = rand.nextInt(n);
		    }while(bool[randInt[i]]);
			bool[randInt[i]] = true;
			so[i]=pho[randInt[i]+1];
			T[i]=k+pho[randInt[i]+1];
			//System.out.println(randInt[i]);
		}
		
		int [] a = new int[12] ;
		int [] b = new int[12] ;
		for(int i=0;i<12;i++)
		{
			b[i]=(int) (Math.random()*12);
			for(int j=0;j<i;j++)
			{
				if(j==0) 
					a[i]=b[i];
				if(a[i]==b[j])
				{
					i--;
					break; 
				}
			}
		}
		for(int i=0;i<12;i++)
		{
			T[i+13]=T[(b[i]+1)];
			so[i+13]=so[b[i]+1];
		}
	}
	
	
}


