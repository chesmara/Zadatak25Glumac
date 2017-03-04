package com.example.androiddevelopment.zadatak20glumac.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.androiddevelopment.zadatak20glumac.R;


public class KontaktGialog extends AlertDialog.Builder {

    public KontaktGialog(Context context) {
        super(context);

        setTitle("Kontakt");
        setMessage("Mozete nas kontaktirati preko telefona 021/555-666 ili na email: srdjan@ekoneimar.com");
        setCancelable(false);

        setPositiveButton(R.string.dialog_about_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        setNegativeButton(R.string.dialog_about_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
    }

        public AlertDialog prepareDialog(){
            AlertDialog dialog = create();
            dialog.setCanceledOnTouchOutside(false);

            return dialog;


    }
}
