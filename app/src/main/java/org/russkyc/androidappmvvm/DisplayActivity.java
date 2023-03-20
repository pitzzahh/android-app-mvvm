package org.russkyc.androidappmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import org.russkyc.androidappmvvm.models.abstractions.NoActionBarActivity;

import java.util.Objects;

public class DisplayActivity extends NoActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
        setContentView(R.layout.activity_display);
    }

    // Add Fragments to ViewPager
    void addPages(){
        // Add Fragments to ViewPager
        ViewPager viewPager = findViewById(R.id.pager);
    }
}

