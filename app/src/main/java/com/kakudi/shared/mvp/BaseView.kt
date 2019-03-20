package com.kakudi.shared.mvp

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface BaseView : MvpView {
    fun showError(message: String)
}