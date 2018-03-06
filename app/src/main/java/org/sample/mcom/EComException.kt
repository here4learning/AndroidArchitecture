package org.sample.mcom


class EComException(var code: Int = 404, statusMessage: String?=null) : Exception() {

}
