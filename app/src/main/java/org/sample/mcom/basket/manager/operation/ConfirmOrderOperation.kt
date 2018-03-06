package org.sample.mcom.basket.manager.operation

import com.android.volley.Request
import com.google.gson.reflect.TypeToken
import org.sample.mcom.EComException
import org.sample.mcom.basket.model.BasketResponse
import org.sample.mcom.constant.URLConstant
import org.sample.mcom.operation.WebServiceOperation

class ConfirmOrderOperation(body: String, private var listener: OnConfirmOrderOperation) :
        WebServiceOperation<BasketResponse>(URLConstant.CONFIRM_ORDER_URI, Request.Method.POST, body,
                object : TypeToken<BasketResponse>() {}.type, ConfirmOrderOperation::class.java.canonicalName as String) {

    interface OnConfirmOrderOperation {
        fun onConfirmOrderOperationSuccess(response: BasketResponse)
        fun onConfirmOrderOperationError(exce: EComException)
    }

    override fun onError(exception: EComException) {
        listener.onConfirmOrderOperationError(exception)
    }

    override fun onSuccess(response: BasketResponse) {
        listener.onConfirmOrderOperationSuccess(response)
    }
}
