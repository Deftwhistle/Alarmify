package com.example.alarmify

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter


import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat


class AdapterAlarm(context: Context, alarmArrayList: ArrayList<Alarm?>?):
    ArrayAdapter<Alarm?>(context, R.layout.list_alarm, alarmArrayList!!) {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        var view = convertView
        val alarm = getItem(position)


        if(view == null){

            view = LayoutInflater.from(context).inflate(R.layout.list_alarm, parent, false)
        }


            val txtNombre = view!!.findViewById<TextView>(R.id.txt_nombre)
            val txtHora = view.findViewById<TextView>(R.id.txt_hora)
            val txtAmpm = view.findViewById<TextView>(R.id.txt_ampm)
            val txtSunday = view.findViewById<TextView>(R.id.txt_sunday)
            val txtMonday = view.findViewById<TextView>(R.id.txt_monday)
            val txtTuesday = view.findViewById<TextView>(R.id.txt_tuesday)
            val txtWednesday = view.findViewById<TextView>(R.id.txt_wednesday)
            val txtThursday = view.findViewById<TextView>(R.id.txt_thursday)
            val txtFriday = view.findViewById<TextView>(R.id.txt_friday)
            val txtSaturday = view.findViewById<TextView>(R.id.txt_saturday)
            val switchAlarm = view.findViewById<SwitchCompat>(R.id.switch_alarm)



        txtNombre.text = "alarma 1"
        txtHora.text = "01:23"
        txtAmpm.text = "am"
        txtSunday.text = "S"
        txtMonday.text = "M"
        txtTuesday.text = "T"
        txtWednesday.text = "W"
        txtThursday.text = "T"
        txtFriday.text = "F"
        txtSaturday.text = "S"
        switchAlarm.isChecked = true




        txtSunday.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        txtSunday.setTypeface(null, Typeface.BOLD)
        txtMonday.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        txtMonday.setTypeface(null, Typeface.BOLD)
        txtTuesday.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        txtTuesday.setTypeface(null, Typeface.BOLD)

        return view


    }

}