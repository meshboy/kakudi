package com.kakudi.shared.mvp

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
abstract class BasePresenter<T> {

    abstract fun getPresenter(): T
}