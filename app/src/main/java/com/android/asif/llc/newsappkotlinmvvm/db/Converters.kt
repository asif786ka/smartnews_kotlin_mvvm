package com.android.asif.llc.newsappkotlinmvvm.db

import androidx.room.TypeConverter
import com.android.asif.llc.newsappkotlinmvvm.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source) = source.name

    @TypeConverter
    fun toSource(name: String) = Source(name, name)
}