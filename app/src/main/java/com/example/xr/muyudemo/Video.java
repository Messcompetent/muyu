package com.example.xr.muyudemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import static com.example.xr.muyudemo.Classshou.urlvideo;
import static com.example.xr.muyudemo.Classshou.vurl0;
import static com.example.xr.muyudemo.Classshou.vurl1;
import static com.example.xr.muyudemo.Classshou.vurl2;
import static com.example.xr.muyudemo.Classshou.vurl3;
import static com.example.xr.muyudemo.Classshou.vurl4;
import static com.example.xr.muyudemo.Classshou.vurl5;
import static com.example.xr.muyudemo.Classshou.vurl6;
import static com.example.xr.muyudemo.Classshou.vurl7;


/**
 *
 * @author tanwenwei
 *
 */
public class Video extends Activity {

    private FrameLayout videoview;// 全屏时视频加载view
    private Button videolandport;
    private WebView videowebview;
    public ProgressBar VideoPB;
    private Boolean islandport = true;//true表示此时是竖屏，false表示此时横屏。
    private View xCustomView;
    private String ua,ub,uc;
    private int w=0;
    private xWebChromeClient xwebchromeclient;
//    private String url = "http://www.iqiyi.com";
    private WebChromeClient.CustomViewCallback 	xCustomViewCallback;
    private FloatingActionButton bfloating;
    private long ExitTime = 0;
    private String urlzancun="";//暂存url
    String[] items = new String[] {
            "全屏线模式一(功能不稳定，失败请重试)",
            "全屏线模式二(播放条变灰色代表失败)",
            "全屏线模式三(功能不稳定，失败请重试)",
            "全屏线模式四(功能不稳定，失败请重试)",
            "全屏线模式五(功能不稳定，失败请重试)",
            "全屏线模式六(功能不稳定，失败请重试)",
            "全屏线模式七(功能不稳定，失败请重试)",
            "全屏线模式八(功能不稳定，失败请重试)",
    "刷新","爱奇艺","优酷","搜狐","土豆","回到小说"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉应用标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.xvideo);
        initwidget();
        initListener();
        videowebview.loadUrl(urlvideo);
        VideoPB.setMax(100);





    }

    public void simpleList(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("请选择怎样播放")
                // 设置图标
//                .setIcon(R.drawable.tools)
                // 设置简单的列表项内容
                .setItems(items, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        switch(which){
                            case 0:
                                String bofang0=vurl0+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);

                                Log.v("bofang0",bofang0);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                                bfloating.setVisibility(View.GONE);
                                videowebview.loadUrl(bofang0);
                                break;
                            case 1:
                                String bofang1=vurl1+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);

                                Log.v("bofang1",bofang1);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);
                                videowebview.loadUrl(bofang1);

                                break;
                            case 2://不行？
                                String bofang2=vurl2+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);
                                videowebview.loadUrl(bofang2);
                                Log.v("bofang2",bofang2);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);

                                break;
                            case 3://不行
                                String bofang3=vurl3+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);
                                videowebview.loadUrl(bofang3);
                                Log.v("bofang3",bofang3);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);

                                break;
                            case 4://不行2
                                String bofang4=vurl4+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);
                                videowebview.loadUrl(bofang4);
                                Log.v("bofang4",bofang4);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);

                                break;
                            case 5:
                                String bofang5=vurl5+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);
                                videowebview.loadUrl(bofang5);
                                Log.v("bofang5",bofang5);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);

                                break;
                            case 6:
                                String bofang6=vurl6+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);
                                videowebview.loadUrl(bofang6);
                                Log.v("bofang6",bofang6);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);

                                break;
                            case 7:
                                String bofang7=vurl7+urlzancun;
                                videowebview.getSettings().setUserAgentString(uc);

                                Log.v("bofang7",bofang7);
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                                bfloating.setVisibility(View.GONE);
                                videowebview.loadUrl(bofang7);
                                break;
                            case 8:
                                videowebview.reload();
                                break;
                            case 9:
                                videowebview.loadUrl("http://www.iqiyi.com");
                                break;
                            case 10:
                                videowebview.loadUrl("http://www.youku.com");

                                break;
                            case 11:
                                videowebview.loadUrl("http://tv.sohu.com");

                                break;
                            case 12:
                                videowebview.loadUrl("http://www.tudou.com");

                                break;
                            case 13:
                                Intent intent=new Intent(Video.this,Classshou.class);
                                startActivity(intent);
                                break;
                        }
                    }
                });
        // 为AlertDialog.Builder添加“确定”按钮
