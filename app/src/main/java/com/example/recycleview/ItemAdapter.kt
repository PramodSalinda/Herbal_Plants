package com.example.recycleview
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ItemAdapter"

class ItemAdapter(val context: Context, val herbals: MutableList<plant>):
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val herbal = herbals[position]
        holder.tvName.text = herbal.slname
        holder.tvbname.text = herbal.bname


        holder.itemView.setOnClickListener{
            val intent = Intent(context,AddItemActivity:: class.java).apply {
                putExtra("herbal_name",herbal.slname)
                putExtra("herbal_bname",herbal.bname)
                putExtra("herbal_info",herbal.info)
                putExtra("herbal_image",herbal.imageId)

                Log.i(TAG,"Intent check")

            }
            context.startActivity(intent)

            Log.i(TAG,"Start intent")
        }
    }

    override fun getItemCount() = herbals.size


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvplantname)
        val tvbname: TextView = itemView.findViewById(R.id.tvbname)

        fun bind(herbal: plant) {
            tvName.text = herbal.slname
            tvbname.text = herbal.bname

        }


    }

}
