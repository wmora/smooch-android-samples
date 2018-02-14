package io.smooch.samples

import android.app.Application
import io.smooch.core.Smooch

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Smooch.init(this)
    }

}