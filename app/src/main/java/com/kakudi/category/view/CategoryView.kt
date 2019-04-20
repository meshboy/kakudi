package com.kakudi.category.view

import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/04/2019
 */
interface CategoryView : BaseView {
    fun navigateToCategoryList()
    fun navigateToCreateCategory()
}