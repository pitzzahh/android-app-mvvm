package org.russkyc.androidappmvvm.factories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.russkyc.androidappmvvm.R;
import org.russkyc.androidappmvvm.databinding.ActivityMainBinding;

public class ViewFactory {

    public static ActivityMainBinding GetMainViewAdapter(AppCompatActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }
}
