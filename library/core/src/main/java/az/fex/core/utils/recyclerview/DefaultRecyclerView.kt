package az.fex.core.utils.recyclerview

import androidx.annotation.LayoutRes

class DefaultRecyclerView<T>(@LayoutRes private val id: Int) : DataBindingAdapter<T>() {
    override fun getItemLayoutId(viewType: Int): Int = id
}