package com.example.prove

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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


        /**/
    }

}