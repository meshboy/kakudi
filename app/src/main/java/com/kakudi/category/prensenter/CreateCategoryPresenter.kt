package com.kakudi.category.prensenter

import android.annotation.SuppressLint
import com.kakudi.category.data.model.Category
import com.kakudi.category.di.usecases.CreateCategory
import com.kakudi.category.view.CreateCategoryView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.di.usecase.CurrentUser
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
class CreateCategoryPresenter @Inject constructor(
    private val createCategory: CreateCategory,
    private val currentUser: CurrentUser
) : BasePresenter<CreateCategoryView>() {

    @SuppressLint("CheckResult")
    fun create(name: String?, description: String?) {

        if (validateInput(name)) {

            ifViewAttached { view ->
                view.showLoading()
                currentUser.execute()
                    .flatMap { user ->
                        val category =
                            Category(
                                name = name!!,
                                description = description,
                                userId = user.id
                            )
                        createCategory.execute(category)
                    }
                    .subscribe({
                        view.hideLoading()
                        view.showSuccess("Category created successfully")

                    }, { err ->
                        err.printStackTrace()
                        view.hideLoading()
                        view.showError("Something went wrong. Please try again...")
                    })
            }

        }
    }

    private fun validateInput(name: String?): Boolean {
        when {
            name.isNullOrEmpty() -> {
                ifViewAttached { view ->
                    view.nameError("Category name can not be empty")
                }
                return false
            }
        }
        return true
    }
}