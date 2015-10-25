package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class Gallery3DActivity extends Activity {
	
	int mSingleChoiceID = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery3_d);
	
	
	 Integer[] images = { R.drawable.single3, R.drawable.double3,
             R.drawable.baby3, R.drawable.d};
     
     ImageAdapter adapter = new ImageAdapter(this, images);
     adapter.createReflectedImages();//创建倒影效果
     Gallery galleryFlow = (Gallery) this.findViewById(R.id.Gallery01);
     galleryFlow.setFadingEdgeLength(0);
     galleryFlow.setSpacing(400); //图片之间的间距
    // galleryFlow.setBackgroundResource(R.drawable.line3);
     galleryFlow.setAdapter(adapter);
     
     galleryFlow.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
             Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
             if(position==0){
            	 Intent intent0 = new Intent(Gallery3DActivity.this,MusicList.class);
            	 startActivity(intent0);
             }
             if(position==1){
            	 Intent intent1 = new Intent(Gallery3DActivity.this,DoubleGame.class);
            	 startActivity(intent1);
             }
             if(position==2){
            	 etcselect();
             }
         }
         
     });
     galleryFlow.setSelection(0);
 }
	
	public void etcselect(){
		new AlertDialog.Builder(this).setTitle("请选择游戏").setSingleChoiceItems(new String[]{"数字","颜色+文字","图片","颜色"},0,new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				mSingleChoiceID = which;
				
			}
		}).setNegativeButton("确定",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				if(mSingleChoiceID==0){
					ETC.star=1;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					
				}
				else if(mSingleChoiceID==1){
					ETC.star=2;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					
				}
				else if(mSingleChoiceID==2){
					ETC.star=3;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					
				}
				else if(mSingleChoiceID==3){
					ETC.star=4;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					
				}
			}}).show();
	}
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			AlertDialog.Builder isExit = new Builder(Gallery3DActivity.this);
			isExit.setTitle("系统提示");
			isExit.setMessage("确定要退出吗");
			isExit.setPositiveButton("坚决要走", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Gallery3DActivity.this.finish();
				}
			});
			isExit.setNegativeButton("回心转意", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			isExit.show();
		}
		return false;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery3_d, menu);
		return true;
	}

}
