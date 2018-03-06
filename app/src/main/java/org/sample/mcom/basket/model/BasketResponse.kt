package org.sample.mcom.basket.model

import org.sample.mcom.model.BaseResponse
import org.sample.mcom.product.model.Product
import org.sample.mcom.user.model.Address

class BasketResponse : BaseResponse() {
    var orderId: String? = null
    var userId: String? = null
    var deliverAddress: Address? = null
    var cartList: List<Product>? = null
    var paymentParameter: PaymentParameter? = null

    class PaymentParameter {
        var orderId: String? = null
        var successURl: String? = null
        var failureURl: String? = null
        //more has to be added
    }
}

