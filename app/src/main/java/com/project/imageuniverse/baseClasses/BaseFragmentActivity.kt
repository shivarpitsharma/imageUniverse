package com.project.imageuniverse.baseClasses

import androidx.fragment.app.FragmentTransaction

/**
 * Created by Shivarpit
 */
abstract class BaseFragmentActivity : BaseActivity() {
    abstract val frameId: Int

    fun inflateAddFragment(
        baseFragment: BaseFragment,
        addToBackStack: Boolean,
        backStackTag: String
    ) {
        if (addToBackStack)
            getFragmentTransaction().add(frameId, baseFragment).addToBackStack(backStackTag)
                .commit()
        else
            getFragmentTransaction().add(frameId, baseFragment).commit()
    }


    fun inflateReplaceFragment(
        baseFragment: BaseFragment,
        addToBackStack: Boolean,
        backStackTag: String
    ) {
        if (addToBackStack)
            getFragmentTransaction().replace(frameId, baseFragment).addToBackStack(backStackTag)
                .commit()
        else
            getFragmentTransaction().replace(frameId, baseFragment).commit()
    }

    private fun getFragmentTransaction(): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
    }
}