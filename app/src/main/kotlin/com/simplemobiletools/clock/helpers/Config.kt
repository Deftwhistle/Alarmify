package com.simplemobiletools.clock.helpers

import android.content.Context
import android.media.RingtoneManager
import com.simplemobiletools.clock.extensions.gson.gson
import com.simplemobiletools.clock.models.Alarm
import com.simplemobiletools.clock.models.ObfuscatedAlarm
import com.simplemobiletools.clock.models.ObfuscatedTimer
import com.simplemobiletools.clock.models.Timer
import com.simplemobiletools.commons.extensions.getDefaultAlarmSound
import com.simplemobiletools.commons.extensions.getDefaultAlarmTitle
import com.simplemobiletools.commons.helpers.BaseConfig
import com.simplemobiletools.commons.helpers.SORT_DESCENDING

class Config(context: Context) : BaseConfig(context) {
    companion object {
        fun newInstance(context: Context) = Config(context)
    }

    var timerSeconds: Int
        get() = prefs.getInt(TIMER_SECONDS, 300)
        set(lastTimerSeconds) = prefs.edit().putInt(TIMER_SECONDS, lastTimerSeconds).apply()

    var timerVibrate: Boolean
        get() = prefs.getBoolean(TIMER_VIBRATE, false)
        set(timerVibrate) = prefs.edit().putBoolean(TIMER_VIBRATE, timerVibrate).apply()

    var timerSoundUri: String
        get() = prefs.getString(TIMER_SOUND_URI, context.getDefaultAlarmSound(RingtoneManager.TYPE_ALARM).uri)!!
        set(timerSoundUri) = prefs.edit().putString(TIMER_SOUND_URI, timerSoundUri).apply()

    var timerSoundTitle: String
        get() = prefs.getString(TIMER_SOUND_TITLE, context.getDefaultAlarmTitle(RingtoneManager.TYPE_ALARM))!!
        set(timerSoundTitle) = prefs.edit().putString(TIMER_SOUND_TITLE, timerSoundTitle).apply()

    var timerMaxReminderSecs: Int
        get() = prefs.getInt(TIMER_MAX_REMINDER_SECS, DEFAULT_MAX_TIMER_REMINDER_SECS)
        set(timerMaxReminderSecs) = prefs.edit().putInt(TIMER_MAX_REMINDER_SECS, timerMaxReminderSecs).apply()

    var timerLabel: String?
        get() = prefs.getString(TIMER_LABEL, null)
        set(label) = prefs.edit().putString(TIMER_LABEL, label).apply()

    var alarmSort: Int
        get() = prefs.getInt(ALARMS_SORT_BY, SORT_BY_CREATION_ORDER)
        set(alarmSort) = prefs.edit().putInt(ALARMS_SORT_BY, alarmSort).apply()

    var alarmMaxReminderSecs: Int
        get() = prefs.getInt(ALARM_MAX_REMINDER_SECS, DEFAULT_MAX_ALARM_REMINDER_SECS)
        set(alarmMaxReminderSecs) = prefs.edit().putInt(ALARM_MAX_REMINDER_SECS, alarmMaxReminderSecs).apply()

    var increaseVolumeGradually: Boolean
        get() = prefs.getBoolean(INCREASE_VOLUME_GRADUALLY, true)
        set(increaseVolumeGradually) = prefs.edit().putBoolean(INCREASE_VOLUME_GRADUALLY, increaseVolumeGradually).apply()

    var alarmLastConfig: Alarm?
        get() = prefs.getString(ALARM_LAST_CONFIG, null)?.let { lastAlarm ->
            try {
                if (lastAlarm.contains("\"b\"")) {
                    gson.fromJson(lastAlarm, ObfuscatedAlarm::class.java).toAlarm()
                } else {
                    gson.fromJson(lastAlarm, Alarm::class.java)
                }
            } catch (e: Exception) {
                null
            }
        }
        set(alarm) = prefs.edit().putString(ALARM_LAST_CONFIG, gson.toJson(alarm)).apply()

    var timerLastConfig: Timer?
        get() = prefs.getString(TIMER_LAST_CONFIG, null)?.let { lastTimer ->
            try {
                if (lastTimer.contains("\"b\"")) {
                    gson.fromJson(lastTimer, ObfuscatedTimer::class.java).toTimer()
                } else {
                    gson.fromJson(lastTimer, Timer::class.java)
                }
            } catch (e: Exception) {
                null
            }
        }
        set(timer) = prefs.edit().putString(TIMER_LAST_CONFIG, gson.toJson(timer)).apply()

    var timerChannelId: String?
        get() = prefs.getString(TIMER_CHANNEL_ID, null)
        set(id) = prefs.edit().putString(TIMER_CHANNEL_ID, id).apply()

    var wasInitialWidgetSetUp: Boolean
        get() = prefs.getBoolean(WAS_INITIAL_WIDGET_SET_UP, false)
        set(wasInitialWidgetSetUp) = prefs.edit().putBoolean(WAS_INITIAL_WIDGET_SET_UP, wasInitialWidgetSetUp).apply()
}
