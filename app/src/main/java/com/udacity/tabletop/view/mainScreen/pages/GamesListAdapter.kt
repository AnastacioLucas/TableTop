package com.udacity.tabletop.view.mainScreen.pages

import com.udacity.tabletop.R
import com.udacity.tabletop.view.mainScreen.Game
import com.udacity.tabletop.view.base.BaseRecyclerViewAdapter

//Use data binding to show the reminder on the item
class GamesListAdapter(callBack: (game: Game) -> Unit) :
    BaseRecyclerViewAdapter<Game>(callBack) {
    override fun getLayoutRes(viewType: Int) = R.layout.it_game
}