package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.tabletop.view.mainScreen.Game
import com.udacity.tabletop.view.mainScreen.Player
import com.udacity.tabletop.databinding.NewFragmentBinding
import com.udacity.tabletop.utils.setup
import com.udacity.tabletop.view.base.BaseFragment
import com.udacity.tabletop.utils.GameStatus
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

        _viewModel.loadTableTops()

//        addMock()
    }

    private fun addMock(){
        val gameMaster = Player("Redkey")

        val gameItem = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.NEW.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )

        val gameItem1 = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.ON_GOING.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )


        val gameItem2 = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.INVITED.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )


        val gameItem3 = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.FINISHED.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )


        val gameItem4 = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.CANCELED.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )

        _viewModel.saveNewGame(gameItem)
        _viewModel.saveNewGame(gameItem1)
        _viewModel.saveNewGame(gameItem2)
        _viewModel.saveNewGame(gameItem3)
        _viewModel.saveNewGame(gameItem4)

    }

    private fun setupRecyclerView() {
        val adapter = GamesListAdapter {
        }
//        setup the recycler view using the extension function
        binding.newGamesRecyclerView.setup(adapter)
    }
}