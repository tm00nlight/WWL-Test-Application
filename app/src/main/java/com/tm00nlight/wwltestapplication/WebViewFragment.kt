package com.tm00nlight.wwltestapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(BuildConfig.URL_KEY)
        url.let {
            if (it != null) {
                val myWebView: WebView = requireActivity().findViewById(R.id.webView)
                myWebView.settings.javaScriptEnabled = true
                myWebView.loadUrl(it)
            }
        }
    }

}