package com.kakudi.category.prensenter

import android.annotation.SuppressLint
import com.kakudi.category.di.usecases.FetchCategory
import com.kakudi.category.view.CategoryListView
import com.kakudi.category.view.CategoryView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.di.usecase.CurrentUser
import timber.log.Timber
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryListPresenter @Inject constructor(
    private val fetchCategory: FetchCategory,
    private val currentUser: CurrentUser,
    private val categoryView: CategoryView
) : BasePresenter<CategoryListView>() {

    @SuppressLint("CheckResult")
    fun getCategories() {
        ifViewAttached { view -> view.showLoading() }

        currentUser.execute()
            .flatMap { user ->
                fetchCategory.execute(input = user.id)
            }
            .subscribe({ list ->
                ifViewAttached { view ->

                    view.hideLoading()

                    if (list.isEmpty()) {
                        view.showEmptyCategory()
                    }

                    view.showCategoryList(list)
                }

            }, { err ->

                Timber.i("mesh_list $err")
                err.printStackTrace()
                ifViewAttached { view -> view.hideLoading() }
            })
    }

    fun navigateToCreateCategory() {
        categoryView.navigateToCreateCategory()
    }
}