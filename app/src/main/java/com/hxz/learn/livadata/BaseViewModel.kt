package com.hxz.learn.livadata

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * @Author:andy
 * @CreateDate:2020/12/12 18:16
 * @Description: 顶级ViewModel
 */
open class BaseViewModel(mApplication: Application) : AndroidViewModel(mApplication) {

    var mBaseLiveData = BaseLiveData()
}