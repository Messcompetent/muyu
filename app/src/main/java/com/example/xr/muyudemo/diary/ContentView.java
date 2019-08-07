package com.example.xr.muyudemo.diary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.xr.muyudemo.R;

import java.util.ArrayList;

public class ContentView extends Activity {
	private TextView tv_year, tv_days, tv_winder;
	private DBHelpe DB;
	private Button btn_return;
	private TextView tv_content;
	private Animation animation;
	private Button btn_bianji, btn_delete;
	private String id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		SharedPreferences kan=getSharedPreferences("yangshi",MODE_PRIVATE);
		String yan=kan.getString("banshi","");
		if (yan.equals("nan")||yan.isEmpty()) {
			setContentView(R.layout.contentview);
		}else {
			setContentView(R.layout.nvcontentview);
		}
		intview();

	}

	private void intview() {
		animation = AnimationUtils.loadAnimation(ContentView.this, R.anim.anim_click_info);
		String content = "", data = "", days = "", winder = "";
		tv_year = (TextView) findViewById(R.id.tv_year);
		tv_days = (TextView) findViewById(R.id.tv_days);
		tv_content = (TextView) findViewById(R.id.tv_content);
		btn_bianji = (Button) findViewById(R.id.btn_bianji);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		tv_winder = (TextView) findViewById(R.id.tv_winder);
		btn_return = (Button) findViewById(R.id.btn_fanhui);
		DB = new DBHelpe(ContentView.this);
		Intent intent = getIntent();
		Bundle bd = intent.getExtras();
		id = bd.getString("id");
		ArrayList<Mode> list = DB.fetchValue(id);
		for (Mode m : list) {
			content = m.getCONTENT();
			data = m.getDATA();
			days = m.getDAYS();
//			winder = m.getWINDER();
		}
		tv_year.setText(data);
		tv_days.setText(days);
		tv_content.setText(content);
		tv_winder.setText("心情" + winder);
		btn_return.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animation);
				animation.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
					}
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						ContentView.this.finish();// TODO Auto-generated method
													// stub

					}
				});// TODO Auto-generated method stub

			}
		});
		btn_bianji.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animation);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						Intent intent = new Intent(ContentView.this, Bianji.class);
						Bundle bd = new Bundle();
						bd.putString("content", tv_content.getText().toString());
						bd.putString("id", id);
						intent.putExtra("bianji", bd);
						startActivity(intent);
						ContentView.this.finish();

					}
				});// TODO Auto-generated method stub

			}
		});
		btn_delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animation);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						dialog();
						
					}
				});// TODO Auto-generated method stub

			}
		});

	}
	public void dialog()
	  {  
		  final AlertDialog.Builder dialog = new AlertDialog.Builder(this);  
	      
		  dialog.setTitle("提示").setMessage("真要删除回忆吗").setPositiveButton("删除",
	                  new DialogInterface.OnClickListener() {  
	                      public void onClick(DialogInterface dialog,  
	                              int which) {  
	                    	  DB.del(Integer.valueOf(id));
	  						ArrayList<Mode> list = DB.fetchValue();
	  						DB.clean();
	  						ContentValues values = new ContentValues();
	  						for (Mode mode : list) {
	  							values.put("content", mode.getCONTENT());
	  							values.put("data", mode.getDATA());
	  							values.put("days", mode.getDAYS());
	  							values.put("winder", mode.getWINDER());
	  							DB.insert(values);
	  						}
	  						Conmon.bln_content=true;
	  						Toast.makeText(ContentView.this, "已删除", Toast.LENGTH_SHORT).show();
	  						ContentView.this.finish();
	                    	 
	                                           }  
	                 }).setNegativeButton("留下",
	                  new DialogInterface.OnClickListener() {  
	                     public void onClick(DialogInterface dialog,  
	                             int which) {  
	                           }  
	                  });  
	          AlertDialog dialog_dialog = dialog.create();  
	          dialog_dialog.show();  
	                    
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}// TODO Auto-generated method stub
		return false;
	}
}
