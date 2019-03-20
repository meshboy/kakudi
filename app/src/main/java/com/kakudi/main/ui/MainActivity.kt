package com.kakudi.main.ui

import com.kakudi.R
import com.kakudi.category.ui.CategoryFragment
import com.kakudi.shared.mvp.BaseActivity

class MainActivity : BaseActivity() {

    override fun setDaggerComponent() {

    }

    override fun setLayout(): Int = R.layout.activity_main

    override fun bindViews() {

        supportFragmentManager.beginTransaction().add(R.id.container, CategoryFragment()).commit()
    }

}
