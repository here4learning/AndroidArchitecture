package org.sample.mcom.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sample.mcom.BaseFragment
import org.sample.mcom.EComException
import org.sample.mcom.R
import org.sample.mcom.product.manager.ProductManager
import org.sample.mcom.product.model.Product

class FeaturedProductListFragment : BaseFragment(), ProductManager.OnGetProductListListener {

    companion object {
        fun newInstance(): FeaturedProductListFragment {
            return FeaturedProductListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        return view
    }

    override fun onGetProductListSuccess(response: List<Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetProductListEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetProductListError(exce: EComException) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}