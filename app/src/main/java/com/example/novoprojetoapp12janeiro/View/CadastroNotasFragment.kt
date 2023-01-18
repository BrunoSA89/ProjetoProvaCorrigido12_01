package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.novoprojetoapp12janeiro.R
import kotlinx.android.synthetic.main.fragment_cadastro_notas.*


class CadastroNotasFragment : Fragment(R.layout.fragment_cadastro_notas) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val action = CadastroNotasFragmentDirections.actionCadastroNotasFragmentToRecyclerViewFragment()

        view.findViewById<Button>(R.id.buttonCadastroNota).setOnClickListener {
            findNavController().navigate(R.id.action_cadastroNotasFragment_to_recyclerViewFragment)
        }
    }
    fun calculoNotas() : Float{
        return editTextNumberNota1.text.toString().toFloat() + editTextNumberNota2.text.toString().toFloat() +
                
    }

}