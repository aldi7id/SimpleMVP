package com.ajgroup.simplemvp

import android.text.TextUtils

class MainPresenterImp(private  val view: MainView) : MainPresenter {
    private  val STUDENT = mutableListOf<Student>()

    override fun addData(firstName: String, lastName: String) {
        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)) {
            view.showMessage("Field tidak boleh kosong")
        } else {
            STUDENT.run {
                add(Student(firstName, lastName))
            }
            view.showMessage("Data ditambahkan")
            view.clearField()
        }
    }

    override fun loadData() {
        if (STUDENT.size == 0) {
            view.showMessage("Data Kosong")
        } else {
            var allData = ""

            for (i in 0 until STUDENT.size) {
                allData += STUDENT[i].firstName + " " + STUDENT[i].lastName + "\n \n"
            }
            allData += "Total: " + STUDENT.size
            view.showData(allData)
        }
    }
}