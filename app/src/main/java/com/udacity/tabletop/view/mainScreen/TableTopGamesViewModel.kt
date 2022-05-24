package com.udacity.tabletop.view.mainScreen

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.udacity.tabletop.view.base.BaseViewModel
import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.data.dto.Result.Success
import com.udacity.tabletop.data.dto.Result.Error
import kotlinx.coroutines.launch

class TableTopGamesViewModel(
    app: Application,
    private val dataSource: TableTopDataSource
) : BaseViewModel(app) {
    // list that holds the reminder data to be displayed on the UI
    val remindersList = MutableLiveData<List<TableTopDataItem>>()

    /**
     * Get all the reminders from the DataSource and add them to the remindersList to be shown on the UI,
     * or show error if any
     */
    fun loadReminders() {
        showLoading.value = true
        viewModelScope.launch {
            //interacting with the dataSource has to be through a coroutine
            val result = dataSource.getReminders()
            showLoading.postValue(false)
            when (result) {
                is Success<*> -> {
                    val dataList = ArrayList<TableTopDataItem>()
                    dataList.addAll((result.data as List<TableTopDTO>).map { reminder ->
                        //map the reminder data from the DB to the be ready to be displayed on the UI
                        TableTopDataItem(
                            reminder.title,
                            reminder.description,
                            reminder.location,
                            reminder.latitude,
                            reminder.longitude,
                            reminder.id
                        )
                    })
                    remindersList.value = dataList
                }
                is Error ->
                    showSnackBar.value = result.message
            }

            //check if no data has to be shown
            invalidateShowNoData()
        }
    }

    /**
     * Inform the user that there's not any data if the remindersList is empty
     */
    private fun invalidateShowNoData() {
        showNoData.value = remindersList.value == null || remindersList.value!!.isEmpty()
    }
}