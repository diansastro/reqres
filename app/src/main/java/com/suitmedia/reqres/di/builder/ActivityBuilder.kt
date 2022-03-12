package com.suitmedia.reqres.di.builder

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
}