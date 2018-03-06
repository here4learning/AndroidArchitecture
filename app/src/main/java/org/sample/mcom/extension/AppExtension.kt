package org.sample.mcom.extension

import android.annotation.SuppressLint
import android.provider.Settings.Secure
import org.sample.mcom.ECommerceApplication

@SuppressLint("HardwareIds")
val DeviceId: String = Secure.getString(ECommerceApplication.instance!!.contentResolver, Secure.ANDROID_ID)

