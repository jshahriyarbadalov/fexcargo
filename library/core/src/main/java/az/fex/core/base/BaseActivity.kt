package az.fex.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import az.fex.core.extensions.updateStatusBarColor
import az.fex.core.widget.toolbar.ToolbarProperties

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: DB

    abstract fun initViews(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        initViews(savedInstanceState)
    }

    open fun setToolbarProperties(properties: ToolbarProperties) {
        updateStatusBarColor(properties.themeId)
    }

    abstract fun showBottomNav(isShow: Boolean)
}