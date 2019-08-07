package com.example.xr.muyudemo.diary;




import com.example.xr.muyudemo.R;

import java.util.ArrayList;
import java.util.List;

public class CallbyeTabActivity extends MyTabActivity {
	public CallbyeTabActivity() {
		super(R.layout.tab, R.drawable.kk);
	}
	@Override
	public List<MyTab> getMyTabList() {
		List<MyTab> myTabList = new ArrayList<MyTab>();
		myTabList.add(new MyTab(R.drawable.read, "我的日记",
				MyDialoy.class));
		myTabList.add(new MyTab(R.drawable.write, "写日记",
				WriteDialy.class));
		myTabList.add(new MyTab(R.drawable.setting, "设置",
				SheZhi.class));
		return myTabList;
	}
	
}