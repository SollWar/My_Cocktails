package ru.nikita.myocktails.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideCocktailsRoomDao(appDatabase: AppDatabase): CocktailsRoomDao {
        return appDatabase.getCocktailsRoomDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context):
            AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Cocktails"
        ).build()
    }
}