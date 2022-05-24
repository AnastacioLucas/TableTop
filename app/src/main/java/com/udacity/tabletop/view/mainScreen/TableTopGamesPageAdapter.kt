package com.udacity.tabletop.view.mainScreen

import com.udacity.tabletop.R
import com.udacity.tabletop.view.base.BaseRecyclerViewAdapter


//Use data binding to show the reminder on the item
class TableTopGamesPageAdapter(callBack: (selectedReminder: TableTopDataItem) -> Unit) :
    BaseRecyclerViewAdapter<TableTopDataItem>(callBack) {
    override fun getLayoutRes(viewType: Int) = R.layout.it_reminder
}