package custom.study.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;



/**
 * Created by Administrator on 2016/12/14.
 */

public class Html5Activity extends Activity {

    private String mUrl;
    private WebView mWebView;

    private LinearLayout ll_layout;
    private ProgressBar progressBar;
    private Button buttonjs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);
        ll_layout= (LinearLayout) findViewById(R.id.ll_layout);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        buttonjs= (Button) findViewById(R.id.buttonjs);
        if(getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            mUrl = bundle.getString("url");
        }



        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(params);
        ll_layout.addView(mWebView);

        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setSupportZoom(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebSettings.setLoadsImagesAutomatically(true);


        //调用JS方法.安卓版本大于17,加上注解 @JavascriptInterface
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new InsertObj(), "jsObj");
       // saveData(mWebSettings);

        newWin(mWebSettings);

        mWebView.setWebChromeClient(webChromeClient);
        mWebView.setWebViewClient(webViewClient);

        mUrl="file:///android_asset/test.html";
        mWebView.loadUrl(mUrl);


        buttonjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                // Android版本变量
                final int version = Build.VERSION.SDK_INT;
                // 因为该方法在 Android 4.4 版本才可使用，所以使用时需进行版本判断
                if (version < 18) {
                    mWebView.loadUrl("javascript:showFromHtml()");
                } else {
                    mWebView.evaluateJavascript("javascript:showFromHtml()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            //此处为 js 返回的结果
                        }
                    });
                }


                if (version < 18) {
                    mWebView.loadUrl("javascript:showFromHtmlWithPara('测试带参数的刷刷刷')");
                } else {
                    mWebView.evaluateJavascript("javascript:showFromHtmlWithPara('测试带参数的刷刷刷')", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            //此处为 js 返回的结果
                            Toast.makeText(Html5Activity.this,value,Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }



    @Override
    public void onPause() {
        super.onPause();
      //  webView.onPause();
       // webView.pauseTimers(); //小心这个！！！暂停整个 WebView 所有布局、解析、JS。
    }

    @Override
    public void onResume() {
        super.onResume();
      //  webView.onResume();
       // webView.resumeTimers();
    }


    /**
     * 多窗口的问题
     */
    private void newWin(WebSettings mWebSettings) {
        //html中的_bank标签就是新建窗口打开，有时会打不开，需要加以下
        //然后 复写 WebChromeClient的onCreateWindow方法
        mWebSettings.setSupportMultipleWindows(false);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    /**
     * HTML5数据存储
     */
    private void saveData(WebSettings mWebSettings) {
        //有时候网页需要自己保存一些关键数据,Android WebView 需要自己设置
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setDatabaseEnabled(true);
        mWebSettings.setAppCacheEnabled(true);
        String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
        mWebSettings.setAppCachePath(appCachePath);
    }

    WebViewClient webViewClient = new WebViewClient(){

        /**
         * 多页面在同一个WebView中打开，就是不新建activity或者调用系统浏览器打开
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    };



    WebChromeClient webChromeClient = new WebChromeClient() {


        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress < 100) {
                String progress = newProgress + "%";
                Log.e("test.html",progress);
                progressBar.setProgress(newProgress);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
        //获取Web页中的title用来设置自己界面中的title
        //当加载出错的时候，比如无网络，这时onReceiveTitle中获取的标题为 找不到该网页,
        //因此建议当触发onReceiveError时，不要使用获取到的title
        @Override
        public void onReceivedTitle(WebView view, String title) {
          //  Toast.makeText(Html5Activity.this,title,Toast.LENGTH_SHORT).show();


        }
        //=========HTML5定位==========================================================
        //需要先加入权限
        //<uses-permission android:name="android.permission.INTERNET"/>
        //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        //<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
            callback.invoke(origin, true, false);//注意个函数，第二个参数就是是否同意定位权限，第三个是是否希望内核记住
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
        //=========HTML5定位==========================================================

        //=========多窗口的问题==========================================================
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(view);
            resultMsg.sendToTarget();
            return true;
        }
        //=========多窗口的问题==========================================================

        @Override
        public boolean onJsAlert(WebView view, String url, String message, final  JsResult result) {
            AlertDialog.Builder b = new AlertDialog.Builder(Html5Activity.this);
            b.setTitle("Alert");
            b.setMessage(message);
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.confirm();
                }
            });
            b.setCancelable(false);
            b.create().show();
            return true;
        }



        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
                new AlertDialog.Builder(Html5Activity.this)
                        .setTitle("JsConfirm")
                        .setMessage(message)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();
                // 返回布尔值：判断点击时确认还是取消
                // true表示点击了确认；false表示点击了取消；
                return true;
            }


        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue,final JsPromptResult result) {
            final EditText et = new EditText(Html5Activity.this);
            et.setText(defaultValue);
            new AlertDialog.Builder(Html5Activity.this)
                    .setTitle(message)
                    .setView(et)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            result.confirm(et.getText().toString());
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            result.cancel();
                        }
                    })
                    .setCancelable(false)
                    .show();

            return true;

        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mWebView != null) {
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.loadUrl("about:blank");
            mWebView.stopLoading();
            mWebView.setWebChromeClient(null);
            mWebView.setWebViewClient(null);
            mWebView.destroy();
            mWebView = null;
        }
    }

    // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
    //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
    //协议格式js  协议名字 webview
    class InsertObj extends Object{
        //给html提供的方法，js中可以通过：var str = window.jsObj.HtmlcallJava(); 获取到
        @JavascriptInterface
        public String HtmlcallJava(){
            return  "Html call Java";
        }

        @JavascriptInterface
        public void ToActivity(String s){
            Log.e("test",s);
            Intent intent=new Intent(Html5Activity.this,TestActivity.class);
            startActivity(intent);
        }
        //给html提供的有参函数 ： window.jsObj.HtmlcallJava2("IT-homer blog");
        @JavascriptInterface
        public String HtmlcallJava2(final String param) {
            return "Html call Java : " + param;
        }


        //Html给我们提供的函数
        @JavascriptInterface
        public void JavacallHtml() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //这里是调用方法
                    mWebView.loadUrl("javascript: showFromHtml()");
                    Toast.makeText(Html5Activity.this, "clickBtn", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //Html给我们提供的有参函数
        @JavascriptInterface
        public void JavacallHtml2(final String param) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mWebView.loadUrl("javascript: showFromHtml2('IT-homer blog')");
                    Toast.makeText(Html5Activity.this, "clickBtn2", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
