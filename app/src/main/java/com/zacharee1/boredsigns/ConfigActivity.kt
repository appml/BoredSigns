package com.zacharee1.boredsigns

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceFragment
import com.zacharee1.boredsigns.fragments.ImageFragment
import com.zacharee1.boredsigns.fragments.InfoFragment
import com.zacharee1.boredsigns.fragments.WeatherFragment

class ConfigActivity : AppCompatActivity() {
    companion object {
        val SB_TYPE = "type"

        val INFO = "info"
        val WEATHER = "weather"
        val IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        val type = intent?.getStringExtra(SB_TYPE)

        if (type != null) {
            var fragment = Fragment()

            when (type) {
                INFO -> fragment = InfoFragment()
                WEATHER -> fragment = WeatherFragment()
                IMAGE -> fragment = ImageFragment()
            }

            fragmentManager.beginTransaction().replace(R.id.content_main, fragment).commit()
        } else {
            finish()
        }
    }
}
