package com.example.prove

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.prove.Constants.*
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.photoBtn).setOnClickListener {
            val i = Intent(this@MainActivity, PhotoVideoActivity::class.java)
            i.putExtra(PHOTO_VIDEO_LABEL, PICTURE_ACTION)
            startActivity(i)
        }

        findViewById<Button>(R.id.videoBtn).setOnClickListener {
            val i = Intent(this@MainActivity, PhotoVideoActivity::class.java)
            i.putExtra(PHOTO_VIDEO_LABEL, VIDEO_ACTION)
            startActivity(i)
        }

        findViewById<Button>(R.id.syncBtn).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ProvaServiceActivity::class.java
                )
            )
        }
        findViewById<Button>(R.id.syncCertificate).setOnClickListener {
            val inte = Intent(
                this@MainActivity,
                ProvaServiceActivity::class.java
            )
            inte.putExtra("MIMMO", true)
            startActivity(inte)
        }

        findViewById<Button>(R.id.addAttachemnts).setOnClickListener {
            val i = Intent(this@MainActivity, AttachmentsActivity::class.java);
            startActivity(i)
        }
    }
}

