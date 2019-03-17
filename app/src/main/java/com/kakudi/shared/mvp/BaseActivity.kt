package com.kakudi.shared.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
abstract class BaseActivity: AppCompatActivity(){

    abstract fun setLayout(): Int
    abstract fun bindViews()
    abstract fun setDaggerComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        setDaggerComponent()
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        bindViews()
    }
}