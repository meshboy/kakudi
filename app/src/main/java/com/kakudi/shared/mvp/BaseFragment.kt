package com.kakudi.shared.mvp

import com.hannesdorfmann.mosby3.mvp.MvpFragment

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : MvpFragment<V, P>()