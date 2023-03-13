package az.fex.fexcargo.ui.fragment.home

import az.fex.core.base.BaseFragment
import az.fex.core.widget.toolbar.MenuType
import az.fex.core.widget.toolbar.ToolbarProperties
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initViews() {
        showBottomMenu(true)

        vi.toolbarHeader.setProperties(
            ToolbarProperties(
                menuType = MenuType.Profile,
                title = getString(az.fex.i18n.R.string.app_name),
                themeId = az.fex.core.R.style.Theme_Fexcargo,
                logoId = az.fex.core.R.drawable.logo,
                hasBottomLine = false
            )
        )
    }

    override fun setListeners() {
        TODO("Not yet implemented")
    }

    override fun setReceivers() {
        TODO("Not yet implemented")
    }
}