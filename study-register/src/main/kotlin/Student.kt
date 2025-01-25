package study_register

class Student (
    name: String,
    age: Int,
    val courses: MutableList<CourseRecord> = mutableListOf()
) : Human(name, age) {
    fun addCourse(course: CourseRecord ) { courses.add(course) }

    fun weightedAverage(): Double {
        if (courses.isEmpty()) { return 0.0 }

        val weightedGrades = courses.sumOf { it.grade * it.credits }
        val totalCredits = courses.sumOf { it.credits }
        return weightedGrades / totalCredits
    }

    fun weightedAverage(year: Int): Double {
        if (courses.isEmpty()) { return 0.0 }

        val coursesByYear = courses.filter { it.yearCompleted == year }
        if (coursesByYear.isEmpty()) { return 0.0 }

        val weightedGrades = coursesByYear.sumOf { it.grade * it.credits }
        val totalCredits = coursesByYear.sumOf { it.credits }
        return weightedGrades / totalCredits
    }

    // this is redundant because weighted grade from only one course is the same as the grade of that course
    fun weightedAverage(courseName: String): Double {
        if (courses.isEmpty()) { return 0.0 }

        val coursesByName = courses.filter { it.name == courseName }
        if (coursesByName.isEmpty()) { return 0.0 }

        val weightedGrades = coursesByName.sumOf { it.grade * it.credits }
        val totalCredits = coursesByName.sumOf { it.credits }
        return weightedGrades / totalCredits
    }

    fun getGrade(courseName: String): Double {
        val course = courses.find { it.name == courseName }
        return course?.grade ?: 0.0
    }

    fun minMaxGrades(): Pair<Double, Double> {
        if (courses.isEmpty()) { return Pair(0.0, 0.0) }

        val minGrade = courses.minOf { it.grade }
        val maxGrade = courses.maxOf { it.grade }
        return Pair(minGrade, maxGrade)
    }
}