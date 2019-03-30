package com.kakudi.login.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kakudi.databinding.FragmentLoginBinding
import com.kakudi.intro.di.modules.MainIntroModule
import com.kakudi.intro.view.MainIntroView
import com.kakudi.login.presenter.LoginPresenter
import com.kakudi.login.view.LoginView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.hide
import com.kakudi.shared.ext.show
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : BaseFragment<LoginView, LoginPresenter>(), LoginView {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    lateinit var binding: FragmentLoginBinding

    override fun createPresenter(): LoginPresenter = loginPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(MainIntroModule(activity as MainIntroView)).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, com.kakudi.R.layout.fragment_login, container, false)
        return binding.root

    }

    override fun setView(view: View) {

        binding.apply {
            navigateToRegistrationTextView.setOnClickListener { navigateToRegistrationScreen() }
            loginAccountButton.setOnClickListener { login() }
        }
    }

    private fun navigateToRegistrationScreen() {
        loginPresenter.navigateToRegistrationScreen()
    }

    fun login() {

        val email = binding.userEmailText.text.toString()
        val password = binding.passwordText.text.toString()

        loginPresenter.loginUser(email, password)
    }


    override fun showLoading() {
        binding.loginProgressBar.show()
        binding.loginAccountButton.hide()
    }

    override fun hideLoading() {
        binding.loginProgressBar.hide()
        binding.loginAccountButton.show()
    }

    override fun showError(message: String) {
        activity?.toast(message)
    }
}
