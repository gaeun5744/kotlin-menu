package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.Category

class SelectMenu(
    private val coachesCantEat: Map<String, List<String>>,
    private val selectCategory: SelectCategory
) {

    private val recommendation = mutableMapOf<String, MutableList<String>>()

    init {
        initRecommendMenu()
    }

    private fun initRecommendMenu() {
        coachesCantEat.keys.forEach { coach ->
            recommendation[coach] = mutableListOf()
        }
    }

    private fun getRandomMenu(category: Category): String {
        return Randoms.shuffle(category.menu)[0]
    }

    fun getRecommendation(): Map<String, List<String>> {
        val categories = selectCategory.weekCategories

        for (category in categories) {
            coachesCantEat.keys.forEach { coach ->
                insertCategoryMenuInRecommend(category, coach)
            }
        }
        return recommendation
    }

    private fun insertCategoryMenuInRecommend(category: Category, coach: String) {
        while (true) {
            val randomMenu = getRandomMenu(category)
            if (!checkCantEat(coach, randomMenu)) {
                recommendation[coach]!!.add(randomMenu)
                break
            }
        }
    }

    private fun checkCantEat(coach: String, randomMenu: String): Boolean =
        coachesCantEat[coach]!!.contains(randomMenu) || recommendation[coach]!!.contains(randomMenu)


}