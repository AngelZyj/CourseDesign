package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.animation.ObjectAnimator;
//import android.R.id;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Property;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.SlidingDrawer;
import android.widget.TabWidget;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {
	Button leftb,rightb,ro3d,back;
	Display display;
    int Width;
    int Height;
    
    Button bsingle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = this.getWindowManager().getDefaultDisplay();
        Width = display.getWidth();
        Height = display.getHeight();
        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	

	
    
}
