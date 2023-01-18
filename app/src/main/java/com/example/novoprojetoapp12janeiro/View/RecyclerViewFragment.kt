package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.novoprojetoapp12janeiro.R

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    var args: RecyclerViewFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}