package kh.edu.rupp.ite.daytoon.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kh.edu.rupp.ite.daytoon.databinding.FragmentMineeBinding
import kh.edu.rupp.ite.daytoon.page.IndexActivity

class MineFragment : Fragment() {
    private var binding: FragmentMineeBinding? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMineeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        if (currentUser != null) {
            databaseReference = FirebaseDatabase.getInstance().reference.child("users")
                .child(currentUser.uid)

            // Retrieve data from the Realtime Database
            databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        val email = dataSnapshot.child("email").value.toString()
                        val name = dataSnapshot.child("name").value.toString()

                        // Display user data in the UI
                        binding?.Temail?.text = "Email: $email"
                        binding?.Tname?.text = "Name: $name"
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle error
                }
            })
        }


        firebaseAuth = FirebaseAuth.getInstance()

        binding?.btnLogout?.setOnClickListener {
            // Sign out the user
            firebaseAuth.signOut()

            // Redirect to the WelcomePageActivity after sign-out
            val intent = Intent(requireActivity(), IndexActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}
