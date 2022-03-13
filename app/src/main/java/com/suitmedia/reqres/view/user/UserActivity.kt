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

//    companion object {
//        fun newInstance(activity: Activity, userName: String) {
//            activity.startActivity(activity.intentFor<UserActivity>(Params.USER_NAME to userName))
//        }
//
//        fun newInstanceEvent(activity: Activity, eventName: String, userName: String) {
//            activity.startActivity(activity.intentFor<UserActivity>(Params.EVENT_NAME to eventName, userName to Params.USER_NAME))
//        }
//    }

//    private var userName: String? = ""
//    private var eventName: String? = ""
//    private val uName = intent.getStringExtra("userName")

//    private var un = intent.getStringExtra("userName")

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
//        initBundle()
        initView()
        initAction()
    }

    override fun getLayout(): Int = R.layout.activity_user

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

//    private fun initBundle(){
//        intent?.extras?.let {
//            userName = it.getString(Params.USER_NAME, "")
//        }
//
//        intent?.extras?.let {
//            eventName = it.getString(Params.EVENT_NAME, "")
//        }
//    }

    private fun initView() {
//        tvUserName.text = userName
//        btEvent.text = eventName


        val intent = intent
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
    }

    private fun initAction() {
        btEvent.setOnClickListener {
//            EventActivity.newInstance(this, userName!!)
            val intent = Intent(this, EventActivity::class.java)
            intent.putExtra("un", intent.getStringExtra("userName"))
            println("Extra : ${intent.getStringExtra("userName")}")
            startActivity(intent)
        }

        btGuest.setOnClickListener {
            startActivity(intentFor<GuestActivity>())
        }
    }
}