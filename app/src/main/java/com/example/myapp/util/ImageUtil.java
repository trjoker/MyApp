package com.example.myapp.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by Ryan on 18/03/2019.
 */
public class ImageUtil {

    //load net pic
    public static void loadUriImage(Context context, String url, ImageView iv, int placeHolder,
                                    int errorHolder) {
        if (context == null) {
            return;
        }
        Glide.with(context)
                .load(url)
                .placeholder(placeHolder)
                .error(errorHolder)
                .into(iv);
    }

    //load local pic
    public static void loadLocalImage(Context context, String path, ImageView iv, int placeHolder,
                                      int errorHolder) {
        File file = new File(context.getExternalCacheDir() + path);
        Glide.with(context)
                .load(file)
                .placeholder(placeHolder)
                .error(errorHolder)
                .into(iv);
    }

    public static void loadLocalImage(Context context, File file, ImageView iv, int placeHolder,
                                      int errorHolder) {
        Glide.with(context)
                .load(file)
                .placeholder(placeHolder)
                .error(errorHolder)
                .into(iv);
    }

}
