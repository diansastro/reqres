package com.suitmedia.reqres.view.event

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaeger.library.StatusBarUtil
import com.suitmedia.reqres.R
import com.suitmedia.reqres.base.BaseMvpActivity
import com.suitmedia.reqres.model.EventData
import com.suitmedia.reqres.objects.Params
import com.suitmedia.reqres.view.adapter.EventAdapter
import com.suitmedia.reqres.view.user.UserActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.nav_bar_event.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject


open class EventActivity: BaseMvpActivity<EventPresenter>(), EventContract.View {

//    companion object {
//        fun newInstance(activity: Activity, userName: String) {
//            activity.startActivity(activity.intentFor<EventActivity>(Params.USER_NAME to userName))
//        }
//    }

//    private var userName: String? = ""

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    override lateinit var presenter: EventPresenter

    private val eventData = arrayListOf<EventData>()
    private lateinit var eventAdapter: EventAdapter

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

    override fun getLayout(): Int = R.layout.activity_event

//    private fun initBundle(){
//        intent?.extras?.let {
//            userName = it.getString(Params.USER_NAME, "")
//        }
//    }

    private fun initView() {
        println("Extra : ${intent.getStringExtra("un")}")
        eventData.add(EventData(1, "Dummy Event 1", "2 April, 2022", ""))
        eventData.add(EventData(2, "Dummy Event 2", "4 May, 2022", ""))
        eventData.add(EventData(3, "Dummy Event 3", "20 June, 2022", ""))
        eventData.add(EventData(4, "Dummy Event 4", "28 August, 2022", ""))

        eventAdapter = EventAdapter(eventData)
        eventAdapter.apply {
            setOnItemClickListener { adapter, view, position ->
//                UserActivity.newInstanceEvent(this@EventActivity, eventData[position].eventName!!, userName!!)
                val extras = Bundle()
                val i = Intent(this@EventActivity, UserActivity::class.java)
//                extras.putString("userName", i.getStringExtra("un"))
                extras.putString("eventName", eventData[position].eventName!!)

                i.putExtras(extras)
                startActivity(i)
            }
            notifyDataSetChanged()
        }

        rvEventList.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL, false)
            isNestedScrollingEnabled = false
        }
    }

    private fun initAction() {
        ivBackEvent.setOnClickListener { onBackPressed() }
    }
}