package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.Category

class SelectCategory {

    private fun getRandomCategory(): Category {

        when (Randoms.pickNumberInRange(1, 5)) {
            1 -> return Category.JAPANESE
            2 -> return Category.KOREA
            3 -> return Category.CHINESE
            4 -> return Category.ASIAN
            5 -> return Category.WESTERN
        }

        return Category.JAPANESE
    }

    fun getWeekCategories(): List<Category> {
        val weekCategories = mutableListOf<Category>()

        while (weekCategories.size != 5) {

            val randomCategory = getRandomCategory()
            if (weekCategories.count { it == randomCategory } < 2) {
                weekCategories.add(randomCategory)
            }
        }
        return weekCategories
    }
}