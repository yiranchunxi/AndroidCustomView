package custom.study.com.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import custom.study.com.R;
import custom.study.com.VerifyCodeActivity;
import custom.study.com.bean.EventData;
import views.verifycodeview.VerifyCodeView;
import widget.BusProvider;

/**
 * Created by Administrator on 2018/7/13.
 */

public class RegisterFragment2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    VerifyCodeView verifyCodeView;
    Button button;
    public static RegisterFragment2 newInstance(String param1, String param2) {
        RegisterFragment2 fragment = new RegisterFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RegisterFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verify, container, false);


        verifyCodeView=view.findViewById(R.id.verify_code_view);


        verifyCodeView.setInputCompleteListener(new VerifyCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                Toast.makeText(getActivity(), "inputComplete: " + verifyCodeView.getEditContent(), Toast.LENGTH_SHORT).show();
                BusProvider.getInstance().post(new EventData(1111,2));
            }

            @Override
            public void invalidContent() {

            }
        });
        button=view.findViewById(R.id.btn_test);

        button.setOnClickListener(v -> {
            BusProvider.getInstance().post(new EventData(123,0));
        });


        return view;
}


}
