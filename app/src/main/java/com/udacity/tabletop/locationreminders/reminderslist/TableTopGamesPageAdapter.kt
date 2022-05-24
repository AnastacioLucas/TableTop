package com.udacity.tabletop.locationreminders.reminderslist

import com.udacity.tabletop.R
import com.udacity.tabletop.base.BaseRecyclerViewAdapter


//Use data binding to show the reminder on the item
class TableTopGamesPageAdapter(callBack: (selectedReminder: TableTopDataItem) -> Unit) :
    BaseRecyclerViewAdapter<TableTopDataItem>(callBack) {
    override fun getLayoutRes(viewType: Int) = R.layout.it_reminder
}