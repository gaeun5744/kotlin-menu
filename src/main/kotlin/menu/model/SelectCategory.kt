package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.Category

class SelectCategory {

    private fun getRandomCategory(): Category {

        when (Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM)) {
            JAPANESE -> return Category.JAPANESE
            KOREA -> return Category.KOREA
            CHINESE -> return Category.CHINESE
            ASIAN -> return Category.ASIAN
            WESTERN -> return Category.WESTERN
        }

        return Category.JAPANESE
    }

    fun getSelectedCategories(): List<Category> {
        val weekCategories = mutableListOf<Category>()

        while (weekCategories.size != MAX_RANDOM_NUM) {

            addCategoryInList(weekCategories)
        }
        return weekCategories
    }

    private fun addCategoryInList(weekCategories: MutableList<Category>) {
        val randomCategory = getRandomCategory()
        if (weekCategories.count { it == randomCategory } < MAX_CATEGORY_COUNT) {
            weekCategories.add(randomCategory)
        }
    }

    companion object {

        private const val MIN_RANDOM_NUM = 1
        private const val MAX_RANDOM_NUM = 5

        private const val JAPANESE = 1
        private const val KOREA = 2
        private const val CHINESE = 3
        private const val ASIAN = 4
        private const val WESTERN = 5

        private const val MAX_CATEGORY_COUNT = 2
    }
}