package com.udacity.tabletop.view.mainScreen.pages

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.udacity.tabletop.view.base.BaseViewModel
import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.data.dto.Result.Success
import com.udacity.tabletop.data.dto.Result.Error
import com.udacity.tabletop.data.model.Game
import com.udacity.tabletop.data.model.TableTopDataItem
import kotlinx.coroutines.launch

class ClosedViewModel(
    app: Application,
    private val dataSource: TableTopDataSource
) : BaseViewModel(app) {
    // list that holds the tableTop data to be displayed on the UI
    val tableTopsList = MutableLiveData<List<Game>>()

    fun loadTableTops2(item: Game) {
        showLoading.value = true
        viewModelScope.launch {
            //interacting with the dataSource has to be through a coroutine
            showLoading.postValue(false)
            val dataList = ArrayList<Game>()
            dataList.add(item)
            tableTopsList.value = dataList
        }
    }
}