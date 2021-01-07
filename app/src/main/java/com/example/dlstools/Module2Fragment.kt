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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Module2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Module2Fragment : Fragment() {

    var Images = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rotating_bar_2.playAnimation()

//        addImages()


        Handler().postDelayed({
            rotating_bar_2.visibility = GONE
            if (isOnline(context!!)) {
                addImages()
                giveImagesToTheAdapter(activity!!.supportFragmentManager, Images, vp_quotes_module2)
            } else {
                context?.showNetworkErrorDialog({
                    if (loadImages()) {
                        context?.showToast("Successfully Connected to to the Internet")
                        it.dismiss()
                    } else {
                        reloadFragment(fragmentManager!!,this)
                    }
                }, {
                    tv_error_2.visibility = VISIBLE
                    it.dismiss()
                })
            }

        }, 2000)

    }

    private fun addImages() {
        Images.add("https://i.ibb.co/Scv3MGj/11.png")
        Images.add("https://i.ibb.co/kGV3gbD/12.png")
        Images.add("https://i.ibb.co/XpcQ2LJ/13.png")
        Images.add("https://i.ibb.co/c2vLvZW/14.png")
        Images.add("https://i.ibb.co/5F9FVFY/15.png")
        Images.add("https://i.ibb.co/KzppBpJ/16.png")
        Images.add("https://i.ibb.co/f1rYNy2/17.png")
        Images.add("https://i.ibb.co/JyF2s3W/18.png")
        Images.add("https://i.ibb.co/1mBq7NY/19.png")
        Images.add("https://i.ibb.co/kqffw9Z/20.png")
        Images.add("https://i.ibb.co/s3xm64B/21.png")
        Images.add("https://i.ibb.co/g9L1VVS/22.png")
        Images.add("https://i.ibb.co/xF38Gkw/23.png")
        Images.add("https://i.ibb.co/GTBszDb/24.png")
        Images.add("https://i.ibb.co/qmzFcJY/25.png")

    }

    private fun loadImages(): Boolean {
        var isImagesLoaded = false
        if (isOnline(context!!)) {
            addImages()
            giveImagesToTheAdapter(activity!!.supportFragmentManager, Images, vp_quotes_module2)
            isImagesLoaded = true
        } else {
            isImagesLoaded = false
        }

        return isImagesLoaded
    }
}