package com.example.novoprojetoapp12janeiro.Resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.novoprojetoapp12janeiro.Model.DataCalculo
import com.example.novoprojetoapp12janeiro.Model.PerfilRecycler
import com.example.novoprojetoapp12janeiro.R
import com.example.novoprojetoapp12janeiro.View.RecyclerViewFragment
import kotlinx.android.synthetic.main.res_list_item.view.*

class Adapter(
    private val myList : List<DataCalculo>,
    private val perfilRecycler: PerfilRecycler,
    private val onClicked: (PerfilRecycler) -> Unit,
    private val onEditeClicked: (PerfilRecycler) -> Unit,
    private val onDeleteClicked: (PerfilRecycler) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return MyViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.res_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MyViewHolder -> {
                holder.populateItems(myList[position], perfilRecycler, onClicked, onEditeClicked, onDeleteClicked)
            }
        }
    }

    override fun getItemCount() = myList.size

    class MyViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val textName: TextView = itemView.name
        val textNota: TextView = itemView.nota

        fun populateItems(dataCalculo: DataCalculo,
                          perfilRecycler: PerfilRecycler,
                          onClicked: (PerfilRecycler) -> Unit,
                          onEditeClicked: (PerfilRecycler) -> Unit,
                          onDeleteClicked: (PerfilRecycler) -> Unit) {

            textName.text = dataCalculo.nome
            textNota.text = dataCalculo.media.toString()

            itemView.setOnClickListener {
                onClicked(perfilRecycler)
            }
            itemView.buttonEdit.setOnClickListener {
                onEditeClicked(perfilRecycler)
            }
            itemView.buttonDelete.setOnClickListener {
                onDeleteClicked(perfilRecycler)
            }
        }
    }
}