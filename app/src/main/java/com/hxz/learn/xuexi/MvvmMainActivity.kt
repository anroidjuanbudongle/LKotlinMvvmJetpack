package com.hxz.learn.xuexi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hxz.learn.R
import com.hxz.learn.databinding.ActivityMvvmMainBinding
import com.hxz.learn.utils.Logger
import io.reactivex.disposables.Disposable
import io.reactivex.Observer

class MvvmMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 笔记   ??   判断左右边是否为空,空显示右边数据

        val mData = DataBindingUtil.setContentView<ActivityMvvmMainBinding>(this, R.layout.activity_mvvm_main)
        mData.viewmodel = ViewModel("韩湘子", "15")






        val observer: Observer<String> = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Logger.d("onSubscribe")
            }
            override fun onNext(s: String) {
                Logger.d("onNext")

            }
            override fun onError(e: Throwable) {
                Logger.d("onError")

            }
            override fun onComplete() {
                Logger.d("onComplete")

            }
        }




    }


}