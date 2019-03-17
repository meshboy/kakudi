package com.kakudi.category.prensenter

import android.annotation.SuppressLint
import com.kakudi.category.data.model.Category
import com.kakudi.category.di.usecases.CreateCategory
import com.kakudi.category.di.usecases.FetchCategory
import com.kakudi.category.view.CategoryView
import com.kakudi.user.data.repository.UserRepository
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryPresenter @Inject constructor(
    private val fetchCategory: FetchCategory,
    private val createCategory: CreateCategory,
    private val currentUser: UserRepository,
    private val view: CategoryView
) {

    @SuppressLint("CheckResult")
    fun get() {
        view.showLoading()
        fetchCategory.execute("")
            .subscribe({ list ->
                view.hideLoading()
                view.showCategoryList(list)
            }, { err ->
                err.printStackTrace()
                view.hideLoading()
                view.showError("An error occurred. please try again")
            })
    }

    fun create(name: String, description: String?, targetAmount: String) {

        if (validateInput(name, targetAmount)) {
            val category =
                Category(name = name, description = description, targetExpense = targetAmount.toDouble(), userId = "")
            createCategory.execute(category)

        }
    }

    private fun validateInput(name: String, targetAmount: String): Boolean {
        when {
            name.isEmpty() -> {
                view.nameError("Name can not be empty")
                return false
            }
            targetAmount.isEmpty() -> {
                view.budgetExpenseError("Budget expense can not be empty")
                return false
            }
        }
        return true
    }

}