package edu.zsk.a2025_03_05_photosinhorizontalscrollview;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ImageDialogFragment extends DialogFragment {
    private static final String ARG_IMAGE_RES_ID = "image_res_id";

    public static ImageDialogFragment newInstance(int imageResId) {
        ImageDialogFragment fragment = new ImageDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_image, null);
        dialog.setContentView(view);

        ImageView imageView = view.findViewById(R.id.dialogImageView);
        int imageResId = getArguments().getInt(ARG_IMAGE_RES_ID);
        imageView.setImageResource(imageResId);

        view.setOnClickListener(v -> dismiss());
        return dialog;
    }
}
