package org.sample.mcom.account.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.sample.mcom.BaseFragment
import org.sample.mcom.EComException
import org.sample.mcom.R
import org.sample.mcom.account.manager.AccountManager

class LoginFragment : BaseFragment(), AccountManager.OnLoginOperationListener {

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val editTextUsername = view.edittext_username
        val editTextPassword = view.edittext_password

        view.button_login.setOnClickListener {
            AccountManager().doLogin(editTextUsername.text.toString(), editTextPassword.text.toString(), this)
        }
        return view
    }

    override fun onLoginOperationSuccess() {
        //success
    }

    override fun onLoginOperationError(exec: EComException) {
        //error message
    }

}