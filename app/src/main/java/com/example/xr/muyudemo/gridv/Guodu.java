package com.example.xr.muyudemo.gridv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


import com.example.xr.muyudemo.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static com.example.xr.muyudemo.Classshou.c;

import static com.example.xr.muyudemo.Classshou.nantu;
import static com.example.xr.muyudemo.Classshou.nantukouling;


/**
 * Created by XR on 2017/8/22.
 */

public class Guodu extends Activity {
    public static String[] mUrl=new String[c];
    public static String[] mtao=new String[c];
    DataOutputStream out;
    String fenlei;
    String fenlei2="";
    String fenzu;
    String fenzu2="";
    int b=0,a=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
//        Log.v("ceshi","ssss"+c);

        fenlei=nantu;
        if (fenlei.isEmpty()){
            Toast.makeText(Guodu.this,"服务器打盹儿了，请重新进入",Toast.LENGTH_LONG).show();
        }else {
            for (int i = 0; i < fenlei.length(); i++) {

//                    Log.v("ceshi","s");
                char every = fenlei.charAt(i);
                if (every != ';' && b < c) {
                    fenlei2 += every;
                } else if (every == ';' && b < c) {
                    mUrl[b] = fenlei2;
                    b++;
//                        Log.v("ceshi",fenlei2);
                    fenlei2 = "";
//                        Log.v("ce","网址");
                };
            }
        }

        fenzu=nantukouling;
        if (fenzu.isEmpty()){
            Toast.makeText(Guodu.this,"服务器打盹儿了，请重新进入",Toast.LENGTH_LONG).show();
        }else {
            for (int i = 0; i < fenzu.length(); i++) {
//                    Log.v("ceshi","s");
                char every = fenzu.charAt(i);
                if (every != ';' && a < c) {
                    fenzu2 += every;
                } else if (every == ';' && a < c) {
                    mtao[a] = fenzu2;
                    a++;
//                        Log.v("ceshi",fenzu2);
                    fenzu2 = "";
//                        Log.v("ce","口令");
                };
            };
            Intent intent = new Intent();
            intent.setClass(Guodu.this, GridView.class);
            startActivity(intent);
            finish();
        }

//        final Handler handler=new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                fenlei=msg.obj.toString();
//                if (fenlei.isEmpty()){
//                    Toast.makeText(Guodu.this,"服务器打盹儿了，请重新进入",Toast.LENGTH_LONG).show();
//                }else {
//                    for (int i = 0; i < fenlei.length(); i++) {
//
////                    Log.v("ceshi","s");
//                        char every = fenlei.charAt(i);
//                        if (every != ';' && b < c) {
//                            fenlei2 += every;
//                        } else if (every == ';' && b < c) {
//                            mUrl[b] = fenlei2;
//                            b++;
////                        Log.v("ceshi",fenlei2);
//                            fenlei2 = "";
////                        Log.v("ce","网址");
//                        }
//                        ;
//                    }
//                }
////                Log.v("ceshi","ss");
////                Intent intent=new Intent();
////                intent.setClass(Guodu.this,GridView.class);
////                startActivity(intent);
////                finish();
//            }
//        };
//        final Handler mhandler=new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                fenzu=msg.obj.toString();
//                if (fenzu.isEmpty()){
//                    Toast.makeText(Guodu.this,"服务器打盹儿了，请重新进入",Toast.LENGTH_LONG).show();
//                }else {
//                    for (int i = 0; i < fenzu.length(); i++) {
////                    Log.v("ceshi","s");
//                        char every = fenzu.charAt(i);
//                        if (every != ';' && a < c) {
//                            fenzu2 += every;
//                        } else if (every == ';' && a < c) {
//                            mtao[a] = fenzu2;
//                            a++;
////                        Log.v("ceshi",fenzu2);
//                            fenzu2 = "";
////                        Log.v("ce","口令");
//                        }
//                        ;
//                    }
//                    ;
//                    Intent intent = new Intent();
//                    intent.setClass(Guodu.this, GridView.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        };


//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Socket socket=new Socket(duankou,port);
////                    Log.v("ceshi","url");
//                    out=new DataOutputStream(socket.getOutputStream());
//                    out.write(2);
//                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    String line=bufferedReader.readLine();
////                    out=new DataOutputStream(socket.getOutputStream());
////                    out.write(3);
////                    BufferedReader bkou=new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                    String skou=bkou.readLine();
////                    Log.v("kk",line);
//                    Log.v("handle",line);
//                    Message msg=new Message();
//                    msg.obj=line;
//                    handler.sendMessage(msg);
////                    Message mkou=new Message();
////                    mkou.obj=skou;
////                    mhandler.sendMessage(mkou);
//                    bufferedReader.close();
////                    bkou.close();
//                    out.close();
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                new Thread(){
//                    @Override
//                    public void run() {
////                        Log.v("ceshi","kou");
//                        try {
//                            Socket socket=new Socket(duankou,port);
//                            out=new DataOutputStream(socket.getOutputStream());
//                            out.write(3);
//                            BufferedReader bkou=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                            String skou=bkou.readLine();
//                            Log.v("handle",skou);
//                            Message mkou=new Message();
//                            mkou.obj=skou;
//                            mhandler.sendMessage(mkou);
//                            bkou.close();
//                            out.close();
//                            socket.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }.start();
//            }
//        }.start();


    }

}
