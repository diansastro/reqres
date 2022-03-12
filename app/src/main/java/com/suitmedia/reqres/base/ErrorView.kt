package com.suitmedia.reqres.base

interface ErrorView {
    fun errorScreen(message: String? = "", code: Int? = -1)
    fun errorScreen(message: String? = "")
    fun forceLogout()
}