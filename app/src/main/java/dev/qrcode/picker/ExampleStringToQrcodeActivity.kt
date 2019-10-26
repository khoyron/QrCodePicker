package dev.qrcode.picker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qrcodepicker.QRPopUp
import com.example.qrcodepicker.QrcodePicker
import com.example.qrcodepicker.StringToQrcode
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.example_string_ro_qrcode.*

class ExampleStringToQrcodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_string_ro_qrcode)

        // string to image
        var code = "terserah"
        image_barcode.setImageBitmap(StringToQrcode.stringToBarcodeeBitmap(code))

        //show popup
        image_barcode.setOnClickListener {
            QRPopUp.show(this, code)
        }

    }
}
