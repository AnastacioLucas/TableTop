package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.tabletop.R
import com.udacity.tabletop.data.model.Game
import com.udacity.tabletop.data.model.Player
import com.udacity.tabletop.databinding.ClosedFragmentBinding
import com.udacity.tabletop.utils.GameStatus
import com.udacity.tabletop.utils.setup
import com.udacity.tabletop.view.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ClosedFragment : BaseFragment() {

    private lateinit var binding: ClosedFragmentBinding
    override val _viewModel: ClosedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ClosedFragmentBinding.inflate(layoutInflater)

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
        val gameMaster = Player("Redkey")

        val gameItem = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.CANCELED.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )

        val gameItem1 = Game(
            "Cthulhu Cap 06 boss Hastur",
            gameMaster,
            GameStatus.FINISHED.name,
            "Sabado,Domingo",
            Calendar.getInstance().time
        )

        val dataList = ArrayList<Game>()
        dataList.add(gameItem)
        dataList.add(gameItem1)
        _viewModel.tableTopsList.value = dataList
//        _viewModel.loadTableTops2(gameItem)
    }

    private fun setupRecyclerView() {
        val adapter = GamesListAdapter {
        }
//        setup the recycler view using the extension function
        binding.newGamesRecyclerView.setup(adapter)
    }
}