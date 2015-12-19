package com.example.brdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		ActionBar actionBar = getActionBar();// 获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);// 显示应用程序图标
		actionBar.setDisplayHomeAsUpEnabled(true);// 将应用程序图标转变为可点击图标，并添加一个返回箭头。
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			//创建启动MainActivity的Intent
			Intent iabout=new Intent();
			iabout.setClass(this,H.class);
			//添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
			iabout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iabout);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
