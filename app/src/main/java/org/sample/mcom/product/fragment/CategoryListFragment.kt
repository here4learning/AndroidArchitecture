package org.sample.mcom.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sample.mcom.BaseFragment
import org.sample.mcom.R

class CategoryListFragment : BaseFragment() {

    companion object {
        fun newInstance(): CategoryListFragment {
            return CategoryListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        return view
    }

}