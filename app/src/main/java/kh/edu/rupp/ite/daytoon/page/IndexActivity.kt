package kh.edu.rupp.ite.daytoon.page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityIndexBinding
import kh.edu.rupp.ite.daytoon.fragment.ComicsFragment
import kh.edu.rupp.ite.daytoon.fragment.LibraryFragment
import kh.edu.rupp.ite.daytoon.fragment.MineFragment
import kh.edu.rupp.ite.daytoon.fragment.MoreFragement
import kh.edu.rupp.ite.daytoon.fragment.StoryFragment

class IndexActivity : AppCompatActivity(){

    private lateinit var binding: ActivityIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(ComicsFragment())
        //setup Listener
        //setup Listener
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId === R.id.mnucomic) {
                showFragment(ComicsFragment())
            } else if (item.itemId === R.id.mnustory) {
                showFragment(StoryFragment())
            } else if (item.itemId === R.id.mnulibrary) {
                showFragment(LibraryFragment())
            } else if (item.itemId === R.id.mnuprofile) {
                showFragment(MineFragment())
            } else {
                showFragment(MoreFragement())
            }
            true
        }
    }

}

}