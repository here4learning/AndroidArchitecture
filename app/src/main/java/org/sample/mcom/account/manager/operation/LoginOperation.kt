package org.sample.mcom.account.manager.operation

import com.android.volley.Request
import com.google.gson.reflect.TypeToken
import org.sample.mcom.EComException
import org.sample.mcom.EComPreference
import org.sample.mcom.account.model.LoginResponse
import org.sample.mcom.constant.URLConstant
import org.sample.mcom.operation.WebServiceOperation

class LoginOperation(body: String, private var listener: OnLoginOperationListener) :
        WebServiceOperation<LoginResponse>(URLConstant.LOGIN_URI, Request.Method.POST, body,
                object : TypeToken<LoginResponse>() {}.type, LoginOperation::class.java.canonicalName as String) {

    interface OnLoginOperationListener {
        fun onLoginOperationSuccess()
        fun onLoginOperationError(exce: EComException)
    }

    override fun onError(exception: EComException) {
        listener.onLoginOperationError(exception)
    }

    override fun onSuccess(response: LoginResponse) {
        EComPreference.mInstance.setToken(response.token)
        listener.onLoginOperationSuccess()
    }
}
