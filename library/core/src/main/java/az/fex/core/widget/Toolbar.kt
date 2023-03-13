package az.fex.core.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import az.fex.core.R
import az.fex.core.databinding.ToolbarLayoutBinding
import com.onurcankeskin.core.extension.hide
import com.onurcankeskin.core.extension.show
import az.fex.core.extensions.toSafeString
import az.fex.core.widget.toolbar.MenuType
import az.fex.core.widget.toolbar.ToolbarProperties


class Toolbar : LinearLayout {
    var navigationClickListener: (() -> Unit)? = null

    private var toolbarBinding =
        ToolbarLayoutBinding.inflate(LayoutInflater.from(this.context), this, true)

    var currentThemeId: Int? = null
    private var textNavView: TextView? = null

    constructor(context: Context) : super(context) {
        initAttrs(null)
    }

    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes) {
        initAttrs(attributes)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    ) {
        initAttrs(attributeSet)
    }

    private fun initAttrs(attributeSet: AttributeSet?) {

    }

    fun setProperties(properties: ToolbarProperties) {
        toolbarBinding.toolbar.setNavigationOnClickListener { navigationClickListener?.invoke() }
        currentThemeId = properties.themeId
        setLeftIcon(properties.menuType)
        setLogo(properties.logoId)
        setDivider(properties.hasBottomLine)
        setTitle(properties.title.toSafeString())
    }

    private fun setLeftIcon(leftMenu: MenuType) = with(toolbarBinding.toolbar) {
        when (leftMenu) {
            MenuType.None -> {
                textNavView?.hide()
                navigationIcon = null
                navigationContentDescription = ""
            }
            MenuType.Back -> {
                textNavView?.hide()
                navigationIcon =
                    ContextCompat.getDrawable(context, R.drawable.ic_arrow_back)
                navigationContentDescription = "hello"
            }
            MenuType.Close -> {
                textNavView?.hide()
                navigationIcon
                navigationContentDescription
            }
            MenuType.Help -> {
                textNavView?.hide()
                navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_help)
                navigationContentDescription
            }
            MenuType.Profile -> {
                textNavView?.hide()
                navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_person_fulfil)
                navigationContentDescription
            }
        }
        setNavigationOnClickListener { navigationClickListener?.invoke() }
    }

    private fun setLogo(resId: Int) = with(toolbarBinding) {
        if (resId == -1) {
            ivIcon.hide()
        } else {
            ivIcon.apply {
                setImageResource(resId)
                show()
            }
        }
    }

    fun setTitle(title: String) = with(toolbarBinding) {
        tvToolbar.text = title
    }

    private fun setDivider(hasBottomLine: Boolean) {
        val bgRes = when {
            hasBottomLine -> R.drawable.toolbar_line
            else -> 0
        }
        setBackgroundResource(bgRes)
    }

    fun getToolbarView() = toolbarBinding.toolbar

}