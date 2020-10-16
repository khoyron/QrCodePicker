package com.example.qrcodepicker

import android.Manifest
import android.os.Build
import android.view.View
import android.app.Activity
import android.view.ViewGroup
import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.content.pm.PackageManager
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class QrcodePicker : LinearLayout, View.OnClickListener,ZBarScannerView.ResultHandler {

    lateinit var callback : CallbackScannerListener

    lateinit var mScannerView: ZBarScannerView

    fun callbackScanner(callbackListener: CallbackScannerListener){
        callback = callbackListener
    }

    constructor(context: Context) : super(context) {
        init()
    }

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet, defStyle: Int = 0) : super(context, attrs, defStyle) {

        init()
    }

    private fun init() {
        setOrientation(VERTICAL)
        View.inflate(context, R.layout.scanner_barcode_view, this)

        initViewScanner()
    }

    private fun initViewScanner() {
        val contentFrame = findViewById(R.id.frame_scanner) as ViewGroup

        mScannerView = ZBarScannerView(context)
        contentFrame.addView(mScannerView)

        checkPermissionCamera(context)
    }

    val READ_REQUEST_CODE = 897

    private fun checkPermissionCamera(context: Context) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (context.checkSelfPermission(Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED ) {
                (context as Activity).requestPermissions(arrayOf( Manifest.permission.CAMERA), READ_REQUEST_CODE)

            } else {
                startScanner()
            }
        }
        else{
            startScanner()
        }
    }


    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when(requestCode){
            READ_REQUEST_CODE ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startScanner()
                }
                else{
                    showAlert("Sorry","Please allow camera permision",context)
                }
            }
        }
    }

    private fun showAlert(title: String, message: String, activity: Context) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { dialog, which -> dialog.dismiss() }
        builder.create().show()
    }


    private fun startScanner() {
        mScannerView.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView.startCamera()          // Start camera on resume
    }


    private fun stopCamera() {
        mScannerView.stopCamera()
    }

    fun onResume() {
        startScanner()
    }

    fun onPause() {
        stopCamera()
    }

    interface CallbackScannerListener{
        fun responseScanner(result: String?)
    }

    override fun onClick(v: View?) {

    }

    override fun handleResult(rawResult: Result?) {
        callback.responseScanner(rawResult?.contents)
    }

}