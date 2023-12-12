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
}