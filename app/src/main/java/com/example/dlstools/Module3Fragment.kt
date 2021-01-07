package com.example.dlstools

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_module1.*
import kotlinx.android.synthetic.main.fragment_module2.*
import kotlinx.android.synthetic.main.fragment_module3.*

class Module3Fragment : Fragment() {

    var Images = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rotating_bar.playAnimation()


        Handler().postDelayed({
            rotating_bar.visibility = GONE
            if (isOnline(context!!)) {
                addImages()
                giveImagesToTheAdapter(activity!!.supportFragmentManager, Images, vp_quotes_module3)
            } else {
                context?.showNetworkErrorDialog({
                    if (loadImages()) {
                        context?.showToast("Successfully Connected to to the Internet")
                        it.dismiss()
                    } else {
                        reloadFragment(fragmentManager!!,this)
                    }
                }, {
                    tv_error_3.visibility = VISIBLE
                    it.dismiss()
                })
            }

        }, 2000)

    }

    private fun addImages() {
        Images.add("https://i.ibb.co/TM9cd6w/26.png")
        Images.add("https://i.ibb.co/T8sFmjX/27.png")
        Images.add("https://i.ibb.co/k4xHYhD/28.png")
        Images.add("https://i.ibb.co/C8RJcTv/29.png")
        Images.add("https://i.ibb.co/L97vdgb/30.png")
        Images.add("https://i.ibb.co/fFpQZgg/31.png")
        Images.add("https://i.ibb.co/XWMwqXr/33.png")
        Images.add("https://i.ibb.co/DCzzzwF/34.png")
    }

    private fun loadImages(): Boolean {
        var isImagesLoaded = false
        if (isOnline(context!!)) {
            addImages()
            giveImagesToTheAdapter(activity!!.supportFragmentManager, Images, vp_quotes_module3)
            isImagesLoaded = true
        } else {
            isImagesLoaded = false
        }

        return isImagesLoaded
    }
}