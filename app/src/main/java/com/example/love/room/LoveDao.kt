package com.example.love.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.love.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insertLove(love: com.example.love.LoveModel)

    @Query("SELECT * FROM 'love-table'")
    fun getAll(): List<LoveModel>

    @Query("DELETE FROM 'love-table' WHERE firstName = :name OR secondName = :name OR percentage  = :name OR result = :name")
    fun deleteByName(name: String)

    @Query("DELETE FROM 'love-table'")
    fun deleteAll()

    @Query ("SELECT * FROM 'love-table' ORDER BY firstName ASC")
    fun getSortedItemsByName():List<LoveModel>
}