package menu.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import menu.util.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SelectCategoryTest {

    @Test
    fun `주간 카테고리 추천 반환 테스트`() {

        val selectCategory = SelectCategory()

        assertRandomNumberInRangeTest(
            {
                assertEquals(
                    selectCategory.getSelectedCategories(),
                    listOf(
                        Category.CHINESE,
                        Category.KOREA,
                        Category.CHINESE,
                        Category.WESTERN,
                        Category.WESTERN,
                    )
                )
            },
            CHINESE, KOREA, CHINESE, CHINESE, WESTERN, WESTERN, WESTERN, CHINESE,
        )
    }

    companion object {
        private const val KOREA = 2
        private const val CHINESE = 3
        private const val WESTERN = 5
    }

}