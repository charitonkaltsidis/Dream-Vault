package eu.friton.dreamvault

import android.content.Context
import androidx.room.Room
import eu.friton.dreamvault.DataDrm.WishDatabase
import eu.friton.dreamvault.DataDrm.WishRepository

//Singleton, one instance exist in the app. Graph is being used as a service locator.
object Graph {
    lateinit var database: WishDatabase
    //"by lazy" initialise the repository the moment we need it
    val wishRepository by lazy{
        WishRepository(wishDao = database.wishDao())
    }
    //initialise
    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}