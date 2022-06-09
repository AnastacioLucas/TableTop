package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.tabletop.view.mainScreen.Game
import com.udacity.tabletop.view.mainScreen.Player
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
        _viewModel.loadTableTops()
    }

    private fun setupRecyclerView() {
        val adapter = GamesListAdapter {
        }
//        setup the recycler view using the extension function
        binding.newGamesRecyclerView.setup(adapter)
    }
}