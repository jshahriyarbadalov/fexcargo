package az.fex.fexcargo.ui.fragment.conditions

import az.fex.core.base.BaseFragment
import az.fex.fexcargo.R
import az.fex.fexcargo.databinding.FragmentAcceptTermsBinding

class AcceptTermsFragment : BaseFragment<FragmentAcceptTermsBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_accept_terms


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