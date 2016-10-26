package com.example.firstservice;

import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.app.Service;
import android.content.Intent;

public class MyService extends Service {

	private static final String TAG="MyService";
	
	protected int count=0;
	private boolean quit=false;
	private MyBinder myBinder=new MyBinder();

	public class MyBinder extends Binder {
		public MyBinder() {
			Log.i(TAG, "MyBinder Constructure invoked!");
		}
		public int getCount() {
			return count;
		}
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i(TAG, "MyService onBind invoked!");
		return myBinder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MyService onCreate invoked!");
		super.onCreate();
		new Thread(){
			public void run(){
				while(!quit){
					try{
						Thread.sleep(500);
						count++;
						System.out.println();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}				
			}
		}.start();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MyService onDestroy invoked!");
		super.onDestroy();
		this.quit=true;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i(TAG, "MyService onStartCommand invoked!");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "MyService onRebind invoked!");
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "MyService onUnbind invoked!");
		return super.onUnbind(intent);
	}
	

}
