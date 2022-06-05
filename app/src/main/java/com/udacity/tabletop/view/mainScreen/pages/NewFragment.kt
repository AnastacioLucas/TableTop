package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.tabletop.data.model.Game
import com.udacity.tabletop.databinding.NewFragmentBinding
import com.udacity.tabletop.utils.setup
import com.udacity.tabletop.view.base.BaseFragment
import com.udacity.tabletop.data.model.TableTopDataItem
import com.udacity.tabletop.utils.GameStatus
import com.udacity.tabletop.utils.formatTime
import com.udacity.tabletop.utils.fromLocalDateToDate
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class NewFragment : BaseFragment() {

    private lateinit var binding: NewFragmentBinding
    override val _viewModel: NewViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewFragmentBinding.inflate(layoutInflater)

        binding.viewModel = _viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setupRecyclerView()

        binding.newTableTop.setOnClickListener {
        }

        binding.newGameRefreshLayout.setOnRefreshListener {
            binding.newGameRefreshLayout.isRefreshing = false
        }
        addMock()
    }

    private fun addMock(){
        val gameItem = Game(
            "Cthulhu Cap 06 boss Hastur",
            "cthulhu death may die",
            GameStatus.NEW.name,
            "Sabado",
            Calendar.getInstance().time
        )

        _viewModel.loadTableTops2(gameItem)
    }

    private fun setupRecyclerView() {
        val adapter = GamesListAdapter {
        }
//        setup the recycler view using the extension function
        binding.newGamesRecyclerView.setup(adapter)
    }
}