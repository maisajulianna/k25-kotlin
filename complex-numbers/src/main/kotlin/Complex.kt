package complex_numbers

const val EPS = 0.0000001 // used in equals comparison

class Complex (val real: Double, val imaginary: Double) {
    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())

    operator fun plus(other: Complex): Complex {
        return Complex(this.real + other.real, this.imaginary + other.imaginary)
    }

    operator fun minus(other: Complex): Complex {
        return Complex(this.real - other.real, this.imaginary - other.imaginary)
    }

    operator fun times(other: Complex): Complex {
        return Complex(this.real * other.real - this.imaginary * other.imaginary,
                this.real * other.imaginary + this.imaginary * other.real)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false // !is is a type check
        return (kotlin.math.abs(this.real - other.real) < EPS &&
                kotlin.math.abs(this.imaginary - other.imaginary) < EPS)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }

    override fun hashCode(): Int {
        return real.hashCode() * 31 + imaginary.hashCode()
    }

    // itseisarvo
    val abs: Double
        get() = kotlin.math.sqrt(real * real + imaginary * imaginary)
}