package com.udacity.tabletop.view.mainScreen.pages

import com.udacity.tabletop.R
import com.udacity.tabletop.view.base.BaseRecyclerViewAdapter
import com.udacity.tabletop.view.mainScreen.TableTopDataItem


//Use data binding to show the reminder on the item
class GamesListAdapter(callBack: (selectedReminder: TableTopDataItem) -> Unit) :
    BaseRecyclerViewAdapter<TableTopDataItem>(callBack) {
    override fun getLayoutRes(viewType: Int) = R.layout.it_game
}