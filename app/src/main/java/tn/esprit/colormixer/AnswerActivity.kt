package tn.esprit.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import tn.esprit.colormixer.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {

    //TODO 12 Add lateint var for binding
    lateinit var binding : ActivityAnswerBinding
    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 13 Bind the view and implement setContentView()
          binding = ActivityAnswerBinding.inflate(layoutInflater)
          setContentView(binding.root)
        //TODO 14 Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
          correctColor= intent.getStringExtra(MIXED_COLOR).toString();
          name= intent.getStringExtra(NAME).toString();
          color1= intent.getStringExtra(COLOR1).toString();
          color2= intent.getStringExtra(COLOR2).toString();

        //TODO 15 Change the txtChoosed with : "You chose $color1 and $color2"
          binding.txtChoosed.text="you choose $color1 and $color2";
        //TODO 16 Implement setOnClickListener on the btnSubmit and call checkAnswer()
        // You must check if only one radio button is selected the navigate to the ResultActivity with the data name and RESULT (FAILED/SUCCESS)
         binding.btnSubmit.setOnClickListener {
             if (!binding.rbGreen.isChecked && !binding.rbPurple.isChecked && !binding.rbOrange.isChecked){
                 Snackbar.make(binding.contextView,  "Choose your answer !", Snackbar.LENGTH_SHORT).show()
                 return@setOnClickListener
             }

             val intent = Intent(this, ResultActivity::class.java).apply {
                 putExtra(NAME, name)
                 putExtra(RESULT, FAILED)
             }

             if (checkAnswer())
                 intent.apply { putExtra(RESULT, SUCCESS) }

             startActivity(intent)
             finish()
         }
    }

    private fun checkAnswer(): Boolean{

        //TODO 17 Check if the answer of the chosen color is correct
        if(binding.rbGreen.isChecked && correctColor.equals(GREEN)){
            return true
        }else if (binding.rbOrange.isChecked && correctColor.equals(ORANGE)){
            return true
        }else if (binding.rbPurple.isChecked && correctColor.equals(PURPLE)){
            return true
        }
        return false
    }
}