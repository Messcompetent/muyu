package com.example.xr.muyudemo.update;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.widget.Button;

import com.example.xr.muyudemo.R;

import java.io.File;

import static com.example.xr.muyudemo.Classshou.updateurl;

/**
 * Created by empty cup on 2017/9/15.
 */

public class DownActivtiy extends Activity implements OpenApk {
    private DownloadUtils downloadUtils;
    Button dddd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloadtishi);
        downloadUtils = new DownloadUtils(this,this);
        File updateFile = new File("/storage/emulated/0/Jingyu/update.apk");
        if (updateFile.exists()){
            updateFile.delete();
        }
        downloadUtils.downloadAPK(updateurl, "update.apk");
    }

    //下载到本地后执行安装
    private void installAPK() {
        //获取下载文件的Uri
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"Download/QF_r.apk");
//        File file = new File("/storage/emulated/0/Android/data/com.example.xr.myapplication/files/storage/emulated/0/Download/QF_r.apk");//
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
//          File file = new File("/sdcard/Android/data/com.example.xr.myapplication/files/QF_r.apk");
        File file = new File("/storage/emulated/0/Jingyu/update.apk");//

        Uri downloadFileUri = null;
        if (currentapiVersion<24) {
//            Log.v("this", "载到本地后执行安装           " + Environment.getExternalStorageDirectory().getAbsolutePath());
            downloadFileUri = Uri.fromFile(file);//非7.0
        }else if (currentapiVersion>=24) {
            downloadFileUri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);//7.0改换
        }
//        Uri downloadFileUri = FileProvider.getUriForFile(this,Environment.getExternalStorageDirectory().getAbsolutePath(),file);
        if (downloadFileUri != null) {
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(downloadFileUri, "application/vnd.android.package-archive");
            startActivity(intent);

        }

    }

    @Override
    public void OpenApk() {
        installAPK();
    }
//    public static void Deleteapk(){
//        String aaa="/storage/emulated/0/Jingyu/update.apk";
//        File updateDir=new File(Environment.getExternalStorageDirectory(),aaa);
//        File updateFile=new File(updateDir.getPath()+"/update.apk");
////        File updateFile = new File("/storage/emulated/0/Jingyu/update.apk");
//        if (updateFile.exists()){
//            updateFile.delete();
//        }
//    }
}


