package com.example.test;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		 final Intent itent = new Intent(this, Gallery3DActivity.class); //你要转向的Activity   
	        Timer timer = new Timer(); 
	        TimerTask task = new TimerTask() {  
	            @Override  
	            public void run() {   
	            startActivity(itent); //执行 
	            finish();
	             } 
	         };
	        timer.schedule(task, 1000 * 5); //5秒后
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
