package az.fex.fexcargo.ui.fragment.about

import az.fex.core.base.BaseFragment
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment<FragmentAboutBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_about

    override fun initViews() {
        showBottomMenu(false)
    }

    override fun setListeners() {
    }

    override fun setReceivers() {
    }
}