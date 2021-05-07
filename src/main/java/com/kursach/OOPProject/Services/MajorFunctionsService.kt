package com.kursach.OOPProject.Services

import com.kursach.OOPProject.models.AllProducts
import javafx.scene.control.TextArea
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MajorFunctionsService
{
    private val listOfProducts: MutableList<AllProducts> =ArrayList()
    private val listForCaloriesSum: MutableList<String> = ArrayList()

    @Autowired
    lateinit var minorFunctionsService: MinorFunctionsService

    fun getAmountOfCalories(textArea:TextArea):Double
    {
        var sum=0.0
        val buffer=textArea.text
        val splits=(buffer.split("\n"))
        listForCaloriesSum.addAll(splits)
        for (productName in listForCaloriesSum) {

            listOfProducts.add(minorFunctionsService.getProductInfo(productName))
        }

        for (product in listOfProducts) {
            sum+=product.calories
        }

        listOfProducts.clear()
        listForCaloriesSum.clear()

        return sum
    }
}


