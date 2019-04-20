package com.kakudi.shared.ext

import android.view.View

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/03/2019
 */

fun View.hide(invisible: Boolean = false) {
    if(invisible) {
        this.visibility = View.INVISIBLE
    }
    else{
        this.visibility = View.GONE
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}