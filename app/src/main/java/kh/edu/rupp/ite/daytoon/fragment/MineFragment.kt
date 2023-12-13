package kh.edu.rupp.ite.daytoon.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.daytoon.databinding.FragmentMineeBinding
import kh.edu.rupp.ite.daytoon.page.IndexActivity

class MineFragment : Fragment() {
    private var binding: FragmentMineeBinding? =null
    private lateinit var user: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMineeBinding.inflate(inflater, container, false)
        return binding?.root

//        user = FirebaseAuth.getInstance()
//
//        if ( user.currentUser != null){
//            user.currentUser?. let {
//                binding!!.email.text = it.email
//            }
//        }
//        binding!!.logout.setOnClickListener {
//            user.signOut()
//            startActivity(
//                Intent(this, IndexActivity::class.java)
//            )
//        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}