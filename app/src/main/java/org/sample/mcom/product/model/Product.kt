package org.sample.mcom.product.model

class Product {
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var skuId: String? = null
    var imageURlList: List<String>? = null
    var colorList: List<String>? = null
    var sizeList: List<Int>? = null
    var originalPrice: String? = null
    var discountPrice: String? = null
    var taxPrice: Tax? = null
    var quantity: Int = 0
}
