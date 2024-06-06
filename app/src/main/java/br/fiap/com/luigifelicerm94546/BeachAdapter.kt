package br.fiap.com.luigifelicerm94546

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


@SuppressLint("NotifyDataSetChanged")
class BeachAdapter : RecyclerView.Adapter<BeachAdapter.ItemViewHolder>() {

    private val beaches = mutableListOf<BeachModel>()


    fun addItem(newBeach: BeachModel) {
        beaches.add(newBeach)
        notifyDataSetChanged()
    }

    fun removeItem(beach: BeachModel) {
        beaches.remove(beach)
        notifyDataSetChanged()
    }

    fun clearList(){
        beaches.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beach_layout, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = beaches.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = beaches[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.name)
        private val location: TextView = view.findViewById(R.id.location)
        private val button: ImageButton = view.findViewById(R.id.imageButton)

        @SuppressLint("SetTextI18n")
        fun bind(beach: BeachModel) {
            name.text = beach.name
            location.text = "${beach.city}, ${beach.state}"

            button.setOnClickListener {
                beach.onRemove(beach)
            }
        }
    }
}