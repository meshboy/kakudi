package com.kakudi.category.di.usecases

import com.kakudi.category.data.model.Category
import com.kakudi.category.data.repositories.CategoryRepository
import com.kakudi.shared.usecases.OneInputUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class FetchCategory @Inject constructor(private val repository: CategoryRepository) :
    OneInputUseCase<String, List<Category>> {
    override fun execute(input: String): Observable<List<Category>> {
        return repository
            .getAllCategories(userId = input)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}