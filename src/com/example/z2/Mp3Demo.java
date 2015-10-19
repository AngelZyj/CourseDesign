
package com.example.z2; 

import android.media.MediaPlayer; 
import android.os.Bundle; 
import android.app.Activity; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.TextView; 

public class Mp3Demo extends Activity {  
	//�������� 
	private Button start=null; 
	private Button pause=null; 
	private Button stop=null; 
	private TextView state=null; 
	private MediaPlayer mp3; 
	private Boolean flag=false; //���ñ�ǣ�false��ʾ���ڲ��� 
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		super.setContentView(R.layout.activity_mp3_demo); 
		//ȡ�ø���ť��� 
		start=(Button) super.findViewById(R.id.start); 
		pause=(Button) super.findViewById(R.id.pause); 
		stop=(Button) super.findViewById(R.id.stop); 
		state=(TextView)super.findViewById(R.id.state); 
		
		start.setText("����");
		pause.setText("��ͣ");
		stop.setText("��ֹ");
		//Ϊÿ����ť���õ����¼� 
		start.setOnClickListener(new OnClickListenerStart()); 
		pause.setOnClickListener(new OnClickListenerPause()); 
		stop.setOnClickListener(new OnClickListenerStop()); 
		mp3= new MediaPlayer();    //����һ��MediaPlayer���� 
		//��res���½�һ��raw�ļ��а�һ�׸�ŵ����ļ����в���Ӣ������ 
		mp3 = MediaPlayer.create(Mp3Demo.this,R.raw.ask);   

	} 
	//����ť�����¼���ʵ������ 
	//��ʼ���� 
	private class OnClickListenerStart implements OnClickListener{ 
	//implementsOnClickListenerΪʵ��OnClickListener�ӿ� 
	@Override 
	//��дonClic�¼� 
		public void onClick(View v) {    
		//ִ�еĴ��룬���п������쳣��һ�������쳣������������catchִ�С����򲻻�ִ��catch���������  
			try 
			{ 
				if (mp3!=null) 
				{ 
					mp3.stop(); 
				} 
				mp3.prepare();         //���뵽׼��״̬ 
				mp3.start();          //��ʼ���� 
				state.setText("Playing");  //�ı������ϢΪ��Playing������ͬ 
			} catch (Exception e) 
			{ 
				state.setText(e.toString());//���ַ�������ʽ����쳣 
				e.printStackTrace();  //�ڿ���̨��control���ϴ�ӡ���쳣 
			} 
		} 
	} 

	//��ͣ����   
	private class OnClickListenerPause implements OnClickListener{ 
	@Override 
		public void onClick(View v) 
		{ 
			try 
			{ 
				if (flag==false) //��flagΪfalse�����ʾ��ʱ��������״̬Ϊ���ڲ��� 
				{ 
					mp3.pause(); 
					flag=true; 
					state.setText("pause"); 
				} 
				else if(flag==true){ 
					mp3.start();    //��ʼ���� 
					flag=false;     //��������flagΪfalse 
					state.setText("Playing"); 
				} 
			} catch (Exception e) 
			{ 
				state.setText(e.toString()); 
				e.printStackTrace(); 
			} 
		} 
	} 
	//ֹͣ���� 
	private class OnClickListenerStop implements OnClickListener{ 
		@Override 
		public void onClick(View v) { 
			try 
			{ 
				if (mp3!=null) 
				{ 
					mp3.stop(); 
					state.setText("stop"); 
				} 
			} catch (Exception e) 
			{ 
				state.setText(e.toString()); 
				e.printStackTrace(); 
			} 
		} 
	} 
	//��д��ͣ״̬�¼� 
	protected void onPause(){ 
		try 
		{ 
			mp3.release();   //�ͷ�������Դ 
		} catch (Exception e) 
		{ 
			state.setText(e.toString()); 
			e.printStackTrace(); 
		} 
		super.onPause(); 
	} 
} 






