package com.example.xr.muyudemo.diary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xr.muyudemo.R;


public class SheZhi extends Activity {
	private EditText edit_shezhi;
	private Button btn_shezhi,btn_clock;
    private DB_PASSWORD db;
    private TextView tv_laogong2;
    private Animation animation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		SharedPreferences kan=getSharedPreferences("yangshi",MODE_PRIVATE);
		String yan=kan.getString("banshi","");
		if (yan.equals("nan")||yan.isEmpty()) {
			setContentView(R.layout.shezhi);
		}else {
			setContentView(R.layout.nvshezhi);
		}
		intview();
	}
	private void intview() {
		animation=AnimationUtils.loadAnimation(SheZhi.this, R.anim.anim_click_info);
		edit_shezhi = (EditText) findViewById(R.id.edit_shezhi);
		btn_shezhi = (Button) findViewById(R.id.btn_shezhi);
//		btn_clock = (Button) findViewById(R.id.btn_clock);
		btn_shezhi.setOnClickListener(new OnClickListener() {
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
						String s = edit_shezhi.getText().toString().trim();
						db = new DB_PASSWORD(getApplicationContext());

						if (!s.equals("") && db.selectall().equals("")) {
							ContentValues values = new ContentValues();
							values.put("password", s);
							db.insert(values);
							contral();
							Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_LONG).show();
							//tv_laogong2.setVisibility(View.VISIBLE);
						} else if (!s.equals("") && !db.selectall().equals("")) {
							db.update(s);
							contral();
							//tv_laogong2.setVisibility(View.VISIBLE);
							Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_LONG).show();
						}
						else
						{Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();}// TODO Auto-generated method stub
						
					}
				});
			}
		});
		
//		btn_clock.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				v.startAnimation(animation);
//				animation.setAnimationListener(new AnimationListener() {
//
//					@Override
//					public void onAnimationStart(Animation animation) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onAnimationRepeat(Animation animation) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onAnimationEnd(Animation animation) {
//						Intent intent=new Intent();
//						intent.setClass(SheZhi.this,MainActivity .class);
//						startActivity(intent);
//					}
//				});
//			}
//		});
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
	        exit_app();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
	public void exit_app()
	  {  
		  final AlertDialog.Builder dialog = new AlertDialog.Builder(this);  
	      
		  dialog.setTitle("提示").setMessage("确定要退出").setPositiveButton("退出",
	                  new DialogInterface.OnClickListener() {  
	                      public void onClick(DialogInterface dialog,  
	                              int which) {  
	                    	  System.exit(0);
	                                           }  
	                 }).setNegativeButton("返回",
	                  new DialogInterface.OnClickListener() {  
	                     public void onClick(DialogInterface dialog,  
	                             int which) {  
	                           }  
	                  });  
	          AlertDialog dialog_dialog = dialog.create();  
	          dialog_dialog.show();  
	                    
	}
private void contral()
	{InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	imm.hideSoftInputFromWindow(edit_shezhi.getWindowToken(), 0);}
}
