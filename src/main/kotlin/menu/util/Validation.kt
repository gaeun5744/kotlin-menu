package menu.util

object Validation {

    private const val COACH_COUNT_ERROR_MESSAGE = "[ERROR] 코치는 최소 2명 이상 입력해야 합니다."
    private const val COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자까지 가능합니다."
    private const val NAME_SEPARATOR = ","

    fun checkCoachesName(input: String) {
        checkContainComma(input)
    }

    private fun checkContainComma(input: String) {
        require(input.contains(NAME_SEPARATOR)) {
            COACH_COUNT_ERROR_MESSAGE
        }
    }
}