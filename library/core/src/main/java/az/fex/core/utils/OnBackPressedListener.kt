package az.fex.core.utils

interface OnBackPressedListener {
    fun isBackEnabled(): Boolean
    fun onBackPressed(): Boolean
}