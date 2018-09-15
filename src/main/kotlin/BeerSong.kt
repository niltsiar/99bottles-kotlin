class BeerSong {

    companion object {

        fun verses(from: Int, to: Int): String = (from downTo to)
            .map { numberOfBottles ->
                val bottleNumber = BottleNumber.build(numberOfBottles)
                val nextBottleNumber = bottleNumber.successor

                "${bottleNumber.toString().capitalize()} of beer on the wall, $bottleNumber of beer.\n" +
                        "${bottleNumber.action}, $nextBottleNumber of beer on the wall.\n"
            }.reduce { accumulator, verse -> accumulator + "\n" + verse }
    }
}

open class BottleNumber(protected val numberOfBottles: Int) {

    companion object {

        fun build(numberOfBottles: Int): BottleNumber = when (numberOfBottles) {
            0 -> BottleNumber0()
            1 -> BottleNumber1()
            6 -> BottleNumber6()
            else -> BottleNumber(numberOfBottles)
        }
    }

    open val container: String
        get() = "bottles"

    open val quantity: String
        get() = numberOfBottles.toString()

    protected open val pronoun: String
        get() = "one"

    open val action: String
        get() = "Take ${this.pronoun} down and pass it around"

    open val successor: BottleNumber
        get() = build(numberOfBottles - 1)

    override fun toString(): String = "$quantity $container"
}

class BottleNumber0 : BottleNumber(0) {

    override val quantity: String
        get() = "no more"

    override val action: String
        get() = "Go to the store and buy some more"

    override val successor: BottleNumber
        get() = build(99)
}

class BottleNumber1 : BottleNumber(1) {

    override val container: String
        get() = "bottle"

    override val pronoun: String
        get() = "it"
}

class BottleNumber6 : BottleNumber(6) {

    override val container: String
        get() = "six-pack"

    override val quantity: String
        get() = "1"
}
