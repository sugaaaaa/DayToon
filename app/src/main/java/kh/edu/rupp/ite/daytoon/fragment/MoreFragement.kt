package kh.edu.rupp.ite.daytoon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding
import kh.edu.rupp.ite.daytoon.databinding.FragmentMoreBinding

class MoreFragement : Fragment() {
    private lateinit var binding: FragmentMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMoreBinding.inflate(layoutInflater)
    }
}