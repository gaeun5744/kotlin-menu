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
                    selectCategory.weekCategories,
                    listOf(
                        Category.CHINESE,
                        Category.KOREA,
                        Category.CHINESE,
                        Category.WESTERN,
                        Category.WESTERN,
                    )
                )
            },
            3, 2, 3, 3, 5, 5, 5, 3,
        )
    }

}