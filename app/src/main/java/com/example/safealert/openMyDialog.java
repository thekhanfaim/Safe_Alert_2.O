package com.example.safealert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class openMyDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder mybuilder = new AlertDialog.Builder(getActivity());
        mybuilder.setTitle("YOU HAVE NOT CHECKED THE BOX")
                .setMessage("Please Accept Terms and Conditions To Proceed Further")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return mybuilder.create();
    }
}
