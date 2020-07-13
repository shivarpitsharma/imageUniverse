package com.project.imageuniverse.baseClasses

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.project.imageuniverse.R

/**
 * Created by Shivarpit
 */
abstract class BaseDialogFragment : DialogFragment() {
    abstract val layoutId: Int

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        val dialog = this.activity?.layoutInflater?.inflate(
            layoutId,
            LinearLayout(this.activity),
            false
        )
        val builder = Dialog(dialog!!.context)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setCanceledOnTouchOutside(false)
        builder.setContentView(dialog)
        builder.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return builder
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog?.let { dialog ->
            dialog.window?.let { window ->
                if (isFullScreen()) {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    window.setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN
                    )
                    window.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                } else {
                    window.attributes.windowAnimations = R.style.DialogWindowAnimation
                    window.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
            }
            dialog.setCancelable(isCancellable())
        }
    }

    abstract fun isFullScreen(): Boolean

    abstract fun isCancellable(): Boolean
}