package ar.edu.ort.challengeConEze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.challengeConEze.R
import ar.edu.ort.challengeConEze.listener.onProductoClickedListener
import ar.edu.ort.challengeConEze.model.Producto

class AdapterProducto(
    private val listaProductos : List<Producto>,
    private val onProductoClickedListener : onProductoClickedListener
) : RecyclerView.Adapter<ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]

        holder.bindeo(producto)

        holder.itemView.setOnClickListener{
            onProductoClickedListener.onProductoSeleccionado(producto)
        }
    }

    override fun getItemCount() = listaProductos.size
}