package com.tm00nlight.wwltestapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tm00nlight.wwltestapplication.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            when (it.getInt("QUESTION_NUMBER")) {
                1 -> {
                    binding.question.text = getString(R.string.question_coffee)
                    binding.image1.setImageDrawable(resources.getDrawable(R.drawable.cappuccino))
                    binding.image2.setImageDrawable(resources.getDrawable(R.drawable.latte))
                    setCorrectSecondImage()
                }
                2 -> {
                    binding.question.text = getString(R.string.question_food)
                    binding.image1.setImageDrawable(resources.getDrawable(R.drawable.lasagne))
                    binding.image2.setImageDrawable(resources.getDrawable(R.drawable.carbonara))
                    setCorrectFirstImage()
                }
                3 -> {
                    binding.question.text = getString(R.string.question_cats)
                    binding.image1.setImageDrawable(resources.getDrawable(R.drawable.british))
                    binding.image2.setImageDrawable(resources.getDrawable(R.drawable.scottish))
                    setCorrectSecondImage()
                }
                else -> {
                    binding.question.text = getString(R.string.question_dogs)
                    binding.image1.setImageDrawable(resources.getDrawable(R.drawable.spitz))
                    binding.image2.setImageDrawable(resources.getDrawable(R.drawable.pudel))
                    setCorrectFirstImage()
                }
            }

        }
    }

    private fun answer(result: Boolean) {
        val bundle = Bundle()
        bundle.putBoolean("GAME_RESULT", result)
        findNavController().navigate(R.id.action_gameFragment_to_gameResultFragment, bundle)
    }

    private fun setCorrectFirstImage() {
        binding.image1.setOnClickListener { answer(true) }
        binding.image2.setOnClickListener { answer(false) }
    }

    private fun setCorrectSecondImage() {
        binding.image1.setOnClickListener { answer(false) }
        binding.image2.setOnClickListener { answer(true) }
    }
}