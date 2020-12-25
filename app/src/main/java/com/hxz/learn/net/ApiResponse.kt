package com.hxz.learn.net

import java.io.Serializable

/**
 * @author andy
 * @Date 2020/12/24 22:55
 * @Description:统一处理回来的数据
 */

class ApiResponse<T> : Serializable {

    private var mData: T? = null
    private var mErrCode: Int = 0
    private var mErrMsg: String = ""

    /**
     * 如果某些接口存在data为null的情况,需传入class对象
     * 生成空对象。避免后面做一系列空判断
     */
    fun data(clazz: Class<T>): T {
        when (mErrCode) {
            //请求成功
            0, 200 -> {
                //避免业务层做null判断,通过反射将null替换为T类型空对象
                if (mData == null) {
                    mData = clazz.newInstance()
                }
                return mData!!
            }
            //未登陆请求需要用户信息的接口
            -1001 -> {
                throw ApiError("请先登陆", -1)
            }
            //登录失败
            -1 -> {
                throw ApiError("登陆失败", -1)
            }
        }
        //未知错误
        throw ApiError(mErrMsg, mErrCode)
    }

}

/**
 * 错误处理
 */
class ApiError(var mErrorMsg: String, var mErrorCode: Int) : Throwable()