package com.udacity.tabletop.view.mainScreen.createGame

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.udacity.tabletop.R
import com.udacity.tabletop.view.base.BaseViewModel
import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.GameDTO
import com.udacity.tabletop.data.dto.Result.Success
import com.udacity.tabletop.view.mainScreen.Game
import com.udacity.tabletop.view.mainScreen.Player
import kotlinx.coroutines.launch

class CreateGameViewModel(val
    app: Application,
                          private val dataSource: TableTopDataSource
) : BaseViewModel(app) {
    // list that holds the tableTop data to be displayed on the UI
    val tableTopsList = MutableLiveData<List<Game>>()
}