# QrCodePicker

[![API](https://img.shields.io/badge/API-14%2B-red.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![](https://jitpack.io/v/mkhoiron/Actionsheet-android.svg)](https://jitpack.io/#mkhoiron/Actionsheet-android/0.1)

QrCodePicker is an Android Library for easy to use qrcode

![alt text](https://i.ibb.co/Nj1ZpQ2/Qrcode-picker.png)
![alt text](https://i.ibb.co/nPp0XJ5/Qrcode-2.png)

## Installation

-  Add the following to your project level `build.gradle`:
 
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
  -  Add this to your app `build.gradle`:
 
```gradle
dependencies {
	implementation 'com.github.mkhoiron:QrCodePicker:0.1'
}
```
## QRcodeScanner

  -  add Layout in xml
```xml

    <com.example.qrcodepicker.QrcodePicker
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/qrcode_picker">
    </com.example.qrcodepicker.QrcodePicker>

```
  -  Initialize:
  
```kotlin
       //init callback qrcode scanner in onCreate
        qrcode_picker.callbackScanner(object : QrcodePicker.CallbackScannerListener{
            override fun responseScanner(result: String?) {
                Toast.makeText(this@MainActivity,result,Toast.LENGTH_LONG).show()
            }
        } )
        
       //overide onRequestPermissionsResult in activity
       override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        qrcode_picker.onRequestPermissionsResult(requestCode, permissions, grantResults)
       }

       //overide onPause in activity
       override fun onPause() {
          super.onPause()
          qrcode_picker.onPause()
       }
       
       //overide onResume in activity
       override fun onResume() {
          super.onResume()
          qrcode_picker.onResume()
       }
        
        
```

## StringToQrCode and PopUpQrcode

        // you can generate string to image Qrcode and show popup with Qrcode
        
        //string 
        var code = "terserah"
        //setImageView
        image_barcode.setImageBitmap(StringToQrcode.stringToBarcodeeBitmap(code))

        image_barcode.setOnClickListener {
            //show popup
            QRPopUp.show(this,code)
        }


License
=======
Copyright 2019 [M Khoiron and anxdre]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Al-hamdulillahi Rabbil 'alamin And Special thanks to [JetBrains](https://github.com/JetBrains) and [jitpack.io](https://github.com/jitpack-io) for their contributions to this project.
