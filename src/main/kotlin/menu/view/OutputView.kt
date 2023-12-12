package menu.view

import menu.util.Category

class OutputView {

    fun printStartMessage() {
        println(MENU_RECOMMEND_START_MESSAGE).also { println() }
    }

    fun printResult(categories: List<Category>, selectMenus: Map<String, List<String>>) {

        println(MENU_RECOMMEND_RESULT_MESSAGE)
        println(WEEK_CATEGORY)
        print(CATEGORY_START)
        categories.forEach { print(" | ${it.categoryName}") }
        println(CATEGORY_END)

        selectMenus.forEach { (t, u) ->
            printCoachMenu(t, u)
        }

        println(ENDING_MESSAGE)
    }

    private fun printCoachMenu(coach: String, menus: List<String>) {
        print("$MENU_RECOMMEND_START$coach")
        menus.forEach { print("$MENU_RECOMMEND_DIVIDER$it") }
        println("$MENU_RECOMMEND_END")
    }

    companion object {
        private const val MENU_RECOMMEND_START_MESSAGE = "점심 메뉴 추천을 시작합니다."
        private const val MENU_RECOMMEND_RESULT_MESSAGE = "메뉴 추천 결과입니다."
        private const val WEEK_CATEGORY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val CATEGORY_START = "[ 카테고리"
        private const val CATEGORY_END = " ]"
        private const val ENDING_MESSAGE = "추천을 완료했습니다."
        private const val MENU_RECOMMEND_START = "[ "
        private const val MENU_RECOMMEND_END = " ]"
        private const val MENU_RECOMMEND_DIVIDER = " | "
    }
}