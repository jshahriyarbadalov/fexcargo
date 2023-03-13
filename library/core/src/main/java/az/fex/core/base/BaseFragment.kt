package az.fex.core.base

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import az.fex.core.R
import az.fex.core.extensions.updateStatusBarColor
import az.fex.core.utils.OnBackPressedListener
import az.fex.core.utils.ResProvider
import az.fex.core.widget.toolbar.ToolbarProperties
import com.google.android.material.snackbar.Snackbar
import com.onurcankeskin.core.extension.hide
import com.onurcankeskin.core.extension.show
import javax.inject.Inject

abstract class BaseFragment<DB : ViewDataBinding> : Fragment(), OnBackPressedListener {

    lateinit var vi: DB

    @Inject
    lateinit var resProvider: ResProvider

    @LayoutRes
    abstract fun getLayoutId(): Int

    @MenuRes
    open fun getMenuId(): Int = -1

    @StyleRes
    open fun getThemeId(): Int = R.style.Theme_Fexcargo

    var isViewCreated = false

    var toolbarNavListener: (() -> Unit)? = null

    private var progressView: ProgressBar? = null

    abstract fun initViews()

    abstract fun setListeners()

    abstract fun setReceivers()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        resProvider = ResProvider(requireContext())
        return createFragment(inflater, container)
    }

    private fun createFragment(inflater: LayoutInflater, container: ViewGroup?): View {
        if (!::vi.isInitialized) {
            inflateLayout(inflater, container)
            initProgress(this.context!!)
        }
        container?.removeView(vi.root)
        return vi.root
    }

    private fun inflateLayout(inflater: LayoutInflater, container: ViewGroup?) {
        vi = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
    }

    private fun initProgress(context: Context) {
        progressView = ProgressBar(context)
    }

    protected fun navigate(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    protected fun navigateUp() {
        NavHostFragment.findNavController(this).navigateUp()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        if (!isViewCreated) {
            isViewCreated = true
            initViews()
            setListeners()
        }
        setReceivers()
        if (::vi.isInitialized) {
            vi.root.setOnClickListener { clearCurrentFocus() }
        }
    }

    open fun showProgress() {
        progressView?.show()
    }

    open fun hideProgress() {
        progressView?.hide()
    }

    fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes id: Int) {
        Toast.makeText(requireContext(), resProvider.getString(id), Toast.LENGTH_SHORT).show()
    }

    fun makeSnackbar(str: String): Snackbar {
        return Snackbar.make(vi.root, str, Snackbar.LENGTH_SHORT)
    }

    @CallSuper
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        getMenuId().let { id ->
            if (id != -1) {
                inflater.inflate(id, menu)
            } else {
                menu.clear()
            }
        }
    }

    private fun updateStatusBarColor(@StyleRes themeId: Int) {
        (requireActivity() as BaseActivity<*>).updateStatusBarColor(themeId)
    }

    protected fun setFragmentResultListener(
        requestKey: String,
        lifecycleOwner: LifecycleOwner,
        listener: FragmentResultListener,
    ) {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            requestKey,
            lifecycleOwner,
            listener
        )
    }

    protected fun clearCurrentFocus() {
        requireActivity().currentFocus?.clearFocus()
    }

    override fun isBackEnabled(): Boolean = false

    override fun onBackPressed(): Boolean = true

    fun showBottomMenu(isShow: Boolean) {
        (requireActivity() as BaseActivity<*>).showBottomNav(isShow)
    }
}