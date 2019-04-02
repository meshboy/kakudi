package com.kakudi.main.ui

import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.kakudi.R
import com.kakudi.databinding.ActivityMainBinding
import com.kakudi.main.prensenter.MainPresenter
import com.kakudi.main.view.MainView
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
    lateinit var drawerLayout: DrawerLayout

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
        drawerLayout = binding.drawerLayout

        navController = this.findNavController(R.id.mainNavHost)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun goToHomePage() {
    }

    override fun goToCategoryListPage() {

    }

    override fun goToCreateCategoryPage() {

    }

    override fun goToCreateExpensePage() {

    }

    override fun goToExpenseListPage() {

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun showError(message: String) {
        toast(message)
    }
}
