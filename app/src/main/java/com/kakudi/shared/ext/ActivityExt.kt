package com.kakudi.shared.ext

import android.app.Activity
import android.widget.Toast

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
fun Activity.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}