package eu.friton.dreamvault.DataDrm

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    //Insert a wish
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>
    //Flow is like LiveData, is designed to provide an efficient way to handle data
    //Update a wish
    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)
    //Delete a wish
    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)
    //Fetch a single wish by id
    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long): Flow<Wish>


}