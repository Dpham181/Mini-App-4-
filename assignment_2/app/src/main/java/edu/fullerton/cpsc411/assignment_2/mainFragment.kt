package edu.fullerton.cpsc411.assignment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.fullerton.cpsc411.assignment_2.databinding.FragmentMainBinding





class mainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

    // binding the model with inflate view at the same time
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewmodel = ViewModelProviders.of(this).get(DataModel::class.java)
        // using root for getting the fragment view
        val fragmentView = binding.root
        // return view
        return fragmentView
    }






}






