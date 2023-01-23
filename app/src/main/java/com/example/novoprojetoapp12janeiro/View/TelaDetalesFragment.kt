package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.novoprojetoapp12janeiro.R
import kotlinx.android.synthetic.main.fragment_tela_detales.*

class TelaDetalesFragment : Fragment(R.layout.fragment_tela_detales) {

    val args: TelaDetalesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(">>>>>>>>>>>>>>>>>>")
        println(args.perfilRecycler)
        println(args.dataCalculo)
        println(">>>>>>>>>>>>>>>>>>")

        // ID do campo mais o que contem mais args mais arquivo aonde
        // esta a informacao kt mais ID strig

        nomeAlunoResultado.text = args.dataCalculo.nome
        // concatenando float em string
        numberNota1.setText("${args.perfilRecycler.nota1}")
        numberNota2.setText("${args.perfilRecycler.nota2}")
        numberNota3.setText("${args.perfilRecycler.nota3}")
        numberNota4.setText("${args.perfilRecycler.nota4}")
        numberNotaResult.setText("${args.dataCalculo.media}")






    }

}