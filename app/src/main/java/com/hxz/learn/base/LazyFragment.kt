package com.hxz.learn.base

import android.os.Bundle

/**
 * @Author:andy
 * @CreateDate:2020/12/24 17:53
 */
abstract class LazyFragment : BaseFragment() {


    private var isLoaded = false


    override fun onResume() {
        super.onResume()
        //增加了Fragment是否可见的判断
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        }
    }

    override fun init(savedInstanceState: Bundle?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()
}