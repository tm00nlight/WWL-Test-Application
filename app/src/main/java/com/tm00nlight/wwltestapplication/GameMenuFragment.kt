package com.tm00nlight.wwltestapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tm00nlight.wwltestapplication.databinding.FragmentGameMenuBinding

class GameMenuFragment : Fragment() {
    lateinit var binding: FragmentGameMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = View.OnClickListener {
            val question: Int =
                when (it) {
                    binding.coffeeButton -> 1
                    binding.foodButton -> 2
                    binding.catsButton -> 3
                    else -> 4
                }

            val bundle = Bundle()
            bundle.putInt("QUESTION_NUMBER", question)
            findNavController().navigate(R.id.action_gameMenuFragment_to_gameFragment, bundle)
        }

        binding.coffeeButton.setOnClickListener(listener)
        binding.foodButton.setOnClickListener(listener)
        binding.catsButton.setOnClickListener(listener)
        binding.dogsButton.setOnClickListener(listener)
    }
}