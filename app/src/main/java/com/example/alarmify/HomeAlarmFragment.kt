package com.example.alarmify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alarmify.databinding.ActivityMainBinding


class HomeAlarmFragment : Fragment() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterAlarm: AdapterAlarm
    private lateinit var alarm: Alarm
    var alarmArrayList = ArrayList<Alarm?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_alarm, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        binding = ActivityMainBinding.inflate(layoutInflater)



        val namelist = arrayOf("TEST", "TEST 2", "TEST 3")

        alarm = Alarm("test","01:23",true,true,true,true,false,false,false,false,2)
        adapterAlarm = AdapterAlarm(this,alarmArrayList)
        binding.list_alarm.adapter = adapterAlarm
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@HomeAlarmFragment, DetailedActivity::class.java)
            intent.putExtra("", namelist[i])
            startActivity(intent)*/
    }

    companion object {

    }
}