//        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
//        setNegativeButton(builder)
//                .create()
                builder.show();
    }

    private void initListener() {
        // TODO Auto-generated method stub
        videolandport.setOnClickListener(new Listener());
    }

    private void initwidget() {
        // TODO Auto-generated method stub
        videoview = (FrameLayout) findViewById(R.id.video_view);
        videolandport = (Button) findViewById(R.id.video_landport);
        videowebview = (WebView) findViewById(R.id.video_webview);
        VideoPB=(ProgressBar)findViewById(R.id.VideoPB);
        bfloating=findViewById(R.id.bfloating);
        WebSettings ws = videowebview.getSettings();
        /**
         * setAllowFileAccess 启用或禁止WebView访问文件数据 setBlockNetworkImage 是否显示网络图像
         * setBuiltInZoomControls 设置是否支持缩放 setCacheMode 设置缓冲的模式
         * setDefaultFontSize 设置默认的字体大小 setDefaultTextEncodingName 设置在解码时使用的默认编码
         * setFixedFontFamily 设置固定使用的字体 setJavaSciptEnabled 设置是否支持Javascript
         * setLayoutAlgorithm 设置布局方式 setLightTouchEnabled 设置用鼠标激活被选项
         * setSupportZoom 设置是否支持变焦
         * */
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

//        ws.setUseWideViewPort(true);
//        ws.setLoadWithOverviewMode(true);
//        ws.setDefaultTextEncodingName("UTF-8");
//        ws.setAllowFileAccess(true);
//        ws.setJavaScriptCanOpenWindowsAutomatically(true);
//        ws.setPluginState(WebSettings.PluginState.ON);

        //		ua="Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0";//Firefox on Windows
//		ua="Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0";//Firefox on Windows
//		ua="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 BIDUBrowser/7.5 Safari/537.36";//百度浏览器
		uc="MQQBrowser/3.6/Adr (Linux; U; 4.0.3; zh-cn; HUAWEI U8818 Build/U8818V100R001C17B926;480*800)";//QQ浏览器手机版
//		ua="Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)";//遨游浏览器
//		ua="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36 QQBrowser/9.0.2229.400";//QQ浏览器
//		ua="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36 SE 2.X MetaSr 1.0";//搜狗浏览器
//		ub="UCWEB/2.0 (iOS; U; iPh OS 4_3_2; zh-CN; iPh4) U2/1.0.0 UCBrowser/8.6.0.199 U2/1.0.0 Mobile";//UC浏览器手机版
//        ua="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 UBrowser/5.1.2238.18 Safari/537.36";//UC浏览器电脑版
//		ua="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.99 Safari/537.36 LBBROWSER";//猎豹浏览器
//		ua="Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)";//360安全浏览器
		ua="Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360Chrome)";//360极速浏览器
//        uc="JUC (Linux; U; 2.3.5; zh-cn; MEIZU MX; 640*960) UCWEB8.5.1.179/145/33232";
		ub="JUC (Linux; U; 2.3.5; zh-cn; MEIZU MX; 640*960) UCWEB8.5.1.179/145/33232";//魅族
//		uc="Mozilla/5.0 (MeeGo; NokiaN9) AppleWebKit/534.13 (KHTML, like Gecko) NokiaBrowser/8.5.0 Mobile Safari/534.13";//MeeGo - Nokia N9
//		ua="Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.1.0; en-US) AppleWebKit/536.2+ (KHTML, like Gecko) Version/7.2.1.0 Safari/536.2+";//BlackBerry - Playbook 2.1
//		ua="Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3";//iPad
//		ua="Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3";//iPhone
//		uc="Mozilla/5.0 (Linux;u;Android 4.2.2;zh-cn;) AppleWebKit/534.46 (KHTML,like Gecko) Version/5.1 Mobile Safari/10600.6.3 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)";//百度移动端
//        ua="JUC (Linux; U; 2.3.5; zh-cn; MEIZU MX; 640*960) UCWEB8.5.1.179/145/33232";//魅族;
//		uc="UCWEB/2.0 (iOS; U; iPh OS 4_3_2; zh-CN; iPh4) U2/1.0.0 UCBrowser/8.6.0.199 U2/1.0.0 Mobile";//UC浏览器手机版
//		ub="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36 QQBrowser/9.0.2229.400";//QQ浏览器
//		uc="Mozilla/5.0 (Linux; U; Android 4.1.1; zh-cn;  MI2 Build/JRO03L) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 XiaoMi/MiuiBrowser/1.0";//小米

        ws.setUserAgentString(ua);
        xwebchromeclient = new xWebChromeClient();
        videowebview.setWebChromeClient(xwebchromeclient);
        videowebview.setWebViewClient(new xWebViewClientent());

    }

    class Listener implements OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.video_landport:
                    if (islandport) {
                        Log.i("testwebview", "竖屏切换到横屏");
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        videolandport.setText("全屏不显示该按扭，点击切换竖屏");
                    }else {
                        Log.i("testwebview", "横屏切换到竖屏");
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        videolandport.setText("全屏不显示该按扭，点击切换横屏");
                    }
                    break;

                default:
                    break;
            }
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Log.v("zancun",urlzancun);
//            if ((System.currentTimeMillis() - ExitTime) > 2500&&urlzancun.equals("http://www.iqiyi.com/")){
//                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
//                ExitTime = System.currentTimeMillis();
//            }
            if(!islandport){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            if (inCustomView()) {
                videowebview.getSettings().setUserAgentString(ua);
                if (w==1) {
                    videowebview.getSettings().setUserAgentString(ub);
                }
                hideCustomView();
                return true;
            }
            if (!videowebview.canGoBack()) {
                finish();

            } else{
                videowebview.getSettings().setUserAgentString(ua);
                if (w==1) {
                    videowebview.getSettings().setUserAgentString(ub);
                }


                videowebview.goBack();
//                videowebview.loadUrl("about:blank");
//		       		 mTestWebView.loadData("", "text/html; charset=UTF-8", null);
//                Video.this.finish();
//                Log.i("testwebview", "===>>>2");
            }
            bfloating.setVisibility(View.VISIBLE);
            videowebview.getSettings().setUserAgentString(ua);
        }
