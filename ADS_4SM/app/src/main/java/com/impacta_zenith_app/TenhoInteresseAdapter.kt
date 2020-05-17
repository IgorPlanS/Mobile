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

class TenhoInteresseAdapter (
    val tenhointeresse: List<TenhoInteresse>,
    val onClick: (TenhoInteresse) -> Unit
): RecyclerView.Adapter<TenhoInteresseAdapter.TenhoInteresseViewHolder>() {

    class TenhoInteresseViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardCliente: TextView
        val cardImagem: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardCliente = view.findViewById(R.id.cardCliente)
            cardImagem = view.findViewById(R.id.card_imagem)
            cardProgress = view.findViewById(R.id.card_progressbar)
            cardView = view.findViewById(R.id.card_tenhointeresse)
        }
    }

    override fun getItemCount() = this.tenhointeresse.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenhoInteresseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_tenhointeresse, parent, false)

        val holder = TenhoInteresseViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder:TenhoInteresseViewHolder, position: Int) {
        val context = holder.itemView.context
        val tenhointeresse = tenhointeresse[position]
        holder.cardCliente.text = (tenhointeresse.cliente+" \n"+tenhointeresse.datainteracao)
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(tenhointeresse.foto).fit().into(
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

        holder.itemView.setOnClickListener{ onClick(tenhointeresse)}
    }
}