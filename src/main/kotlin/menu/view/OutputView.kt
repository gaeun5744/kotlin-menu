package menu.view

import menu.util.Category

class OutputView {

    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.").also { println() }
    }

    fun printResult(categories: List<Category>, selectMenus: Map<String, List<String>>) {

        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        print("[ 카테고리")
        categories.forEach { print(" | ${it.categoryName}") }
        println(" ]")

        selectMenus.forEach { (t, u) ->
            printCoachMenu(t, u)
        }

        println("추천을 완료했습니다.")
    }

    private fun printCoachMenu(coach: String, menus: List<String>) {
        print("[ $coach")
        menus.forEach { print(" | $it") }
        println(" ]")
    }


}