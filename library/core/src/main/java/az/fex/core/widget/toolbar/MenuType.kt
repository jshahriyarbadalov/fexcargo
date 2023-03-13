package az.fex.core.widget.toolbar


enum class MenuType(val type: Int) {
    None(0),
    Back(1),
    Close(2),
    Help(3),
    Profile(4);

    companion object {
        fun getLeftIcon(style: Int) = values().first { it.type == style }
    }
}