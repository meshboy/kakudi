package com.kakudi.category.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.category.di.domain.modules.CategoryModule
import com.kakudi.category.prensenter.CreateCategoryPresenter
import com.kakudi.category.view.CategoryView
import com.kakudi.category.view.CreateCategoryView
import com.kakudi.databinding.FragmentCreateCategoryBinding
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.hide
import com.kakudi.shared.ext.show
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CreateCategoryFragment : BaseFragment<CreateCategoryView, CreateCategoryPresenter>(),
    CreateCategoryView {

    @Inject
    lateinit var createCategoryPresenter: CreateCategoryPresenter

    lateinit var binding: FragmentCreateCategoryBinding

    override fun createPresenter(): CreateCategoryPresenter = createCategoryPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(CategoryModule(activity as CategoryView))
            .inject(this@CreateCategoryFragment)
    }

    override fun setView(view: View) {
        activity?.title = getString(R.string.create_category)

        binding.apply {
            createCategoryButton.setOnClickListener { onClickCreateCategory() }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_create_category, container, false)
        return binding.root
    }

    override fun nameError(message: String?) {
        binding.categoryTextInputLayout.error = message
    }

    override fun showError(message: String) {
        activity?.toast(message)
    }

    override fun showSuccess(message: String) {
        activity?.toast(message)
        binding.categoryText.text = null
        binding.descriptionText.text = null
    }

    override fun showLoading() {
        binding.apply {
            categoryProgressBar.show()
            createCategoryButton.hide(invisible = true)
        }
    }

    override fun hideLoading() {
        binding.apply {
            categoryProgressBar.hide(invisible = true)
            createCategoryButton.show()
        }
    }

    fun onClickCreateCategory() {
        binding.categoryTextInputLayout.error = null

        binding.apply {
            createCategoryPresenter.create(
                categoryText.text.toString(),
                descriptionText.text.toString()
            )
        }
    }
}
