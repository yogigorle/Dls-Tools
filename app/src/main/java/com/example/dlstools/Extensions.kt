package com.example.dlstools

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Paint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.dialog.MaterialAlertDialogBuilder


inline fun <reified T : Any> Activity.launchActivity() {
    val intent = newIntent<T>(this)
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

fun giveImagesToTheAdapter(
    fragmentManager: FragmentManager,
    Images: ArrayList<String>,
    viewPager: ViewPager
) {

    val quotesViewPagerAdapter = QuotesViewPagerAdapter(fragmentManager, Images)

    viewPager.offscreenPageLimit = Images.size

    viewPager.setPageTransformer(true, CardStackTransformer())

    viewPager.adapter = quotesViewPagerAdapter
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commitAllowingStateLoss()
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    frameId: Int,
    force: Boolean = false,
    tag: String = fragment.javaClass.simpleName
) {
    if (force) {
        if (!fragment.isAdded)
            supportFragmentManager.inTransaction { replace(frameId, fragment, "force") }
    } else {
        supportFragmentManager.inTransaction {
            try {
                val oldFragment = supportFragmentManager.findFragmentByTag(tag)

                supportFragmentManager.fragments.forEach {
                    if (it.id == frameId && it != fragment && it.tag != "force") hide(
                        it
                    )
                }
                if (oldFragment == null && !fragment.isAdded) {
                    add(frameId, fragment, tag)
                } else {
                    if (fragment.isAdded)
                        show(fragment)
                    else
                        add(frameId, fragment, tag)
                }
            } catch (ex: java.lang.IllegalStateException) {
                show(fragment)
            }
        }
    }
}

fun setStrikeThroughText(textView: TextView) {
    if (!textView.paint.isStrikeThruText) {
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        textView.alpha = 0.4f
    } else {
        textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        textView.alpha = 1f
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun putBoolean(key: String, value: Boolean) {
    val sp = MyApplication.sharedPreferences
    sp.edit().putBoolean(key, value).apply()
}

fun getBoolean(key: String): Boolean {
    val sp = MyApplication.sharedPreferences
    return sp.getBoolean(key, false)
}

fun isOnline(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
            return true
        }
    }
    return false
}

fun Context.showNetworkErrorDialog(
    positiveButtonClicked: (alertDialog: DialogInterface) -> Unit,
    negativeButtonClicked: (alertDialog: DialogInterface) -> Unit
) {
    MaterialAlertDialogBuilder(this, R.style.AlertDialogTheme)
        .setTitle("Alert")
        .setMessage("Please Check Your Internet Connectivity and Try Again!.")
        .setCancelable(false)
        .setPositiveButton(
            "Try Again"
        ) { p0, _ -> positiveButtonClicked.invoke(p0!!) }


        .setNegativeButton(
            "CANCEL"
        ) { p0, _ ->

            negativeButtonClicked.invoke(p0!!)
        }
        .show()

}

fun reloadFragment(fragmentManager: FragmentManager, fragment: Fragment) {
    fragmentManager.beginTransaction().detach(fragment).attach(fragment).commit()
}