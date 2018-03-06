package org.sample.mcom

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import org.sample.mcom.BaseFragment
import org.sample.mcom.R
import org.sample.mcom.product.fragment.CategoryListFragment
import org.sample.mcom.product.fragment.FeaturedProductListFragment
import org.sample.mcom.product.fragment.OutfitFragment
import org.sample.mcom.settings.fragment.SettingFragment

class DashboardFragment : BaseFragment() {
    companion object {
        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val viewPager = view.viewpager_dashboard
        viewPager.adapter = PagerAdapter(fragmentManager)
        return view
    }


    inner class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        val TAB_TITLE = intArrayOf(R.string.tab_featured, R.string.tab_category, R.string.text_outfit, R.string.text_setting)
        override fun getItem(index: Int): BaseFragment? {
            var fragment: BaseFragment? = null
            when (index) {
                0 ->
                    fragment = FeaturedProductListFragment.newInstance()
                1 ->
                    fragment = CategoryListFragment.newInstance();
                2 ->
                    fragment = OutfitFragment.newInstance();
                3 ->
                    fragment = SettingFragment.newInstance();
            }

            return fragment
        }

        override fun getCount(): Int {
            return TAB_TITLE.count()
        }

        override fun getPageTitle(position: Int): CharSequence {
            return getString(TAB_TITLE[position])
        }


    }

}