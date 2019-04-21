package com.kakudi.category.ui

import androidx.databinding.DataBindingUtil
import com.kakudi.R
import com.kakudi.category.prensenter.CategoryPresenter
import com.kakudi.category.view.CategoryView
import com.kakudi.databinding.ActivityCategoryBinding
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.pop
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseActivity
import javax.inject.Inject

class CategoryActivity : BaseActivity<CategoryView, CategoryPresenter>(), CategoryView {

    @Inject
    lateinit var categoryPresenter: CategoryPresenter

    lateinit var binding: ActivityCategoryBinding

    override fun createPresenter(): CategoryPresenter = categoryPresenter


    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .repositoryModule(RepositoryModule())
            .build().inject(this)
    }

    override fun setView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.beginTransaction()
            .add(R.id.categoryContainer, CategoryListFragment()).commit()
    }

    override fun navigateToCategoryList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.categoryContainer, CategoryListFragment()).commit()
    }

    override fun navigateToCreateCategory() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.categoryContainer, CreateCategoryFragment()).addToBackStack(null).commit()
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun onSupportNavigateUp(): Boolean {
        pop {
            finish()
        }
        return super.onSupportNavigateUp()
    }
}
