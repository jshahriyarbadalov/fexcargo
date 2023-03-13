package az.fex.fexcargo.ui.fragment.auth

import az.fex.core.base.BaseFragment
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentSignUpBinding

class SingUpFragment :BaseFragment<FragmentSignUpBinding>(){
    override fun getLayoutId(): Int = R.layout.fragment_sign_up

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