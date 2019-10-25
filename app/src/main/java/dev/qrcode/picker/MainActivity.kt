package dev.qrcode.picker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qrcodepicker.QrcodePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        qrcode_picker.callbackScanner(object : QrcodePicker.CallbackScannerListener{
            override fun responseScanner(result: String?) {
                Toast.makeText(this@MainActivity,result,Toast.LENGTH_LONG).show()
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
