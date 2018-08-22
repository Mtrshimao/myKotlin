package com.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.mykotlin.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    var currentIndex = R.id.radioButton
    lateinit var fmTab1: BaseFragment
    lateinit var fmTab2: BaseFragment
    lateinit var fmTab3: BaseFragment
    lateinit var fmTab4: BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchFragment(currentIndex, true)
        rg.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        switchFragment(checkedId, true)
    }

    fun switchFragment(index: Int, isRefresh: Boolean) {
        currentIndex = index
        var curFragment: BaseFragment? = null
        when (index) {
            R.id.radioButton -> {
                fmTab1 = OneFragment()
                fragmentManager.beginTransaction()
                        .replace(R.id.fly_container, fmTab1)
                        .commit()
                curFragment = fmTab1

            }
            R.id.radioButton2 -> {
                fmTab2 = TwoFragment()
                fragmentManager.beginTransaction()
                        .replace(R.id.fly_container, fmTab2)
                        .commit()
                curFragment = fmTab2

            }

            R.id.radioButton3 -> {
                fmTab3 = ThreeFragment()
                fragmentManager.beginTransaction()
                        .replace(R.id.fly_container, fmTab3)
                        .commit()
                curFragment = fmTab3
            }

            R.id.radioButton4 -> {
                fmTab4 = FourFragment()
                fragmentManager.beginTransaction()
                        .replace(R.id.fly_container, fmTab4)
                        .commit()
                curFragment = fmTab4
            }
        }
        if (null != curFragment) {
            if (isRefresh) {
                curFragment!!.refresh()
            }
        }
    }


}
