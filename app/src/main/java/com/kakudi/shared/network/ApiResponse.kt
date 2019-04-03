package com.kakudi.shared.network

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 03/04/2019
 */

data class ApiResponse<T>(val status: Boolean, val message: String, val data: T)