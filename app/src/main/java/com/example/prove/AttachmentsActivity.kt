package com.example.prove

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.prove.Constants.ACTION_ADD_ATTACHMENTS
import com.example.prove.Constants.SMTU_MAIN_ACTIVITY
import com.example.prove.Constants.SMTU_PACKAGE
import com.example.prove.adapters.AttachmentAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


data class Attachment(val fileName: String, val filePath: String)

class AttachmentsActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "FAKECALL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attachments)

        var attachmentsLauncher = registerForActivityResult(StartActivityForResult(), ActivityResultCallback { result: ActivityResult ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                val data = result.data
                Log.d(TAG, "Valore ricevuto: $data")
                // Gestisci i dati di ritorno qui
                val extras = data?.extras
                Log.d(TAG, "extras: $extras")
                if (extras != null) {
                    val temp = extras.getString("attachments")
                    Log.d(TAG, "temp: $temp")
                    val gson = Gson()
                    val listType = object : TypeToken<List<Attachment>>() {}.type
                    val attachmentList: List<Attachment> = gson.fromJson(temp, listType)
                    for (attachment in attachmentList) {
                        Log.d(TAG, "FileName: ${attachment.fileName}, FilePath: ${attachment.filePath}")
                    }
                    val attachmentAdapter = AttachmentAdapter(this, attachmentList)
                    val listViewAttachments = findViewById<ListView>(R.id.listViewAttachments)
                    listViewAttachments.adapter = attachmentAdapter
                } else {
                    Log.d(TAG, "extras = null")
                }
            } else if (result.data == null) {
                Log.d(TAG, "Data is null")
            } else {
                Log.d(TAG, "resultCode != RESULT_OK")
            }
        })


        // Invia l'Intent all'app wfm.in.enel.com.smtu
        val intent = Intent()
        intent.putExtra(Constants.MT_PACKAGE_NAME, packageName)
        intent.putExtra(Constants.UO, "D81CB")
        intent.putExtra(Constants.IDWOA, "43342242")
        intent.putExtra(Constants.REGISTERED_VAT_NUMBER, "6552241215")
        intent.putExtra(Constants.CONTRACT_CODE, "5200002608")
        intent.putExtra(Constants.MATERIAL_METHOD, "attachments")
        intent.setPackage(packageName)
        intent.action = ACTION_ADD_ATTACHMENTS
        intent.component = ComponentName(SMTU_PACKAGE, SMTU_MAIN_ACTIVITY)
        Log.d(TAG, "CALLING SMTU...")
        attachmentsLauncher.launch(intent)


    }
}


