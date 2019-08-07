package com.example.xr.muyudemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import com.example.xr.muyudemo.diary.MainActivity;
import com.example.xr.muyudemo.gridv.Guodu;
import com.example.xr.muyudemo.gridv.Guoduw;
import com.example.xr.muyudemo.image.SmartImageView;
import com.example.xr.muyudemo.update.DownActivtiy;
import com.example.xr.muyudemo.update.Guanyu;
import com.example.xr.muyudemo.video.test_webview_demo.BrowserActivity;
import static com.example.xr.muyudemo.XVideo.bofangdeurl;




public class Classshou extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences.Editor editor;
    public static String updateurl="";
//    public static int port=0;
    public static String url="";//openurl的
    public static String urlvideo;
    String twelve,zctwelve="",getUrl,everyurl="";
    String ur1="",ur2="",ur3="",ur4="",ur5="",ur6="",ur7="",ur8="",ur9="",ur10="",ur11="",ur12="";
    int t=0,u=0;
    String shouurl="http://m.jingyu.com/index/freelimit",yinqinbaidu="http://www.baidu.com/s?wd=",yinqin="http://www.baidu.com/s?wd=",yinqinbiying="http://cn.bing.com/search?q=";
    private TextView Tgonggao;
    private EditText etsosuo,Equnhao;
    private LinearLayout LLsosuo;
    private Button qianjin,shezhi,zhuye,sosuo,busosuo;
    public static int c;//数组长度
    public static int w;
    private LinearLayout shoubottom;
    FloatingActionButton fab;
    private Animation animation;
    public ObservableWebView shouhome;
    private SmartImageView url01,url02,url03,url04,url05,url06,url07,url08,url09,url10,url11,url12,man,woman;
    private WebView wvtianqi;
    private ProgressBar ShouPB;
    private long dangqianshijian= 0 ;
    public static int toolb=0,lineayout=0;
    public static String vurl0="",vurl1="",vurl2="",vurl3="",vurl4="",vurl5="",vurl6="",vurl7="";
    private int vt=0,shuangtucount=0;
    private String seven="",zcseven="",shuangtudezancun="";
    public String xuanze="";
    private String zancunxuanding="sd";//选择服务器
    public int jizu=0;//接受数据分组统计
    public static String shiertu="",shiertuurl="",bajiekou="",nantucount="",nvtucount="",nantu="",nantukouling="",nvtu="",nvtukouling="",shuangtu="",gonggao="",qunhao="",version="";
    public String allurl;//接到的数据综合
    public int sosuoint=0;
    String dizhi="",panduan="";
    String duankouhao="";
    int duankouhaoma=0;

    String[] iten=new String[]{
            "小说阅读","起点小说","言情小说"
    };
    String[] shezhiiten=new String[]{
            "不显示上边蓝色部分","不显示下边几个按钮","显示上边蓝色部分","显示下边几个按钮","都显示","都不显示","刷新一下","搜索用百度","搜索用必应","隐藏小说按钮","显示小说按钮"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉应用标题
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layoutshou);
        editor=getSharedPreferences("duankou",MODE_PRIVATE).edit();
        //获取手机IMEI码
