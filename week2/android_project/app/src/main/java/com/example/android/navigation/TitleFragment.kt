package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_title, container, false)
        binding.playButton.setOnClickListener{view: View ->
//            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())

            //connect the button to the navigate action, the "findNavController" return the root of
            //navigation, you can traverse any fragment to find this root.
        }
//        binding.playButton.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Android Trivia"
        return binding.root
        // Inflate the layout for this fragment

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TitleFragment.
         */
        // TODO: Rename and change types and number of parameters
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}