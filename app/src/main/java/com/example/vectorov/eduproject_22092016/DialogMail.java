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
public class DialogMail extends DialogFragment implements DialogInterface.OnClickListener {
    private String actualEmail;

    public DialogMail(){}
    //нужно через Bundle передавать аргументы
    public DialogMail(String actualEmail) {
        super();
        this.actualEmail = actualEmail;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        switch (which)
        {
            case Dialog.BUTTON_POSITIVE:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{actualEmail});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
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
                .setTitle("Email!").setPositiveButton(R.string.yes, this)
                .setNegativeButton(R.string.no, this)
                .setMessage(R.string.message_text_mail);
        return adb.create();
    }
}
