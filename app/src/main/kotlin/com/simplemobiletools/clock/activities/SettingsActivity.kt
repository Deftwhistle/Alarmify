package com.simplemobiletools.clock.activities

import android.content.Intent
import android.os.Bundle
import com.simplemobiletools.clock.databinding.ActivitySettingsBinding
import com.simplemobiletools.clock.extensions.config
import com.simplemobiletools.clock.helpers.DEFAULT_MAX_ALARM_REMINDER_SECS
import com.simplemobiletools.clock.helpers.DEFAULT_MAX_TIMER_REMINDER_SECS
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.commons.helpers.IS_CUSTOMIZING_COLORS
import com.simplemobiletools.commons.helpers.MINUTE_SECONDS
import com.simplemobiletools.commons.helpers.NavigationIcon
import com.simplemobiletools.commons.helpers.isTiramisuPlus
import java.util.Locale
import kotlin.system.exitProcess

class SettingsActivity : SimpleActivity() {
    private val binding: ActivitySettingsBinding by viewBinding(ActivitySettingsBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        isMaterialActivity = true
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        updateMaterialActivityViews(binding.settingsCoordinator, binding.settingsHolder, useTransparentNavigation = true, useTopSearchMenu = false)
        setupMaterialScrollListener(binding.settingsNestedScrollview, binding.settingsToolbar)
    }

    override fun onResume() {
        super.onResume()
        setupToolbar(binding.settingsToolbar, NavigationIcon.Arrow)
        setupPreventPhoneFromSleeping()
        setupSundayFirst()
        setupAlarmMaxReminder()
        setupUseSameSnooze()
        setupSnoozeTime()
        setupTimerMaxReminder()
        setupIncreaseVolumeGradually()
        arrayOf(
            binding.settingsGeneralSettingsLabel,
            binding.settingsAlarmTabLabel,
            binding.settingsTimerTabLabel,
        ).forEach {
            it.setTextColor(getProperPrimaryColor())
        }
    }


    private fun setupPreventPhoneFromSleeping() {
        binding.settingsPreventPhoneFromSleeping.isChecked = config.preventPhoneFromSleeping
        binding.settingsPreventPhoneFromSleepingHolder.setOnClickListener {
            binding.settingsPreventPhoneFromSleeping.toggle()
            config.preventPhoneFromSleeping = binding.settingsPreventPhoneFromSleeping.isChecked
        }
    }

    private fun setupSundayFirst() {
        binding.settingsSundayFirst.isChecked = config.isSundayFirst
        binding.settingsSundayFirstHolder.setOnClickListener {
            binding.settingsSundayFirst.toggle()
            config.isSundayFirst = binding.settingsSundayFirst.isChecked
        }
    }

    private fun setupAlarmMaxReminder() {
        updateAlarmMaxReminderText()
        binding.settingsAlarmMaxReminderHolder.setOnClickListener {
            showPickSecondsDialog(config.alarmMaxReminderSecs, true, true) {
                config.alarmMaxReminderSecs = if (it != 0) it else DEFAULT_MAX_ALARM_REMINDER_SECS
                updateAlarmMaxReminderText()
            }
        }
    }

    private fun setupUseSameSnooze() {
        binding.settingsSnoozeTimeHolder.beVisibleIf(config.useSameSnooze)
        binding.settingsUseSameSnooze.isChecked = config.useSameSnooze
        binding.settingsUseSameSnoozeHolder.setOnClickListener {
            binding.settingsUseSameSnooze.toggle()
            config.useSameSnooze = binding.settingsUseSameSnooze.isChecked
            binding.settingsSnoozeTimeHolder.beVisibleIf(config.useSameSnooze)
        }
    }

    private fun setupSnoozeTime() {
        updateSnoozeText()
        binding.settingsSnoozeTimeHolder.setOnClickListener {
            showPickSecondsDialog(config.snoozeTime * MINUTE_SECONDS, true) {
                config.snoozeTime = it / MINUTE_SECONDS
                updateSnoozeText()
            }
        }
    }

    private fun setupTimerMaxReminder() {
        updateTimerMaxReminderText()
        binding.settingsTimerMaxReminderHolder.setOnClickListener {
            showPickSecondsDialog(config.timerMaxReminderSecs, true, true) {
                config.timerMaxReminderSecs = if (it != 0) it else DEFAULT_MAX_TIMER_REMINDER_SECS
                updateTimerMaxReminderText()
            }
        }
    }

    private fun setupIncreaseVolumeGradually() {
        binding.settingsIncreaseVolumeGradually.isChecked = config.increaseVolumeGradually
        binding.settingsIncreaseVolumeGraduallyHolder.setOnClickListener {
            binding.settingsIncreaseVolumeGradually.toggle()
            config.increaseVolumeGradually = binding.settingsIncreaseVolumeGradually.isChecked
        }
    }

    private fun updateSnoozeText() {
        binding.settingsSnoozeTime.text = formatMinutesToTimeString(config.snoozeTime)
    }

    private fun updateAlarmMaxReminderText() {
        binding.settingsAlarmMaxReminder.text = formatSecondsToTimeString(config.alarmMaxReminderSecs)
    }

    private fun updateTimerMaxReminderText() {
        binding.settingsTimerMaxReminder.text = formatSecondsToTimeString(config.timerMaxReminderSecs)
    }
}
