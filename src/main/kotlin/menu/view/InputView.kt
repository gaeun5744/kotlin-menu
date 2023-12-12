package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.util.Validation

class InputView {

    fun readCoachesName():List<String> {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        return try {
            val input = Console.readLine()
            Validation.checkCoachesName(input)
            input.split(",")
        } catch (e: IllegalStateException) {
            println(e.message)
            readCoachesName()
        }
    }

    fun readCantEat(coach: String): List<String> {

        println("${coach}(이)가 못 먹는 메뉴를 입력해 주세요.")

        return try {
            val input = Console.readLine()
            Validation.checkCantEatMenu(input)
            input.split(",")
        } catch (e: IllegalStateException) {
            println(e.message)
            readCoachesName()
        }
    }

    fun readCantEatMenus(coaches: List<String>): Map<String, List<String>> {
        val menus = mutableMapOf<String, List<String>>()

        coaches.forEach { coach ->
            menus[coach] = readCantEat(coach)
        }

        return menus
    }
}