package org.russkyc.androidappmvvm.viewmodels;

import android.content.Intent;
import android.view.View;
import java.util.Objects;
import android.widget.Toast;
import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

import org.russkyc.androidappmvvm.DisplayActivity;

public class MainViewModel extends ViewModel {

    public ObservableField<String> Username;
    public ObservableField<String> Password;
    public ObservableField<String> Status;

    public MainViewModel(){
        Username = new ObservableField<>("");
        Password = new ObservableField<>("");
        Status = new ObservableField<>("");
    }

    public void onLogin(View view){
        if (Objects.requireNonNull(Username.get()).length() > 0 && Objects.requireNonNull(Password.get()).length() > 0){
            if (Objects.equals(Username.get(), "12345678") && Objects.equals(Password.get(), "12345678")){
                Toast.makeText(view.getContext(), "Login successful.", Toast.LENGTH_LONG)
                        .show();

                Username.set("");
                Password.set("");

                // Open Display Activity
                view.getContext()
                        .startActivity(new Intent(view.getContext(), DisplayActivity.class)
                                .putExtra("Username", Username.get())
                );

            } else {
                Status.set("Username or Password does not match.");
            }
        } else {
            Status.set("Username or Password cannot be blank.");
        }
    }
}
