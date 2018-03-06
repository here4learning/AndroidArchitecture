package org.sample.mcom.operation

import android.content.Context
import android.net.ConnectivityManager
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.sample.mcom.EComException
import org.sample.mcom.ECommerceApplication
import org.sample.mcom.model.BaseResponse
import java.io.IOException
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.security.GeneralSecurityException

abstract class WebServiceOperation<T> constructor(uri: String,
                                                  method: Int = Request.Method.GET,
                                                  body: String? = null,
                                                  type: Type,
                                                  tag: String) : Response.Listener<Any>, Response.ErrorListener {
    private val TIME_OUT_CONNECTION = 5000

    private var mClazzType: Type = type
    private var mTag: String = tag
    private var mWebServiceRequest: WebServiceRequest = WebServiceRequest(uri, method, body, this, this)

    var mRetry: Int = TIME_OUT_CONNECTION

    init {
        val policy = DefaultRetryPolicy(mRetry, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        mWebServiceRequest.retryPolicy = policy
    }

    open fun addToRequestQueue() {
        if (isOnline()) {
            mWebServiceRequest.setTag(mTag)
        } else {
            //  onError(EComException(ECommerceApplication.instance.getString(R.string.msg_err_no_network)))
        }
    }

    private fun isOnline(): Boolean {
        val cm = ECommerceApplication.instance!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo?.isConnectedOrConnecting!!
    }

    fun removeFromRequestQueue() {
        ECommerceApplication.instance!!.requestQueue.cancelAll(mTag)
    }

    override fun onErrorResponse(error: VolleyError) {
        onError(EComException(if (error.networkResponse != null) error.networkResponse.statusCode else 404))
    }

    override fun onResponse(response: Any) {
        val `object`: T?
        try {
            val responseString = response as String

            `object` = Gson().fromJson(responseString, mClazzType)
            /*}*/
            if (`object` != null) {
                var statusCode = HttpURLConnection.HTTP_OK
                var statusMessage = ""
                if (`object` is BaseResponse) {
                    val baseResponse = `object` as BaseResponse?
                    statusCode = baseResponse!!.statusCode
                    statusMessage = baseResponse.statusMessage!!
                }
                if (statusCode == HttpURLConnection.HTTP_OK || statusCode == HttpURLConnection.HTTP_CREATED) {
                    onSuccess(`object`)
                } else {
                    onError(EComException(statusCode, statusMessage))
                }
            } else {
                onError(EComException(404))
            }
        } catch (e: JsonSyntaxException) {
            onError(EComException(404))
        } catch (e: GeneralSecurityException) {
            onError(EComException(404))
        } catch (e: IOException) {
            onError(EComException(404))
        }

    }

    abstract fun onSuccess(response: T)
    abstract fun onError(exception: EComException)

}
