package com.kakudi.reminder.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.main.di.modules.MainModule
import com.kakudi.main.view.MainView
import com.kakudi.reminder.presenter.CreateReminderPresenter
import com.kakudi.reminder.view.CreateReminderView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CreateReminderFragment : BaseFragment<CreateReminderView, CreateReminderPresenter>(),
    CreateReminderView {

    @Inject
    lateinit var createReminderPresenter: CreateReminderPresenter

    override fun createPresenter(): CreateReminderPresenter = createReminderPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(MainModule(activity as MainView))
            .inject(this@CreateReminderFragment)
    }

    override fun setView(view: View) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_reminder, container, false)
    }

    override fun showError(message: String) {
        activity?.toast(message)
    }
}
