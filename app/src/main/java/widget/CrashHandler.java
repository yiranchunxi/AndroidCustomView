package widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 相当于一个全局try..catch..
 * 捕获程序crash时的异常，异常会写入日志文件：errorlog.txt 位于（手机内部存储根目录下）
 * @author 
 *
 */
public class CrashHandler implements UncaughtExceptionHandler {


	private CrashHandler() {

	}

	private static class CrashHandlerHolder{
		static CrashHandler mCrashHandler=new CrashHandler();
	}
	
	public static CrashHandler getInstance(Context context) {
		return CrashHandlerHolder.mCrashHandler;
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		try {
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PrintWriter printWriter = new PrintWriter(bos);
			ex.printStackTrace(printWriter);
			printWriter.close();
			
			if(true){
				StringBuilder sb = new StringBuilder(bos.toString());
				try {
					
					Date date = new Date();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String mTime = df.format(date);
					sb.append("==========================="+mTime+"============================");
					sb.append("\n\n");
					
					File f = new File(Environment.getExternalStorageDirectory(),"CustomViewerrorlog.txt");
					FileWriter fw = new FileWriter(f, true);
					fw.write(sb.toString());
					
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			bos.close();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		Thread.setDefaultUncaughtExceptionHandler(this);
	}
	
}
