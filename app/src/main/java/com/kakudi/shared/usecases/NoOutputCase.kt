package com.kakudi.shared.usecases

import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */

interface NoOutputCase<I> {
    fun execute(data: I): Observable<Unit>
}