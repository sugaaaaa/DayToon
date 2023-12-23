package kh.edu.rupp.ite.daytoon.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.databinding.FragmentComicsBinding

class ComicsFragment :  Fragment(){

    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using View Binding
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Your code for fragment initialization and UI interactions goes here
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding when the view is destroyed
        _binding = null
    }
}