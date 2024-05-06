package com.example.alarmify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var home_alarm_Fragment: HomeAlarmFragment
    lateinit var achievements_Fragment: AchievementsFragment
    lateinit var settings_Fragment: SettingsFragment
    lateinit var alarm_details: Alarm_details

    var alarmArrayList: ArrayList<Alarm> = ArrayList<Alarm>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        home_alarm_Fragment = HomeAlarmFragment()
        achievements_Fragment = AchievementsFragment()
        settings_Fragment = SettingsFragment()
        alarm_details = Alarm_details()

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.btmNavBar)
        loadFragment(HomeAlarmFragment())
        bottomNavigationView.setOnItemSelectedListener {

            try {
                when (it.itemId) {
                    R.id.home -> {
                        loadFragment(home_alarm_Fragment)
                        true
                    }
                    R.id.achievements-> {
                        loadFragment(achievements_Fragment)
                        true
                    } else -> {
                    R.id.settings
                    loadFragment(settings_Fragment)
                    true
                }
                }
            } catch (e : Exception) {
                throw e
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(com.google.android.material.R.id.container, fragment)
            transaction.commit()
        }
    }
}