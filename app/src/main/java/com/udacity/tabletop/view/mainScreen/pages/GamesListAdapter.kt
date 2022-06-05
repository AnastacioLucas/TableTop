package com.udacity.tabletop.view.mainScreen.pages

import com.udacity.tabletop.R
import com.udacity.tabletop.data.model.Game
import com.udacity.tabletop.view.base.BaseRecyclerViewAdapter
import com.udacity.tabletop.data.model.TableTopDataItem

//Use data binding to show the reminder on the item
class GamesListAdapter(callBack: (game: Game) -> Unit) :
    BaseRecyclerViewAdapter<Game>(callBack) {
    override fun getLayoutRes(viewType: Int) = R.layout.it_game
}