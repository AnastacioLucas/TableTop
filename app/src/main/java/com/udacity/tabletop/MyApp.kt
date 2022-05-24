package com.udacity.tabletop

import android.app.Application
import com.udacity.tabletop.locationreminders.data.TableTopDataSource
import com.udacity.tabletop.locationreminders.data.local.LocalDB
import com.udacity.tabletop.locationreminders.data.local.TableTopLocalRepository
import com.udacity.tabletop.locationreminders.reminderslist.TableTopGamesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        /**
         * use Koin Library as a service locator
         */
        val myModule = module {
            //Declare a ViewModel - be later inject into Fragment with dedicated injector using by viewModel()
            viewModel {
                TableTopGamesViewModel(
                    get(),
                    get() as TableTopDataSource
                )
            }
            // RemindersLocalRepository
            single<TableTopLocalRepository> {TableTopLocalRepository(get())}
            // ReminderDataSource
            single<TableTopDataSource> {get<TableTopLocalRepository>()}

            single { LocalDB.createRemindersDao(this@MyApp) }
        }

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(myModule))
        }
    }
}