package com.example.ex3insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            calculatePayment(it)
        }

        val buttonReset = findViewById<Button>(R.id.buttonReset)

        buttonReset.setOnClickListener {
            resetInput(it)
        }
    }

    private fun calculatePayment(viewThatIsClicked: View) {
        // Get Age
        val spinnerAge = findViewById<Spinner>(R.id.spinnerAge)
        //https://stackoverflow.com/questions/8597582/get-the-position-of-a-spinner-in-android
        val age = spinnerAge.selectedItemPosition

        // Get Gender
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val genderGroup = radioGroupGender.checkedRadioButtonId
        val radioGender = findViewById<RadioButton>(genderGroup)
        val gender = radioGender.text

        // Check whether is smoker
        val checkBoxSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val isSmoker = checkBoxSmoker.isChecked

        // Calculate Premium
        var premium = 0

        //Check condition
        //Check age > check whether is male > check whether isSmoker
        if (age == 0) {
            premium += 60
        } else if (age == 1) {
            premium += 70

            if (gender == "Male") {
                premium += 50
            }

            if (isSmoker) {
                premium += 100
            }
        } else if (age == 2) {
            premium += 90

            if (gender == "Male")
            {
                premium += 100
            }

            if (isSmoker) {
                premium += 150
            }
        } else if (age == 3) {
            premium += 120

            if (gender == "Male") {
                premium += 150
            }

            if (isSmoker) {
                premium += 200
            }
        } else if (age == 4) {
            premium += 150

            if (gender == "Male") {
                premium += 200
            }

            if (isSmoker) {
                premium += 250
            }
        } else if (age == 5) {
            premium += 150

            if (gender == "Male") {
                premium += 200
            }

            if (isSmoker) {
                premium += 300
            }
        }

        // Set Payment Details
        textViewPremium.text = String.format("%s \n         %s %d",getString(R.string.insurance_premium), "RM", premium)
    }

    fun resetInput(view: View?){
        spinnerAge.setSelection(0)
        checkBoxSmoker.isChecked = false
        radioGroupGender.clearCheck()
        textViewPremium.text = getString(R.string.insurance_premium)
    }
}