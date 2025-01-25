package wk1

import kotlin.math.min
import kotlin.math.max

class Car( val maxSpeed: Double = 120.0, val gasolineCapacity: Double = 50.0) {
    var gasolineLevel: Double = 0.0
        private set
    var speed: Double = 0.0
        private set

    fun fillTank() {
        gasolineLevel = gasolineCapacity
    }

    fun accelerate() {
        // min function returns the smaller of two values
        val newSpeed = min(speed + 1.0, maxSpeed)
        val gasolineNeeded = (newSpeed - speed) * 0.1
        if (gasolineLevel >= gasolineNeeded) {
            gasolineLevel -= gasolineNeeded
            speed = newSpeed
        }
    }

    fun decelerate() {
        // max function returns the larger of two values
        speed = max(speed - 1.5, 0.0)
    }

    override fun toString(): String {
        return "Car with speed $speed/$maxSpeed, gas $gasolineLevel/$gasolineCapacity"
    }
}


val car1 = Car()

/*
val car2 = Car(120.0)
val car3 = Car(gasolineCapacity = 50.0)
val car4 = Car(120.0, 50.0)
val car5 = Car(180.0, 70.0)
car5.toString()
 */

