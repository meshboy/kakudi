package com.kakudi.category.di.usecases

import com.kakudi.category.data.model.Category
import com.kakudi.category.data.repositories.CategoryRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CreateCategory @Inject constructor(private val repository: CategoryRepository) {

    fun execute(data: Category): Observable<Category> {
        return Observable.create {
            repository.insert(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.onNext(data)
                }, { err ->
                    err.printStackTrace()
                    it.onError(err)
                })
        }
    }
}