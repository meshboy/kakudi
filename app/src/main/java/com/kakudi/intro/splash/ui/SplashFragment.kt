package com.kakudi.intro.splash.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.intro.di.modules.MainIntroModule
import com.kakudi.intro.splash.presenter.SplashPresenter
import com.kakudi.intro.splash.view.SplashView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class SplashFragment : BaseFragment<SplashView, SplashPresenter>() {

    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun createPresenter(): SplashPresenter = splashPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(MainIntroModule()).inject(this)
    }

    override fun setView(view: View) {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}
