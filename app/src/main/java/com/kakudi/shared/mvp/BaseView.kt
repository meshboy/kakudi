package com.kakudi.shared.mvp

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showNextLoading()
    fun hideNextLoading()
}