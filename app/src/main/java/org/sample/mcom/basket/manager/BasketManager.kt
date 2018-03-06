package org.sample.mcom.basket.manager

import com.google.gson.Gson
import org.sample.mcom.BaseRequest
import org.sample.mcom.EComException
import org.sample.mcom.basket.manager.operation.ConfirmOrderOperation
import org.sample.mcom.basket.manager.operation.GetSavedAccountInfoOperation
import org.sample.mcom.basket.model.AccountInfoRequest
import org.sample.mcom.basket.model.AccountInfoResponse
import org.sample.mcom.basket.model.BasketResponse

class BasketManager {

    interface OnGetSavedAccountInfoListener {
        fun onGetSavedAccountInfoSuccess(response: AccountInfoResponse)
        fun onGetSavedAccountInfoError(exce: EComException)
    }

    fun getSavedAccountData(listener: OnGetSavedAccountInfoListener?) {
        val operation = GetSavedAccountInfoOperation(Gson().toJson(AccountInfoRequest()), object : GetSavedAccountInfoOperation.OnGetSavedAccountInfoOperation {
            override fun onGetSavedAccountInfoOperationSuccess(response: AccountInfoResponse) {
                listener?.onGetSavedAccountInfoSuccess(response)
            }

            override fun onGetSavedAccountInfoOperationError(exce: EComException) {
                listener?.onGetSavedAccountInfoError(exce)
            }
        })
        operation.addToRequestQueue()
    }

    interface OnConfirmOrderListener {
        fun onConfirmOrderSuccess(response: BasketResponse)
        fun onConfirmOrderError(exce: EComException)
    }

    fun confirmOrder(listener: OnConfirmOrderListener?) {
        val operation = ConfirmOrderOperation(Gson().toJson(BaseRequest()), object : ConfirmOrderOperation.OnConfirmOrderOperation {
            override fun onConfirmOrderOperationSuccess(response: BasketResponse) {
                listener?.onConfirmOrderSuccess(response)
            }

            override fun onConfirmOrderOperationError(exce: EComException) {
                listener?.onConfirmOrderError(exce)
            }
        })
        operation.addToRequestQueue()
    }
}