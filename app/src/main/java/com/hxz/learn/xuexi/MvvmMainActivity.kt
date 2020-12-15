package com.hxz.learn.xuexi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hxz.learn.R
import com.hxz.learn.databinding.ActivityMvvmMainBinding

class MvvmMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 笔记   ??   判断左右边是否为空,空显示右边数据

        val mData = DataBindingUtil.setContentView<ActivityMvvmMainBinding>(this, R.layout.activity_mvvm_main)
        mData.viewmodel = ViewModel("韩湘子", "15")


    }


}