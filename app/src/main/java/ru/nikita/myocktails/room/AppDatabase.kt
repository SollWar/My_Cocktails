package ru.nikita.myocktails.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.nikita.myocktails.data.CocktailEntity

@Database(
    version = 1,
    entities = [CocktailEntity::class]
)
@TypeConverters(ConvertersRoom::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getCocktailsRoomDao(): CocktailsRoomDao

}