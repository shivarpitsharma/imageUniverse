package com.project.imageuniverse.baseClasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Shivarpit
 */

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getInflatedView(getLayoutId(), inflater, container)
    }

    private fun getInflatedView(
        layoutId: Int,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View? {
        return inflater.inflate(layoutId, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewInflated(view, savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            activity?.onBackPressed()
            return true
        }
        return false
    }

    abstract fun onViewInflated(view: View, savedInstanceState: Bundle?)

    abstract fun getLayoutId(): Int
}