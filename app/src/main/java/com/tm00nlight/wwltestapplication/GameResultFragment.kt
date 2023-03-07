package com.tm00nlight.wwltestapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tm00nlight.wwltestapplication.databinding.FragmentGameResultBinding

class GameResultFragment : Fragment() {
    lateinit var binding: FragmentGameResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = arguments?.getBoolean("GAME_RESULT")
        if (result == true) {
            binding.root.setBackgroundColor(resources.getColor(R.color.green_200))
            binding.result.text = getString(R.string.success)
        } else {
            binding.root.setBackgroundColor(resources.getColor(R.color.red_200))
            binding.result.text = getString(R.string.fail)
        }

        binding.tryAgain.setOnClickListener {
            findNavController().navigate(R.id.action_gameResultFragment_to_gameMenuFragment)
        }
    }
}