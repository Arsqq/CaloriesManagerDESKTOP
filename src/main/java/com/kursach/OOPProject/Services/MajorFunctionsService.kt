package com.kursach.OOPProject.Services

import com.jfoenix.controls.JFXTextArea
import com.kursach.OOPProject.Controllers.DailyCaloriesIntakeController
import com.kursach.OOPProject.models.AllProducts
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MajorFunctionsService {
    private val listOfProducts: MutableList<AllProducts> = ArrayList()
    private val listForCaloriesSum: MutableList<String> = ArrayList()

    @Autowired
    lateinit var minorFunctionsService: MinorFunctionsService

    @Autowired
    lateinit var dailyCaloriesIntakeController: DailyCaloriesIntakeController

    fun getAmountOfCalories(textArea: TextArea): Double {
        var sum = 0.0
        val buffer = textArea.text
        val splits = (buffer.split("\n"))
        listForCaloriesSum.addAll(splits)
        for (productName in listForCaloriesSum) {

            listOfProducts.add(minorFunctionsService.getProductInfo(productName))
        }

        for (product in listOfProducts) {
            sum += product.calories
        }

        listOfProducts.clear()
        listForCaloriesSum.clear()

        return sum
    }

    fun getDailyIntake(
        ageField: TextField,
        weightField: TextField,
        heightField: TextField,
        maleBox: CheckBox,
        femaleBox: CheckBox,
        activityBox: ComboBox<String>
    ): Double {

        val LOW_ACTIVITY="Low"
        val MEDIUM_ACTIVITY="Medium"
        val HIGH_ACTIVITY="High"

        var amountOfIntake=0.0
        if (maleBox.isSelected) {
            amountOfIntake =
                (weightField.text.toDouble() * 10) + (heightField.text.toDouble() * 6.25) - (ageField.text.toDouble() * 5) - 5
            when(activityBox.value)
            {
                LOW_ACTIVITY->amountOfIntake*=1.2
                MEDIUM_ACTIVITY->amountOfIntake*=1.55
                HIGH_ACTIVITY->amountOfIntake*=1.725

            }

        }
        if (femaleBox.isSelected) {
            amountOfIntake = (weightField.text.toDouble() * 10) + (heightField.text.toDouble() * 6.25) - (ageField.text.toDouble() * 5) - 161
            when(activityBox.value)
            {
                LOW_ACTIVITY->amountOfIntake*=1.2
                MEDIUM_ACTIVITY->amountOfIntake*=1.55
                HIGH_ACTIVITY->amountOfIntake*=1.725

            }
        }

        return amountOfIntake
    }
}







