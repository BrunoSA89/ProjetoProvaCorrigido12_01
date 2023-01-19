package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.novoprojetoapp12janeiro.R

class TelaDetalesFragment : Fragment(R.layout.fragment_tela_detales) {

    val args: TelaDetalesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(">>>>>>>>>>>>>>>>>>")
        println(args.perfilRecycler)
        println(args.dataCalculo)
        println(">>>>>>>>>>>>>>>>>>")
    }

}