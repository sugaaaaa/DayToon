package kh.edu.rupp.ite.daytoon.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.daytoon.databinding.ActivityStoryshowBinding

class StoryShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoryshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryshowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storyArray = intent.getStringArrayExtra("story")
        if (storyArray != null) {
            val storyTitle = storyArray[1]
            val storyDescription = storyArray[2]
            val storyImgUrl = storyArray[3]

            binding.title.text = storyTitle.toString()
            binding.description.text = storyDescription.toString()
            Picasso.get().load(storyImgUrl).into(binding.image)


        } else {
            finish()
        }
        binding.btnBack.setOnClickListener {
//            val intent = Intent(this@StoryShowActivity, IndexActivity::class.java)
//            startActivity(intent)
            finish()
        }
    }
}
