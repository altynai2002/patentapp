package com.pro.patentapp.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.pro.patentapp.R
import com.pro.patentapp.databinding.CustomViewBinding
import com.pro.patentapp.ext.obtainStyledAttributes
import com.pro.patentapp.ext.viewBinding

class ViewCustom @JvmOverloads constructor(
                 context: Context, attrs: AttributeSet? = null
): ConstraintLayout(context, attrs) {


    private val binding = viewBinding(CustomViewBinding::inflate)
    var onClicked: (() -> Unit) = {}

//    init {
//        attrs.obtainStyledAttributes(context, R.styleable.LoanPaymentStateView) {
//            val textCustom =
//                it.getString(R.styleable.LoanPaymentStateView_lpsvPaymentDateText) ?: ""
//        }
//    }

}