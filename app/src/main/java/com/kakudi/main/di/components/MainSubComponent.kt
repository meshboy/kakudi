package com.kakudi.main.di.components

import com.kakudi.main.di.modules.MainModule
import com.kakudi.records.ui.CreateRecordActivity
import com.kakudi.records.ui.RecordFragment
import com.kakudi.reminder.ui.CreateReminderFragment
import com.kakudi.reminder.ui.ReminderFragment
import dagger.Subcomponent

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 19/03/2019
 */
@Subcomponent(modules = [(MainModule::class)])
interface MainSubComponent {
    fun inject(fragment: RecordFragment)
    fun inject(fragment: CreateRecordActivity)
    fun inject(fragment: ReminderFragment)
    fun inject(fragment: CreateReminderFragment)
}