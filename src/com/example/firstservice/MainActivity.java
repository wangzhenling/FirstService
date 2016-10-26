package com.example.firstservice;

import com.example.firstservice.MyService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final String TAG = null;
	Button btnStart,btnStop,btnBangding,btnJiebang,btnGetData;
	protected MyBinder myBinder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStart=(Button) this.findViewById(R.id.btnStart);
		btnStop=(Button) this.findViewById(R.id.btnStop);
		btnBangding=(Button) this.findViewById(R.id.btnBangding);
		btnJiebang=(Button) this.findViewById(R.id.btnJiebang);
		btnGetData=(Button) this.findViewById(R.id.btnGetData);
		final Intent  intent=new Intent();
		intent.setAction("cn.jxufe.iet.MY_SERVICE");
		btnStart.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startService(intent);
			}
		});
        btnStop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
        btnBangding.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bindService(intent,conn,Service.BIND_AUTO_CREATE);
			}
		});
        btnJiebang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				unbindService(conn);
			}
		});
        btnGetData.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Count="+myBinder.getCount(), 100).show();
			}
		});
	}
	private ServiceConnection conn=new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.i(TAG, "MainActivity onServiceConnected invoked!");
			myBinder=(MyBinder)service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.i(TAG, "MainActivity onServiceDisconnected invoked!");
		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
