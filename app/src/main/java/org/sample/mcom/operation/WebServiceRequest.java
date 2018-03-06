package org.sample.mcom.operation;

import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class WebServiceRequest extends Request {

    private final Gson gson = new Gson();
    private String mBody;
    private Response.Listener mListener;

    public WebServiceRequest(String url, int method,
                             String body, Response.Listener responseListener,
                             Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mBody = body;
        this.mListener = responseListener;

    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        // Map headers = super.getHeaders();
        //headers.put("Content-Type", "application/json;charset=utf8");

        return super.getHeaders();
    }

    @Override
    public String getBodyContentType() {
        return "application/json;charset=utf8";
    }


    /**
     * Returns the raw POST or PUT body to be sent.
     *
     * @throws AuthFailureError in the event of auth failure
     */
    public byte[] getBody() throws AuthFailureError {
        if (!TextUtils.isEmpty(mBody)) {
            return mBody.getBytes();
        }
        return null;

    }

    @Override
    protected void deliverResponse(Object response) {
        if (mListener != null)
            mListener.onResponse(response);
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data, "UTF-8");
            return Response.success(json,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }
}

