package dev.qrcode.picker

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_xample_qrcode.setOnClickListener {
            startActivity(Intent(this,ExampleQrcodePicker::class.java))
        }

        btn_xample_string_to_qrcode.setOnClickListener {
            startActivity(Intent(this,ExampleStringToQrcodeActivity::class.java))
        }
    }

}

