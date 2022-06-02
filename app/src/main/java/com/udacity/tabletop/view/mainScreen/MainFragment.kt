package com.udacity.tabletop.view.mainScreen

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.google.android.material.tabs.TabLayoutMediator
import com.udacity.tabletop.R
import com.udacity.tabletop.view.base.BaseFragment
import com.udacity.tabletop.utils.setDisplayHomeAsUpEnabled
import com.udacity.tabletop.utils.setTitle
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.udacity.tabletop.databinding.FragmentMainBinding

class MainFragment : BaseFragment() {

    //use Koin to retrieve the ViewModel instance
    override val _viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_main, container, false
            )
        binding.viewModel = _viewModel

        setHasOptionsMenu(true)
        setDisplayHomeAsUpEnabled(false)
        setTitle(getString(R.string.app_name))

//        binding.refreshLayout.setOnRefreshListener { _viewModel.loadTableTops() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        setupRecyclerView()
        setupTabLayout()

        binding.newTableTop.setOnClickListener {
        }

        if (Firebase.auth.currentUser == null) {
            findNavController().navigate(MainFragmentDirections.toLogin())
        }
    }

    override fun onResume() {
        super.onResume()
        //load the tableTops list on the ui
        _viewModel.loadTableTops()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabLayout, binding.mainPages
        ) { tab, position ->
            tab.text = when(position) {
                0 -> "New/OnGoing"
                1 -> "Invites"
                2 -> "Closed"
                else -> "New/OnGoing"
            }
        }.attach()
    }

    private fun setupRecyclerView() {
        val adapter = MainPageAdapter (requireActivity(), 3)
//        setup the recycler view using the extension function
        binding.mainPages.adapter = (adapter)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                AuthUI.getInstance()
                    .signOut(requireContext())
                    .addOnCompleteListener {
                        findNavController().navigate(MainFragmentDirections.toLogin())
                    }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }
}
