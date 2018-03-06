package org.sample.mcom.product.manager.operation

import com.android.volley.Request
import com.google.gson.reflect.TypeToken
import org.sample.mcom.EComException
import org.sample.mcom.constant.URLConstant
import org.sample.mcom.operation.WebServiceOperation
import org.sample.mcom.product.model.Product

class ProductDetailsOperation(private var body: String, private var listener: OnGetProductDetailsOperation) :
        WebServiceOperation<Product>(URLConstant.GET_PRODUCT_DETAILS, Request.Method.POST, body,
                object : TypeToken<List<Product>>() {}.type,
                ProductDetailsOperation::class.java.canonicalName as String) {

    interface OnGetProductDetailsOperation {
        fun onGetProductDetailsOperationSuccess(response: Product)
        fun onGetProductDetailsOperationError(exce: EComException)
    }

    override fun onError(exception: EComException) {
        listener.onGetProductDetailsOperationError(exception)
    }

    override fun onSuccess(response: Product) {
        listener.onGetProductDetailsOperationSuccess(response)
    }
}