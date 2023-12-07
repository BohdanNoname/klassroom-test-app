package ua.nedash.klassroom

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun AppCompatImageView.glideLoadUserImage(
    url: String,
    placeholder: Int = R.drawable.ic_user,
    error: Int = R.drawable.ic_user
) =
    Glide.with(this)
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .circleCrop()
        .into(this)


fun AppCompatImageView.glideLoadMessageImage(url: String) =
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)