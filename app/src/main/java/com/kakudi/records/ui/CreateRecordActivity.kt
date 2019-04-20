package com.kakudi.records.ui


import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.databinding.ActivityCreateRecordBinding
import com.kakudi.records.presenter.CreateRecordsPresenter
import com.kakudi.records.view.CreateRecordsView
import com.kakudi.shared.di.components.DaggerApplicationComponent
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.RepositoryModule
import com.kakudi.shared.ext.toast
import com.kakudi.shared.mvp.BaseActivity
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CreateRecordActivity : BaseActivity<CreateRecordsView, CreateRecordsPresenter>(),
    CreateRecordsView {

    @Inject
    lateinit var createRecordsPresenter: CreateRecordsPresenter

    lateinit var binding: ActivityCreateRecordBinding

    override fun createPresenter(): CreateRecordsPresenter = createRecordsPresenter

    override fun setDaggerComponent() {
        DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this)
    }

    override fun setView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_record)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.create_record)
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
