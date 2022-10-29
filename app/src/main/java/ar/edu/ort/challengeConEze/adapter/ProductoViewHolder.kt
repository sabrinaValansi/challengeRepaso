package ar.edu.ort.challengeConEze.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.challengeConEze.R
import ar.edu.ort.challengeConEze.model.Producto
import com.bumptech.glide.Glide

class ProductoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val descripcion: TextView
    private val precio : TextView
    private val imagen : ImageView

    init {
        descripcion = itemView.findViewById(R.id.producto_descripcion)
        precio =  itemView.findViewById(R.id.producto_precio)
        imagen =  itemView.findViewById(R.id.producto_imagen)
    }

    fun bindeo (producto: Producto) {
        descripcion.text = producto.descripcion
        precio.text = "$${producto.precio}"

        Glide.with(itemView)
            .load(producto.linkImagen)
            .into(imagen)
    }

}