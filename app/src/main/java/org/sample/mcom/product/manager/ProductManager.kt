package org.sample.mcom.product.manager

import com.google.gson.Gson
import org.sample.mcom.EComException
import org.sample.mcom.product.manager.operation.GetFeaturedProductListOperation
import org.sample.mcom.product.manager.operation.ProductDetailsOperation
import org.sample.mcom.product.model.Product
import org.sample.mcom.product.model.ProductDetailRequest

class ProductManager {

    interface OnGetProductListListener {
        fun onGetProductListSuccess(response: List<Product>)
        fun onGetProductListEmpty()
        fun onGetProductListError(exce: EComException)
    }

    fun getFeaturedProductList(listener: OnGetProductListListener?) {
        val operation = GetFeaturedProductListOperation(object : GetFeaturedProductListOperation.OnGetProductListOperation {
            override fun onGetProductListOperationSuccess(response: List<Product>) {
                if (response.isNotEmpty()) {
                    listener?.onGetProductListSuccess(response)
                } else {
                    listener?.onGetProductListEmpty()
                }
            }

            override fun onGetProductListOperationError(exce: EComException) {
                listener?.onGetProductListError(exce)
            }
        })
        operation.addToRequestQueue()
    }

    interface OnGetProductDetailsListener {
        fun onGetProductDetailsSuccess(response: Product)
        fun onGetProductDetailsError(exce: EComException)
    }

    fun getProductDetails(sku: String? = null, barcode: String? = null, listener: OnGetProductDetailsListener?) {
        val request = ProductDetailRequest()
        request.sku = sku
        request.barcode = barcode
        barcode?.apply {
            request.isBarCode = true
        }

        val operation = ProductDetailsOperation(Gson().toJson(request), object : ProductDetailsOperation.OnGetProductDetailsOperation {
            override fun onGetProductDetailsOperationSuccess(response: Product) {
                listener?.onGetProductDetailsSuccess(response)
            }

            override fun onGetProductDetailsOperationError(exce: EComException) {
                listener?.onGetProductDetailsError(exce)
            }
        })
        operation.addToRequestQueue()
    }
}