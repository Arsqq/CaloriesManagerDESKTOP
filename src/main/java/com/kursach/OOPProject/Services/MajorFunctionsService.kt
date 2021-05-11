package com.kursach.OOPProject.Services

import com.kursach.OOPProject.Controllers.DailyCaloriesIntakeController
import com.kursach.OOPProject.models.AllProducts
import com.kursach.OOPProject.models.Dishes
import com.kursach.OOPProject.repo.AllProductsRepository
import com.kursach.OOPProject.repo.DishesRepository
import javafx.scene.control.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class MajorFunctionsService {


    @Autowired
    lateinit var minorFunctionsService: MinorFunctionsService

    @Autowired
    lateinit var dailyCaloriesIntakeController: DailyCaloriesIntakeController

    @Autowired
    lateinit var dishesRepository:DishesRepository

    @Autowired
    lateinit var allProductsRepository: AllProductsRepository

    fun getAmountOfCalories(textArea: TextArea): Double?
    {
        try {
            var sum:Double=0.0
            var productsSum=0.0
            var dishesSum=0.0
            val listOfDishes: MutableList<Dishes> = ArrayList()
            val listOfDishesForCaloriesSum: MutableList<String> = ArrayList()

            val listOfProducts: MutableList<AllProducts> = ArrayList()
            val listForCaloriesSum: MutableList<String> = ArrayList()

            val buffer = textArea.text
            val splits = (buffer.split("\n"))
            listForCaloriesSum.addAll(splits)
            for (productName in listForCaloriesSum) {
                if(allProductsRepository.existsByAnyProductName(productName))
                {
                    listOfProducts.add(minorFunctionsService.getProductInfo(productName))
                }
                if(dishesRepository.existsByDishName(productName))
                {
                    listOfDishes.add(minorFunctionsService.getDishInfo(productName))
                }
            }
            for (dish in listOfDishes) {
                dishesSum += dish.calories
            }
            for (product in listOfProducts) {
                productsSum += product.calories
            }

            sum=dishesSum+productsSum
            return sum
        }

        catch (exc:NullPointerException)
        {
            val alert = Alert(Alert.AlertType.ERROR)
            alert.title = "Error Alert"
            alert.headerText = null
            alert.contentText = "ERROR.Sum can't be calculated due to incorrect input.Try again"
            alert.show()
            return null

        }

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







