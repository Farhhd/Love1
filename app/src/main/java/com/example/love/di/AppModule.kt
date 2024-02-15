package com.example.love.di

import android.content.Context
import android.content.SharedPreferences
import com.example.love.LoveApi
import com.example.love.data.Pref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApi::class.java)
    }
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences(Pref.PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun providePreferences(sharedPreferences: SharedPreferences): Pref{
        return Pref(sharedPreferences)
    }
}