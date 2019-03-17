package com.kakudi.shared.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
abstract class BaseFragment : Fragment() {

    abstract fun setView(): View
    abstract fun bindViews()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setView()
    }
}