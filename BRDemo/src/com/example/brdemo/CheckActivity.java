package com.example.brdemo;

import java.util.Random;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CheckActivity extends Activity {
	public Button btn1, btn2;// 开始答题，退出
	public Button btnbof, btnzant, btg, btd;// 播放，退出,高音量，低音量
	private AudioManager am;// 音量调节定义
	private EditText et1;
	private EditText et2;
	long startTime;
	long endTime;
	private TextView t11;
	private TextView t4;
	private TextView t2;
	private TextView t3;
	private TextView t1;
	private TextView t5;
	private TextView t6;
	int ranswer = 0;
	int uanswer = 0;
	String str = "";
	String z = "";
	private boolean stop = false;
	public int num = 5, T = 0, F = 0, count = 1, b = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.szys);
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		// 最大音量
		int maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		// 当前音量
		int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);

		btn1 = (Button) findViewById(R.id.bb1);// 开始答题
		btn2 = (Button) findViewById(R.id.bb2);// 退出

		et2 = (EditText) findViewById(R.id.editText2);
		et1 = (EditText) findViewById(R.id.editText1);
		t11 = (TextView) findViewById(R.id.t11);
		t4 = (TextView) findViewById(R.id.textView4);
		t6 = (TextView) findViewById(R.id.textView6);
		t2 = (TextView) findViewById(R.id.textView12);
		t5 = (TextView) findViewById(R.id.textView10);
		t3 = (TextView) findViewById(R.id.textView7);
		t1 = (TextView) findViewById(R.id.textView14);

		ActionBar actionBar = getActionBar();// 获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);// 显示应用程序图标
		actionBar.setDisplayHomeAsUpEnabled(true);// 将应用程序图标转变为可点击图标，并添加一个返回箭头。

		// 播放按钮
		btnbof = (Button) findViewById(R.id.btstart);
		btnbof.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startService(new Intent(CheckActivity.this, MyService.class));
			}
		});
		// 暂停按钮
		btnzant = (Button) findViewById(R.id.btstop);
		btnzant.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				stopService(new Intent(CheckActivity.this, MyService.class));
			}
		});
		// 高音量
		btg = (Button) findViewById(R.id.btgao);
		btg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				am.adjustStreamVolume(AudioManager.STREAM_MUSIC,
						AudioManager.ADJUST_RAISE,
						AudioManager.FX_FOCUS_NAVIGATION_UP);
			}
		});
		// 低音量
		btd = (Button) findViewById(R.id.btdi);
		btd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				am.adjustStreamVolume(AudioManager.STREAM_MUSIC,
						AudioManager.ADJUST_LOWER,
						AudioManager.FX_FOCUS_NAVIGATION_UP);
			}
		});
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				CheckActivity.this.finish();

			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				CheckActivity.this.finish();
			}
		});
		// 开始答题
		btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				T = 0;
				F = 0;
				str = "";
				z = "";
				stop = false;

				try {
					String bb = et1.getText().toString();
					num = Integer.parseInt(bb);
					if (num > 15) {

						t11.setText("输入题数错误，请重新输入！（1-15）");
						et1.setText("");
					} else {
						startTime = System.currentTimeMillis();
						t4.setText("" + T);
						t2.setText("" + F);
						t1.setText("" + b);
						// btn.setVisible(false);
						// et1.setEditable(false);

						showtext();

					}

				} catch (NumberFormatException e1) {
					t11.setText("输入题数错误，请重新输入！（1~15）");
					et1.setText("");
				}

			}

		});

		et2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {
					if (!stop) {

						String tt = et2.getText().toString();
						uanswer = Integer.parseInt(tt);
						;
						if (num == count) {
							if (uanswer == ranswer) {
								t4.setText("" + ranswer);
								t3.setText("答对！");

								T++;
								t6.setText("" + T);
								b = (100 / num) * T;
								t1.setText("" + b);

								if (b > 90) {
									Intent intent = new Intent();
									intent.setClass(CheckActivity.this,
											Test1.class);
									startActivity(intent);
									CheckActivity.this.finish();

								}
								count++;
							} else {
								t4.setText("" + ranswer);
								t3.setText("答错！");
								F++;
								t2.setText("" + F);
								count++;
							}
							stop = true;
							t3.setText(" 答題結束！");
							endTime = System.currentTimeMillis();
							// et2.setEditable(true);
							// btn.setVisible(true);
							t5.setText((endTime - startTime) / 1000 + "s");

						}

						else if (uanswer == ranswer) {
							t4.setText("" + ranswer);
							t3.setText("答对！");

							T++;
							t6.setText("" + T);
							b = (100 / num) * T;
							t1.setText("" + b);
							showtext();
							if (b > 90) {
								Intent intent = new Intent();
								intent.setClass(CheckActivity.this, Test1.class);
								startActivity(intent);
								CheckActivity.this.finish();

							}
							count++;

						} else {
							t4.setText("" + ranswer);
							t3.setText("答错！");
							F++;
							t2.setText("" + F);
							showtext();
							count++;
						}
					}
				}

				catch (NumberFormatException e2) {
					t11.setText(str + "答案格式错误，请重新输入答案！");
					et2.setText("");
				}

			}
		});
	}

	void showtext() {
		char op = '+';
		int a = 0, b = 0, c = 0, e = 0, f = 0, opnum = 0, chioce = 0;
		int temp = 0;
		Random ra = new Random();
		e = ra.nextInt(10) + 1;
		f = ra.nextInt(10) + 1;
		chioce = ra.nextInt(2) + 1;
		if (e % 2 == 0) {
			a = ra.nextInt(10) + 2;
		} else {
			a = -ra.nextInt(10) + 2;
		}
		if (f % 2 == 0) {
			b = ra.nextInt(10) + 2;
		} else {
			b = -ra.nextInt(10) + 2;
		}
		c = ra.nextInt(5);
		opnum = Math.abs(ra.nextInt()) % 4 + 1;
		et2.setText("");
		switch (chioce) {
		case 1: {
			switch (opnum) {
			case 1:
				op = '+';
				break;
			case 2:
				op = '-';
				break;
			case 3:
				op = '*';
				break;
			case 4:
				op = '/';
				break;
			}

			if ((op == '-') && (a < b)) {
				temp = a;
				a = b;
				b = temp;
			}

			if (op == '/') {
				if (b == 0) {
					b = 1;
				}
				a = a * b;
			}
			if (a > 0 && b > 0) {
				z = String.valueOf(a) + String.valueOf(op) + String.valueOf(b)
						+ "=" + "\n";
			} else if (a < 0 && b > 0) {
				z = "(" + String.valueOf(a) + ")" + String.valueOf(op)
						+ String.valueOf(b) + "=" + "\n";
			} else if (a > 0 && b < 0) {
				z = String.valueOf(a) + String.valueOf(op) + "("
						+ String.valueOf(b) + ")" + "=" + "\n";
			} else {
				z = "(" + String.valueOf(a) + ")" + String.valueOf(op) + "("
						+ String.valueOf(b) + ")" + "=" + "\n";
			}
			str = str + z;
			t11.setText(str);

			switch (op) {
			case '+':
				ranswer = a + b;
				break;
			case '-':
				ranswer = a - b;
				break;
			case '*':
				ranswer = a * b;
				break;
			case '/':
				ranswer = a / b;
				break;
			}
			break;
		}
		case 2: {
			int jc = 1;
			str = str + String.valueOf(c) + "!=" + "\n";
			t11.setText(str);
			for (int i = c; i > 0; i--) {
				jc = jc * i;
			}
			ranswer = jc;
			break;
		}
		}

	}

	// 返回主菜单
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			// 创建启动MainActivity的Intent
			Intent intent = new Intent();
			intent.setClass(this, H.class);
			// 添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			CheckActivity.this.finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
