package com.example.xr.muyudemo.gridv;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xr.muyudemo.R;
import com.example.xr.muyudemo.image.SmartImageView;

import static com.example.xr.muyudemo.gridv.Guodu.mUrl;
import static com.example.xr.muyudemo.gridv.Guodu.mtao;


public class GridView extends Activity {
    /** Called when the activity is first created. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        android.widget.GridView gridView=(android.widget.GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        //单击GridView元素的响应
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //弹出单击的GridView元素的位置
//                Toast.makeText(GridView.this,mtao[position], Toast.LENGTH_SHORT).show();
                //获取剪贴板管理器：
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
// 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", mtao[position]);
// 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);
                Toast.makeText(GridView.this,"已复制淘口令，请打开淘宝查看",Toast.LENGTH_SHORT).show();
//                Toast.makeText(GridView.this,mtao[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    private class ImageAdapter extends BaseAdapter {
        private Context mContext;
        public ImageAdapter(Context context) {
            this.mContext=context;
        }
        @Override
        public int getCount() {
            return mUrl.length;
        }
        @Override
        public Object getItem(int position) {
            return mUrl[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //定义一个ImageView,显示在GridView里
            SmartImageView imageView;
            if(convertView==null){
                imageView=new SmartImageView(mContext);

                WindowManager windowManager=getWindowManager();
                Display display=windowManager.getDefaultDisplay();
                int width=display.getWidth();
                int height=display.getHeight();
//                Toast.makeText(GridView.this,"宽"+width+"高"+height,Toast.LENGTH_LONG).show();//获取屏幕尺寸
                //另一种获取屏幕尺寸的方法
//                DisplayMetrics dm = new DisplayMetrics();
//                getWindowManager().getDefaultDisplay().getMetrics(dm);
//                float fwidth=dm.widthPixels*dm.density;
//                float fheight=dm.heightPixels*dm.density;但是这种是浮点型

                imageView.setLayoutParams(new android.widget.GridView.LayoutParams(3*width/7, height/5));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0,0,0,0);
            }else{
                imageView = (SmartImageView) convertView;
            }
            imageView.setImageUrl(mUrl[position]);
            return imageView;
        }
    }
//展示图片
//    private Integer[] mThumbIds = {
//            R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7,
//            R.drawable.sample_0, R.drawable.sample_1,
//            R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7,
//            R.drawable.sample_0, R.drawable.sample_1,
//            R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7
//    };
}