package com.hhmedic.sdk.demo;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hhmedic.android.sdk.config.HHImageEngine;

public class GlideImageLoader implements HHImageEngine {
    @Override
    public void loadImage(Context context, int placeHolder, String url, ImageView imageView) {
        Glide.with(context).load(url).apply(new RequestOptions()).placeholder(placeHolder).into(imageView);
    }
}

