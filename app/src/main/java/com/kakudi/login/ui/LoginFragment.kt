package com.kakudi.login.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.databinding.FragmentLoginBinding
import com.kakudi.intro.di.modules.MainIntroModule
import com.kakudi.intro.view.MainIntroView
import com.kakudi.login.presenter.LoginPresenter
import com.kakudi.login.view.LoginView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : BaseFragment<LoginView, LoginPresenter>() {

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root

    }

    override fun setView(view: View) {

    }
}
