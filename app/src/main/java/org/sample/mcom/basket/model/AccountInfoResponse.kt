package org.sample.mcom.basket.model

import org.sample.mcom.user.model.Address

class AccountInfoResponse {
    var creditList: List<CreditCardInfo>? = null
    var addressList: List<Address>? = null

}