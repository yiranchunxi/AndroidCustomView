package custom.study.com.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import custom.study.com.R;
import custom.study.com.bean.EventData;
import widget.BusProvider;

/**
 * Created by Administrator on 2018/7/13.
 */

public class RegisterFragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private TextView tv_next;

    public static RegisterFragment1 newInstance(String param1, String param2) {
        RegisterFragment1 fragment = new RegisterFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RegisterFragment1() {

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
        View view = inflater.inflate(R.layout.fragment_register1, container, false);

        tv_next=view.findViewById(R.id.tv_next);

        tv_next.setOnClickListener(v -> {

            BusProvider.getInstance().post(new EventData(123,1));

        });

        return view;
    }





}
