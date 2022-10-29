package ar.edu.ort.challengeConEze.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.challengeConEze.R
import ar.edu.ort.challengeConEze.adapter.AdapterProducto
import ar.edu.ort.challengeConEze.listener.onProductoClickedListener
import ar.edu.ort.challengeConEze.model.Producto
import ar.edu.ort.challengeConEze.utils.Images
import ar.edu.ort.challengeConEze.utils.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment(), onProductoClickedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textoHome : TextView
    private lateinit var recycler : RecyclerView
    private lateinit var productos : List<Producto>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textoHome = view.findViewById(R.id.textHome)

        textoHome.text = "Hola, ${User.userName}"

        recycler = view.findViewById(R.id.recyclerProductos)

        llenarListaProductos()
    }

    private fun llenarListaProductos() {
        val producto1 = Producto("Iphone 14", Images.iphone , 4000000.00)
        val producto2 = Producto("Remera standard", Images.remera , 700.00)
        val producto3 = Producto("Zapatilla Running", Images.zapatilla , 16000.00)

        productos = listOf(producto1, producto2, producto3)

        val layoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layoutManager
        recycler.adapter = AdapterProducto(productos, this)

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onProductoSeleccionado(producto: Producto) {
        findNavController().navigate(HomeDirections.actionHome2ToDetail(producto))
    }
}