package com.example.dlstools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import kotlinx.android.synthetic.main.quotes_fragment.*

class QuotesFragment : Fragment() {
    private val resourceId by lazy { arguments?.getString("resource_id") }

    companion object {
        fun newInstance(id: String): QuotesFragment {
            val args = Bundle()
            args.putString("resource_id", id)
            val fragment = QuotesFragment()
            fragment.arguments = args

            return fragment

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout = inflater.inflate(R.layout.quotes_fragment, container, false)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(resourceId != null){
            iv_quote.load(resourceId)
        }



    }
}