package com.kakudi.register.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.databinding.FragmentRegisterBinding
import com.kakudi.intro.di.modules.MainIntroModule
import com.kakudi.intro.view.MainIntroView
import com.kakudi.register.presenter.RegisterPresenter
import com.kakudi.register.view.RegisterView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.hide
import com.kakudi.shared.ext.show
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterFragment : BaseFragment<RegisterView, RegisterPresenter>(), RegisterView {

    @Inject
    lateinit var registerPresenter: RegisterPresenter

    override fun createPresenter(): RegisterPresenter = registerPresenter

    lateinit var binding: FragmentRegisterBinding


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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binding.root
    }

    override fun setView(view: View) {
        binding.createAccountButton.setOnClickListener { onCreateAccountButton() }
    }

    fun onCreateAccountButton() {
        binding.apply {
            val username = "${userNameEditText.text}"
            val email = "${userEmailText.text}"
            val password = "${passwordText.text}"
            val confirmPassword = "${confirmPasswordText.text}"
            registerPresenter.createAccount(username, email, password, confirmPassword)
        }
    }

    override fun showLoading() {
        binding.apply {
            createAccountButton.hide()
            createAccountProgressBar.show()
        }
    }

    override fun hideLoading() {
        binding.apply {
            createAccountButton.show()
            createAccountProgressBar.hide()
        }
    }

    override fun showError(message: String) {
        activity?.toast(message)
    }

}