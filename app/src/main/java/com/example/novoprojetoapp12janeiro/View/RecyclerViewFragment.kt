package com.example.novoprojetoapp12janeiro.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

    // Variáveis sempre são declaradas antes do método principal -> override
    // Funções customizadas sempre são declaradas depois dos métodos principais -> override
    val args: RecyclerViewFragmentArgs by navArgs()
    lateinit var listAdapter: Adapter
    var list = mutableListOf<DataCalculo>()
    var perfilRecyclerlist = mutableListOf<PerfilRecycler>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        setListAdapter(args.dataCalculo, args.perfilRecycler)
        setAdapter()
    }

    override fun onResume() {
        super.onResume()

        if (args.perfilRecyclerUpdated != null) {
            setAdapter()
        }
    }

    // Diz pro recycler quem é o adaptador dele e quem vai manipular ele
    fun setAdapter() {
        // (Linha 32 <) -> Inicializa o adapter e coloca dentro da variável listAdapter
        listAdapter = Adapter(list,
        args.perfilRecycler,
            { setClicked(it) }, // <<<<- Função ao clicar no card
            { args.perfilRecyclerUpdated?.let { it1 -> editCard(it, it1) } }, // <<<<- Função de editar card
            { deleteCard(it) }) // <<<<- Função de deletar card

        recyclerViewPagina.adapter = listAdapter // <<<- Coloca a variável adapter no recycler view
        recyclerViewPagina.layoutManager = LinearLayoutManager(requireContext()) // <<<- Diz pro recycler view quem é o responsável por manipula-lo (requireContext = RecyclerViewFragment)
    }

    fun setListAdapter(dataCalculo: DataCalculo, perfilRecycler: PerfilRecycler) {
        list.add(dataCalculo)
        perfilRecyclerlist.add(perfilRecycler)

    }
// Funcao click recycler acao de botao

    fun setClicked(perfilRecycler: PerfilRecycler) {
        val action = RecyclerViewFragmentDirections.actionRecyclerViewFragmentToTelaDetalesFragment(
            perfilRecycler,
            args.dataCalculo
        )
        findNavController().navigate(action)
// clic do botao de editar
        view.findViewById<Button>(R.id.buttonAtualizarNota).setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_recyclerViewFragment)
        }
    }
// editar a partir dessa parte para realizar a funcionalidade do botao
// Funcao botao de editar, vai os parametros da minha fun de perfil

    fun editCard(perfilRecycler: PerfilRecycler, perfilRecyclerUpDate: PerfilRecycler ) {
        setListAdapter(args.dataCalculo, args.perfilRecycler)

        perfilRecyclerlist.remove(perfilRecycler)
        perfilRecyclerlist.add(perfilRecyclerUpDate)

    }
// Fun de deletar objeto com click de botao

    fun deleteCard(perfilRecycler: PerfilRecycler) {
        perfilRecyclerlist.remove(perfilRecycler)
    }
}