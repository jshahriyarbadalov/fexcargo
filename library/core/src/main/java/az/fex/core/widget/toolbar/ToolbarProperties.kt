package az.fex.core.widget.toolbar

import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import az.fex.core.widget.toolbar.MenuType

class ToolbarProperties(
    val menuType: MenuType = MenuType.Back,
    var title: String? = null,
    var subTitle: String? = null,
    @StyleRes var themeId: Int? = null,
    @DrawableRes var logoId: Int = -1,
    val hasBottomLine: Boolean = false
)