package com.kakudi.category.view

import com.kakudi.category.data.model.Category
import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface CategoryView: BaseView {

    fun showCategoryList(list: List<Category>)
    fun nameError(message: String)
    fun budgetExpenseError(message: String)
    fun showLoading()
    fun hideLoading()
    fun showNextLoading()
    fun hideNextLoading()
}