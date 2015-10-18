package com.example.z2;

import java.util.Random;

import com.example.z2.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ETC extends Activity {
	
	final Button[] b=new Button[30];
	int Width,Height;
	String [] T=new String[100];
	
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.etc);
		
		Display display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
		int w=Width;
		
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
		pho[1]=R.drawable.samesizepho001;
		pho[2]=R.drawable.samesizepho002;
		pho[3]=R.drawable.samesizepho003;
		pho[4]=R.drawable.samesizepho004;
		pho[5]=R.drawable.samesizepho005;
		pho[6]=R.drawable.samesizepho006;
		pho[7]=R.drawable.samesizepho007;
		pho[8]=R.drawable.samesizepho008;
		pho[9]=R.drawable.samesizepho009;
		pho[10]=R.drawable.samesizepho010;
		pho[11]=R.drawable.samesizepho011;
		pho[12]=R.drawable.samesizepho012;
		pho[13]=R.drawable.samesizepho013;
		pho[14]=R.drawable.samesizepho014;
		
		spho[0]=R.drawable.smallpho000;
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
			//b[i].setX(Width);		//b[i].setY(Height);
		}
		b[0].setWidth(Width);
		b[0].setHeight(Height/90*26);
		
		//b[1].setBackgroundResource(pho[1]);
		//b[0].setBackgroundColor(BIND_IMPORTANT);
		b[0].setBackgroundColor(Color.CYAN);
		
		
		/*
		{
			RandomMode1();
			for(int i=1;i<=24;i++)
				b[i].setText(T[i]);	
		}
		*/
		/*
		{
			RandomMode2();
			for(int i=1;i<=24;i++)
			{
				b[i].setText(T[i]);
				b[i].setTextColor(ct[i]);
			}
		}
		*/
		{
			RandomMode3();
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
	
	public void judge(int j){
		int i=j;
		if(i>12)
		{
			mom=T[i];
			m=i;
		}
		else
		{
			son=T[i];
			s=i;
		}
		
		if(son.equals(mom))
		{
			b[m].setText("000");
			b[s].setText("000");
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
	

}


