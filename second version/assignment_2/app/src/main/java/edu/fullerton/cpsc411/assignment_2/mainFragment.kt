package edu.fullerton.cpsc411.assignment_2

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.fullerton.cpsc411.assignment_2.databinding.FragmentMainBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class mainFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var listener: OnFragmentInteractionListener? = null

    // deceleration the model view with lazy as labcode for gettting the class viewmodel
    private val dataModel by lazy { ViewModelProviders.of(this).get(DataModel::class.java) }



    // inflate fragment to match with layout and container


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

    // bidding the model with inflate view at the same time
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewmodel = dataModel
        // using root to layout the fragmentview on main activity
        val fragmentView = binding.root

        return fragmentView
    }



    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }


}






