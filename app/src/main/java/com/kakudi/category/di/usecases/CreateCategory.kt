package com.kakudi.category.di.usecases

import android.annotation.SuppressLint
import com.kakudi.category.data.model.Category
import com.kakudi.category.data.repositories.CategoryRepository
import com.kakudi.shared.usecases.NoOutputCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CreateCategory @Inject constructor(private val repository: CategoryRepository) :
    NoOutputCase<Category> {
    @SuppressLint("CheckResult")
    override fun execute(input: Category): Observable<Unit> {
        return repository.insert(input)
    }
}