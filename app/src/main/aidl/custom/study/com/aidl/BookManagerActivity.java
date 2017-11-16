package custom.study.com.aidl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import custom.study.com.R;

/**
 * Created by Administrator on 2017/7/20.
 */

public class BookManagerActivity extends Activity {
    private static final String TAG = "BookManagerActivity";
    private static final int MESSAGE_NEW_BOOK_ARRIVED = 1;

    private IBookManager  mRemoteBookManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manager);
        Intent intent=new Intent(this,BookManagerService.class);

        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager=IBookManager.Stub.asInterface(service);
            mRemoteBookManager=bookManager;
            Log.d(TAG, "ServiceConnection Created!");
            try {
                mRemoteBookManager.asBinder().linkToDeath(mDeathRecipient,0);
                List<Book> list=bookManager.getBookList();
                Log.i(TAG, "query book list, list type:"
                        + list.getClass().getCanonicalName());
                Log.i(TAG, "query book list:" + list.toString());
                Book newBook=new Book(3,"Android进阶");
                bookManager.addBook(newBook);
                Log.i(TAG, "add book:" + newBook);
                List<Book> newList=bookManager.getBookList();
                Log.i(TAG, "query book list:" + newList.toString());
                bookManager.registerListener(mOnNewBookArrivedListener);
            }catch (RemoteException e){
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mRemoteBookManager=null;
            Log.d(TAG, "onServiceDisconnected. tname:" + Thread.currentThread().getName());
        }
    };


    private IBinder.DeathRecipient mDeathRecipient=new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.d(TAG, "binder died. tname:" + Thread.currentThread().getName());
            if(mRemoteBookManager==null){
                return;
            }

            mRemoteBookManager.asBinder().unlinkToDeath(mDeathRecipient,0);
            mRemoteBookManager=null;
            // TODO:这里重新绑定远程Service
        }
    };


    private IOnNewBookArrivedListener mOnNewBookArrivedListener= new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            mHandler.obtainMessage(MESSAGE_NEW_BOOK_ARRIVED,newBook).sendToTarget();
        }
    };


    @SuppressLint("HandlerLeak")
    private Handler mHandler=new Handler(){

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case MESSAGE_NEW_BOOK_ARRIVED:
                    Log.d(TAG, "receive new book :" + msg.obj);
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    };

    public  void onButton1Click(View view){
        Toast.makeText(this, "click button1", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(mRemoteBookManager!=null){
                    try {
                        List<Book> newList=mRemoteBookManager.getBookList();
                        Log.e("test.html","当前的书本量"+newList.size());
                    }catch (RemoteException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        if(mRemoteBookManager!=null&&mRemoteBookManager.asBinder().isBinderAlive()){

            try{
                Log.i(TAG, "unregister listener:" + mOnNewBookArrivedListener);
                mRemoteBookManager.unregisterListener(mOnNewBookArrivedListener);
            }catch (RemoteException e){
                e.printStackTrace();
            }

        }
        unbindService(mConnection);
        super.onDestroy();
    }
}
