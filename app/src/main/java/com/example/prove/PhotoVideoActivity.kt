package com.example.prove

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.prove.Constants.*
import java.io.File
import java.io.FileOutputStream
import android.app.Dialog
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ProgressDialogFragment : DialogFragment() {
    var text = "";

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val progressBar = ProgressBar(requireContext())
        progressBar.isIndeterminate = true

        return AlertDialog.Builder(requireContext())
            .setView(progressBar)
            .setTitle("Call SM-TU Camera")
            .setMessage(text)
            .setCancelable(true)
            .create()
    }
}

class PhotoVideoActivity : AppCompatActivity() {

    var progressDialogFragment = ProgressDialogFragment()
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
                            progressDialogFragment.dismiss()
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

        progressDialogFragment.text = "Mode: $photoVideoAction"
        progressDialogFragment.show(supportFragmentManager, "SM-TU Camera")

        val intent = Intent()
        intent.putExtra(MT_PACKAGE_NAME, packageName)
        intent.putExtra(UO, "D81CB")
        intent.putExtra(IDWOA, "idWoa43342242")
        intent.putExtra(REGISTERED_VAT_NUMBER, "6552241215")
        intent.putExtra(CONTRACT_CODE, "5200002608")
        intent.component =
            //ComponentName(SMTU_PACKAGE, SMTU_MAIN_ACTIVITY)
        ComponentName(SMTU_PACKAGE, SMTU_MAIN_ACTIVITY_CAMERA)

        intent.setPackage(packageName)
        intent.action = SMTU_PACKAGE.plus(".".plus(photoVideoAction))
        startForResult.launch(intent)
    }
}