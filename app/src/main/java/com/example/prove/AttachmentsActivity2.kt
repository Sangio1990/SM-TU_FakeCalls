package com.example.prove

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ListView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.prove.Constants.ACTION_ADD_ATTACHMENTS
import com.example.prove.Constants.SMTU_MAIN_ACTIVITY
import com.example.prove.Constants.SMTU_PACKAGE
import com.example.prove.adapters.AttachmentAdapter
import com.example.prove.adapters.AttachmentAdapter2
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


data class Attachment2(val fileName: String, val filePath: String)

class AttachmentsActivity2 : AppCompatActivity() {

    companion object {
        private const val TAG = "FAKECALL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attachments)
        var idWoa = "43342242"

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
                    val listType = object : TypeToken<List<Attachment2>>() {}.type
                    val attachment2List: List<Attachment2> = gson.fromJson(temp, listType)
                    for (attachment in attachment2List) {
                        Log.d(TAG, "FileName: ${attachment.fileName}, FilePath: ${attachment.filePath}")
                    }
                    val attachmentAdapter = AttachmentAdapter2(this, attachment2List)
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

        //Creo il dialog per far inserire un IdWoa custom
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Inserisci un IdWoa: (Num only)")

        val input = EditText(this)
        input.setText(idWoa)
        builder.setView(input)

        builder.setPositiveButton("invia") {
            dialog, which ->
            idWoa = if (input.text.toString().toIntOrNull() != null) input.text.toString() else "notANum"
            if (idWoa=="notANum"){
                val errorDialogBuilder = AlertDialog.Builder(this)
                errorDialogBuilder.setTitle("idWoa non valido, ripristinato al valore di default: 43342242")
                errorDialogBuilder.setPositiveButton("OK"){ errDialog, _ -> errDialog.dismiss() }
                errorDialogBuilder.setCancelable(false)
                errorDialogBuilder.show()
                idWoa = "43342242"
            }



            // Invia l'Intent all'app wfm.in.enel.com.smtu
            val intent = Intent()
            intent.putExtra(Constants.MT_PACKAGE_NAME, packageName)
            intent.putExtra(Constants.UO, "D81CB")
            intent.putExtra(Constants.APP, "SM-TU_FakeCalls")
            intent.putExtra(Constants.IDWOA, idWoa)
            intent.putExtra(Constants.REGISTERED_VAT_NUMBER, "6552241215")
            intent.putExtra(Constants.CONTRACT_CODE, "5200002608")
            intent.putExtra(Constants.MATERIAL_METHOD, "attachments")
            intent.putExtra(Constants.MT_OPERATION_ID, "111111")

            intent.putExtra(Constants.SWIM_CLASS, "SWIM_XX")
            intent.putExtra(Constants.SWIM_SEND_SMDP, "TRUE")
            intent.putExtra(Constants.SWIM_ATTACHMENT_TO_FB, "TRUE")

            intent.setPackage(packageName)
            intent.action = ACTION_ADD_ATTACHMENTS
            //intent.component = ComponentName(SMTU_PACKAGE, SMTU_MAIN_ACTIVITY_CAMERA)
            intent.component = ComponentName(SMTU_PACKAGE, SMTU_MAIN_ACTIVITY)
            Log.d(TAG, "CALLING SMTU...")
            attachmentsLauncher.launch(intent)

        }

        builder.show()

    }
}



