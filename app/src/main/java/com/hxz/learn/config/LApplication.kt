package com.hxz.learn.config

import android.content.Context
import androidx.multidex.MultiDexApplication

/**
 * @Author:andy
 * @CreateDate:2020/12/12 18:47
 * @Description:
 */
class LApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }

    companion object{
        private lateinit var baseApplication: LApplication

        fun getContext(): Context {
            return baseApplication
        }
    }



}