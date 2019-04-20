package com.kakudi.records.presenter

import com.kakudi.main.view.MainView
import com.kakudi.records.view.RecordsView
import com.kakudi.shared.mvp.BasePresenter
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/04/2019
 */
class RecordsPresenter @Inject constructor(private val mainView: MainView): BasePresenter<RecordsView>() {

    fun navigateToCreateRecordScreen() {
        mainView.navigateToCreateRecordFromRecordScreen()
    }

    fun navigateToCategoryScreen() {
        mainView.navigateToCategoryListScreenFromRecordScreen()
    }
}