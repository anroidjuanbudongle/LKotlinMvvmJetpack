package com.hxz.learn.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.hxz.learn.R
import com.hxz.learn.common.initFragment
import com.hxz.learn.config.DataBindingConfig
import com.hxz.learn.fragment.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @Author:andy
 * @CreateDate:2020/12/21 13:32
 * @Description:调度其他首页
 */


class HomeFragment : BaseFragment() {

    private val mFrgList = arrayListOf<Fragment>()

    private val mMainFragment by lazy { MainFragment() }
    private val mProjectFragment by lazy { ProjectFragment() }
    private val mSquareFragment by lazy { SquareFragment() }
    private val mPublicNumberFragment by lazy { PublicNumberFragment() }
    private val mMineFragment by lazy { MineFragment() }

    init {
        mFrgList.apply {
            add(mMainFragment)
            add(mProjectFragment)
            add(mSquareFragment)
            add(mPublicNumberFragment)
            add(mMineFragment)
        }
    }


    override fun init(savedInstanceState: Bundle?) {
        //初始化fragment
        /**
         * 上下文对象可用作接收者（this）
         * run作为上下文对象的扩展功能，其功能与相同with但调用为let-。
         */
        vpHome.initFragment(this, mFrgList).run {
            //全部缓存,避免切换回重新加载
            offscreenPageLimit = mFrgList.size
        }
        //取消viewPager2滑动
        vpHome.isUserInputEnabled = false
        //注册底部切换事件监听
        vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                btnNav.menu.getItem(position).isChecked = true
            }
        })
        //初始化底部导航栏
        btnNav.run {
            setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> vpHome.setCurrentItem(0, false)
                    R.id.navigation_project -> vpHome.setCurrentItem(1, false)
                    R.id.navigation_navigation -> vpHome.setCurrentItem(2, false)
                    R.id.navigation_wx -> vpHome.setCurrentItem(3, false)
                    R.id.navigation_mine -> vpHome.setCurrentItem(4, false)
                }
                // 这里注意返回true,否则点击失效
                true
            }
        }
    }


    override fun getLayoutId() = R.layout.fragment_home


    override fun getDataBindingConfig(): DataBindingConfig? {
        return null
    }


}