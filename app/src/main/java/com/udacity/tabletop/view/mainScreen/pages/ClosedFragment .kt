package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.tabletop.R
import com.udacity.tabletop.databinding.ClosedFragmentBinding
import com.udacity.tabletop.view.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClosedFragment : BaseFragment() {

    private lateinit var binding: ClosedFragmentBinding
    override val _viewModel: ClosedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ClosedFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
    }

    private fun setupData() {
        binding.label.text = getString(R.string.closed_fragment)
    }
}