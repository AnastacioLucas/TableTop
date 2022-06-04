package com.udacity.tabletop.view.mainScreen.pages

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.udacity.tabletop.view.base.BaseViewModel
import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.data.dto.Result.Success
import com.udacity.tabletop.data.dto.Result.Error
import com.udacity.tabletop.view.mainScreen.TableTopDataItem
import kotlinx.coroutines.launch

class NewViewModel(
    app: Application,
    private val dataSource: TableTopDataSource
) : BaseViewModel(app) {
    // list that holds the tableTop data to be displayed on the UI
    val tableTopsList = MutableLiveData<List<TableTopDataItem>>()

    /**
     * Get all the tableTops from the DataSource and add them to the tableTopsList to be shown on the UI,
     * or show error if any
     */
    fun loadTableTops() {
        showLoading.value = true
        viewModelScope.launch {
            //interacting with the dataSource has to be through a coroutine
            val result = dataSource.getTableTops()
            showLoading.postValue(false)
            when (result) {
                is Success<*> -> {
                    val dataList = ArrayList<TableTopDataItem>()
                    dataList.addAll((result.data as List<TableTopDTO>).map { tableTop ->
                        //map the tableTop data from the DB to the be ready to be displayed on the UI
                        TableTopDataItem(
                            tableTop.title,
                            tableTop.description,
                            tableTop.location,
                            tableTop.latitude,
                            tableTop.longitude,
                            tableTop.id
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

    fun loadTableTops2(item: TableTopDataItem) {
        showLoading.value = true
        viewModelScope.launch {
            //interacting with the dataSource has to be through a coroutine
            showLoading.postValue(false)
            val dataList = ArrayList<TableTopDataItem>()
            dataList.add(item)
            tableTopsList.value = dataList
        }
    }

    /**
     * Inform the user that there's not any data if the tableTopsList is empty
     */
    private fun invalidateShowNoData() {
        showNoData.value = tableTopsList.value == null || tableTopsList.value!!.isEmpty()
    }
}