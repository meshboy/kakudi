package com.kakudi.category.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kakudi.R
import com.kakudi.category.adapter.CategoryAdapter
import com.kakudi.category.data.model.Category
import com.kakudi.category.di.domain.modules.CategoryModule
import com.kakudi.category.prensenter.CategoryListPresenter
import com.kakudi.category.view.CategoryListView
import com.kakudi.category.view.CategoryView
import com.kakudi.databinding.FragmentCategoryBinding
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.hide
import com.kakudi.shared.ext.show
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CategoryListFragment : BaseFragment<CategoryListView, CategoryListPresenter>(),
    CategoryListView {

    lateinit var binding: FragmentCategoryBinding

    @Inject
    lateinit var categoryListPresenter: CategoryListPresenter
    lateinit var categoryAdapter: CategoryAdapter

    override fun createPresenter(): CategoryListPresenter = categoryListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false)
        return binding.root
    }

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(CategoryModule(activity as CategoryView))
            .inject(this@CategoryListFragment)
    }

    override fun setView(view: View) {
        activity?.title = getString(R.string.category)

        val linearLayoutManager = LinearLayoutManager(context)
        categoryAdapter = CategoryAdapter(context!!)

        binding.categoryRecyclerView.apply {
            adapter = categoryAdapter
            layoutManager  = linearLayoutManager
            itemAnimator = DefaultItemAnimator()
        }

        categoryListPresenter.getCategories()

        binding.navigateToCreateCategoryButton.setOnClickListener { onClickCreateCategory() }
    }

    fun onClickCreateCategory() {
        categoryListPresenter.navigateToCreateCategory()
    }

    override fun showEmptyCategory() {
        binding.emptyTextView.show()
        binding.categoryRecyclerView.hide()
        binding.emptyTextView.text = getString(R.string.empty_category)
    }

    override fun showCategoryList(list: List<Category>) {
        binding.emptyTextView.hide()
        binding.categoryRecyclerView.show()
        categoryAdapter.setCategoryListData(list)
        binding.categoryRecyclerView.invalidate()
    }

    override fun showLoading() {
        binding.categoryProgressBar.show()
    }

    override fun hideLoading() {
        binding.categoryProgressBar.hide()
    }

    override fun showNextLoading() {

    }

    override fun hideNextLoading() {

    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
