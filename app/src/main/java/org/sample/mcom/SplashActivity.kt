package org.sample.mcom

import android.content.Intent
import android.os.Bundle

import java.util.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
                }
            }

        }, 500L)
    }
}
