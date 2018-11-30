package edu.fullerton.cpsc411.assignment_2

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableDouble
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

import java.util.*

// two functions for math calculation and round off
fun cal(mib: kotlin.Double?, mbp: kotlin.Double?): Double {

    return mib!! * Math.pow(2.0, 20.0) * 8.0 / (mbp!! * Math.pow(10.0, 6.0))
}
fun roundOff(final_output: kotlin.Double?): String {

    return String.format(Locale.US, "%.1f", final_output)

}
open class DataModel : ViewModel(), Observable {
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()
    // build in call back
    override fun addOnPropertyChangedCallback(
            callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(
            callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }


    // observable decleartion for two inputs text
    val mib = ObservableDouble();
    val mbps = ObservableDouble();


    // first text on change to get update for file size called mib
    fun mibTextChanged(s: CharSequence) {

        Log.w("tag", "onTextChanged " + s);
        // check string is empty incase blank edittext

        if(s.isNotEmpty()) {
            mib.set(java.lang.Double.parseDouble(s.toString()));
        }else{
            mib.set(0.0);

        }

    }
    // second text on change to get update for net speed called mbps
    fun mbpsTextChanged(s: CharSequence) {

        Log.w("tag", "onTextChanged " + s);

        // check string is empty incase blank edittext
        if (s.isNotEmpty()) {

            mbps.set(java.lang.Double.parseDouble(s.toString()));

        }
        else
        {
            mbps.set(0.0);

        }
    }
    // final  textview output get those and one more check for empty then roundoff convert to double
    val finalouput: ObservableDouble = object : ObservableDouble(mib,mbps) {

        override fun get(): Double {

                return java.lang.Double.parseDouble(roundOff(cal(mib.get(), mbps.get())));

        }
    }



}





