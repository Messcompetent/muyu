package com.example.xr.muyudemo.diary;



import com.example.xr.muyudemo.R;

import java.util.ArrayList;
import java.util.List;


public class NvCallbyeTabActivity extends MyTabActivity {
	public NvCallbyeTabActivity() {
		super(R.layout.tab, R.drawable.nn);
	}

	@Override
	public List<MyTab> getMyTabList() {
		List<MyTab> myTabList = new ArrayList<MyTab>();
		myTabList.add(new MyTab(R.drawable.nvread, "我的日记",
				MyDialoy.class));
		myTabList.add(new MyTab(R.drawable.nvwrite, "写日记",
				WriteDialy.class));
		myTabList.add(new MyTab(R.drawable.nvsetting, "设置",
				SheZhi.class));
		return myTabList;
	}

}