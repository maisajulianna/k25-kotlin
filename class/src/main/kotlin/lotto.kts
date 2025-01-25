package wk1

// 7 eri numeroa 1-40 listaan


// 1.

(1..40).toList().shuffled().take(7).sorted()


// lista
val numerot1 = mutableListOf<Int>()
numerot1

while (numerot1.size < 7) {
    val uusiNumero = (1..40).random()
    if (uusiNumero !in numerot1) {
        numerot1.add(uusiNumero)
    }
}
numerot1.sorted()


// joukko
val numerot = mutableSetOf<Int>()

while (numerot.size < 7) {
    val uusi = (1..40).random()
    numerot.add(uusi)
}
numerot.sorted()




// lotto-rivin tarkistus

// class Lotto {}