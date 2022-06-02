package com.udacity.tabletop

import android.app.Application
import com.google.firebase.FirebaseApp
import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.local.LocalDB
import com.udacity.tabletop.data.local.TableTopLocalRepository
import com.udacity.tabletop.view.mainScreen.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)

        /**
         * use Koin Library as a service locator
         */
        val myModule = module {
            //Declare a ViewModel - be later inject into Fragment with dedicated injector using by viewModel()
            viewModel {
                MainViewModel(
                    get(),
                    get() as TableTopDataSource
                )
            }
            // TableTopsLocalRepository
            single<TableTopLocalRepository> {TableTopLocalRepository(get())}
            // TableTopDataSource
            single<TableTopDataSource> {get<TableTopLocalRepository>()}

            single { LocalDB.createTableTopsDao(this@MyApp) }
        }

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(myModule))
        }
    }
}