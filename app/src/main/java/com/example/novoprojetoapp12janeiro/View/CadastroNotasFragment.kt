package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.novoprojetoapp12janeiro.Model.DataCalculo
import com.example.novoprojetoapp12janeiro.Model.PerfilRecycler
import com.example.novoprojetoapp12janeiro.R
import kotlinx.android.synthetic.main.fragment_cadastro_notas.*


class CadastroNotasFragment : Fragment(R.layout.fragment_cadastro_notas) {

    private lateinit var perfil: PerfilRecycler

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonCadastroNota).setOnClickListener {
            val action = CadastroNotasFragmentDirections.actionCadastroNotasFragmentToRecyclerViewFragment(
                createPerfil(),
                createDataCalculo()
            )
            findNavController().navigate(action)
        }
    }

    fun createPerfil() : PerfilRecycler {
        perfil = PerfilRecycler(
            editTextNomeAluno.text.toString(),
            editTextNumberNota1.text.toString().toFloat(),
            editTextNumberNota2.text.toString().toFloat(),
            editTextNumberNota3.text.toString().toFloat(),
            editTextNumberNota4.text.toString().toFloat())
        return perfil
    }

    fun createDataCalculo() : DataCalculo  {
        var dataCalculo = DataCalculo(perfil.aluno, calculoNotas())
        return dataCalculo
    }

    fun calculoNotas() : Float {
        return ((editTextNumberNota1.text.toString().toFloat() + editTextNumberNota2.text.toString().toFloat()) +
                (editTextNumberNota3.text.toString().toFloat() + editTextNumberNota4.text.toString().toFloat())) / 4
    }
}