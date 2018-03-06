package org.sample.mcom.basket.manager.operation

import com.android.volley.Request
import com.google.gson.reflect.TypeToken
import org.sample.mcom.EComException
import org.sample.mcom.account.model.LoginResponse
import org.sample.mcom.basket.model.AccountInfoResponse
import org.sample.mcom.constant.URLConstant
import org.sample.mcom.operation.WebServiceOperation

class GetSavedAccountInfoOperation(body: String, private var listener: OnGetSavedAccountInfoOperation) :
        WebServiceOperation<AccountInfoResponse>(URLConstant.ACCOUNT_SAVED_URI, Request.Method.POST, body,
                object : TypeToken<LoginResponse>() {}.type, GetSavedAccountInfoOperation::class.java.canonicalName as String) {

    interface OnGetSavedAccountInfoOperation {
        fun onGetSavedAccountInfoOperationSuccess(response: AccountInfoResponse)
        fun onGetSavedAccountInfoOperationError(exce: EComException)
    }

    override fun onError(exception: EComException) {
        listener.onGetSavedAccountInfoOperationError(exception)
    }

    override fun onSuccess(response: AccountInfoResponse) {
        listener.onGetSavedAccountInfoOperationSuccess(response)
    }
}
