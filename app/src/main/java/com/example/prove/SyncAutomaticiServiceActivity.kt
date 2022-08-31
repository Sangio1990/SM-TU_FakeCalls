package com.example.prove

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class SyncAutomaticiServiceActivity : AppCompatActivity() {
    lateinit var show: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_automatici_service)
        val view = findViewById<ConstraintLayout>(R.id.mainView)
        show = ProgressDialog.show(
            this, "Call SM-TU ",
            "Sync materiali automatici",
        )
        ProvaService.provaService(this) {
            show.hide()
            val snackbar = Snackbar.make(
                view,
                "U DID THE SYNC!",
                Snackbar.LENGTH_SHORT
            )
            snackbar.show()
            snackbar.addCallback(object : Snackbar.Callback() {
                override fun onDismissed(snackbar: Snackbar, event: Int) {
                    finishAffinity()
                }

                override fun onShown(snackbar: Snackbar) {}
            })
        }
    }
}