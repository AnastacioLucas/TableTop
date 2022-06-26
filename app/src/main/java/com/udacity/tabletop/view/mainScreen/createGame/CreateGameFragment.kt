package com.udacity.tabletop.view.mainScreen.createGame

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.udacity.tabletop.databinding.FragmentCreateGameBinding
import com.udacity.tabletop.view.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class CreateGameFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateGameBinding
    override val _viewModel: CreateGameViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateGameBinding.inflate(layoutInflater)

        binding.viewModel = _viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btShowTimePiker.setOnClickListener {
            TimePickerFragment().show(parentFragmentManager, "timePicker")
        }
    }

    class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            // Use the current time as the default values for the picker
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            // Create a new instance of TimePickerDialog and return it
            return TimePickerDialog(requireActivity(), this, hour, minute,
                DateFormat.is24HourFormat(requireActivity()))
        }

        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
            TODO("Not yet implemented")
        }
    }
}