package com.suitmedia.reqres.view.guest

import com.suitmedia.reqres.base.BasePresenter
import com.suitmedia.reqres.data.entity.GuestEntity
import com.suitmedia.reqres.extension.uiSubscribe
import com.suitmedia.reqres.objects.NetworkCode
import javax.inject.Inject

class GuestPresenter @Inject constructor(val guestEntity: GuestEntity): BasePresenter<GuestContract.View>(), GuestContract.Presenter {
    override fun execGuestList() {
        addSubscription(guestEntity.getGuestList().uiSubscribe({
            when(it.code()) {
                NetworkCode.CODE_OK -> view?.getGuestList(it.body())
                else -> {
                    view?.errorScreen("Unable to Load Data")
                }
            }
        }, {
           view?.errorScreen(it.localizedMessage)
        }, {}))
    }
}