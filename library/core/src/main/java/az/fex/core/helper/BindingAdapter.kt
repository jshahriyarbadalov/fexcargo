package az.fex.core.helper

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import az.fex.core.R
import coil.load
import com.onurcankeskin.core.extension.gone
import com.onurcankeskin.core.extension.show
import org.jetbrains.annotations.NotNull

fun setImageResource(@NotNull imageView: ImageView, resInt: Int?) {
    resInt?.let { imageView.setImageResource(it) }
}

@BindingAdapter("imageResourceDrawable")
fun setImageDrawable(@NotNull imageView: ImageView, drawable: Drawable?) {
    drawable?.let { imageView.setImageDrawable(drawable) }
}

@BindingAdapter("coilString")
fun setCoilResource(@NotNull imageView: ImageView, resInt: String?) {
    resInt?.let {
        imageView.load(resInt) {
            crossfade(true)
            placeholder(R.drawable.ic_image)
        }
    }
}

@BindingAdapter("android:show")
fun setShow(@NotNull view: View, boolean: Boolean) {
    if (boolean) {
        view.show()
    } else {
        view.gone()
    }
}