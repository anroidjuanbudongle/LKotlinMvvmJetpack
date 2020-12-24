package com.hxz.learn.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hxz.learn.R
import com.hxz.learn.utils.ColorUtils
import com.hxz.learn.utils.StatusUtils

/**
 * @Author:andy
 * @CreateDate:2020/12/12 18:37
 */
abstract class BaseActivity : AppCompatActivity() {

    private var mActivityProvider: ViewModelProvider? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let { //此时let在不为null的时候执行setContentView
            setContentView(it)
        }
        setStatusBg()
        init(savedInstanceState)
    }


    //通过activity获取viewModel，跟随activity生命周期
    protected fun <T : ViewModel?> getActivityViewModel(modelClass: Class<T>): T? {
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this)
        }
        return mActivityProvider?.get(modelClass)
    }


    open fun setStatusBg() {
        StatusUtils.setUseStatusBarColor(this, ColorUtils.parseColor(R.color.app_color))
    }

    //获取layout布局
    abstract fun getLayoutId(): Int?

    //入口
    abstract fun init(bundle: Bundle?)


    //初始化viewModel,之所以没有设计为抽象，是因为部分简单activity可能不需要viewModel,observe同理
    open fun initViewModel() {}
}