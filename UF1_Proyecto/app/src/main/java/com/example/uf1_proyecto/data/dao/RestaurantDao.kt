package com.example.uf1_proyecto.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.uf1_proyecto.data.Restaurant
import com.example.uf1_proyecto.data.RestaurantWithMenu

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRestaurant(restaurant: Restaurant)

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)

    @Transaction
    @Query("SELECT * FROM Restaurant WHERE id = :restaurantId")
    fun getRestaurantWithMenu(restaurantId: Int): LiveData<RestaurantWithMenu>

    @Query("SELECT * FROM Restaurant")
    fun getAllRestaurants(): LiveData<List<Restaurant>>

    @Query("SELECT * FROM Restaurant WHERE id = :restaurantId")
    fun getRestaurantById(restaurantId: Int): LiveData<Restaurant>

    @Query("SELECT COUNT(*) FROM restaurant")
    suspend fun getCount(): Int
}