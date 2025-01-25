package study_register

class Major (
    var name: String,
    val students: MutableList<Student> = mutableListOf(),
) {
    fun addStudent(student: Student) { students.add(student) }

    fun stats(): Triple<Double, Double, Double> {
        if (students.isEmpty()) { return Triple(0.0, 0.0, 0.0) }

        val averageGrades = students.map { it.weightedAverage() }
        val minAverage = averageGrades.minOf { it }
        val maxAverage = averageGrades.maxOf { it }

        val averageOfAverages = averageGrades.sum() / averageGrades.size

        return Triple(minAverage, maxAverage, averageOfAverages)
    }

    fun stats(courseName: String): Triple<Double, Double, Double> {
        if (students.isEmpty()) { return Triple(0.0, 0.0, 0.0) }

        // lists students who have taken the course
        val studentsByCourse = students.filter { student ->
            student.courses.any { course -> course.name == courseName }
        }

        if (studentsByCourse.isEmpty()) { return Triple(0.0, 0.0, 0.0) }

        // calculates and lists grades for the given course
        val courseGrades = studentsByCourse.map { it.getGrade(courseName) }

        val minGrade = courseGrades.minOf { it }
        val maxGrade = courseGrades.maxOf { it }
        val averageGrade = courseGrades.sum() / courseGrades.size

        return Triple(minGrade, maxGrade, averageGrade)
    }
}