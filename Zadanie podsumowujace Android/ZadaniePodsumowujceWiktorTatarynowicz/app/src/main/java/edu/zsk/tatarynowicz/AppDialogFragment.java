package edu.zsk.tatarynowicz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class AppDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Okno dialogowe")
                .setMessage("Treść wiadomości")
                .setIcon(R.drawable.baseline_warning_24)
                .setCancelable(true);
        return builder.create();
    }
}