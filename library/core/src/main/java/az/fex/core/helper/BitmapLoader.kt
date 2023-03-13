package com.onurcan.core.helper

import android.graphics.Bitmap


interface BitmapLoader {
    fun loadBitmap(url: String): Bitmap
}