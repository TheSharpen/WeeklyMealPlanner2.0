package com.example.weeklymealplanner.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.io.StringReader
import java.util.*

// ChatGPT code adjustment
@ProvidedTypeConverter
class Converters {

    private val gson: Gson = Gson()

    @TypeConverter
    fun fromStringToList(data: String?): List<String> {
        if (data == null) {
            return Collections.emptyList()
        }
        val jsonReader = JsonReader(StringReader(data))
        jsonReader.isLenient = true
        val listType = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(jsonReader, listType)
    }

    @TypeConverter
    fun fromListToString(list: List<String?>?): String {
        return gson.toJson(list)
    }
}


// Original code below

//@ProvidedTypeConverter
//class Converters {
//
//    private val gson: Gson = Gson()
//
//
//    @TypeConverter
//    fun fromStringToList(data: String?): List<String> {
//        if (data == null) {
//            return Collections.emptyList()
//        }
//
//
//        //gson.jsonReader.isLenient = true
//
//        val listType: Type = object : TypeToken<List<String?>?>() {}.type
//        return gson.fromJson(data, listType)
//    }
//
//    @TypeConverter
//    fun fromListToString(list: List<String?>?): String {
//        return gson.toJson(list)
//    }
//}