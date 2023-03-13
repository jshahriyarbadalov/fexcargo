package az.fex.fexcargo.ui.fragment.splash

import az.fex.core.base.BaseFragment
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_splash_screen

    override fun initViews() {
        showBottomMenu(false)
    }

    override fun setListeners() {
        TODO("Not yet implemented")
    }

    override fun setReceivers() {
        TODO("Not yet implemented")
    }
}