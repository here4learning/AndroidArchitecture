package org.sample.mcom

import android.os.Bundle


class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        replace(R.id.rlayout_container, DashboardFragment.newInstance())
    }
}
