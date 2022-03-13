package com.suitmedia.reqres.data.entity

import android.content.Context
import com.suitmedia.reqres.data.BasicAbstractNetwork
import com.suitmedia.reqres.data.api.GuestApi
import com.suitmedia.reqres.data.response.GuestResponse
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class GuestEntity @Inject constructor(context: Context): BasicAbstractNetwork<GuestApi>(context) {
    override fun getApi(): Class<GuestApi> = GuestApi::class.java

    fun getGuestList(): Observable<Response<GuestResponse>> = networkService().getGuestList()
}