//        return super.onKeyDown(keyCode, event);
        return true;
    }
    /**
     * 判断是否是全屏
     * @return
     */
    public boolean inCustomView() {
        return (xCustomView != null);
    }
    /**
     * 全屏时按返加键执行退出全屏方法
     */
    public void hideCustomView() {
        xwebchromeclient.onHideCustomView();
    }
    /**
     * 处理Javascript的对话框、网站图标、网站标题以及网页加载进度等
     * @author
     */
    public class xWebChromeClient extends WebChromeClient {
        private Bitmap xdefaltvideo;
        private View xprogressvideo;

        @Override
        //播放网络视频时全屏会被调用的方法
        public void onShowCustomView(View view, CustomViewCallback callback)//全屏播放回调
        {
            if (islandport) {

            }
            else{

//				ii = "1";
//				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            videowebview.setVisibility(View.GONE);
            //如果一个视图已经存在，那么立刻终止并新建一个
            if (xCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }

            videoview.addView(view);
            xCustomView = view;
            xCustomViewCallback = callback;
            videoview.setVisibility(View.VISIBLE);
        }



        @Override
        //视频播放退出全屏会被调用的
        public void onHideCustomView() {

            if (xCustomView == null)//不是全屏播放状态
                return;

            // Hide the custom view.
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            xCustomView.setVisibility(View.GONE);

            // Remove the custom view from its container.
            videoview.removeView(xCustomView);
            xCustomView = null;
            videoview.setVisibility(View.GONE);
            xCustomViewCallback.onCustomViewHidden();

            videowebview.setVisibility(View.VISIBLE);

            //Log.i(LOGTAG, "set it to webVew");
        }
        //视频加载添加默认图标
        @Override
        public Bitmap getDefaultVideoPoster() {
            //Log.i(LOGTAG, "here in on getDefaultVideoPoster");
            if (xdefaltvideo == null) {
                xdefaltvideo = BitmapFactory.decodeResource(
                        getResources(), R.drawable.videoicon);
            }
            return xdefaltvideo;
        }
        //视频加载时进程loading
        @Override
        public View getVideoLoadingProgressView() {
            //Log.i(LOGTAG, "here in on getVideoLoadingPregressView");

            if (xprogressvideo == null) {
                LayoutInflater inflater = LayoutInflater.from(Video.this);
                xprogressvideo = inflater.inflate(R.layout.video_loading_progress, null);
            }
            return xprogressvideo;
        }
        //网页标题
        @Override
        public void onReceivedTitle(WebView view, String title) {
            (Video.this).setTitle(title);
        }

//         @Override
//       //当WebView进度改变时更新窗口进度
//         public void onProgressChanged(WebView view, int newProgress) {
//        	 (MainActivity.this).getWindow().setFeatureInt(Window.FEATURE_PROGRESS, newProgress*100);
//         }


    }

    /**
     * 处理各种通知、请求等事件
     * @author
     */
    public class xWebViewClientent extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i("wwtest",url);
            urlzancun=url;
            return super.shouldOverrideUrlLoading(view,urlzancun);
        }


    }
    /**
     * 当横竖屏切换时会调用该方法
     * @author
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("testwebview", "=====<<<  onConfigurationChanged  >>>=====");
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("webview", "   现在是横屏1");
            islandport = false;
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("webview", "   现在是竖屏1");
            islandport = true;
        }
    }
//    public void exit_app()
//    {
//        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//
//        dialog.setTitle("提示").setMessage("要退出吗").setPositiveButton("退出",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,
//                                        int which) {
//                        Video.this.finish();
//                    }
//                }).setNegativeButton("返回",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,
//                                        int which) {
//                    }
//                });
//        AlertDialog dialog_dialog = dialog.create();
//        dialog_dialog.show();
//    }
}
