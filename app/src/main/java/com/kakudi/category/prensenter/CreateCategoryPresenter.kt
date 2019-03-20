package com.kakudi.category.prensenter

import com.kakudi.category.data.model.Category
import com.kakudi.category.di.usecases.CreateCategory
import com.kakudi.category.view.CreateCategoryView
import com.kakudi.user.data.repository.UserRepository
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
class CreateCategoryPresenter @Inject constructor(
        private val createCategory: CreateCategory,
        private val currentUser: UserRepository,
        private val viewCreate: CreateCategoryView
) {

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
                viewCreate.nameError("Name can not be empty")
                return false
            }
            targetAmount.isEmpty() -> {
                viewCreate.budgetExpenseError("Budget expense can not be empty")
                return false
            }
        }
        return true
    }
}