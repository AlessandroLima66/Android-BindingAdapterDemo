package com.andersonbadari.bindingadapterdemo.main;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Anderson Badari on 10/01/2018.
 */
public class ImageviewBindAdapter {

    @BindingAdapter("android:showImage")
    public static void bindUrlToImageview(ImageView imageView, String URL) {
        Glide.with(imageView.getContext())
                .load(URL)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }
}
