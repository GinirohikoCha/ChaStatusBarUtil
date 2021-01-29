package com.github.ginirohikocha.statusbarutil.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.ginirohikocha.statusbarutil.R;

public class FragmentHomepage extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    public static FragmentHomepage newInstance() {

        Bundle args = new Bundle();

        FragmentHomepage fragment = new FragmentHomepage();
        fragment.setArguments(args);
        return fragment;
    }
}
