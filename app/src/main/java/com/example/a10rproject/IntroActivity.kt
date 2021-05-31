package com.example.a10rproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a10rproject.Utils.PreferenceUtils
import java.text.SimpleDateFormat
import java.util.*

class IntroActivity : BaseActivity() {

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        var tv_intro_content = findViewById(R.id.tv_intro_content) as TextView

        var nowDate = System.currentTimeMillis()
        val date = Date(nowDate)
        val mFormat = SimpleDateFormat("yyyyMMdd")
        val nowTime = mFormat.format(date)

        if(nowTime.toInt() - PreferenceUtils.getInstance(this).saveInt >= 1) {
            PreferenceUtils.getInstance(this).saveString = "0"
            PreferenceUtils.getInstance(this).saveInt = nowTime.toInt()
        } else{
            PreferenceUtils.getInstance(this).saveInt = nowTime.toInt()
        }


        mRunnable = Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        mHandler = Handler()
        mHandler.postDelayed(mRunnable, 2000)
//        val animation = AnimationUtils.loadAnimation(this,R.anim.intro)
//        animation.setAnimationListener(Animation.AnimationListener(){
//
//        })
//        tv_intro_content.startAnimation(animation)


    }
}