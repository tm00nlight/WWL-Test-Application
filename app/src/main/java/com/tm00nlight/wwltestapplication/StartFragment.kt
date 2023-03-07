package com.tm00nlight.wwltestapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

class StartFragment : Fragment() {
    private var pass = Random.nextBoolean()
    private var url = "https://webqr.com/"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (pass)
            findNavController().navigate(R.id.action_startFragment_to_gameMenuFragment)
        else {
            val bundle = Bundle()
            bundle.putString("web_link", url)
            findNavController().navigate(R.id.action_startFragment_to_webViewFragment, bundle)
        }
    }
}