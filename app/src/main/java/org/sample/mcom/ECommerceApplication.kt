package org.sample.mcom

import android.app.Application
import android.content.Context

import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class ECommerceApplication : Application() {

    private var mRequestQueue: RequestQueue? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        mRequestQueue = Volley.newRequestQueue(applicationContext)
    }

    val requestQueue: RequestQueue
        get() {
            return mRequestQueue!!
        }

    companion object {
        var instance: ECommerceApplication? = null
    }

}
