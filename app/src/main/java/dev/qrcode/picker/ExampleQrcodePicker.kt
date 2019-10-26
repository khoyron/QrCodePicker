package dev.qrcode.picker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qrcodepicker.QrcodePicker
import kotlinx.android.synthetic.main.example_qrcode_picker.*

class ExampleQrcodePicker : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_qrcode_picker)

        //show qrcode scanner
        qrcode_picker.callbackScanner(object : QrcodePicker.CallbackScannerListener{
            override fun responseScanner(result: String?) {
                Toast.makeText(this@ExampleQrcodePicker,result,Toast.LENGTH_LONG).show()
            }
        } )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        qrcode_picker.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onPause() {
        super.onPause()
        qrcode_picker.onPause()
    }

    override fun onResume() {
        super.onResume()
        qrcode_picker.onResume()
    }
}
