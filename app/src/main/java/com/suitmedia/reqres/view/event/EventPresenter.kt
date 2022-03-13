package com.suitmedia.reqres.view.event

import com.suitmedia.reqres.base.BasePresenter
import javax.inject.Inject

class EventPresenter @Inject constructor(): BasePresenter<EventContract.View>(), EventContract.Presenter {
}