//        final TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
//        Log.v("imei",tm.getDeviceId());



        allid();
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        qianjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qianjin.startAnimation(animation);
                if (shouhome.canGoForward()){
                    shouhome.goForward();
                }else Toast.makeText(Classshou.this,"没有已打开的页面",Toast.LENGTH_SHORT).show();
            }
        });


        final AlertDialog.Builder buildershezhi=new AlertDialog.Builder(this);
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shezhi.startAnimation(animation);
                buildershezhi.setItems(shezhiiten, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                toolb=1;
                                toolbar.setVisibility(View.GONE);
                                break;
                            case 1:
                                lineayout=1;
                                shoubottom.setVisibility(View.GONE);
                                break;
                            case 2:
                                toolb=0;
                                toolbar.setVisibility(View.VISIBLE);
                                break;
                            case 3:
                                lineayout=0;
                                shoubottom.setVisibility(View.VISIBLE);
                                break;
                            case 4:
                                lineayout=0;
                                toolb=0;
                                shoubottom.setVisibility(View.VISIBLE);
                                toolbar.setVisibility(View.VISIBLE);
                                break;
                            case 5:
                                shoubottom.setVisibility(View.GONE);
                                toolbar.setVisibility(View.GONE);
                                lineayout=1;
                                toolb=1;
                                break;
                            case 6:
                                shouhome.reload();
                                break;
                            case 7:
                                yinqin=yinqinbaidu;
                                break;
                            case 8:
                                yinqin=yinqinbiying;
                                break;
                            case 9:
                                fab.setVisibility(View.GONE);
                                break;
                            case 10:
                                fab.setVisibility(View.VISIBLE);
                                break;

                        }
                    }
                });
                buildershezhi.show();
            }
        });
        zhuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zhuye.startAnimation(animation);
                shouhome.loadUrl(shouurl);
            }
        });
        sosuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sosuo.startAnimation(animation);
                if (sosuoint==0) {
                    sosuoint=1;
                    LLsosuo.setVisibility(View.VISIBLE);
                }else if (sosuoint==1){
                    sosuoint=0;
                    LLsosuo.setVisibility(View.GONE);
                }
            }
        });
        busosuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busosuo.startAnimation(animation);
                LLsosuo.setVisibility(View.GONE);
                shouhome.loadUrl(yinqin+etsosuo.getText().toString());
                toolbar.setVisibility(View.GONE);
            }
        });

        shouhome.setOnScrollChangedCallback(new ObservableWebView.OnScrollChangedCallback() {
            @Override
            public void onScroll(int dx, int dy) {
                if (dy<1&&toolb==0&&lineayout==0){//往上划
                    toolbar.setVisibility(View.GONE);
                    shoubottom.setVisibility(View.VISIBLE);
                }
                if (dy>1&&toolb==0&&lineayout==0){//往下滑
                    toolbar.setVisibility(View.VISIBLE);
                    shoubottom.setVisibility(View.GONE);
                }
                if (dy<1&&toolb==0&&lineayout==1){
                    toolbar.setVisibility(View.GONE);
                    shoubottom.setVisibility(View.GONE);
                }
                if (dy>1&&toolb==0&&lineayout==1){
                    toolbar.setVisibility(View.VISIBLE);
                    shoubottom.setVisibility(View.GONE);
                }
                if (dy<1&&lineayout==0&&toolb==1){
                    toolbar.setVisibility(View.GONE);
                    shoubottom.setVisibility(View.GONE);
                }
                if (dy>1&&lineayout==0&&toolb==1){
                    toolbar.setVisibility(View.GONE);
                    shoubottom.setVisibility(View.VISIBLE);
                }
                if (toolb==1&&lineayout==1){
                    toolbar.setVisibility(View.GONE);
                    shoubottom.setVisibility(View.GONE);
                }
            }
        });

        ShouPB.setMax(100);
        shouhome.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                ShouPB.setVisibility(View.VISIBLE);
                ShouPB.setProgress(newProgress);
                if (newProgress==100){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            //execute the task
                            ShouPB.setVisibility(View.GONE);
                        }
                    }, 1000);
                }
                super.onProgressChanged(view,newProgress);
            }

        });


        final Handler allhandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                allurl=msg.obj.toString();
                String zanshicun="";
                Log.v("allurl",allurl);
                for (int i=0;i<allurl.length();i++){
                    if (allurl.charAt(i)!='㤅'){
                        zanshicun+=allurl.charAt(i);
                    }else {
                        switch (jizu){
                            case 0:
                                shiertu=zanshicun;
                                Log.v("aa",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 1:
                                shiertuurl=zanshicun;
                                Log.v("bb",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 2:
                                bajiekou=zanshicun;
                                Log.v("cc",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 3://男图数组数量
                                nantucount=zanshicun;
                                Log.v("dd",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 4://女图数组的数量
                                nvtucount=zanshicun;
                                Log.v("ee",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 5:
                                nantu=zanshicun;
                                Log.v("ff",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 6:
                                nantukouling=zanshicun;
                                Log.v("gg",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 7:
                                nvtu=zanshicun;
                                Log.v("hh",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 8:
                                nvtukouling=zanshicun;//
                                Log.v("jj",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 9:
                                shuangtu=zanshicun;//
                                Log.v("kk",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 10:
                                gonggao=zanshicun;
                                Log.v("gonggao",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 11:
                                qunhao=zanshicun;
                                Log.v("qunhao",zanshicun);
                                jizu++;
                                zanshicun="";
;                                break;
                            case 12:
                                version=zanshicun;
                                Log.v("version",zanshicun);
                                jizu++;
                                zanshicun="";
                                break;
                            case 13:
                                updateurl=zanshicun;
                                jizu++;
                                zanshicun="";
                                break;
                            case 14:
                                if (!zanshicun.equals("")){
                                    editor.putString("dizhi",zanshicun);
                                    editor.apply();
                                    Log.v("dizhi",zanshicun);
                                }
                                jizu++;
                                zanshicun="";
                                break;
                            case 15:
                                if (!zanshicun.equals("")){
                                    editor.putString("duankouhao",zanshicun);
                                    editor.apply();
                                    Log.v("duankouhao",zanshicun);
                                }
                                jizu++;
                                zanshicun="";
                                break;

                        }
                    }
                }
                //12图
                twelve=shiertu;
                for (int i=0;i<twelve.length();i++){
                    if (twelve.charAt(i)!=';'&&t<12){
                        zctwelve+=twelve.charAt(i);
                    }else if (twelve.charAt(i)==';'){
                        t++;
                        switch (t){
                            case 1:
                                url01.setImageUrl(zctwelve);
                                break;
                            case 2:
                                url02.setImageUrl(zctwelve);
                                break;
                            case 3:
                                url03.setImageUrl(zctwelve);
                                break;
                            case 4:
                                url04.setImageUrl(zctwelve);
                                break;
                            case 5:
                                url05.setImageUrl(zctwelve);
                                break;
                            case 6:
                                url06.setImageUrl(zctwelve);
                                break;
                            case 7:
                                url07.setImageUrl(zctwelve);
                                break;
                            case 8:
                                url08.setImageUrl(zctwelve);
                                break;
                            case 9:
                                url09.setImageUrl(zctwelve);
                                break;
                            case 10:
                                url10.setImageUrl(zctwelve);
                                break;
                            case 11:
                                url11.setImageUrl(zctwelve);
                                break;
                            case 12:
                                url12.setImageUrl(zctwelve);
                                break;
                        }
                        zctwelve="";
                    }
                }



                //12图url
                getUrl=shiertuurl;
                for (int i=0;i<getUrl.length();i++){
                    if (getUrl.charAt(i)!=';'&&u<12){
                        everyurl+=getUrl.charAt(i);


                    }else if (getUrl.charAt(i)==';'){
                        u++;
                        switch (u){
                            case 1:
                                ur1=everyurl;
                                break;
                            case 2:
                                ur2=everyurl;
                                break;
                            case 3:
                                ur3=everyurl;
                                break;
                            case 4:
                                ur4=everyurl;
                                break;
                            case 5:
                                ur5=everyurl;
                                break;
                            case 6:
                                ur6=everyurl;
                                break;
                            case 7:
                                ur7=everyurl;
                                break;
                            case 8:
                                ur8=everyurl;
                                break;
                            case 9:
                                ur9=everyurl;
                                break;
                            case 10:
                                ur10=everyurl;
                                break;
                            case 11:
                                ur11=everyurl;
                                break;
                            case 12:
                                ur12=everyurl;
                                break;
                        }
                        everyurl="";
                    }
                }


                //8接口
                seven=bajiekou;
                for (int i=0;i<seven.length();i++){
                    if (seven.charAt(i)!=';'&&vt<8){
                        zcseven+=seven.charAt(i);
                    }else if (seven.charAt(i)==';'){
                        vt++;
                        switch (vt){
                            case 1:
                                vurl0=zcseven;
                                break;
                            case 2:
                                vurl1=zcseven;
                                break;
                            case 3:
                                vurl2=zcseven;
                                break;
                            case 4:
                                vurl3=zcseven;
                                break;
                            case 5:
                                vurl4=zcseven;
                                break;
                            case 6:
                                vurl5=zcseven;
                                break;
                            case 7:
                                vurl6=zcseven;
                                break;
                            case 8:
                                vurl7=zcseven;
                                break;
                        }
                        zcseven="";
                    }
                }

                //男图数量
                c=Integer.parseInt(nantucount,10);
                //女图数量
                w=Integer.parseInt(nvtucount,10);

                for (int i = 0; i < shuangtu.length(); i++) {
                    if (shuangtu.charAt(i) != ';' && shuangtucount < 2) {
                        shuangtudezancun += shuangtu.charAt(i);
                    } else if (shuangtu.charAt(i) == ';') {
                        shuangtucount++;
                        switch (shuangtucount) {
                            case 1:
                                man.setImageUrl(shuangtudezancun);
                                Log.v("man",shuangtudezancun);
                                break;
                            case 2:
                                woman.setImageUrl(shuangtudezancun);
                                Log.v("man",shuangtudezancun);
                                break;
                        }
                        shuangtudezancun = "";
                    }
                }

                Tgonggao.setText(gonggao);
                Equnhao.setText(qunhao);

                if (!version.equals("0")) {
                    Intent intent = new Intent(Classshou.this, DownActivtiy.class);
                    startActivity(intent);
                }











            }
        };

        SharedPreferences huandizhi=getSharedPreferences("duankou",MODE_PRIVATE);
            dizhi = huandizhi.getString("dizhi", "");
            duankouhao = huandizhi.getString("duankouhao", "");
        if (!duankouhao.equals("")) {
            duankouhaoma = Integer.parseInt(duankouhao, 10);
        }


        //唯一socket
        new Thread(){
            @Override
            public void run() {

                try {

                    Socket socket = new Socket(dizhi,duankouhaoma);
                    Log.v("socket",String.valueOf(socket.isClosed()));
//                    outputStream = new DataOutputStream(socket.getOutputStream());
//                    outputStream.write(Integer.parseInt(tm.getDeviceId(),10));
                    BufferedReader t = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String tt = t.readLine();
                    if (tt!=null) {
                        Message message = new Message();
                        message.obj = tt;
                        allhandler.sendMessage(message);
                    }
                    t.close();
                    socket.close();
//                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    Socket socket=new Socket("106.14.135.141",110);
//                    Socket socket=new Socket("112.1.199.192",110);
//                        outputStream=new DataOutputStream(socket.getOutputStream());
//                        outputStream.write(3);
                    BufferedReader t=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String tt=t.readLine();
                    if (tt!=null) {
                        Message message = new Message();
                        message.obj = tt;
                        allhandler.sendMessage(message);
                    }
                    t.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();













        final Handler bhandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                seven=msg.obj.toString();
                for (int i=0;i<seven.length();i++){
                    if (seven.charAt(i)!=';'&&vt<8){
                        zcseven+=seven.charAt(i);
                    }else if (seven.charAt(i)==';'){
                        vt++;
                        switch (vt){
                            case 1:
                                vurl0=zcseven;
                                break;
                            case 2:
                                vurl1=zcseven;
                                break;
                            case 3:
                                vurl2=zcseven;
                                break;
                            case 4:
                                vurl3=zcseven;
                                break;
                            case 5:
                                vurl4=zcseven;
                                break;
                            case 6:
                                vurl5=zcseven;
                                break;
                            case 7:
                                vurl6=zcseven;
                                break;
                            case 8:
                                vurl7=zcseven;
                                break;
                        }
                        zcseven="";
                    }
                }
            }
        };
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Socket socket=new Socket(duankou,port);
//                    outputStream=new DataOutputStream(socket.getOutputStream());
//                    outputStream.write(88);
//                    BufferedReader t=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    String tt=t.readLine();
//                    Message message=new Message();
//                    message.obj=tt;
//                    bhandler.sendMessage(message);
//                    t.close();
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
////                    Toast.makeText(Video.this,"联网出现问题，请重新进入！",Toast.LENGTH_LONG).show();
////                    Intent intent=new Intent(Video.this,Classshou.class);
////                    startActivity(intent);
//                }
//            }
//        }.start();


        final Handler thandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                twelve=msg.obj.toString();
                for (int i=0;i<twelve.length();i++){
                    if (twelve.charAt(i)!=';'&&t<12){
                        zctwelve+=twelve.charAt(i);
                    }else if (twelve.charAt(i)==';'){
                        t++;
                        switch (t){
                            case 1:
                                url01.setImageUrl(zctwelve);
                                break;
                            case 2:
                                url02.setImageUrl(zctwelve);
                                break;
                            case 3:
                                url03.setImageUrl(zctwelve);
                                break;
                            case 4:
                                url04.setImageUrl(zctwelve);
                                break;
                            case 5:
                                url05.setImageUrl(zctwelve);
                                break;
                            case 6:
                                url06.setImageUrl(zctwelve);
                                break;
                            case 7:
                                url07.setImageUrl(zctwelve);
                                break;
                            case 8:
                                url08.setImageUrl(zctwelve);
                                break;
                            case 9:
                                url09.setImageUrl(zctwelve);
                                break;
                            case 10:
                                url10.setImageUrl(zctwelve);
                                break;
                            case 11:
                                url11.setImageUrl(zctwelve);
                                break;
                            case 12:
                                url12.setImageUrl(zctwelve);
                                break;
                        }
                        zctwelve="";
                    }
                }
            }
        };
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Socket socket=new Socket(duankou,port);
//                    outputStream=new DataOutputStream(socket.getOutputStream());
//                    outputStream.write(12);
//                    BufferedReader t=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    String tt=t.readLine();
//                    Message message=new Message();
//                    message.obj=tt;
//
//                    thandler.sendMessage(message);
//                    t.close();
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();



        final Handler ghandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                getUrl=msg.obj.toString();
                for (int i=0;i<getUrl.length();i++){
                    if (getUrl.charAt(i)!=';'&&u<12){
                        everyurl+=getUrl.charAt(i);


                    }else if (getUrl.charAt(i)==';'){
                        u++;
                        switch (u){
                            case 1:
                                ur1=everyurl;
                                break;
                            case 2:
                                ur2=everyurl;
                                break;
                            case 3:
                                ur3=everyurl;
                                break;
                            case 4:
                                ur4=everyurl;
                                break;
                            case 5:
                                ur5=everyurl;
                                break;
                            case 6:
                                ur6=everyurl;
                                break;
                            case 7:
                                ur7=everyurl;
                                break;
                            case 8:
                                ur8=everyurl;
                                break;
                            case 9:
                                ur9=everyurl;
                                break;
                            case 10:
                                ur10=everyurl;
                                break;
                            case 11:
                                ur11=everyurl;
                                break;
                            case 12:
                                ur12=everyurl;
                                break;
                        }
                        everyurl="";
                    }
                }
            }
        };
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Socket socket=new Socket(duankou,port);
//                    outputStream=new DataOutputStream(socket.getOutputStream());
//                    outputStream.write(120);
//                    BufferedReader t=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    String tt=t.readLine();
//                    Message message=new Message();
//                    message.obj=tt;
//
//                    ghandler.sendMessage(message);
//                    t.close();
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();




        final Handler chandle=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                c=msg.what;
            }
        };

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    //获取grid列表数量
//                    Socket count=new Socket(duankou,port);
//                    outputStream=new DataOutputStream(count.getOutputStream());
//                    outputStream.write(1);
//                    BufferedReader cc=new BufferedReader(new InputStreamReader(count.getInputStream()));
////                    cout =new DataOutputStream(count.getOutputStream());
//                    int ccc=cc.read();
//                    Log.v("cc", String.valueOf(ccc));
//                    Message msg=new Message();
//                    msg.what=ccc;
//                    chandle.sendMessage(msg);
//                    Log.v("mei","运行");
//                    cc.close();
//                    count.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

        final Handler whandle=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                w=msg.what;
            }
        };

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    //获取grid列表数量
//                    Socket count=new Socket(duankou,port);
//                    outputStream=new DataOutputStream(count.getOutputStream());
//                    outputStream.write(4);
//                    BufferedReader cc=new BufferedReader(new InputStreamReader(count.getInputStream()));
////                    cout =new DataOutputStream(count.getOutputStream());
//                    int ccc=cc.read();
//                    Log.v("cc", String.valueOf(ccc));
//                    Message msg=new Message();
//                    msg.what=ccc;
//                    whandle.sendMessage(msg);
//                    Log.v("mei","运行");
//                    cc.close();
//                    count.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();


        fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent();
//                intent.setClass(Classshou.this,Video.class);
//                startActivity(intent);
//            }
//        });
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setIcon(R.drawable.nn);
//                builder.setTitle("");
                builder.setItems(iten, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                shouhome.loadUrl("https://www.readnovel.com/");
                                break;
                            case 1:
                                shouhome.loadUrl("http://www.qidian.com/");
                                break;
                            case 2:
                                shouhome.loadUrl("https://www.xs8.cn/");
                                break;
                        }
                    }
                });
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                builder.show();
//            .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        View navigationViewHeaderView=navigationView.inflateHeaderView(R.layout.nav_header_classshou);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_click_info);
        wvtianqi=navigationViewHeaderView.findViewById(R.id.wvtianqi);

        Equnhao= navigationViewHeaderView.findViewById(R.id.Equnhaao);
        Tgonggao=navigationViewHeaderView.findViewById(R.id.Tgonggao);

        wvtianqi.getSettings().setJavaScriptEnabled(true);
        wvtianqi.loadUrl("http://i.tianqi.com/index.php?c=code&id=11&color=%23FFFFFF&bgc=%2300B0F0&icon=1&site=12");
        wvtianqi.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wvtianqi.loadUrl("http://i.tianqi.com/index.php?c=code&id=11&color=%23FFFFFF&bgc=%2300B0F0&icon=1&site=12");
                return super.shouldOverrideUrlLoading(view, url);
            }
        });


        shouhome.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.v("jingyu",url);
                return false;
            }
        });
        shouhome.getSettings().setJavaScriptEnabled(true);
        shouhome.loadUrl(shouurl);

        WebSettings ws = shouhome.getSettings();
        /**
         * setAllowFileAccess 启用或禁止WebView访问文件数据 setBlockNetworkImage 是否显示网络图像
         * setBuiltInZoomControls 设置是否支持缩放 setCacheMode 设置缓冲的模式
         * setDefaultFontSize 设置默认的字体大小 setDefaultTextEncodingName 设置在解码时使用的默认编码
         * setFixedFontFamily 设置固定使用的字体 setJavaSciptEnabled 设置是否支持Javascript
         * setLayoutAlgorithm 设置布局方式 setLightTouchEnabled 设置用鼠标激活被选项
         * setSupportZoom 设置是否支持变焦
         * */
        ws.setBuiltInZoomControls(false);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setSavePassword(true);
        ws.setSaveFormData(true);// 保存表单数据
        ws.setJavaScriptEnabled(true);
        ws.setGeolocationEnabled(true);// 启用地理定位
        ws.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");// 设置定位的数据库路径
        ws.setDomStorageEnabled(true);
