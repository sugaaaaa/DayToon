import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kh.edu.rupp.ite.daytoon.databinding.FragmentMineeBinding
import kh.edu.rupp.ite.daytoon.controller.activity.LoginActivity
import kh.edu.rupp.ite.daytoon.databinding.FragmentLibraryBinding

class MineFragment : Fragment() {
    private var _binding: FragmentMineeBinding? = null
    private val binding get() = _binding!!
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMineeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        // Check authentication state to toggle button visibility
        updateButtonVisibility(currentUser != null)

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
            binding?.btnLogout?.isEnabled = false // Disable the button
            binding?.progressBar?.visibility = View.VISIBLE // Show the progress bar

            // Sign out the user
            firebaseAuth.signOut()

            updateButtonVisibility(false)

            // Redirect to the LoginActivity after sign-out
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        binding?.btnSignIn?.setOnClickListener {
            val loginIntent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(loginIntent)
        }
        auth.addAuthStateListener { auth ->
            val currentUser = auth.currentUser
            updateButtonVisibility(currentUser != null)
        }
    }
    private fun updateButtonVisibility(isUserLoggedIn: Boolean) {
        binding?.btnLogout?.visibility = if (isUserLoggedIn) View.VISIBLE else View.GONE
        binding?.btnSignIn?.visibility = if (isUserLoggedIn) View.GONE else View.VISIBLE
    }
}
