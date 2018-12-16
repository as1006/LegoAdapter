package com.xincubate.lego.sample

import android.app.Application
import com.xincubate.lego.generate.LegoRegisterUtils

class LegoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LegoRegisterUtils.init()
    }
}
