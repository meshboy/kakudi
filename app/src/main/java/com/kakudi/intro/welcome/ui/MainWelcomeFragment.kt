package com.kakudi.intro.welcome.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.kakudi.R
import com.kakudi.databinding.FragmentMainWelcomeBinding
import com.kakudi.intro.di.modules.MainIntroModule
import com.kakudi.intro.view.MainIntroView
import com.kakudi.intro.welcome.adapter.MainWelcomePageAdapter
import com.kakudi.intro.welcome.presenter.WelcomePresenter
import com.kakudi.intro.welcome.view.WelcomeView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class MainWelcomeFragment : BaseFragment<WelcomeView, WelcomePresenter>(), WelcomeView {

    @Inject
    lateinit var mainWelcomePresenter: WelcomePresenter

    lateinit var binding: FragmentMainWelcomeBinding

    override fun createPresenter(): WelcomePresenter = mainWelcomePresenter

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
            DataBindingUtil.inflate(inflater, R.layout.fragment_main_welcome, container, false)
        return binding.root
    }

    override fun setView(view: View) {
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.adapter = welcomeAdapter()
        binding.createAccount.setOnClickListener { navigateToRegisterPage() }
        binding.signIn.setOnClickListener { navigateToLogin() }
    }

    private fun welcomeAdapter(): MainWelcomePageAdapter {
        val viewPagerAdapter = MainWelcomePageAdapter(fragmentManager = fragmentManager!!)
        viewPagerAdapter.addFragment(
            ViewPagerFragment.instance(
                R.drawable.coin,
                getString(R.string.description_one),
                R.color.slider_one
            )
        )
        viewPagerAdapter.addFragment(
            ViewPagerFragment.instance(
                R.drawable.money_reminder,
                getString(R.string.description_two),
                R.color.slider_two
            )
        )
        viewPagerAdapter.addFragment(
            ViewPagerFragment.instance(
                R.drawable.growth_icon,
                getString(R.string.description_three),
                R.color.slider_three
            )
        )
        return viewPagerAdapter
    }

    private fun navigateToLogin() {
        mainWelcomePresenter.goToLogin()
    }

    private fun navigateToRegisterPage() {
        mainWelcomePresenter.goToRegister()
    }

    override fun showError(message: String) {
        activity?.toast(message)
    }
}
