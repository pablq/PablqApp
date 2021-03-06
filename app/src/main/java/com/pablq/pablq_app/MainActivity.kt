package com.pablq.pablq_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pablq.pablq_app.ui.main.sports.SportsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        SportsListFragment()
                    )
                    .commitNow()
        }
    }
}