package com.example.z2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
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
	
	
	 Integer[] images = { R.drawable.baby, R.drawable.single,
             R.drawable.c, R.drawable.d, R.drawable.e,
             R.drawable.f,  R.drawable.g,R.drawable.h };
     
     ImageAdapter adapter = new ImageAdapter(this, images);
     adapter.createReflectedImages();//创建倒影效果
     Gallery galleryFlow = (Gallery) this.findViewById(R.id.Gallery01);
     galleryFlow.setFadingEdgeLength(0);
     galleryFlow.setSpacing(800); //图片之间的间距
    // galleryFlow.setBackgroundResource(R.drawable.line3);
     galleryFlow.setAdapter(adapter);
     
     galleryFlow.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
             Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
             if(position==1){
            	 Intent intent1 = new Intent(Gallery3DActivity.this,AnimationTest.class);
            	 startActivity(intent1);
            	 //ETC.star =55;
             }else if(position==0)
             {
            	 yjms(view);
             }
         }
         
     });
     galleryFlow.setSelection(0);
 }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery3_d, menu);
		return true;
	}
	
public void yjms(View v){
		
		new AlertDialog.Builder(this).setTitle("请选择游戏").setSingleChoiceItems(new String[]{"数字","颜色","图片"},0,new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				mSingleChoiceID = which;
				
			}
		}).setNegativeButton("确定",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				if(mSingleChoiceID==0){
					ETC.star=1;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					Gallery3DActivity.this.finish();
				}
				else if(mSingleChoiceID==1){
					ETC.star=2;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					Gallery3DActivity.this.finish();
				}
				else if(mSingleChoiceID==2){
					ETC.star=3;
					Intent intent = new Intent(Gallery3DActivity.this,ETC.class);
					startActivity(intent);
					Gallery3DActivity.this.finish();
				}
			}}).show();
			
		}

}
