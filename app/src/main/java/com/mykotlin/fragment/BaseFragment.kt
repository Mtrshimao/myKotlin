package com.mykotlin.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * desc
 * Author:shimao
 *   Date:2018.08.21 14:27
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (inflater != null) {
            return inflater.inflate(setContentLayout(), container, false)
        }
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        if (view != null) {
            initView(view)
        }
    }

    protected abstract fun setContentLayout(): Int

    /**初始化数据 */
    protected abstract fun initData()

    /**初始化视图 */
    protected abstract fun initView(view: View)

    fun refresh() {}
}