package kh.edu.rupp.ite.daytoon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding
import kh.edu.rupp.ite.daytoon.databinding.FragmentStoryBinding

class LibraryFragment : Fragment() {

    private lateinit var binding: FragmentLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentLibraryBinding.inflate(layoutInflater)
    }
}