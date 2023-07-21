package com.example.a18m5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a18m5.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switchValue = binding.switch1.isChecked
        val prefs= Prefscomp.preferencias

        val llavenumero="llavenumero"
        val llavetexto="llavetexto"
        val llavedecimal="llavedecimal"
        val llavebooleana="llavebooleana"


        binding.btguardar.setOnClickListener {

            //puedo ingresar directo y transformar, gracias kotlin
            var numeroingresado = binding.textInputLayout.editText?.text.toString().toIntOrNull()
            if (numeroingresado != null) {
                binding.textView.setText("El valor ingresadp es $numeroingresado")
                prefs?.guardardatos(llavenumero, numeroingresado.toString())
                binding.textInputLayout.editText?.setError(null)

            } else {
                binding.textInputLayout.editText?.setError("Ingrese un número válido")
                binding.textView.setText("")
            }

            var textoingresado = binding.textInputLayout2.editText?.text.toString()
            if (textoingresado != null) {
                binding.textView2.setText("El valor ingresado es $textoingresado")
                binding.textInputLayout2.editText?.setError(null)
                prefs?.guardardatos(llavetexto, textoingresado)
            } else {
                binding.textInputLayout2.editText?.setError("Ingrese un valor")
                binding.textView2.setText("")
            }

            var decimalingresado =
                binding.textInputLayout3.editText?.text.toString().toDoubleOrNull()
            if (decimalingresado != null) {
                binding.textView3.setText("El número ingresado es $decimalingresado")
                binding.textInputLayout3.editText?.setError(null)
                prefs?.guardardatos(llavedecimal, decimalingresado.toString())
            } else {
                binding.textInputLayout3.editText?.setError("Ingrese un valor valido")
                binding.textView3.setText("")
            }

            val switchValue = binding.switch1.isChecked.toString()
            prefs?.guardardatos(llavebooleana,switchValue)

            binding.buttonFirst.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
