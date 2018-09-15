class BeerSong {

    companion object {

        fun verses(from: Int, to: Int): String = (from downTo to)
            .map {
                when (it) {
                    in 99 downTo 3 -> "$it bottles of beer on the wall, $it bottles of beer.\nTake one down and pass it around, ${(it - 1)} bottles of beer on the wall.\n"
                    2 -> "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
                    1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
                    0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
                    else -> throw IllegalArgumentException()
                }
            }.reduce { acc, s -> acc + "\n" + s }
    }
}
