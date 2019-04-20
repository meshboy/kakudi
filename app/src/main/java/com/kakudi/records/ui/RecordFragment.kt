package com.kakudi.records.ui


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.kakudi.R
import com.kakudi.main.di.modules.MainModule
import com.kakudi.main.ui.MainActivity
import com.kakudi.main.view.MainView
import com.kakudi.records.presenter.RecordsPresenter
import com.kakudi.records.view.RecordsView
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
class RecordFragment : BaseFragment<RecordsView, RecordsPresenter>(), RecordsView {

    @Inject
    lateinit var recordsPresenter: RecordsPresenter

    override fun createPresenter(): RecordsPresenter = recordsPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(activity!!.applicationContext))
            .repositoryModule(RepositoryModule())
            .build().plus(MainModule(activity as MainView))
            .inject(this@RecordFragment)
    }

    override fun setView(view: View) {
        setHasOptionsMenu(true)
    }

    override fun showError(message: String) {
        activity?.toast(message)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.category_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.category -> recordsPresenter.navigateToCategoryScreen()
            R.id.createRecord -> recordsPresenter.navigateToCreateRecordScreen()
        }

        return super.onOptionsItemSelected(item)
    }

}
