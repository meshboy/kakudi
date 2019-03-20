package com.kakudi.category.prensenter

import android.annotation.SuppressLint
import com.kakudi.category.di.usecases.CreateCategory
import com.kakudi.category.di.usecases.FetchCategory
import com.kakudi.category.view.CategoryListView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.data.repository.UserRepository
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryListPresenter @Inject constructor(
        private val fetchCategory: FetchCategory,
        private val createCategory: CreateCategory,
        private val currentUser: UserRepository
) : BasePresenter<CategoryListView>() {

    @SuppressLint("CheckResult")
    fun get() {

        ifViewAttached { view ->
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
    }

    fun test() {

        ifViewAttached { view ->
            view.showError("yes ke")
        }
    }
}