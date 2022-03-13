package com.suitmedia.reqres.di.builder

import com.suitmedia.reqres.view.event.EventActivity
import com.suitmedia.reqres.view.guest.GuestActivity
import com.suitmedia.reqres.view.home.HomeActivity
import com.suitmedia.reqres.view.user.UserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun bindUserActivity(): UserActivity

    @ContributesAndroidInjector
    abstract fun bindEventActivity(): EventActivity

    @ContributesAndroidInjector
    abstract fun bindGuestActivity(): GuestActivity
}