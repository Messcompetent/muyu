package com.example.xr.muyudemo.diary;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xr.muyudemo.R;


public class MainActivity extends Activity {
	private EditText edit_password;
	private Button btn_denglu,btn_gywm;
	private Animation animation;
	private DB_PASSWORD db;
	private TextView tv_laogong;
	private NotificationManager manager;
//	private Notification noti;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		SharedPreferences kan=getSharedPreferences("yangshi",MODE_PRIVATE);
		String yan=kan.getString("banshi","");
        if (yan.equals("nan")||yan.isEmpty()) {
			setContentView(R.layout.diary_main);
		}else {
			setContentView(R.layout.nvdiary);
		}
		intview();
	manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //����Notification����
//        noti=new Notification(android.R.drawable.ic_menu_directions, "通知", System.currentTimeMillis());
        //����Intent����
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(""));
        //pendingIntent ��Intent�����࣬��һ������װ����Intent,���ᱻ����ִ�У��ں��ʵ�ʵ��ִ��
        PendingIntent ontentIntent=PendingIntent.getActivity(this, 1, intent, 0);
        //����setlatestEventInfo����
//		noti.setLatestEventInfo(this,"fff", "ffff", ontentIntent);
//        noti.flags=Notification.FLAG_AUTO_CANCEL;
//        noti.defaults=Notification.DEFAULT_ALL;
	}
	private void intview() {
		edit_password = (EditText) findViewById(R.id.edit_denglu);
		tv_laogong = (TextView) findViewById(R.id.tv_laogong);
		btn_denglu = (Button) findViewById(R.id.btn_denglu);
		btn_gywm=(Button)findViewById(R.id.btn_gywm);
		animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_click_info);
		btn_denglu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				btn_denglu.startAnimation(animation);
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
						if (edit_password.getText().toString().equals("")) {
							TranslateAnimation alphaAnimation2 = new TranslateAnimation(0f, 20f, 0, 0);
							alphaAnimation2.setDuration(50);
							alphaAnimation2.setRepeatCount(Animation.INFINITE);
							alphaAnimation2.setRepeatCount(7);
							alphaAnimation2.setRepeatMode(Animation.REVERSE);
							edit_password.setAnimation(alphaAnimation2);
							alphaAnimation2.start();
//							tv_laogong.setBackgroundResource(R.drawable.brijinan);
							Toast.makeText(getApplicationContext(), "密码不正确", Toast.LENGTH_LONG).show();
						} else {
							db = new DB_PASSWORD(getApplicationContext());
							String s = db.selectall();
							System.out.println("021333" + s);
							if (s.equals("")) {
								if (edit_password.getText().toString().equals("520")) {

									SharedPreferences kan=getSharedPreferences("yangshi",MODE_PRIVATE);
									String yan=kan.getString("banshi","");
									if (yan.equals("nan")||yan.isEmpty()) {
										startActivity(new Intent(MainActivity.this, CallbyeTabActivity.class));
									}else {
										startActivity(new Intent(MainActivity.this, NvCallbyeTabActivity.class));
									}
									Toast.makeText(getApplicationContext(), "欢迎进入私密空间", Toast.LENGTH_LONG).show();
//									manager.notify(1,noti);//��֪ͨ
									MainActivity.this.finish();
								} else {
									Toast.makeText(getApplicationContext(), "密码不正确", Toast.LENGTH_LONG).show();
								}
							} else {
								if (edit_password.getText().toString().equals(s)) {
									SharedPreferences kan=getSharedPreferences("yangshi",MODE_PRIVATE);
									String yan=kan.getString("banshi","");
									if (yan.equals("nan")||yan.isEmpty()) {
										startActivity(new Intent(MainActivity.this, CallbyeTabActivity.class));
									}else {
										startActivity(new Intent(MainActivity.this, NvCallbyeTabActivity.class));
									}
									Toast.makeText(getApplicationContext(), "欢迎进入私密空间", Toast.LENGTH_LONG).show();
//									manager.notify(1,noti);//��֪ͨ
									MainActivity.this.finish();
								} else {
									tv_laogong.setBackgroundResource(R.drawable.brijinan);
									Toast.makeText(getApplicationContext(), "密码不正确", Toast.LENGTH_LONG).show();
								}
							}
						}// TODO Auto-generated method stub
					}
				});
			}
		});
				btn_gywm.setOnClickListener(new View.OnClickListener() {
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
						SharedPreferences kan=getSharedPreferences("yangshi",MODE_PRIVATE);
						String yan=kan.getString("banshi","");
						if (yan.equals("nan")||yan.isEmpty()){
							SharedPreferences.Editor editor=getSharedPreferences("yangshi",MODE_PRIVATE).edit();
							editor.putString("banshi","nv");
							editor.apply();
							Toast.makeText(getApplicationContext(), "更换完成，部分已生效", Toast.LENGTH_LONG).show();
						}else if (yan.equals("nv")){
							SharedPreferences.Editor editor=getSharedPreferences("yangshi",MODE_PRIVATE).edit();
							editor.putString("banshi","nan");
							editor.apply();
							Toast.makeText(getApplicationContext(), "更换完成，部分已生效", Toast.LENGTH_LONG).show();
						}
					}
				});
	}
		});
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
	      
		  dialog.setTitle("提示").setMessage("要退出吗").setPositiveButton("退出",
	                  new DialogInterface.OnClickListener() {  
	                      public void onClick(DialogInterface dialog,  
	                              int which) {  
	                    	  MainActivity.this.finish();
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
}
