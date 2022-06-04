package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.tabletop.R
import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.databinding.NewFragmentBinding
import com.udacity.tabletop.utils.setup
import com.udacity.tabletop.view.base.BaseFragment
import com.udacity.tabletop.view.mainScreen.TableTopDataItem
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
            addMock()
            binding.newGameRefreshLayout.isRefreshing = false
        }
    }

    private fun addMock(){
        var itemTest = TableTopDataItem("Item teste","esse é um item de teste ", "boa pergunta", 1.0, 1.2)
        _viewModel.loadTableTops2(itemTest)
    }

    private fun setupRecyclerView() {
        val adapter = GamesListAdapter {
        }
//        setup the recycler view using the extension function
        binding.newGamesRecyclerView.setup(adapter)
    }
}