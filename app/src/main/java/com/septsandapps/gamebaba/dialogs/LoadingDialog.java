package com.septsandapps.gamebaba.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.septsandapps.gamebaba.R;


/**
 * Created by venkatesh on 4/12/15.
 */
public class LoadingDialog {

    Context context;
    AlertDialog loadingDialog;

    public LoadingDialog(Context context){
        this.context = context;
        this.loadingDialog = new AlertDialog.Builder(context).create();
    }

    public AlertDialog getDialog(){
        return loadingDialog;
    }

    public void show(CharSequence title) {
        show(false, title);
    }

    public void show(boolean isCancellable, CharSequence title) {
        View loadingDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        loadingDialog.setView(loadingDialogView);
        loadingDialog.setCancelable(isCancellable);

        TextView loadingTitle = (TextView) loadingDialogView.findViewById(R.id.title);
        loadingTitle.setText(title);

        loadingDialog.show();
    }

    public void closeDialog(){
        if ( loadingDialog != null ){
            loadingDialog.dismiss();
        }else{
            Toast.makeText(context, "NULL DIALOG", Toast.LENGTH_LONG).show();
        }
    }

}
