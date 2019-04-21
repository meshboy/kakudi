package com.kakudi.shared.ext

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
fun Activity.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

/**
 * used when back button is pressed and you want to go to the previous fragment
 */
fun AppCompatActivity.pop(callback: () -> Unit) {
    val count = supportFragmentManager.backStackEntryCount
    if (count >= 1) {
        supportFragmentManager.popBackStack()
    } else {
        callback()
    }
}