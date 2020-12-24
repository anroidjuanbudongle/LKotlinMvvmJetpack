package com.hxz.learn.common

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

/**
 * @Author:andy
 * @CreateDate:2020/12/24 18:59
 * @Description:扩展
 */

fun ViewPager2.initFragment(mFragment: Fragment, mFragments: MutableList<Fragment>): ViewPager2 {
    //设置适配器
    adapter = object : FragmentStateAdapter(mFragment) {
        override fun createFragment(position: Int) = mFragments[position]
        override fun getItemCount() = mFragments.size
    }
    return this
}