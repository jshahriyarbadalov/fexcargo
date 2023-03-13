package az.fex.core.helper

import android.graphics.Bitmap
import com.bumptech.glide.RequestManager
import com.onurcan.core.helper.BitmapLoader


class GlideBitmapLoader(private val request: RequestManager) : BitmapLoader {
    override fun loadBitmap(url: String): Bitmap {
        return request.asBitmap()
            .load(url)
            .submit()
            .get()
    }
}