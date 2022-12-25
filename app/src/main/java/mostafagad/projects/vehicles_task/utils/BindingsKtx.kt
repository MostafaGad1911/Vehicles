package mostafagad.projects.vehicles_task.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import mostafagad.projects.vehicles_task.R
import javax.sql.DataSource

object BindingsKtx{
    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun loadPictureFromUrl(vehicleImg: ImageView, path: String?) {
        (path != null).let {
            if (it) {
                Log.i("MY_PATH" , path.toString())
                Glide.with(vehicleImg.context)
                    .load("$path")
                    .placeholder(R.drawable.loading_image)
                    .error(R.mipmap.ic_launcher)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean,
                        ): Boolean {
                            Log.i("LOAD_IMG_FAILED" , e?.message.toString())
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: com.bumptech.glide.load.DataSource?,
                            isFirstResource: Boolean,
                        ): Boolean {
                            return false
                        }

                    })
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
