package com.udacity.tabletop.view.mainScreen.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.tabletop.R
import com.udacity.tabletop.databinding.NewFragmentBinding
import com.udacity.tabletop.view.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewFragment : BaseFragment() {

    private lateinit var binding: NewFragmentBinding
    override val _viewModel: NewViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newTableTop.setOnClickListener {
        }
    }
}