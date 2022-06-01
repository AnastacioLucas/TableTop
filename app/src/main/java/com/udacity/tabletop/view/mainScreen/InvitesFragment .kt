package com.udacity.tabletop.view.mainScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.tabletop.R
import com.udacity.tabletop.databinding.InvitesFragmentBinding

class SecondFragment : Fragment() {

    private lateinit var binding: InvitesFragmentBinding

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
