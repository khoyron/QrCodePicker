package com.example.qrcodepicker


import android.app.Dialog
import android.view.Window
import android.graphics.Color
import android.view.ViewGroup
import android.content.Context
import android.widget.ImageView
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.graphics.drawable.ColorDrawable

object QRPopUp {

    fun show(c: Context, code: String) {
        onMain(c, code)
    }

    private fun onMain(c: Context, code: String) {
        val d = Dialog(c)
        d.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val v = LayoutInflater.from(c).inflate(R.layout.pop_up_qr, null)
        d.setContentView(v)
        val qrCode = d.findViewById<ImageView>(R.id.qr_code)
        val layout = d.findViewById<RelativeLayout>(R.id.layout_parent_dialog)
        layout.setOnClickListener { d.dismiss() }

        qrCode.setImageBitmap(StringToQrcode.stringToBarcodeeBitmap(code))

        d.show()
        d.setCancelable(true)
        d.window.setBackgroundDrawable(ColorDrawable(Color.BLACK))
        d.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    }


}