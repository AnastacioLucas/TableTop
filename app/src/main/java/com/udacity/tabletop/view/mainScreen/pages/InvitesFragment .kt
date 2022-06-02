package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.tabletop.R
import com.udacity.tabletop.databinding.InvitesFragmentBinding
import com.udacity.tabletop.view.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : BaseFragment() {

    private lateinit var binding: InvitesFragmentBinding
    override val _viewModel: InvitesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InvitesFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
    }

    private fun setupData() {
        binding.label.text = getString(R.string.second_fragment)
    }
}
