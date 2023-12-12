package menu.util

object Validation {

    private const val COACH_COUNT_ERROR_MESSAGE = "[ERROR] 코치는 쉼표로 구분하여 최소 2명 이상 입력해야 합니다."
    private const val COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자까지 가능합니다."
    private const val INVALID_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 메뉴 입력 입니다."
    private const val MENU_COUNT_ERROR_MESSAGE = "[ERROR] 먹지 못하는 메뉴는 2개까지 가능합니다."
    private const val NAME_SEPARATOR = ","
    private const val MINIMUM_NAME_LENGTH = 2
    private const val MAX_NAME_LENGTH = 4
    private const val MINIMUM_COACH_COUNT = 2
    private const val MAX_COACH_COUNT = 5
    private const val MAX_CANT_EAT_MENU = 2

    fun checkCoachesName(input: String) {
        checkContainComma(input)
        checkNameLength(input)
        checkCoachCount(input)
    }

    fun checkCantEatMenu(input: String) {
        if (input.isBlank()) return
        checkValidMenu(input)
        checkMenuCount(input)
    }

    private fun checkContainComma(input: String) {
        require(input.contains(NAME_SEPARATOR)) {
            COACH_COUNT_ERROR_MESSAGE
        }
    }

    private fun checkNameLength(input: String) {
        val names = inputSplit(input)
        names.forEach { name ->
            require(name.length in MINIMUM_NAME_LENGTH..MAX_NAME_LENGTH) {
                COACH_NAME_ERROR_MESSAGE
            }
        }
    }

    private fun checkCoachCount(input: String) {
        val names = inputSplit(input)
        require(names.size in MINIMUM_COACH_COUNT..MAX_COACH_COUNT) {
            COACH_COUNT_ERROR_MESSAGE
        }
    }

    private fun checkValidMenu(input: String) {
        val cantMenus = inputSplit(input)
        val menus = Category.values().flatMap { it.menu }

        require(menus.intersect(cantMenus).size == cantMenus.size) {
            throw IllegalArgumentException(INVALID_MENU_ERROR_MESSAGE)
        }
    }

    private fun checkMenuCount(input: String) {
        val menus = inputSplit(input)
        require(menus.size <= MAX_CANT_EAT_MENU) {
            MENU_COUNT_ERROR_MESSAGE
        }
    }

    private fun inputSplit(input: String) = input.split(NAME_SEPARATOR)
}