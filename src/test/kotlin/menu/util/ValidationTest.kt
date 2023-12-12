package menu.util

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["가은", "가은/나은", "여섯글자이름,가은,나은", "가은,나은,다은,라은,마은,바은"])
    fun `코치 이름 입력 유효성 검증 테스트`(input: String) {
        assertThatThrownBy {
            Validation.checkCoachesName(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["규동,스테이크", "오니기리,끼슈,짜장면", "칼국수/하이라이스"])
    fun `먹지 못하는 메뉴 입력 유효성 검증 테스트`(input: String) {
        assertThatThrownBy {
            Validation.checkCantEatMenu(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }


}