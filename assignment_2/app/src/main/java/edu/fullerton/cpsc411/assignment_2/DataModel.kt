package edu.fullerton.cpsc411.assignment_2

import androidx.databinding.Observable
import androidx.databinding.ObservableDouble
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

import java.util.*

// round off to one decimal

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



        if(s.isNotEmpty()) {
            mib.set(java.lang.Double.parseDouble(s.toString()));

            cal();
        }else{
            mib.set(0.0);

        }

    }
    // second text on change to get update for net speed called mbps
    fun mbpsTextChanged(s: CharSequence) {

        if (s.isNotEmpty()) {

            mbps.set(java.lang.Double.parseDouble(s.toString()));
            cal();
        }
        else
        {
            mbps.set(0.0);

        }
    }



    // final  textview output set then roundoff convert to double
   val finaloutput = ObservableDouble();
    fun cal() {

      val final=  mib.get() * Math.pow(2.0, 20.0) * 8.0 / (mbps.get() * Math.pow(10.0, 6.0))
        finaloutput.set(java.lang.Double.parseDouble(roundOff(final)));
    }

}





