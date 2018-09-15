import BeerSong.Companion.firstPart
import BeerSong.Companion.firstPartNoBottles
import BeerSong.Companion.fourthPart
import BeerSong.Companion.fourthPartNoBottles
import BeerSong.Companion.fourthPartOneBottle
import BeerSong.Companion.secondPart
import BeerSong.Companion.secondPartNoBottles
import BeerSong.Companion.thirdPart
import BeerSong.Companion.thirdPartNoBottles
import BeerSong.Companion.thirdPartOneBottle

class BeerSong {

    companion object {
        const val firstPart = "of beer on the wall,"
        const val firstPartNoBottles = "No more bottles of beer on the wall,"
        const val secondPartNoBottles = "no more bottles of beer."
        const val thirdPart = "Take one down and pass it around,"
        const val secondPart = "of beer."
        const val thirdPartOneBottle = "Take it down and pass it around,"
        const val thirdPartNoBottles = "Go to the store and buy some more,"
        const val fourthPart = "of beer on the wall."
        const val fourthPartOneBottle = "no more bottles of beer on the wall."
        const val fourthPartNoBottles = "99 bottles of beer on the wall."


        fun verses(from: Int, to: Int): String {
            return (from downTo to).map {
                "${it.toFirstVerseFirstPart()} ${it.toFirstVerseSecondPart()}\n${it.toSecondVerseFirstPart()} ${it.toSecondVerseSecondPart()}\n"
            }.reduce { acc, s -> acc + "\n" + s }
        }
    }
}

fun Int.toBottles() = when (this) {
    in 99 downTo 2 -> "$this bottles"
    1 -> "1 bottle"
    else -> throw IllegalArgumentException()
}

fun Int.toFirstVerseFirstPart() = when (this) {
    in 99 downTo 1 -> "${this.toBottles()} $firstPart"
    0 -> firstPartNoBottles
    else -> throw IllegalArgumentException()
}

fun Int.toFirstVerseSecondPart() = when (this) {
    in 99 downTo 1 -> "${this.toBottles()} $secondPart"
    0 -> secondPartNoBottles
    else -> throw IllegalArgumentException()
}

fun Int.toSecondVerseFirstPart() = when (this) {
    in 99 downTo 2 -> thirdPart
    1 -> thirdPartOneBottle
    0 -> thirdPartNoBottles
    else -> throw IllegalArgumentException()
}

fun Int.toSecondVerseSecondPart() = when (this) {
    in 99 downTo 2 -> "${(this - 1).toBottles()} $fourthPart"
    1 -> fourthPartOneBottle
    0 -> fourthPartNoBottles
    else -> throw IllegalArgumentException()
}
