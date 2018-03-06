package org.sample.mcom

import android.support.v4.app.DialogFragment


/**
 * A base fragment that handles common functionality in the app.
 */
abstract class BaseFragment : DialogFragment() {

    val isDialog: Boolean
        get() = dialog != null

    override fun onResume() {
        super.onResume()
        if (view != null) {
            view!!.isClickable = true
        }
    }

    fun replaceChildFragment(containerId: Int, fragment: BaseFragment) {
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.commit()
    }

    fun addChildFragment(containerId: Int, fragment: BaseFragment) {
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(containerId, fragment)
        transaction.commit()
    }

    fun add(containerId: Int, fragment: BaseFragment) {
        activity?.apply {
            (this as BaseActivity).add(containerId, fragment)
        }
    }

    fun replace(containerId: Int, fragment: BaseFragment) {
        activity?.apply {
            (this as BaseActivity).replace(containerId, fragment)
        }
    }

    fun pop() {
        activity?.apply {
            if (isDialog) {
                dismiss()
            } else {
                this.supportFragmentManager.popBackStack()
            }
        }
    }

    fun onBackPress() {
        if (isDialog) {
            dialog.dismiss()
        } else {
            pop()
        }
    }


}
