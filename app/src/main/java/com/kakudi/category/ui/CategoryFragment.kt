package com.kakudi.category.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.category.data.model.Category
import com.kakudi.category.prensenter.CategoryListPresenter
import com.kakudi.category.view.CategoryListView
import com.kakudi.main.di.modules.MainModule
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CategoryFragment : BaseFragment<CategoryListView, CategoryListPresenter>(), CategoryListView {

    @Inject
    lateinit var categoryListPresenter: CategoryListPresenter

    override fun createPresenter(): CategoryListPresenter = categoryListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(MainModule())
            .inject(this@CategoryFragment)
    }

    override fun setView(view: View) {

    }

    override fun showCategoryList(list: List<Category>) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showNextLoading() {

    }

    override fun hideNextLoading() {

    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
