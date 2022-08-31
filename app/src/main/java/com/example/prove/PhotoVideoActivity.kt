package com.example.prove

import android.app.Activity
import android.app.ProgressDialog
import android.content.ComponentName
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.prove.Constants.*
import java.io.File
import java.io.FileOutputStream

class PhotoVideoActivity : AppCompatActivity() {

    lateinit var show: ProgressDialog
    lateinit var photoVideoAction: String

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                intent?.let {
                    if (photoVideoAction == PICTURE_ACTION) {
                        val data = it.data
                        var bitmap: Bitmap? = null
                        data?.let {
                            bitmap = if (Build.VERSION.SDK_INT < 28) {
                                MediaStore.Images.Media.getBitmap(contentResolver, it)
                            } else {
                                val source: ImageDecoder.Source =
                                    ImageDecoder.createSource(contentResolver, it)
                                ImageDecoder.decodeBitmap(source)
                            }
                        }
                        bitmap?.let {
                            val newFile = File(this@PhotoVideoActivity.filesDir, "snapshot.jpg")
                            val out = FileOutputStream(newFile)
                            it.compress(Bitmap.CompressFormat.JPEG, 100, out)
                            out.flush()
                            out.close()
                            val imageView = findViewById<ImageView>(R.id.image)
                            imageView.visibility = VISIBLE
                            imageView.setImageBitmap(bitmap)
                            show.dismiss()
                        } ?: Toast.makeText(
                            this@PhotoVideoActivity,
                            "Image not available",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } else {
                //Todo gestire video
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_video)
        photoVideoAction = intent.getStringExtra(PHOTO_VIDEO_LABEL)!!
        show = ProgressDialog.show(
            this, "Call SM-TU Camera",
            "Mode: $photoVideoAction",
        )
        val intent = Intent()
        intent.putExtra(MT_PACKAGE_NAME, packageName)
        intent.putExtra(UO, "D81CB")
        intent.putExtra(IDWOA, "43342242")
        intent.putExtra(REGISTERED_VAT_NUMBER, "6552241215")
        intent.putExtra(CONTRACT_CODE, "5200002608")
        intent.component =
            ComponentName(SMTU_PACKAGE, SMTU_MAIN_ACTIVITY)
        intent.setPackage(packageName)
        intent.action = SMTU_PACKAGE.plus(".").plus(photoVideoAction)
        startForResult.launch(intent)
    }
}