package org.sample.mcom.account.manager

import com.google.gson.Gson
import org.sample.mcom.EComException
import org.sample.mcom.account.manager.operation.LoginOperation
import org.sample.mcom.account.model.LoginRequest

class AccountManager {

    interface OnLoginOperationListener {
        fun onLoginOperationSuccess()
        fun onLoginOperationError(exec: EComException)
    }

    fun doLogin(username: String, pwd: String, listener: OnLoginOperationListener?) {
        val request = LoginRequest()
        request.username = username
        request.password = pwd

        val operation = LoginOperation(Gson().toJson(request), object : LoginOperation.OnLoginOperationListener {
            override fun onLoginOperationSuccess() {
                listener?.onLoginOperationSuccess()
            }

            override fun onLoginOperationError(exce: EComException) {
                listener?.onLoginOperationError(exce)
            }
        })
        operation.addToRequestQueue()
    }
}