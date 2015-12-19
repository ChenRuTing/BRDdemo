package com.example.brdemo;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Help extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		ActionBar actionBar = getActionBar();//获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标
		actionBar.setDisplayHomeAsUpEnabled(true);//将应用程序图标转变为可点击图标，并添加一个返回箭头。
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
			Intent i1=new Intent(this,H.class);
			startActivity(i1);
		
		case R.id.item2:
			Intent iGyu=new Intent(this,About.class);
			startActivity(iGyu);
			break;
		
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}	
	

	}