//        ws.setUserAgentString("JUC (Linux; U; 2.3.5; zh-cn; MEIZU MX; 640*960) UCWEB8.5.1.179/145/33232");



    }


//    private android.app.AlertDialog.Builder setPositiveButton(
//            android.app.AlertDialog.Builder builder)
//    {
//        // 调用setPositiveButton方法添加“确定”按钮
//        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
//        {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                show.setText("单击了【确定】按钮！");
//            }
//        });
//    }
//    private android.app.AlertDialog.Builder setNegativeButton(
//            android.app.AlertDialog.Builder builder)
//    {
//        // 调用setNegativeButton方法添加“取消”按钮
//        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
//        {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                show.setText("单击了【取消】按钮！");
//            }
//        });
//    }



    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (!shouhome.canGoBack()){
//                finish();
                exit_app();
            }
            shouhome.goBack();
        }
        findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.classshou, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(Classshou.this,XVideo.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void man(View view) {
        final Handler chandle=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                c=msg.what;
            }
        };
        if (c==-1){
//            new Thread(){
//                @Override
//                public void run() {
//                    try {
//                        //获取grid列表数量
//                        Socket count=new Socket("106.14.135.141",110);
//                        outputStream=new DataOutputStream(count.getOutputStream());
//                        outputStream.write(1);
//                        BufferedReader cc=new BufferedReader(new InputStreamReader(count.getInputStream()));
//                        cout =new DataOutputStream(count.getOutputStream());
//                        int ccc=cc.read();
//                        Log.v("cc", String.valueOf(ccc));
//                        Message msg=new Message();
//                        msg.what=ccc;
//                        chandle.sendMessage(msg);
//                        Log.v("mei","运行");
//                        cc.close();
//                        count.close();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
            Toast.makeText(Classshou.this,"服务器走神了！请再点一下",Toast.LENGTH_LONG).show();
        }
        if (c!=-1){
            Intent intent=new Intent();
            intent.setClass(Classshou.this,Guodu.class);
            startActivity(intent);
        }
    }
    public void woman(View view) {
        final Handler chandle = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                w = msg.what;
            }
        };
        if (w == -1) {
//            new Thread() {
//                @Override
//                public void run() {
//                    try {
//                        //获取grid列表数量
//                        Socket count = new Socket("106.14.135.141", 110);
//                        outputStream = new DataOutputStream(count.getOutputStream());
//                        outputStream.write(4);
//                        BufferedReader cc = new BufferedReader(new InputStreamReader(count.getInputStream()));
//                        cout = new DataOutputStream(count.getOutputStream());
//                        int ccc = cc.read();
//                        Log.v("cc", String.valueOf(ccc));
//                        Message msg = new Message();
//                        msg.what = ccc;
//                        chandle.sendMessage(msg);
//                        Log.v("mei", "运行");
//                        cc.close();
//                        count.close();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
            Toast.makeText(Classshou.this, "服务器走神了！请再点一下", Toast.LENGTH_LONG).show();
        }
        if (w != -1) {
            Intent intent = new Intent();
            intent.setClass(Classshou.this, Guoduw.class);
            startActivity(intent);
        }
    }



    public void url01(View view) {
        bofangdeurl=ur1;
//        url="http://v.1by.com/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,CrowserActivity.class);
        startActivity(intent);
    }

    public void url02(View view) {
//        url="http://mm.72du.com/";
        bofangdeurl=ur2;
        //http://www.cnscg.org/
        //http://www.gaoqingkong.com/

        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url03(View view) {
//        url="http://subhd.com/main2";
        bofangdeurl=ur3;
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url04(View view) {
        bofangdeurl=ur4;
//        url="http://www.kankanwu.com/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url05(View view) {
//        url="http://gxdy18.cn/";
        bofangdeurl=ur5;
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url06(View view) {
        bofangdeurl=ur6;
//        url="http://gxdy17.cn/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url07(View view) {
        bofangdeurl=ur7;
//        url="http://m.dyyy2.cn/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url08(View view) {
        bofangdeurl=ur8;
//        url="http://zz.5live.cc/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url09(View view) {
        bofangdeurl=ur9;
//        url="http://dy.sxzxmp.com/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url10(View view) {
        bofangdeurl=ur10;
//        url="http://www.gaoqingkong.com/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url11(View view) {
        bofangdeurl=ur11;
//        url="http://zz.5live.cc/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);
    }

    public void url12(View view) {
        bofangdeurl=ur12;
//        url="http://www.kankanwu.com/";
        Intent intent=new Intent();
        intent.setClass(Classshou.this,BrowserActivity.class);
        startActivity(intent);

    }
//    public static String[] mThumbIds={};
//

    public void diary(View view) {
        Intent intent=new Intent();
        intent.setClass(Classshou.this,MainActivity.class);
        startActivity(intent);

    }

    public void exit_app()
    {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);

        dialog.setTitle("退出").setMessage("要退出吗").setPositiveButton("退出",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Classshou.this.finish();
                    }
                }).setNegativeButton("返回",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        android.app.AlertDialog dialog_dialog = dialog.create();
        dialog_dialog.show();
    }

    private void allid(){
//        Tgonggao= (TextView) findViewById(R.id.Tgonggao);
//        Equnhao= (EditText) findViewById(R.id.Equnhaao);
        LLsosuo= (LinearLayout) findViewById(R.id.LLsosuo);
        busosuo= (Button) findViewById(R.id.busosuo);
        etsosuo= (EditText) findViewById(R.id.etsosuo);
        qianjin= (Button) findViewById(R.id.qianjin);
        shezhi= (Button) findViewById(R.id.shezhi);
        zhuye= (Button) findViewById(R.id.zhuye);
        sosuo= (Button) findViewById(R.id.sousuo);
        man= (SmartImageView) findViewById(R.id.man);
        woman= (SmartImageView) findViewById(R.id.woman);
        url01= (SmartImageView) findViewById(R.id.url01);
        url02= (SmartImageView) findViewById(R.id.url02);
        url03= (SmartImageView) findViewById(R.id.url03);
        url04= (SmartImageView) findViewById(R.id.url04);
        url05= (SmartImageView) findViewById(R.id.url05);
        url06= (SmartImageView) findViewById(R.id.url06);
        url07= (SmartImageView) findViewById(R.id.url07);
        url08= (SmartImageView) findViewById(R.id.url08);
        url09= (SmartImageView) findViewById(R.id.url09);
        url10= (SmartImageView) findViewById(R.id.url10);
        url11= (SmartImageView) findViewById(R.id.url11);
        url12= (SmartImageView) findViewById(R.id.url12);
        shouhome= (ObservableWebView) findViewById(R.id.shouhome);
        shoubottom= (LinearLayout) findViewById(R.id.shoubottom);
        ShouPB= (ProgressBar) findViewById(R.id.ShouPB);
//        shouhome= (WebView) findViewById(R.id.shouhome);
    }

    public void guanyyu(View view) {
        Intent intent=new Intent(Classshou.this, Guanyu.class);
        startActivity(intent);
    }
}
