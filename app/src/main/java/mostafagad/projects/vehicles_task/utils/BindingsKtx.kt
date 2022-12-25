package mostafagad.projects.vehicles_task.utils

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import mostafagad.projects.vehicles_task.R

object BindingsKtx{
    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun loadPictureFromUrl(vehicleImg: ImageView, path: String?) {
        (path != null).let {
            if (it) {
                Glide.with(vehicleImg.context)
                    .load("$path")
                    .placeholder(R.drawable.loading_image)
                    .apply(RequestOptions.centerCropTransform())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .override(512, 512)
                    .into(vehicleImg)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("app:textColor")
    fun textColor(vehicleTxt: TextView, color: String?) {
        (color != null).let {
            if (it) {
                vehicleTxt.setTextColor(Color.parseColor(color))
            }
        }
    }
}
