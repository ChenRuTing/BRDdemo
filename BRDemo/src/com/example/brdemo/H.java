package com.example.brdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class H extends Activity {
		
	public Button  btn2, btn3;
	private TextView tv1, tv2;
	Intent intent = new Intent();
	Bundle bundle = new Bundle();
	

	
	/*
	 * Intent iBzhu = new Intent();// 帮助界面 Intent iGyu = new Intent();// 关于界面
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lly);

		
		btn2 = (Button) findViewById(R.id.bt2);// 退出按钮
		btn3 = (Button) findViewById(R.id.bt3);// 设置按钮

		tv1 = (TextView) findViewById(R.id.montext);// 时间
		tv2 = (TextView) findViewById(R.id.titletext);// 标题
		registerForContextMenu(tv2);// 上下文菜单的注册

		bundle = getIntent().getExtras();

		ActionBar actionBar = getActionBar();// 获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);// 显示应用程序图标
		actionBar.setDisplayHomeAsUpEnabled(true);// 将应用程序图标转变为可点击图标，并添加一个返回箭头。

		// 从Intent获得额外信息，设置为TextView的文本
		// tv1.setText("你的名字是：" + intent.getStringExtra("useName"));
		tv1.setText(bundle.getString("userName") + "," + "早上好！");

		final Button  btn1 = (Button) findViewById(R.id.bt1);// 开始按钮;
	    final PopupMenu pop = new PopupMenu(this, btn1);
	    pop.inflate(R.menu.popupmenu);
		// 开始按钮
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
                pop.show();
				intent.setClass(H.this, CheckActivity.class);
				intent.addCategory(Intent.CATEGORY_APP_MUSIC);
				startActivity(intent);
				H.this.finish();

			}
		});
pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				// TODO Auto-generated method stub
				switch (arg0.getItemId()) {
				case R.id.menu_red:
					btn2.setBackgroundResource(R.drawable.bgfocus);
					btn1.setBackgroundResource(R.drawable.bgfocus);
					btn3.setBackgroundResource(R.drawable.bgfocus);
					break;
				case R.id.menu_green:
					btn2.setBackgroundResource(R.drawable.bgpress);
					btn1.setBackgroundResource(R.drawable.bgpress);
					btn3.setBackgroundResource(R.drawable.bgpress);
					break;
				case R.id.menu_blue:
					btn2.setBackgroundResource(R.drawable.bghover);
					btn1.setBackgroundResource(R.drawable.bghover);
					btn3.setBackgroundResource(R.drawable.bghover);
					break;
				default:
					break;
				}
				return false;
			}
		});
		// 结束按钮
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				H.this.finish();

			}
		});
		// 设置按钮
		btn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent.setClass(H.this, MainActivity.class);// 暂时设置跳转为主界面，待设置界面完善在跳转
				intent.addCategory(Intent.CATEGORY_APP_MUSIC);
				startActivity(intent);
				H.this.finish();
			}
		});

	}

	// 返回主菜单
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	// 导航条的实现事件
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			// 帮助
			Intent i1 = new Intent(this, Help.class);
			startActivity(i1);
			break;
		case R.id.item2:
			// 关于界面
			Intent i2 = new Intent(this, About.class);
			startActivity(i2);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// 上下文菜单的标题
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.context, menu);
		menu.setHeaderTitle("请选择背景颜色");

	}
	// 上下文菜单的事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		item.setChecked(true);
		switch (item.getItemId()) {
		case R.id.red:
			item.setChecked(true);
			tv2.setBackgroundColor(Color.RED);
			break;
		case R.id.green:
			item.setChecked(true);
			tv2.setBackgroundColor(Color.GREEN);
			break;
		case R.id.blue:
			item.setChecked(true);
			tv2.setBackgroundColor(Color.BLUE);
			break;

		default:
			break;
		}
		return true;
	}

}