package com.mvvm.lib.binding.viewadapter.image;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mvvm.lib.R;


public final class ViewAdapter {
    @BindingAdapter(value = {"url", "placeholderRes"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String url, int placeholderRes) {
        if (!TextUtils.isEmpty(url)) {
            //使用Glide框架加载图片
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(new RequestOptions().placeholder(placeholderRes != 0 ? placeholderRes : R.drawable.placeholder_bg))
                    .into(imageView);
        }
    }

    @BindingAdapter(value = {"url", "placeholderRes"}, requireAll = false)
    public static void setImageUri(ImageView imageView, int resId, int placeholderRes) {
        if (resId != 0) {
            //使用Glide框架加载图片
            Glide.with(imageView.getContext())
                    .load(resId)
                    .apply(new RequestOptions().placeholder(placeholderRes != 0 ? placeholderRes : R.drawable.placeholder_bg))
                    .into(imageView);
        }
    }
}

