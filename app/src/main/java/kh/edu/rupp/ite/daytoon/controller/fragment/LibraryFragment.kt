package kh.edu.rupp.ite.daytoon.controller.fragment

import kh.edu.rupp.ite.daytoon.view.viewmodel.LibraryViewModel  // Adjust the package name accordingly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding.inflate

class LibraryFragment : Fragment() {

    private var binding: FragmentLibraryBinding? = null
    private lateinit var viewModel: LibraryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(LibraryViewModel::class.java)

        // Set the ViewModel for data binding
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
