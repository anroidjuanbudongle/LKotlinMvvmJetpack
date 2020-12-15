package com.hxz.learn.livadata

import androidx.lifecycle.MutableLiveData

/**
 * @Author:andy
 * @CreateDate:2020/12/12 16:47
 * @Description:通知基类
 */
class BaseLiveData {
    /**
     *  成功通知
     */
    val SUCCESS by lazy { MutableLiveData<BaseLiveDataType>() }

    /**
     * 失败通知
     */
    val FAILURE by lazy { MutableLiveData<BaseLiveDataType>() }

    /**
     * 刷新
     */
    val REFRESH by lazy { MutableLiveData<BaseLiveDataType>() }

    /**
     * 加载更多
     */
    val LOAD_MORE by lazy { MutableLiveData<BaseLiveDataType>() }

    /**
     * 空数据处理
     */
    val EMPTY_DATA by lazy { MutableLiveData<BaseLiveDataType>() }

}