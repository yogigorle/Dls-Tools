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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Module1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Module1Fragment : Fragment() {


    var Images = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rotating_bar_1.playAnimation()




        Handler().postDelayed({
            rotating_bar_1.visibility = GONE
            if (isOnline(context!!)) {
                addImages()
                giveImagesToTheAdapter(activity!!.supportFragmentManager, Images, vp_quotes_module1)
            } else {
                context?.showNetworkErrorDialog({
                    if (loadImages()) {
                        context?.showToast("Successfully Connected to to the Internet")
                        it.dismiss()
                    } else {
                        reloadFragment(fragmentManager!!,this)
                    }
                }, {
                    tv_error_1.visibility = VISIBLE
                    it.dismiss()
                })
            }

        }, 2000)

    }

    private fun addImages() {
        Images.add("https://i.ibb.co/MC4tgZq/quote1-module1.png")
        Images.add("https://i.ibb.co/yVkbSFT/2.png")
        Images.add("https://i.ibb.co/tx8bcVq/3.png")
        Images.add("https://i.ibb.co/sszdDT7/4.png")
        Images.add("https://i.ibb.co/5LDJf2H/5.png")
        Images.add("https://i.ibb.co/bBjDhRm/6.png")
        Images.add("https://i.ibb.co/jWxMpGp/7.png")
        Images.add("https://i.ibb.co/S370y5q/8.png")
        Images.add("https://i.ibb.co/p2HsJRP/9.png")
        Images.add("https://i.ibb.co/gjRM9Rv/10.png")
    }

    private fun loadImages(): Boolean {
        var isImagesLoaded = false
        if (isOnline(context!!)) {
            addImages()
            giveImagesToTheAdapter(activity!!.supportFragmentManager, Images, vp_quotes_module1)
            isImagesLoaded = true
        } else {
            isImagesLoaded = false
        }

        return isImagesLoaded
    }

//    private fun reloadFragment() {
//        fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit()
//    }


}