package com.suitmedia.reqres.view.user

import android.app.Activity
import androidx.core.content.ContextCompat
import com.jaeger.library.StatusBarUtil
import com.suitmedia.reqres.R
import com.suitmedia.reqres.base.BaseMvpActivity
import com.suitmedia.reqres.objects.Params
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_user.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

open class UserActivity: BaseMvpActivity<UserPresenter>(), UserContract.View, HasAndroidInjector {

    companion object {
        fun newInstance(activity: Activity, userName: String) {
            activity.startActivity(activity.intentFor<UserActivity>(Params.USER_NAME to userName))
        }
    }

    private var userName: String? = ""

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    override lateinit var presenter: UserPresenter

    override fun initPresenterView() {
        presenter.view = this
    }

    override fun injectView() {
        AndroidInjection.inject(this)
    }

    override fun setup() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.white_smoke), 0)
        StatusBarUtil.setLightMode(this)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        initBundle()
        initView()
        initAction()
    }

    override fun getLayout(): Int = R.layout.activity_user

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun initBundle(){
        intent?.extras?.let {
            userName = it.getString(Params.USER_NAME, "")
        }
    }

    private fun initView() {
        tvUserName.text = userName
    }

    private fun initAction() {
        btEvent.setOnClickListener {
            println("Event Clicked")
        }

        btGuest.setOnClickListener {
            println("Guest Clicked")
        }
    }
}