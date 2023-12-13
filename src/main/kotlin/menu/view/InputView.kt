package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.util.Validation

class InputView {

    fun readCoachesName(): List<String> {
        println(INPUT_COACH_NAME_MESSAGE)
        return try {
            val input = Console.readLine()
            Validation.checkCoachesName(input)
            input.split(NAME_SEPARATOR).also { println() }
        } catch (e: IllegalArgumentException) {
            println(e.message).also { println() }
            readCoachesName()
        }
    }

    private fun readCantEat(coach: String): List<String> {

        println("${coach}$INPUT_CANT_EAT_MENU_MESSAGE")

        return try {
            val input = Console.readLine()
            Validation.checkCantEatMenu(input)
            input.split(NAME_SEPARATOR).also { println() }
        } catch (e: IllegalArgumentException) {
            println(e.message).also { println() }
            readCantEat(coach)
        }
    }

    fun readCantEatMenus(coaches: List<String>): Map<String, List<String>> {
        val menus = mutableMapOf<String, List<String>>()

        coaches.forEach { coach ->
            menus[coach] = readCantEat(coach)
        }

        return menus
    }

    companion object {
        private const val INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val NAME_SEPARATOR = ","
        private const val INPUT_CANT_EAT_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}