package custom.study.com.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.util.concurrent.ConcurrentHashMap;

import widget.ImageFetchr;

/**
 * Created by Administrator on 2018/7/26.
 */

public class ThumbnailDownloader<T> extends HandlerThread {

    private static final String TAG="ThumbnailDownloader";

    private static final int MESSAGE_DOWNLOAD=0;

    private Boolean mHasQuit=false;

    private Handler mRequestHandler;

    private ConcurrentHashMap<T,String> mRequestMap=new ConcurrentHashMap<>();

    private Handler mResponseHander;

    private ThumbnailDownloadListener<T> mThumbnailDownloadListener;

    public interface ThumbnailDownloadListener<T>{
        void onThumbnailDownloaded(T target,Bitmap thumbnail);
    }

    public void setmThumbnailDownloadListener(ThumbnailDownloadListener<T> mThumbnailDownloadListener) {
        this.mThumbnailDownloadListener = mThumbnailDownloadListener;
    }

    public ThumbnailDownloader(Handler responseHandler){
        super(TAG);
        mResponseHander=responseHandler;
    }

    @Override
    protected void onLooperPrepared() {
        mRequestHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
               if(msg.what==MESSAGE_DOWNLOAD){
                   T target= (T) msg.obj;
                   Log.e(TAG,"GOT A REQUEST FOR URL:"+mRequestMap.get(target));
                   handleRequest(target);
               }
            }
        };
    }

    private void handleRequest(T target) {

        try {
            final String url=mRequestMap.get(target);

            if(url==null){
                return;
            }

            byte[] bitmapBytes=new ImageFetchr().getUrlBytes(url);
            final Bitmap bitmap= BitmapFactory.decodeByteArray(bitmapBytes,0,bitmapBytes.length);
            Log.e(TAG,"bitmap created");


            mResponseHander.post(new Runnable() {
                @Override
                public void run() {

                    if(mRequestMap.get(target)!=url||mHasQuit){
                        return;
                    }
                    mRequestMap.remove(target);
                    mThumbnailDownloadListener.onThumbnailDownloaded(target,bitmap);
                }
            });

        }catch (IOException ioe){
            Log.e(TAG,"ERROR downloading image",ioe);
        }
    }

    @Override
    public boolean quit() {
        mHasQuit=true;
        return super.quit();
    }


    public void queueThumbnail(T target,String url){

        Log.e(TAG,"got a url:"+url);

        if(url==null){
            mRequestMap.remove(target);
        }else{
            mRequestMap.put(target,url);
            mRequestHandler.obtainMessage(MESSAGE_DOWNLOAD,target)
                    .sendToTarget();
        }
    }

    public void clearQueue(){
        mRequestHandler.removeMessages(MESSAGE_DOWNLOAD);
    }



}
