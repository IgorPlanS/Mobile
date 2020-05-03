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

class FaleConoscoAdapter (
    val faleconosco: List<FaleConosco>,
    val onClick: (FaleConosco) -> Unit
): RecyclerView.Adapter<FaleConoscoAdapter.FaleConoscoViewHolder>() {

    class FaleConoscoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardCliente: TextView
        val cardImagem: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardCliente = view.findViewById(R.id.cardCliente)
            cardImagem = view.findViewById(R.id.card_imagem)
            cardProgress = view.findViewById(R.id.card_progressbar)
            cardView = view.findViewById(R.id.card_faleconosco)
        }
    }

    override fun getItemCount() = this.faleconosco.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaleConoscoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_faleconosco, parent, false)

        val holder = FaleConoscoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder:FaleConoscoViewHolder, position: Int) {
        val context = holder.itemView.context
        val faleconosco = faleconosco[position]
        holder.cardCliente.text = (faleconosco.cliente+" \n"+faleconosco.datacomentario)
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(faleconosco.foto).fit().into(
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

        holder.itemView.setOnClickListener{ onClick(faleconosco)}
    }
}