package kh.edu.rupp.ite.daytoon.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityIndexBinding
import kh.edu.rupp.ite.daytoon.fragment.ComicsFragment
import kh.edu.rupp.ite.daytoon.fragment.LibraryFragment
import kh.edu.rupp.ite.daytoon.fragment.MineFragment
import kh.edu.rupp.ite.daytoon.fragment.MoreFragement
import kh.edu.rupp.ite.daytoon.fragment.StoryFragment

class IndexActivity : AppCompatActivity(){

    private var binding: ActivityIndexBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        showFragment(ComicsFragment())
        //setup Listener
        binding?.bottomNavigationView?.setOnItemSelectedListener { item ->
           when (item.itemId){
               R.id.mnucomic-> showFragment(ComicsFragment())
               R.id.mnustory->showFragment(StoryFragment())
               R.id.mnulibrary->showFragment(LibraryFragment())
               R.id.mnuprofile->showFragment(MineFragment())
               else-> showFragment(MoreFragement())
            }
            true
        }
    }
    private fun showFragment(fragment: Fragment) {
        //FragmentManager
        val fragmentManager = supportFragmentManager

        //FragmentTransaction
        val fragmentTransaction = fragmentManager.beginTransaction()

        //Replace Fragment in lytFragment
        fragmentTransaction.replace(R.id.lytFragment, fragment)

        //Committ
        fragmentTransaction.commit()
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

