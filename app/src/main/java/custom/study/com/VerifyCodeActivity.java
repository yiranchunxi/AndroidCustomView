package custom.study.com;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import views.verifycodeview.VerifyCodeView;

/**
 * Created by Administrator on 2018/7/12.
 */

public class VerifyCodeActivity extends Activity {

    VerifyCodeView verifyCodeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verify);

        verifyCodeView=findViewById(R.id.verify_code_view);


        verifyCodeView.setInputCompleteListener(new VerifyCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                Toast.makeText(VerifyCodeActivity.this, "inputComplete: " + verifyCodeView.getEditContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void invalidContent() {

            }
        });
    }
}
