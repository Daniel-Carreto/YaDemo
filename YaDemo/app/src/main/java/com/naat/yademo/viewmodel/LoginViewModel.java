package com.naat.yademo.viewmodel;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.naat.yademo.R;
import com.naat.yademo.view.activity.HomeActivity;
import com.naat.yademo.model.User;
import com.naat.yademo.networking.NetworkBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseObservable {

    public final ObservableField<String> username;
    public final ObservableField<String> password;
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
        username = new ObservableField<>("");
        password = new ObservableField<>("");
    }

    public void loginEvent(View v) {
        if (true) {
            //TODO: verificar la conexión, de momento el servicio no responde
            //Intent intent = new Intent(context, HomeActivity.class);
            //context.startActivity(intent);
            User user = new User();
            user.setName(username.get());
            user.setPass(password.get());
            User data = new User();
            data.setData(user);
            sendLogin(data);
        } else {

        }
    }


    public void sendLogin(User user) {
        NetworkBase.getNetworkInstance().loginRequest(user)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.code() == 200) {
                            if (response.body().getError() != null) {
                              showAlert(response.body().getError().getMessage());
                            } else {
                                Intent intent = new Intent(context, HomeActivity.class);
                                context.startActivity(intent);
                            }
                        } else {
                          showAlert(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                      try {
                        showAlert(call.execute().body().getError().getMessage());
                      }catch (Exception e){
                        showAlert(context.getString(R.string.network_error_message));
                      }
                    }
                });
    }


    public void showAlert(String message){
        AlertDialog.Builder alert =new  AlertDialog.Builder(context)
            .setCancelable(false)
            .setMessage(message)
            .setTitle(context.getString(R.string.app_name))
            .setNeutralButton("Entendido", null);
        alert.create();
        alert.show();

    }


}
