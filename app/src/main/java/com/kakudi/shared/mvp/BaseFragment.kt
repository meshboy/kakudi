package com.kakudi.shared.mvp

import android.os.Bundle
import android.view.View
import com.hannesdorfmann.mosby3.mvp.MvpFragment

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : MvpFragment<V, P>() {

    abstract fun setDaggerComponent()
    abstract fun setView(view: View)

    override fun onCreate(savedInstanceState: Bundle?) {
        setDaggerComponent()
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView(view)
    }
}