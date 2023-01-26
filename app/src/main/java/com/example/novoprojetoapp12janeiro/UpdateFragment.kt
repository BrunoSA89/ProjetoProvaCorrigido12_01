package com.example.novoprojetoapp12janeiro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.novoprojetoapp12janeiro.Model.DataCalculo
import com.example.novoprojetoapp12janeiro.Model.PerfilRecycler
import com.example.novoprojetoapp12janeiro.View.CadastroNotasFragmentDirections
import kotlinx.android.synthetic.main.fragment_cadastro_notas.*


class UpdateFragment : Fragment(R.layout.fragment_update) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
// funcao que pegue os dados dos campos de texto e inicializa o objeto com os dados dos campos
//        e envia via argumento para a tela de lista
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.buttonAtualizarNota).setOnClickListener {

            val action = CadastroNotasFragmentDirections.actionCadastroNotasFragmentToRecyclerViewFragment(

            )
            findNavController().navigate(action)
        }
    }

    fun createPerfil() : PerfilRecycler {
        var perfil = PerfilRecycler(
            editTextNomeAluno.text.toString(),
            editTextNumberNota1.text.toString().toFloat(),
            editTextNumberNota2.text.toString().toFloat(),
            editTextNumberNota3.text.toString().toFloat(),
            editTextNumberNota4.text.toString().toFloat()
        )
        return perfil
    }
    fun createDataCalculo() : DataCalculo {
        val perfil = null!
        var dataCalculo = DataCalculo(perfil.aluno, calculoNotas())
        return dataCalculo
    }

    fun calculoNotas() : Float {
        return ((editTextNumberNota1.text.toString().toFloat() + editTextNumberNota2.text.toString().toFloat()) +
                (editTextNumberNota3.text.toString().toFloat() + editTextNumberNota4.text.toString().toFloat())) / 4
    }


}