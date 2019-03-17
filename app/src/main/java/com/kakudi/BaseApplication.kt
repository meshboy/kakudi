package com.kakudi

import android.app.Application
import timber.log.Timber

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 14/03/2019
 */

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}