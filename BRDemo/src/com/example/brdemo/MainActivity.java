package com.example.brdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn1;
	private Button btn2; 
	private Button btn3;
	private EditText et1;
	private EditText et2;
	Intent iguangs, iches;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.b1);// 注册
		btn2 = (Button) findViewById(R.id.bt3);// 测试
		btn3 = (Button) findViewById(R.id.b2);// 登录

		et2 = (EditText) findViewById(R.id.editText2);
		et1 = (EditText) findViewById(R.id.editText1);

		// 注册
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				iguangs = new Intent();
				Bundle bundle = new Bundle();
				// 设置Intent的class属性，跳转到SecondActivity
				iguangs.setClass(MainActivity.this, H.class);
				// 为intent添加额外的信息
				bundle.putString("userName", et1.getText().toString());
				bundle.putString("phoneNum", et2.getText().toString());
				iguangs.putExtras(bundle);
				// 启动Activity
				startActivity(iguangs);

			}
		});
		// 测试
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://open.taobao.com");
				 iches = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(iches);
			}
		});
		// 登录
		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				iguangs = new Intent();
				Bundle bundle = new Bundle();
				// 设置Intent的class属性，跳转到SecondActivity
				iguangs.setClass(MainActivity.this, H.class);
				// 为intent添加额外的信息
				bundle.putString("userName", et1.getText().toString());
				bundle.putString("phoneNum", et2.getText().toString());
				Toast.makeText(MainActivity.this, "用户"+et1.getText() +"登录成功", Toast.LENGTH_LONG).show();
				iguangs.putExtras(bundle);
				// 启动Activity
				startActivity(iguangs);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

/*	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			// 创建启动MainActivity的Intent
			Intent intent = new Intent(this, MainActivity.class);
			// 添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case R.id.item1:
			Intent intent1 = new Intent(this, Help.class);
			startActivity(intent1);
			break;
		case R.id.item2:
			Intent intent2 = new Intent(this, Help.class);
			startActivity(intent1);
			break;
		case R.id.item2:
			Intent intent3 = new Intent(this, Help.class);
			startActivity(intent1);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
