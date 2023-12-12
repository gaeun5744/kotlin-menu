package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.Category

class SelectMenu(
    private val coachesCantEat: Map<String, List<String>>,
    private val selectCategory: SelectCategory = SelectCategory(),
) {

    private val recommendation = mutableMapOf<String, MutableList<String>>().apply {
        coachesCantEat.keys.forEach {
            it to mutableListOf<String>()
        }
    }

    private fun getRandomMenu(category: Category): String {
        return Randoms.shuffle(category.menu)[0]
    }

    fun getRecommendation(): Map<String, List<String>> {
        val categories = selectCategory.getWeekCategories()

        for (category in categories) {
            coachesCantEat.keys.forEach { coach ->
                insertRecommendMenu(coach, category)
            }
        }
        return recommendation
    }

    private fun insertRecommendMenu(coach: String, category: Category) {
        while (recommendation[coach]!!.size != 5) {
            val randomMenu = getRandomMenu(category)
            if (!checkCantEat(coach, randomMenu)) {
                recommendation[coach]!!.add(randomMenu)
            }
        }
    }

    private fun checkCantEat(coach: String, randomMenu: String) =
        coachesCantEat[coach]!!.contains(randomMenu) || recommendation[coach]!!.contains(randomMenu)


}