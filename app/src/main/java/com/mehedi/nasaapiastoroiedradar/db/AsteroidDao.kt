package com.mehedi.nasaapiastoroiedradar.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mehedi.nasaapiastoroiedradar.db.model.ImageOfTheDayEntity
import com.mehedi.nasaapiastoroiedradar.db.model.ResponseImageOfTheDay


@Dao
interface AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageOfTheDay(image: ImageOfTheDayEntity)

    @Query("SELECT * FROM image_of_the_day")
    fun getAllImageOfTheDayData(): LiveData<List<ImageOfTheDayEntity>>
}