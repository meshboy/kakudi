package com.kakudi.shared.mvp

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : MvpActivity<V, P>() {

    abstract fun setDaggerComponent()
    abstract fun setView()

    override fun onCreate(savedInstanceState: Bundle?) {
        setDaggerComponent()
        super.onCreate(savedInstanceState)
        setView()
    }
}