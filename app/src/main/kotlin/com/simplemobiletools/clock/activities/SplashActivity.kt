package com.simplemobiletools.clock.activities

import android.content.Intent
import com.simplemobiletools.clock.helpers.*
import com.simplemobiletools.commons.activities.BaseSplashActivity

class SplashActivity : BaseSplashActivity() {
    override fun initActivity() {
        when {
            intent?.action == "android.intent.action.SHOW_ALARMS" -> {
                Intent(this, MainActivity::class.java).apply {
                    putExtra(OPEN_TAB, TAB_ALARM)
                    startActivity(this)
                }
            }

            intent?.action == "android.intent.action.SHOW_TIMERS" -> {
                Intent(this, MainActivity::class.java).apply {
                    putExtra(OPEN_TAB, TAB_TIMER)
                    startActivity(this)
                }
            }

            IntentHandlerActivity.HANDLED_ACTIONS.contains(intent?.action) -> {
                Intent(intent).apply {
                    setClass(this@SplashActivity, IntentHandlerActivity::class.java)
                    startActivity(this)
                }
            }

            else -> startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }
}
