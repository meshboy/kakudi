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
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterFragment : BaseFragment<RegisterView, RegisterPresenter>() {

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

    }

}