package com.suitmedia.reqres.view.user

import com.suitmedia.reqres.base.BasePresenter
import javax.inject.Inject

class UserPresenter @Inject constructor(): BasePresenter<UserContract.View>(), UserContract.Presenter {
}