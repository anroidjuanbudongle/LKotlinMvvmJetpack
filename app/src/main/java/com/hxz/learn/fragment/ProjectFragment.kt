package com.hxz.learn.fragment

import com.hxz.learn.R
import com.hxz.learn.base.LazyFragment
import com.hxz.learn.config.DataBindingConfig

/**
 * @Author:andy
 * @CreateDate:2020/12/24 18:45
 * @Description:公众号
 */
class ProjectFragment : LazyFragment(){
    override fun lazyInit() {

    }

    override fun getLayoutId() = R.layout.fragment_mine

    override fun getDataBindingConfig(): DataBindingConfig? {
        return null
    }
}