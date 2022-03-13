package com.suitmedia.reqres.view.user

import android.content.Intent
import androidx.core.content.ContextCompat
import com.jaeger.library.StatusBarUtil
import com.suitmedia.reqres.R
import com.suitmedia.reqres.base.BaseMvpActivity
import com.suitmedia.reqres.view.event.EventActivity
import com.suitmedia.reqres.view.guest.GuestActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_user.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject


open class UserActivity: BaseMvpActivity<UserPresenter>(), UserContract.View, HasAndroidInjector {

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
        initView()
    }

    override fun getLayout(): Int = R.layout.activity_user

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun initView() {val intent = intent
        val extras = intent.extras

        if (extras?.getString("eventName").isNullOrBlank()) {
            tvUserName.text = intent.getStringExtra("userName")
            btEvent.text = getString(R.string.choose_event)
        } else {
            val u = extras?.getString("userName")
            val e = extras?.getString("eventName")

            tvUserName.text = u
            btEvent.text = e
        }

        btEvent.setOnClickListener {
            val i = Intent(this, EventActivity::class.java)
            i.putExtra("un", intent.getStringExtra("userName"))
            println("Intent : ${intent.getStringExtra("userName")}")
            startActivity(i)
        }

        btGuest.setOnClickListener {
            startActivity(intentFor<GuestActivity>())
        }
    }
}