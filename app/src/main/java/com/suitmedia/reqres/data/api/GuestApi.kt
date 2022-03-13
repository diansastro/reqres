package com.suitmedia.reqres.data.api

import com.suitmedia.reqres.data.response.GuestResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface GuestApi {

    @GET("users")
    fun getGuestList(): Observable<Response<GuestResponse>>
}