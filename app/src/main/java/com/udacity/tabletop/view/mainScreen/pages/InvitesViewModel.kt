package com.udacity.tabletop.view.mainScreen.pages

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.udacity.tabletop.view.base.BaseViewModel
import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.GameDTO
import com.udacity.tabletop.data.dto.Result
import com.udacity.tabletop.view.mainScreen.Game
import com.udacity.tabletop.view.mainScreen.Player
import kotlinx.coroutines.launch

class InvitesViewModel(
    app: Application,
    private val dataSource: TableTopDataSource
) : BaseViewModel(app) {
    // list that holds the tableTop data to be displayed on the UI
    val tableTopsList = MutableLiveData<List<Game>>()

    /**
     * Get all the tableTops from the DataSource and add them to the tableTopsList to be shown on the UI,
     * or show error if any
     */
    fun loadTableTops() {
        showLoading.value = true
        viewModelScope.launch {
            //interacting with the dataSource has to be through a coroutine
            val result = dataSource.getAllInvites()
            showLoading.postValue(false)
            when (result) {
                is Result.Success<*> -> {
                    val dataList = ArrayList<Game>()
                    dataList.addAll((result.data as List<GameDTO>).map { gameDTO ->
                        //map the tableTop data from the DB to the be ready to be displayed on the UI
                        Game(
                            gameDTO.title,
                            Player(gameDTO.master),
                            gameDTO.status,
                            gameDTO.daysOfTheWeek,
                            gameDTO.time,
                            gameDTO.id
                        )
                    })
                    tableTopsList.value = dataList
                }
                is Error ->
                    showSnackBar.value = result.message
            }

            //check if no data has to be shown
            invalidateShowNoData()
        }
    }

    /**
     * Inform the user that there's not any data if the tableTopsList is empty
     */
    private fun invalidateShowNoData() {
        showNoData.value = tableTopsList.value == null || tableTopsList.value!!.isEmpty()
    }
}