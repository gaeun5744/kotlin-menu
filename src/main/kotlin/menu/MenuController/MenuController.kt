package menu.MenuController

import menu.model.SelectCategory
import menu.model.SelectMenu
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun run() {
        outputView.printStartMessage()
        val coaches = inputView.readCoachesName()
        val cantMenus = inputView.readCantEatMenus(coaches)

        val weekCategories = SelectCategory().getSelectedCategories()
        val selectMenu = SelectMenu(cantMenus, weekCategories)

        outputView.printRecommendMenu(weekCategories, selectMenu.getRecommendation())
        outputView.printEndingMessage()

    }
}