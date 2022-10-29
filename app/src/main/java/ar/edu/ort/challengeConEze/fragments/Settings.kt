package ar.edu.ort.challengeConEze.fragments

import android.graphics.Paint
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ar.edu.ort.challengeConEze.R
import ar.edu.ort.challengeConEze.utils.User
import com.bumptech.glide.Glide
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Settings.newInstance] factory method to
 * create an instance of this fragment.
 */
class Settings : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var imagenUsuario : ImageView

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
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imagenUsuario = view.findViewById(R.id.imagen_usuario)

        val nombreUsuario = view.findViewById<TextView>(R.id.texto_nombre)

        val contraseniaUsuario = view.findViewById<TextView>(R.id.texto_contrasenia)

        nombreUsuario.paintFlags = nombreUsuario.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        contraseniaUsuario.paintFlags = contraseniaUsuario.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        nombreUsuario.text = User.userName

        Glide.with(this)
            .load("https://www.w3schools.com/howto/img_avatar.png")
            .circleCrop()
            .into(imagenUsuario)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Settings.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Settings().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}