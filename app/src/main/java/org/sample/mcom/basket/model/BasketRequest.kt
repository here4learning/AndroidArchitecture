package org.sample.mcom.basket.model

import org.sample.mcom.EComPreference
import org.sample.mcom.product.model.Product
import org.sample.mcom.user.model.Address

class BasketRequest {
    var tokenId: String? = EComPreference.mInstance.getToken()
    var userId: String? = null
    var deliverAddress: Address? = null
    var cartList: List<Product>? = null
}