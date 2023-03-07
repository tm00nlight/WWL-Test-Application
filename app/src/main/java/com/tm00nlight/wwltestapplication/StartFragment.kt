package com.tm00nlight.wwltestapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 60
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val pass = remoteConfig.getBoolean(PASS_KEY)
                    Log.d(PASS_KEY, pass.toString())
                    val url = remoteConfig.getString(URL_KEY)
                    Log.d(URL_KEY, url)

                    if (pass)
                        findNavController().navigate(R.id.action_startFragment_to_gameMenuFragment)
                    else {
                        val bundle = Bundle()
                        bundle.putString(URL_KEY, url)
                        findNavController().navigate(
                            R.id.action_startFragment_to_webViewFragment,
                            bundle
                        )
                    }
                } else {
                    Toast.makeText(requireActivity(), "Fetch failed", Toast.LENGTH_SHORT).show()
                }
            }

    }

    companion object {
        const val PASS_KEY = BuildConfig.PASS_KEY
        const val URL_KEY = BuildConfig.URL_KEY
    }
}