package com.suitmedia.reqres.view.guest

import com.suitmedia.reqres.base.ErrorView
import com.suitmedia.reqres.data.response.GuestResponse

interface GuestContract {
    interface View: ErrorView {
        fun getGuestList(guestResponse: GuestResponse?)
    }

    interface Presenter {
        fun execGuestList()
    }
}