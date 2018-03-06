package org.sample.mcom.product.model

import org.sample.mcom.BaseRequest

class ProductDetailRequest : BaseRequest() {
    var sku: String? = null
    var barcode: String? = null
    var isBarCode: Boolean = false

}
