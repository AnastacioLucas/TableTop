package com.udacity.tabletop.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.udacity.tabletop.R
import com.udacity.tabletop.view.mainScreen.Game
import com.udacity.tabletop.view.base.BaseRecyclerViewAdapter
import java.io.StringWriter

object BindingAdapters {
    /**
     * Use binding adapter to set the recycler view data using livedata object
     */
    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("android:liveData")
    @JvmStatic
    fun <T> setRecyclerViewData(recyclerView: RecyclerView, items: LiveData<List<T>>?) {
        items?.value?.let { itemList ->
            (recyclerView.adapter as? BaseRecyclerViewAdapter<T>)?.apply {
                clear()
                addData(itemList)
            }
        }
    }

    /**
     * Use this binding adapter to show and hide the views using boolean variables
     */
    @BindingAdapter("android:fadeVisible")
    @JvmStatic
    fun setFadeVisible(view: View, visible: Boolean? = true) {
        if (view.tag == null) {
            view.tag = true
            view.visibility = if (visible == true) View.VISIBLE else View.GONE
        } else {
            view.animate().cancel()
            if (visible == true) {
                if (view.visibility == View.GONE)
                    view.fadeIn()
            } else {
                if (view.visibility == View.VISIBLE)
                    view.fadeOut()
            }
        }
    }

    @BindingAdapter("android:gameStatus")
    @JvmStatic
    fun gameStatus(imageView: ImageView, gameStatus: String) {
        Log.d("CardGame", "gameStatus: "+gameStatus)
        val iconRes = when(gameStatus) {
            GameStatus.NEW.name -> R.drawable.game_accepted
            GameStatus.ON_GOING.name -> R.drawable.game_started
            GameStatus.INVITED.name -> R.drawable.game_invited
            GameStatus.CANCELED.name -> R.drawable.game_canceled
            GameStatus.FINISHED.name -> R.drawable.game_finished
            else -> R.drawable.game_accepted
        }
        imageView.setImageResource(iconRes)
    }

    @BindingAdapter("android:formatTimeAndDay")
    @JvmStatic
    fun formatTimeAndDay(textView: TextView, game: Game) {
        val formattedTime = StringWriter()
        formattedTime.append(formatTime(game.time!!))
        val daysSplit = game.daysOfTheWeek?.split(",")

        daysSplit?.forEach {
            formattedTime.append("\n$it")
        }
        textView.text = formattedTime.toString()
    }

    @BindingAdapter("android:masterLabel")
    @JvmStatic
    fun setMasterLabel(textView: TextView, master: String) {
        val context = textView.context
        textView.text = context.getString(R.string.game_master_label, master)
    }
}