package org.sample.mcom.product.manager.operation

import com.google.gson.reflect.TypeToken
import org.sample.mcom.EComException
import org.sample.mcom.constant.URLConstant
import org.sample.mcom.operation.WebServiceOperation
import org.sample.mcom.product.model.Product

class GetFeaturedProductListOperation(private var listener: OnGetProductListOperation) :
        WebServiceOperation<List<Product>>(uri = URLConstant.GET_FEATURED_PRODUCT_URI,
                type = object : TypeToken<List<Product>>() {}.type,
                tag = GetFeaturedProductListOperation::class.java.canonicalName as String) {

    interface OnGetProductListOperation {
        fun onGetProductListOperationSuccess(response: List<Product>)
        fun onGetProductListOperationError(exce: EComException)
    }

    override fun onError(exception: EComException) {
        listener.onGetProductListOperationError(exception)
    }

    override fun onSuccess(response: List<Product>) {
        listener.onGetProductListOperationSuccess(response)
    }
}