package org.sample.mcom.user.model

import org.sample.mcom.model.BaseResponse

class UserInfo : BaseResponse() {
    var id: String? = null
    var fName: String? = null
    var lName: String? = null
    var gender: Int? = 0
    var sex: Int? = 0
    var addressList: List<Address>? = null
}