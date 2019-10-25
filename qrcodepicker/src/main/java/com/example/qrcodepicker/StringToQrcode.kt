package com.example.qrcodepicker

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

object StringToQrcode {

    fun stringToBarcodeeBitmap(code: String): Bitmap? {
        //generate QR
        var bitmap: Bitmap? = null
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(code, BarcodeFormat.QR_CODE, 1500, 1500)
            val barcodeEncoder = BarcodeEncoder()
            bitmap = barcodeEncoder.createBitmap(bitMatrix)

        } catch (e: WriterException) {
            e.printStackTrace()
        }

        return bitmap
    }
}