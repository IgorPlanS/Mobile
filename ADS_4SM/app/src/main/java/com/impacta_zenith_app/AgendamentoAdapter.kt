package com.impacta_zenith_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AgendamentoAdapter (
    val agendamentos: List<Agendamento>,
    val onClick: (Agendamento) -> Unit
): RecyclerView.Adapter<AgendamentoAdapter.AgendamentosViewHolder>() {

    class AgendamentosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardCliente: TextView
        val cardImagem: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardCliente = view.findViewById(R.id.cardCliente)
            cardImagem = view.findViewById(R.id.card_imagem)
            cardProgress = view.findViewById(R.id.card_progressbar)
            cardView = view.findViewById(R.id.card_agendamentos)
        }
    }

    override fun getItemCount() = this.agendamentos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendamentosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_agendamentos, parent, false)

        val holder = AgendamentosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder:AgendamentosViewHolder, position: Int) {
        val context = holder.itemView.context
        val agendamento = agendamentos[position]
        holder.cardCliente.text = (agendamento.cliente+" \n"+agendamento.dataagendamento)
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(agendamento.foto).fit().into(
            holder.cardImagem,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }
                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            }

        )

        holder.itemView.setOnClickListener{ onClick(agendamento)}
    }
}