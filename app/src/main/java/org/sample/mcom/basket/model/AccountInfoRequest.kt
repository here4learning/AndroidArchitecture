package org.sample.mcom.basket.model

import org.sample.mcom.BaseRequest
import org.sample.mcom.EComPreference
import org.sample.mcom.user.model.Address

class AccountInfoRequest : BaseRequest() {
    var tokenId: String? = EComPreference.mInstance.getToken()
}