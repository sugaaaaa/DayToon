package kh.edu.rupp.ite.daytoon.controller.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.controller.activity.secretelove.ChapterActivity
import kh.edu.rupp.ite.daytoon.controller.activity.secretelove.ComicsReadActivity
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding


class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)

        // Set click listeners
        binding.btnSecreteLove.setOnClickListener {
            val intent = Intent(requireContext(), ComicsReadActivity::class.java)
            startActivity(intent)
        }

        binding.btntheMaleLead.setOnClickListener {
            val intent = Intent(requireContext(), ComicsReadActivity::class.java)
            startActivity(intent)
        }

        binding.btnSecreteLoveChapter.setOnClickListener {
            val intent = Intent(requireContext(), ChapterActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}