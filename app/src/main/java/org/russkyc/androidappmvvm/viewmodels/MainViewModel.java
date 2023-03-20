package org.russkyc.androidappmvvm.viewmodels;

import android.content.Intent;
import android.view.View;
import java.util.List;
import java.util.Objects;
import android.widget.Toast;
import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;
import org.russkyc.androidappmvvm.DisplayActivity;
import org.russkyc.androidappmvvm.backend.entity.Account;
import io.github.pitzzahh.util.utilities.SecurityUtil;

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
            List<Account> accounts = Account.find(Account.class, "username = ?", SecurityUtil.encrypt(Objects.requireNonNull(Username.get())));
            Account account = accounts.stream()
                    .map(a -> new Account(SecurityUtil.decrypt(a.getUsername()), SecurityUtil.decrypt(a.getPassword())))
                    .filter(a -> a.getUsername().equals(Username.get()))
                    .findAny()
                    .orElse(new Account());
            if (Objects.equals(Username.get(), account.getUsername()) && Objects.equals(Password.get(), account.getPassword())){
                Toast.makeText(view.getContext(), "Login successful.", Toast.LENGTH_LONG)
                        .show();

                Username.set("");
                Password.set("");
                Status.set("");

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
