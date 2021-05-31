package com.example.a10rproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cl_main_activity = findViewById(R.id.cl_main_activity) as ConstraintLayout


        cl_main_activity.setOnClickListener {
            startActivity(Intent(this, ClickActivity::class.java))
            finish()
        }


    }
}