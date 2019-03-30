package com.kakudi.intro.ui

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.kakudi.R
import com.kakudi.databinding.ActivityMainIntroBinding
import com.kakudi.intro.presenter.MainIntroPresenter
import com.kakudi.intro.view.MainIntroView
import com.kakudi.main.ui.MainActivity
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseActivity
import javax.inject.Inject

class MainIntroActivity : BaseActivity<MainIntroView, MainIntroPresenter>(),
    MainIntroView {

    @Inject
    lateinit var mainIntroPresenter: MainIntroPresenter

    private lateinit var navController: NavController

    lateinit var binding: ActivityMainIntroBinding

    override fun createPresenter(): MainIntroPresenter = mainIntroPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(this))
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this)
    }

    override fun setView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_intro)
        navController = findNavController(R.id.mainIntroNavHost)

        Thread {
            Thread.sleep(2_000)
            navigateToWelcomeScreenFromSplashScreen()
        }.start()
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun navigateToWelcomeScreenFromSplashScreen() {
        navController.navigate(R.id.action_splashFragment_to_mainWelcomeFragment)
    }

    override fun navigateToLoginScreenFromFromWelcomeScreen() {
        navController.navigate(R.id.action_mainWelcomeFragment_to_loginFragment)
    }

    override fun navigateToRegisterScreenFromWelcomeScreen() {
        navController.navigate(R.id.action_mainWelcomeFragment_to_registerFragment)
    }

    override fun navigateToRegisterScreenFromLoginScreen() {
        navController.navigate(R.id.action_loginFragment_to_registerFragment)
    }

    override fun navigateToLoginScreenFromRegisterScreen() {
        navController.navigate(R.id.action_registerFragment_to_loginFragment)
    }

    override fun navigateToHomeScreen() {
        val homeIntent = Intent(this, MainActivity::class.java)
        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(homeIntent)
    }
}