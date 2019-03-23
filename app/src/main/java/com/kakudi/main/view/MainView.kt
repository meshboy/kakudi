package com.kakudi.main.view

import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/03/2019
 */
interface MainView : BaseView {
    fun goToCategoryListPage()
    fun goToCreateCategoryPage()
    fun goToCreateExpensePage()
    fun goToExpenseListPage()
}