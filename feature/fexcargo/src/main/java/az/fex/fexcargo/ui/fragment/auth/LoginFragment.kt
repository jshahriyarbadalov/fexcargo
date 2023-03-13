package az.fex.fexcargo.ui.fragment.auth

import az.fex.core.base.BaseFragment
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun initViews() {
       showBottomMenu(false)
    }

    override fun setListeners() {

    }

    override fun setReceivers() {

    }


}