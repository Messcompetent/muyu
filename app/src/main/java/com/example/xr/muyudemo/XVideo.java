package com.example.xr.muyudemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xr.muyudemo.video.test_webview_demo.APPAplication;
import com.example.xr.muyudemo.video.test_webview_demo.BrowserActivity;
import com.example.xr.muyudemo.video.test_webview_demo.MainActivity;

import static com.example.xr.muyudemo.Classshou.vurl0;
import static com.example.xr.muyudemo.Classshou.vurl1;
import static com.example.xr.muyudemo.Classshou.vurl2;
import static com.example.xr.muyudemo.Classshou.vurl3;
import static com.example.xr.muyudemo.Classshou.vurl4;
import static com.example.xr.muyudemo.Classshou.vurl5;
import static com.example.xr.muyudemo.Classshou.vurl6;
import static com.example.xr.muyudemo.Classshou.vurl7;


/**
 * Created by XR on 2017/9/1.
 */

public class XVideo extends Activity {
    private ProgressBar videoPB;
    private String url="http://www.youku.com";
    public static String bofangdeurl="";
    private String zcurl="";
    private WebView tsswebview;
    private FloatingActionButton xvideofab;
    private String[] item=new String[]{ "爱奇艺","优酷","土豆","搜狐","腾讯视频","刷新","退出回小说","全屏播放1","全屏播放2","全屏播放3","全屏播放4","全屏播放5","全屏播放6","全屏播放7","全屏播放8"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xvideourl);
        videoPB=findViewById(R.id.XvideoPB);
        tsswebview=findViewById(R.id.tsswebzhu);
        xvideofab=findViewById(R.id.xvideofab);
        WebSettings ws = tsswebview.getSettings();
        /**
         * setAllowFileAccess 启用或禁止WebView访问文件数据 setBlockNetworkImage 是否显示网络图像
         * setBuiltInZoomControls 设置是否支持缩放 setCacheMode 设置缓冲的模式
         * setDefaultFontSize 设置默认的字体大小 setDefaultTextEncodingName 设置在解码时使用的默认编码
         * setFixedFontFamily 设置固定使用的字体 setJavaSciptEnabled 设置是否支持Javascript
         * setLayoutAlgorithm 设置布局方式 setLightTouchEnabled 设置用鼠标激活被选项
         * setSupportZoom 设置是否支持变焦
         * */
        ws.setUserAgentString("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360Chrome)");
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setSavePassword(true);
        ws.setSaveFormData(true);// 保存表单数据
        ws.setJavaScriptEnabled(true);
        ws.setGeolocationEnabled(true);// 启用地理定位
        ws.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");// 设置定位的数据库路径
        ws.setDomStorageEnabled(true);

        tsswebview.loadUrl(url);
        tsswebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                zcurl=url;
                return super.shouldOverrideUrlLoading(view, url);
            }
        });



        videoPB.setMax(100);
        tsswebview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                videoPB.setVisibility(View.VISIBLE);
                videoPB.setProgress(newProgress);
                if (newProgress==100){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            //execute the task
                            videoPB.setVisibility(View.GONE);
                        }
                    }, 1000);
                }
                super.onProgressChanged(view,newProgress);
            }

        });

        final AlertDialog.Builder buildershezhi=new AlertDialog.Builder(this);
        xvideofab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buildershezhi.setItems(item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(XVideo.this,BrowserActivity.class);
                        switch (i){
                            case 0:
//                                tsswebview.getSettings().setUserAgentString("JUC (Linux; U; 2.3.5; zh-cn; MEIZU MX; 640*960) UCWEB8.5.1.179/145/33232");
                                url="http://www.iqiyi.com";
                                tsswebview.loadUrl(url);
                                break;
                            case 1:
//                                tsswebview.getSettings().setUserAgentString("");
                                url="http://www.youku.com";
                                tsswebview.loadUrl(url);
                                break;
                            case 2:
//                                tsswebview.getSettings().setUserAgentString("");
                                url="http://www.tudou.com/";
                                tsswebview.loadUrl(url);
                                break;
                            case 3:
//                                tsswebview.getSettings().setUserAgentString("");
                                url="http://tv.sohu.com/";
                                tsswebview.loadUrl(url);
                                break;
                            case 4:
//                                tsswebview.getSettings().setUserAgentString("");
                                url="https://v.qq.com/";
                                tsswebview.loadUrl(url);
                                break;
                            case 5:
                                tsswebview.reload();
                                break;
                            case 6:
                                Process.killProcess(Process.myPid());
                            case 7:
                                bofangdeurl=vurl0+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 8:
                                bofangdeurl=vurl1+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 9:
                                bofangdeurl=vurl2+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 10:
                                bofangdeurl=vurl3+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 11:
                                bofangdeurl=vurl4+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 12:
                                bofangdeurl=vurl5+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 13:
                                bofangdeurl=vurl6+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦！",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                            case 14:
                                bofangdeurl=vurl7+zcurl;
                                Toast.makeText(XVideo.this,"第一次打开要连接wifi哦",Toast.LENGTH_LONG).show();
//                                zcurl="";
                                startActivity(intent);
                                break;
                        }
                    }
                });
                buildershezhi.show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (tsswebview.canGoBack()){
                tsswebview.goBack();
            }else {
//                Intent intent=new Intent(XVideo.this,Classshou.class);
//                startActivity(intent);
                finish();
            }
        }
        return true;
    }

}
