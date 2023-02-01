package com.example.novoprojetoapp12janeiro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.novoprojetoapp12janeiro.Model.DataCalculo
import com.example.novoprojetoapp12janeiro.Model.PerfilRecycler
import com.example.novoprojetoapp12janeiro.View.CadastroNotasFragmentDirections
import kotlinx.android.synthetic.main.fragment_cadastro_notas.*
import kotlinx.android.synthetic.main.fragment_update.*


class UpdateFragment : Fragment(R.layout.fragment_update) {

    private val args: UpdateFragmentArgs by navArgs()
    lateinit var perfil: PerfilRecycler

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
// funcao que pegue os dados dos campos de texto e inicializa o objeto com os dados dos campos
//        e envia via argumento para a tela de lista
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.buttonAtualizarNota).setOnClickListener {
//o ID action muda por isso nao tava funcionando pois no direction o ID muda, tem que usar o auto complete

            val action = CadastroNotasFragmentDirections.actionCadastroNotasFragmentToRecyclerViewFragment(
                reCreatePerfil(),
                createDataCalculo()
            )
            findNavController().navigate(action)
        }
    }
//Verificar logica com a kaue
//    Verificar os ID da tela para passar os valores necessarios

    fun reCreatePerfil() : PerfilRecycler {
        var perfil = PerfilRecycler(
            editTextNomeAluno.text.toString(),
            editTextNumberNota1.text.toString().toFloat(),
            editTextNumberNota2.text.toString().toFloat(),
            editTextNumberNota3.text.toString().toFloat(),
            editTextNumberNota4.text.toString().toFloat()
        )
        return perfil
    }
//
//
//     fun upDados (){
//
//         editTextNomeAlunoUpdate.setText(args.perfilRecycler?.aluno)
//         editTextNumberNota1Update.setText(args.perfilRecycler?.nota1)
//         editTextNumberNota2Update.setText(args.perfilRecycler?.nota2)
//         editTextNumberNota3Update.setText(args.perfilRecycler?.nota3)
//         editTextNumberNota4Update.setText(args.perfilRecycler?.nota4)
//
//     }

    fun deleteUpDate () {

    }

    fun createDataCalculo() : DataCalculo {
        var dataCalculo = DataCalculo(perfil.aluno, calculoNotas())
        return dataCalculo
    }

    fun calculoNotas() : Float {
        return ((editTextNumberNota1.text.toString().toFloat() + editTextNumberNota2.text.toString().toFloat()) +
                (editTextNumberNota3.text.toString().toFloat() + editTextNumberNota4.text.toString().toFloat())) / 4
    }


}