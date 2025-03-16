package edu.zsk.a2025_03_05_photosinhorizontalscrollview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import edu.zsk.a2025_03_05_photosinhorizontalscrollview.ImageDialogFragment;
import edu.zsk.a2025_03_05_photosinhorizontalscrollview.R;

public class MainActivity extends AppCompatActivity {
    private int[] imageResIds = {
            R.drawable.zdj1, R.drawable.zdj2, R.drawable.zdj3, R.drawable.zdj4,
            R.drawable.zdj5, R.drawable.zdj6, R.drawable.zdj7, R.drawable.zdj8,
            R.drawable.zdj9, R.drawable.zdj10, R.drawable.zdj11, R.drawable.zdj12,
            R.drawable.zdj13, R.drawable.zdj14, R.drawable.zdj15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout imageContainer = findViewById(R.id.imageContainer);
        FragmentManager fragmentManager = getSupportFragmentManager();

        for (int imageResId : imageResIds) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResId);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));
            imageView.setPadding(10, 10, 10, 10);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setOnClickListener(v -> {
                ImageDialogFragment dialogFragment = ImageDialogFragment.newInstance(imageResId);
                dialogFragment.show(fragmentManager, "image_dialog");
            });

            imageContainer.addView(imageView);
        }
    }
}
