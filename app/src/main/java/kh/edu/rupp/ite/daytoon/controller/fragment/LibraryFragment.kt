package kh.edu.rupp.ite.daytoon.controller.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.controller.activity.ComicsReadActivity
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment() {

    private var binding: FragmentLibraryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding?.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
