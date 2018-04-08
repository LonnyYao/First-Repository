package com.example.ysl.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LeftFragment extends Fragment {
    private static final String TAG = "LeftFragment";

    private Button buttonSend;
    private Button buttonSend2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment, container, false);
        Log.i(TAG, "onCreateView: " + this.getId());

        buttonSend = view.findViewById(R.id.bt_lf_fg_send_msg);
        buttonSend.setOnClickListener(listener);

        buttonSend2 = view.findViewById(R.id.bt_lf_fg_send_msg2);
        buttonSend2.setOnClickListener(listener);

        return view;
    }

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.bt_lf_fg_send_msg:
					Log.i(TAG, "button send msg clicked.");
                    MainActivity activity = (MainActivity) getActivity();
                    activity.showMessage("Message From LeftFragment: ");
                    break;
                case R.id.bt_lf_fg_send_msg2:
					Log.i(TAG, "button send msg2 clicked.");
                    MainActivity activity2 = (MainActivity) getActivity();
                    Fragment fragment = activity2.getSupportFragmentManager().findFragmentById(R.id.fl_right);
                    if (fragment instanceof RightFragment)
                        ((RightFragment) fragment).showMesage("Message From LeftFragment: ");
                    else if (fragment instanceof AnotherRightFragment) {
                        ((AnotherRightFragment) fragment).showMesage("Message From LeftFragment: ");
                    }
                    break;
                default:
                    Log.i(TAG, "onClick: other view " + v.getId());
                    break;
            }

        }
    };

    public void showMesage(String msg) {
        Toast.makeText(getActivity(), msg + TAG, Toast.LENGTH_SHORT).show();
    }

}
