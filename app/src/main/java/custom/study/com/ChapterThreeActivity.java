package custom.study.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by Administrator on 2017/6/5.
 */

public class ChapterThreeActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_lesson1);
    }



    public void onButtonClick(View v) {
        if (v.getId() == R.id.button1) {
            Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);
        }/* else if (v.getId() == R.id.button2) {
            Intent intent = new Intent(this, DemoActivity_1.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button3) {
            Intent intent = new Intent(this, DemoActivity_2.class);
            startActivity(intent);
        }*/
    }
}
