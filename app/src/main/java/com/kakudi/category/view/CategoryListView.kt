package com.kakudi.category.view

import com.kakudi.category.data.model.Category
import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
interface CategoryListView: BaseView {
    fun showCategoryList(list: List<Category>)
    fun showLoading()
    fun hideLoading()
    fun showNextLoading()
    fun hideNextLoading()
}