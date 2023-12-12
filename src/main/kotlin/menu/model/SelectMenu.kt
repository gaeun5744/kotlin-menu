package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.Category

class SelectMenu(
    private val selectCategory: SelectCategory = SelectCategory(),
    private val coachesCantEat: Map<String, List<String>>
) {

    private val recommendation = mutableMapOf<String, MutableList<String>>().apply {
        coachesCantEat.keys.forEach {
            it to mutableListOf<String>()
        }
    }




}