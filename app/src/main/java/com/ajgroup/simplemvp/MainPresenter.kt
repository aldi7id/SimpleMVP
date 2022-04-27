package com.ajgroup.simplemvp

interface MainPresenter {
    fun addData(firstName: String, lastName: String)

    fun loadData()
}