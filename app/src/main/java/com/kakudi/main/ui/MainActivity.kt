package com.kakudi.main.ui

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.kakudi.R
import com.kakudi.category.ui.CategoryActivity
import com.kakudi.databinding.ActivityMainBinding
import com.kakudi.main.prensenter.MainPresenter
import com.kakudi.main.view.MainView
import com.kakudi.records.ui.CreateRecordActivity
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun createPresenter(): MainPresenter = mainPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .repositoryModule(RepositoryModule())
            .build().inject(this)
    }

    override fun setView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = this.findNavController(R.id.mainNavHost)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }

    override fun navigateToCreateRecordFromRecordScreen() {
        startActivity(Intent(this, CreateRecordActivity::class.java))
    }

    override fun navigateToCategoryListScreenFromRecordScreen() {
        startActivity(Intent(this, CategoryActivity::class.java))
    }

    override fun showError(message: String) {
        toast(message)
    }
}
