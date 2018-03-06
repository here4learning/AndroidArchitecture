package org.sample.mcom

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun setTitle(title: String) {
        supportActionBar?.apply {
            this.title = title
            setSubTitle("")
            this.setDisplayShowTitleEnabled(true)
            this.setDisplayShowHomeEnabled(true)
        }
    }

    override fun setTitle(resId: Int) {
        setTitle(getString(resId))
    }

    fun setSubTitle(title: String) {
        supportActionBar?.apply {
            this.subtitle = title
        }
    }

    fun add(containerId: Int, fragment: BaseFragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(containerId, fragment,
                Integer.toString(supportFragmentManager.backStackEntryCount)).addToBackStack(null).commit()
        supportFragmentManager.executePendingTransactions()
    }

    fun replace(containerId: Int, fragment: BaseFragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(containerId, fragment,
                Integer.toString(supportFragmentManager.backStackEntryCount)).addToBackStack(null).commit()
        supportFragmentManager.executePendingTransactions()
    }

    fun pop() {
        val fm = supportFragmentManager
        fm.popBackStackImmediate()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count <= 1) {
            finish()
        } else {
            val fragment = supportFragmentManager.findFragmentByTag("${(count - 1)}")
            fragment?.apply {
                (fragment as BaseFragment).onBackPress()
            }
        }
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> {
                val fragment = supportFragmentManager.findFragmentByTag(
                        "${(supportFragmentManager.backStackEntryCount - 1)}")
                if (supportFragmentManager.backStackEntryCount > 1) {
                    onBackPressed()
                }
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

}

