package az.fex.fexcargo.ui.fragment.auth

import az.fex.core.base.BaseFragment
import az.fex.core.extensions.injectVm
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding>() {
    private val loginViewModel: LoginViewModel by injectVm()

    override fun getLayoutId(): Int = R.layout.fragment_sign_in

    override fun initViews() {
        showBottomMenu(false)
    }

    override fun setListeners() {

    }

    override fun setReceivers() {

    }
}