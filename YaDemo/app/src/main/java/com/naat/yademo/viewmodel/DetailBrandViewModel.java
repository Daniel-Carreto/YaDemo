package com.naat.yademo.viewmodel;

import android.app.AlertDialog;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naat.yademo.R;
import com.naat.yademo.view.activity.DetailBrandActivity;

public class DetailBrandViewModel extends BaseObservable {

    private Context context;
    private AlertDialog alertDialog;

    public ObservableField<String> phoneNumber;
    public ObservableField<String> amount;

    public DetailBrandViewModel(Context context) {
        this.context = context;
        phoneNumber = new ObservableField<>("");
        amount = new ObservableField<>("");
    }


    public void onContinueClick(View view) {
        showConfirmAlert();
    }


    public void showConfirmAlert() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.ConfirmDialog);
        alertDialogBuilder.setCancelable(false);
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.confirm_alert, null);
        TextView amountTextView = (TextView) promptsView.findViewById(R.id.amount_textview);
        TextView phoneTextView = (TextView) promptsView.findViewById(R.id.phone_textview);
        final Button cancelButton = (Button) promptsView.findViewById(R.id.cancel_button);
        final Button confirmButton = (Button) promptsView.findViewById(R.id.confirm_button);
        Button acceptButton = (Button) promptsView.findViewById(R.id.accept_button);
        final LinearLayout successLayout = (LinearLayout) promptsView.findViewById(R.id.success_linear_layout);
        final RelativeLayout dataLinearLayout = (RelativeLayout) promptsView.findViewById(R.id.data_relative_container);
        amountTextView.setText("$ " + amount.get());
        phoneTextView.setText(phoneNumber.get());
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataLinearLayout.setVisibility(View.GONE);
                successLayout.setVisibility(View.VISIBLE);
            }
        });
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DetailBrandActivity) v.getContext()).finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialogBuilder.setView(promptsView);
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
