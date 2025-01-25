
// val is read-only, var is mutable
data class Opiskelija(val nimi: String, val opnro: Int = 666) {
    var op = 0

    // this function gives the student points
    fun suorita(pisteet: Int) {
        if ((1..15).contains(pisteet))
            op += pisteet
    }

    // this function returns the student's name, student number and points
    override fun toString(): String {
        return "$nimi, $opnro, $op"
    }
}


// this line creates a list of 10 students
// the students are named Aapo and have student numbers from 1 to 10
val opiskelijat = (1..10).map { Opiskelija("Aapo", it) }


// this is just to show the students in scratch
opiskelijat


// this line gives each student a random amount of points between 1 and 15
opiskelijat.forEach { it.suorita((1..15).random()) }
opiskelijat

// this line calculates the average amount of points the students have
// the sumOf function is a Kotlin function that calculates the sum of a list
opiskelijat.sumOf { it.op }.toDouble() / opiskelijat.size


// ----------------------------
// anothed data class with a list of pairs
data class Opiskelija2(val nimi: String, val opnro: Int = 666) {
    // what is the point of this mutable list ?
    val suoritukset: MutableList<Pair<Int,Int>> = mutableListOf()

    // this function registers the student's points
    fun rekisteroi(suoritus: Pair<Int,Int>) {
        // what are first and second ? what is the point of rekisteroi ??
        if ((1..15).contains(suoritus.first) && (1..5).contains(suoritus.second))
            suoritukset.add(suoritus)
    }
}

// this line creates a list of 10 students
// the students are named Aapo and have student numbers from 1 to 10
val opiskelijat2 = (1..10).map { Opiskelija2("Aapo", it ) }

//
(1..10).forEach { opiskelijat2.forEach { it.rekisteroi(Pair((1..15).random(), (1..5).random()))}}

opiskelijat2[0].suoritukset

// kolmas tehtävä = opiskelijan painotettu keskiarvo
opiskelijat2[0].suoritukset.map { it.first*it.second }.sum().toDouble() / opiskelijat2[0].suoritukset.sumOf { it.first }


// korkeamman kertoluvun funktio