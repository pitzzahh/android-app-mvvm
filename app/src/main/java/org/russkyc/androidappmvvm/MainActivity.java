package org.russkyc.androidappmvvm;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import org.russkyc.androidappmvvm.databinding.ActivityMainBinding;
import org.russkyc.androidappmvvm.models.abstractions.NoActionBarActivity;
import org.russkyc.androidappmvvm.viewmodels.MainViewModel;

public class MainActivity extends NoActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewModel(new ViewModelProvider(this).get(MainViewModel.class));

        setContentView(binding.getRoot());

    }
}