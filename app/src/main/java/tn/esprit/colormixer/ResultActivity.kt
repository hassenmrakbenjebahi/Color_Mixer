package tn.esprit.colormixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tn.esprit.colormixer.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    //TODO 18 Add lateint var for binding
       lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 19 Bind the view and implement setContentView()

        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO 20 Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        if (intent.getStringExtra(RESULT).toString().equals(SUCCESS)){
            binding.rlBackground.setBackgroundColor(getColor(R.color.success))
            binding.btnQuit.setBackgroundColor(getColor(R.color.success))
            binding.imgResult.setImageResource(R.drawable.ic_success)

            binding.txtResult.text = "SUCCESS"
            binding.txtName.text = "Congratulation ${intent.getStringExtra(NAME).toString()} !"
            binding.txtAnswer.text = "Your answer is correct"

        }else{
            binding.rlBackground.setBackgroundColor(getColor(R.color.error))
            binding.btnQuit.setBackgroundColor(getColor(R.color.error))
            binding.imgResult.setImageResource(R.drawable.ic_failure)

            binding.txtResult.text = "WRONG"
            binding.txtName.text = "Sorry ${intent.getStringExtra(NAME).toString()} !"
            binding.txtAnswer.text = "Your answer is wrong"

        }
        //TODO 21 Implement setOnClickListener for btnQuit to destroy the activity
        binding.btnQuit.setOnClickListener { finish() }

    }
}