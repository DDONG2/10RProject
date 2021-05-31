package com.example.a10rproject

import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.a10rproject.Utils.PreferenceUtils

class ClickActivity : BaseActivity() {

//    var vibrator: Vibrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)

        var tv_click_count = findViewById(R.id.tv_click_count) as TextView
        var btn_click_button = findViewById(R.id.btn_click_button) as Button


        tv_click_count.text = PreferenceUtils.getInstance(this).saveString


        btn_click_button.setOnClickListener {
            var num = tv_click_count.text.toString().toInt();
            num += 1;

            //100회 클릭시 진동
            if (num % 100 == 0) {

                var vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(
                        VibrationEffect.createOneShot(
                            1000,
                            VibrationEffect.DEFAULT_AMPLITUDE
                        )
                    )
                } else {
                    vibrator.vibrate(1000)
                }
            }

            tv_click_count.text = num.toString();
            PreferenceUtils.getInstance(this).saveString = num.toString();
        }
    }
}