package com.kakudi.category.di.usecases

import android.annotation.SuppressLint
import com.kakudi.category.data.model.Category
import com.kakudi.category.data.repositories.CategoryRepository
import com.kakudi.shared.usecases.NoOutputCase
import com.kakudi.shared.usecases.OneInputUseCase
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CreateCategory @Inject constructor(private val repository: CategoryRepository) {

    fun execute(data: Category): Completable {
        return repository.insert(data)
    }
}