package kh.edu.rupp.ite.daytoon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.databinding.FragmentMineeBinding

class MineFragment : Fragment() {
    private lateinit var binding: FragmentMineeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMineeBinding.inflate(layoutInflater)
    }
}