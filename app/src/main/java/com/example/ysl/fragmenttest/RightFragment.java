package com.example.ysl.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RightFragment extends Fragment {
    private static final String TAG = "RightFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fragment, container, false);
        Log.i(TAG, "onCreateView: " + this.getId());
        return view;
    }


    public void showMesage(String msg) {
        Toast.makeText(getActivity(), msg + TAG, Toast.LENGTH_SHORT).show();
    }
}
