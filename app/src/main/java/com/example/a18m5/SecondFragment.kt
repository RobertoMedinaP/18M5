package com.example.a18m5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a18m5.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = Prefscomp.preferencias
        val llavenumero = "llavenumero"
        val llavetexto = "llavetexto"
        val llavedecimal = "llavedecimal"
        val llavebooleana = "llavebooleana"

        val textoNumero = prefs?.obtenerdatos(llavenumero)
        binding.textViewnumero.text = textoNumero

        binding.textViewtexto.text = prefs?.obtenerdatos(llavetexto)
        binding.textViewdecimal.text = prefs?.obtenerdatos(llavedecimal)
        binding.textViewBooleano.text = prefs?.obtenerdatos(llavebooleana)

        /*val prefs= Prefscomp.preferencias
        var texto=prefs?.obtenerdatos(llave = "llavenumero")
        binding.textViewnumero.setText(texto)
        //acá está la madre del cordero
        val llavetexto="llavetexto"
        binding.textViewtexto.text=prefs?.obtenerdatos(llavetexto)
        //binding.textViewnumero.text=prefs?.obtenerdatos("llavenumero")
        binding.textViewdecimal.text=prefs?.obtenerdatos("llavedecimal")
        binding.textViewBooleano.text=prefs?.obtenerdatos("llavebooleana")
*/
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}