package com.example.xr.muyudemo.update;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by empty cup on 2017/9/15.
 */

public class DownloadUtils {

    //下载器
    private DownloadManager downloadManager;
    //上下文
    private Context mContext;
    private OpenApk openApk;
    //下载的ID
    private long downloadId;
    public DownloadUtils(Context context, OpenApk openApk){
        this.mContext = context;
        this.openApk = openApk;
    }

    //下载apk
    public void downloadAPK(String url, String name) {

        //创建下载任务
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //移动网络情况下是否允许漫游
        request.setAllowedOverRoaming(false);

        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setTitle("update");
//        request.setDescription("Apk Downloading");
        request.setVisibleInDownloadsUi(true);

        //设置下载的路径
//        request.setDestinationInExternalPublicDir(Environment.getExternalStorageDirectory().getAbsolutePath() , name);
//        request.setDestinationInExternalFilesDir(mContext,Environment.getExternalStorageDirectory().getAbsolutePath()+"/storage/emulated/0" , name);

        request.setDestinationInExternalPublicDir("/Jingyu",name);
//        request.setDestinationInExternalFilesDir(mContext,"", name);

        Log.v("kankan",Environment.getExternalStorageDirectory().getAbsolutePath());
//        request.setDestinationInExternalFilesDir(mContext,"" , name);
        //获取DownloadManager
        downloadManager = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        //将下载请求加入下载队列，加入下载队列后会给该任务返回一个long型的id，通过该id可以取消任务，重启任务、获取下载的文件等等
        downloadId = downloadManager.enqueue(request);

        //注册广播接收者，监听下载状态
        mContext.registerReceiver(receiver,
                new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    //广播监听下载的各个状态
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkStatus();
        }
    };


    //检查下载状态
    private void checkStatus() {
        DownloadManager.Query query = new DownloadManager.Query();
        //通过下载的id查找
        query.setFilterById(downloadId);
        Cursor c = downloadManager.query(query);
        if (c.moveToFirst()) {
            int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
                //下载暂停
                case DownloadManager.STATUS_PAUSED:
                    break;
                //下载延迟
                case DownloadManager.STATUS_PENDING:
                    break;
                //正在下载
                case DownloadManager.STATUS_RUNNING:
                    break;
                //下载完成
                case DownloadManager.STATUS_SUCCESSFUL:
                    //下载完成安装APK
                    openApk.OpenApk();
//                    installAPK();
                    break;
                //下载失败
                case DownloadManager.STATUS_FAILED:
                    Toast.makeText(mContext, "下载失败，请退出重进再试！或者加qq群直接下载最新版。", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
