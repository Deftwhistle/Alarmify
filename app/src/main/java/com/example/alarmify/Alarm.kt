package com.example.alarmify

import org.json.JSONException
import org.json.JSONObject

class Alarm(
    var nombre: String,
    var hora: String,
    var active: Boolean,
    var sunday: Boolean,
    var monday: Boolean,
    var tuesday: Boolean,
    var wednesday: Boolean,
    var thursday: Boolean,
    var friday: Boolean,
    var saturday: Boolean,
    var minigame: Int
) {




    companion object {

        fun getRecipesFromFile(filename: String, context: HomeAlarmFragment): ArrayList<Alarm> {
            val recipeList = ArrayList<Alarm>()
/*
            try {
                // Load data
                val jsonString = loadJsonFromAsset("alarms.json", context)
                val json = JSONObject(jsonString)
                val recipes = json.getJSONArray("recipes")

                // Get Recipe objects from data
                (0 until recipes.length()).mapTo(recipeList) {
                    Alarm(recipes.getJSONObject(it).getString("nombre"),
                        recipes.getJSONObject(it).getString("hora"),
                        recipes.getJSONObject(it).getString("active"),
                        recipes.getJSONObject(it).getString("sunday"),
                        recipes.getJSONObject(it).getString("monday"),
                        recipes.getJSONObject(it).getString("tuesday"),
                        recipes.getJSONObject(it).getString("wednesday"),
                        recipes.getJSONObject(it).getString("thursday"),
                        recipes.getJSONObject(it).getString("friday"),
                        recipes.getJSONObject(it).getString("saturday"),
                        recipes.getJSONObject(it).getString("minigame")
                        )
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }*/

            return recipeList
        }
/*
        private fun loadJsonFromAsset(filename: String, context: HomeAlarmFragment): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }*/
    }


}