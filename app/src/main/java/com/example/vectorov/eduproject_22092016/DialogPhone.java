package com.example.vectorov.eduproject_22092016;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by vectorov on 28.09.2016.
 * Modify Omelyanchuk on 22.10.2016.
 */
public class DialogPhone extends DialogFragment implements DialogInterface.OnClickListener {

    private String actualPhoneNum;

    public DialogPhone(){}
    //нужно через Bundle передавать аргументы
    public DialogPhone(String actualPhoneNum) {
        super();
        this.actualPhoneNum = actualPhoneNum;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        switch (which)
        {
            case Dialog.BUTTON_POSITIVE:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(actualPhoneNum.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
                break;
            case Dialog.BUTTON_NEGATIVE:
                dismiss();
                break;
            case Dialog.BUTTON_NEUTRAL:
                break;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setTitle("Phone!").setPositiveButton(R.string.yes, this)
                .setNegativeButton(R.string.no, this)
                .setMessage(R.string.message_text_phone);
        return adb.create();
    }
}
