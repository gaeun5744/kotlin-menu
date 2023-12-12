package menu.util

object Validation {

    private const val COACH_COUNT_ERROR_MESSAGE = "[ERROR] 코치는 쉼표로 구분하여 최소 2명 이상 입력해야 합니다."
    private const val COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자까지 가능합니다."
    private const val INVALID_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 메뉴 입력 입니다."
    private const val MENU_COUNT_ERROR_MESSAGE = "[ERROR] 먹지 못하는 메뉴는 2개까지 가능합니다."
    private const val NAME_SEPARATOR = ","

    fun checkCoachesName(input: String) {
        checkContainComma(input)
        checkNameLength(input)
        checkCoachCount(input)
    }

    fun checkCantEatMenu(input: String) {
        checkValidMenu(input)
        checkMenuCount(input)
    }

    private fun checkContainComma(input: String) {
        require(input.contains(NAME_SEPARATOR)) {
            COACH_COUNT_ERROR_MESSAGE
        }
    }

    private fun checkNameLength(input: String) {
        val names = input.split(NAME_SEPARATOR)
        names.forEach { name ->
            require(name.length in 2..4) {
                COACH_NAME_ERROR_MESSAGE
            }
        }
    }

    private fun checkCoachCount(input: String) {
        val names = input.split(",")
        require(names.size in 2..5) {
            COACH_COUNT_ERROR_MESSAGE
        }
    }

    private fun checkValidMenu(input: String) {
        val cantMenus = input.split(NAME_SEPARATOR)

        require(Category.values().intersect(cantMenus).size == cantMenus.size) {
            throw IllegalArgumentException(INVALID_MENU_ERROR_MESSAGE)
        }
    }

    private fun checkMenuCount(input: String) {
        val menus = input.split(NAME_SEPARATOR)
        require(menus.size <= 2) {
            MENU_COUNT_ERROR_MESSAGE
        }
    }
}