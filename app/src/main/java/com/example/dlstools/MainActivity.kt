package com.example.dlstools

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.backdrop_items.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val module1Fragment by lazy { Module1Fragment() }
    private val module2Fragment by lazy { Module2Fragment() }
    private val module3Fragment by lazy { Module3Fragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(NavigationIconClickListener(this, container, AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(this,R.drawable.ic_menu),
            ContextCompat.getDrawable(this,R.drawable.ic_close_icon)
        ))

        tv_module1.setOnClickListener(this)
        tv_module2.setOnClickListener(this)
        tv_module3.setOnClickListener(this)
        tv_money_caluculation.setOnClickListener(this)
        tv_abt_me.setOnClickListener(this)


        replaceFragment(module1Fragment,R.id.container)

        botton_nav_bar.setItemSelected(R.id.module_1)

        botton_nav_bar.setOnItemSelectedListener {
            when (it) {
                R.id.module_1 -> replaceFragment(
                    module1Fragment,
                    R.id.container
                )
                R.id.module_2 -> replaceFragment(
                    module2Fragment,
                    R.id.container
                )
                R.id.module_3 -> replaceFragment(
                    module3Fragment,
                    R.id.container
                )

                else -> {
                      //do nothing.
                }
            }

        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_module1 -> {
                launchActivity<Module1Contents>()
            }

            R.id.tv_module2 -> {
                launchActivity<Module2Contents>()
            }

            R.id.tv_module3 -> {
                launchActivity<Module3Contents>()
            }

            R.id.tv_money_caluculation -> {
                launchActivity<MoneyCalculationActivity>()
            }

            R.id.tv_abt_me -> {
                launchActivity<AboutMe>()
            }

        }
    }


}

class CardStackTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        if (position >= 0) {
            page.scaleX = (0.9f - 0.02f * position)
            page.scaleY = 1f

            page.translationX = - page.width * position
            page.translationY = 20 * position
        }
    }

}
