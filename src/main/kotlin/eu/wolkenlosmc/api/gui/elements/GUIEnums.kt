package eu.wolkenlosmc.api.gui.elements

import eu.wolkenlosmc.api.gui.GUIData
import eu.wolkenlosmc.api.gui.GUIType

enum class Row(val startSlot: Int, val endSlot: Int) {
    ONE(0, 8),
    TWO(9, 17),
    THREE(18, 26),
    FOUR(27, 35),
    FIVE(36, 44),
    SIX(45, 53)
}

enum class Column(val columns: Int, val startSlot: Int) {
    ONE(1, 0),
    TWO(2, 1),
    THREE(3, 2),
    FOUR(4, 3),
    FIVE(5, 4),
    SIX(6, 5),
    SEVEN(7, 6),
    EIGHT(8, 7),
    NINE(9, 8);

    fun getEndSlot(guiType: GUIType): Int {
        val rowAmount = guiType.size/9
        return startSlot + (rowAmount * 9)
    }
}

enum class Slot(val slot: Int) {
    ROW_ONE_SLOT_ONE(0),
    ROW_ONE_SLOT_TWO(1),
    ROW_ONE_SLOT_THREE(2),
    ROW_ONE_SLOT_FOUR(3),
    ROW_ONE_SLOT_FIVE(4),
    ROW_ONE_SLOT_SIX(5),
    ROW_ONE_SLOT_SEVEN(6),
    ROW_ONE_SLOT_EIGHT(7),
    ROW_ONE_SLOT_NINE(8),
    ROW_TWO_SLOT_ONE(9),
    ROW_TWO_SLOT_TWO(10),
    ROW_TWO_SLOT_THREE(11),
    ROW_TWO_SLOT_FOUR(12),
    ROW_TWO_SLOT_FIVE(13),
    ROW_TWO_SLOT_SIX(14),
    ROW_TWO_SLOT_SEVEN(15),
    ROW_TWO_SLOT_EIGHT(16),
    ROW_TWO_SLOT_NINE(17),
    ROW_THREE_SLOT_ONE(18),
    ROW_THREE_SLOT_TWO(19),
    ROW_THREE_SLOT_THREE(20),
    ROW_THREE_SLOT_FOUR(21),
    ROW_THREE_SLOT_FIVE(22),
    ROW_THREE_SLOT_SIX(23),
    ROW_THREE_SLOT_SEVEN(24),
    ROW_THREE_SLOT_EIGHT(25),
    ROW_THREE_SLOT_NINE(26),
    ROW_FOUR_SLOT_ONE(27),
    ROW_FOUR_SLOT_TWO(28),
    ROW_FOUR_SLOT_THREE(29),
    ROW_FOUR_SLOT_FOUR(30),
    ROW_FOUR_SLOT_FIVE(31),
    ROW_FOUR_SLOT_SIX(32),
    ROW_FOUR_SLOT_SEVEN(33),
    ROW_FOUR_SLOT_EIGHT(34),
    ROW_FOUR_SLOT_NINE(35),
    ROW_FIVE_SLOT_ONE(36),
    ROW_FIVE_SLOT_TWO(37),
    ROW_FIVE_SLOT_THREE(38),
    ROW_FIVE_SLOT_FOUR(39),
    ROW_FIVE_SLOT_FIVE(40),
    ROW_FIVE_SLOT_SIX(41),
    ROW_FIVE_SLOT_SEVEN(42),
    ROW_FIVE_SLOT_EIGHT(43),
    ROW_FIVE_SLOT_NINE(44),
    ROW_SIX_SLOT_ONE(45),
    ROW_SIX_SLOT_TWO(46),
    ROW_SIX_SLOT_THREE(47),
    ROW_SIX_SLOT_FOUR(48),
    ROW_SIX_SLOT_FIVE(49),
    ROW_SIX_SLOT_SIX(50),
    ROW_SIX_SLOT_SEVEN(51),
    ROW_SIX_SLOT_EIGHT(52),
    ROW_SIX_SLOT_NINE(53)
}