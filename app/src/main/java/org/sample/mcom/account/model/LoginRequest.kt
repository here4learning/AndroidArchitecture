package org.sample.mcom.account.model

import org.sample.mcom.BaseRequest

class LoginRequest : BaseRequest() {
    var username: String? = null
    var password: String? = null
}