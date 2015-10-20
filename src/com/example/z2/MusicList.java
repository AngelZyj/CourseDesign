package com.example.test;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MusicList extends Activity {
	int speedchoice=0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_list);
		ListView listview = (ListView)this.findViewById(R.id.listView1);
		String[] c = new String[]{"Breath and life","222","333","444"};
		listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,c));
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,long arg3) {
				if(arg2==0){
					new AlertDialog.Builder(MusicList.this).setTitle("请选择游戏速度").setSingleChoiceItems(new String[]{"新手","初级","高级","大师"},0,new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							if(which==0){
								speedchoice = 0;
							}
							else if(which==1){
								speedchoice = 1;
							}
							else if(which==2){
								speedchoice = 2;
							}
							else if(which==3){
								speedchoice = 3;
							}
						}
					}).setPositiveButton("确定",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							if(speedchoice==0){
								AnimationTest.speed = 2000;
								Intent intent11 = new Intent(MusicList.this,AnimationTest.class);
								startActivity(intent11);
								MusicList.this.finish();
							}
							else if(speedchoice==1){
								AnimationTest.speed = 1500;
								Intent intent12 = new Intent(MusicList.this,AnimationTest.class);
								startActivity(intent12);
								MusicList.this.finish();
							}
							else if(speedchoice==2){
								AnimationTest.speed = 1200;
								Intent intent13 = new Intent(MusicList.this,AnimationTest.class);
								startActivity(intent13);
								MusicList.this.finish();
							}
							else if(speedchoice==3){
								AnimationTest.speed = 900;
								Intent intent14 = new Intent(MusicList.this,AnimationTest.class);
								startActivity(intent14);
								MusicList.this.finish();
							}
						}
					}).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music_list, menu);
		return true;
	}

}
