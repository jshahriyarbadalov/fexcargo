package az.fex.core.utils.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import az.fex.core.BR


open class DataBindingViewHolder<T>(
    private val bindViewDataBinding: ViewDataBinding,
    private val currentSelected: T? = null,
) : RecyclerView.ViewHolder(bindViewDataBinding.root) {
    var viewType: Int = -1

    fun bind(item: T) {
        bindViewDataBinding.setVariable(BR.item, item)
        bindViewDataBinding.executePendingBindings()

        itemView.apply {
            currentSelected?.let {
                isActivated = item == currentSelected
            }
        }
    }
}