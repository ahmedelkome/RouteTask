package com.route.route_task.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

@BindingAdapter("imageUrl")
fun imageUrl(image:ImageView,url:String){
    if (url.isNullOrBlank()) return
    Glide
        .with(image)
        .load(url)
        .into(image)
}