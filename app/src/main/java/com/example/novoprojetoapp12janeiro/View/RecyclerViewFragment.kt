package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novoprojetoapp12janeiro.Model.DataCalculo
import com.example.novoprojetoapp12janeiro.Model.PerfilRecycler
import com.example.novoprojetoapp12janeiro.R
import com.example.novoprojetoapp12janeiro.Resource.Adapter
import kotlinx.android.synthetic.main.fragment_recycler_view.*

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    val args: RecyclerViewFragmentArgs by navArgs()
    lateinit var listAdapter: Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    fun setAdapter() {
        listAdapter = Adapter(setListAdapter(args.dataCalculo)) {
            setClicked()
        }

        recyclerViewPagina.adapter = listAdapter
        recyclerViewPagina.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setListAdapter(dataCalculo: DataCalculo) : List<DataCalculo>{
        var list = ArrayList<DataCalculo>()
        list.add(dataCalculo)
        return list
    }

    fun setClicked() {
        val action = RecyclerViewFragmentDirections.actionRecyclerViewFragmentToTelaDetalesFragment(
            args.perfilRecycler,
            args.dataCalculo
        )
        findNavController().navigate(action)
    }
}