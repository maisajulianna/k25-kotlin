import study_register.*

internal class StudyRegister {
    val students = ArrayList<Student>()

    fun createStudents() {
        var student: Student
        student = Student("Enzio Benzino", 21)
        student.addCourse(CourseRecord("Kotlin basics", 2023,5, 5.0))
        student.addCourse(CourseRecord("Java basics", 2023, 5, 1.0))
        student.addCourse(CourseRecord("Scala basics", 2023, 3, 2.0))
        students.add(student)
        student = Student("Abebe Bikila", 23)
        student.addCourse(CourseRecord("Kotlin basics", 2023, 5, 2.0))
        students.add(student)
        student = Student("Günther Radulic", 20)
        student.addCourse(CourseRecord("Kotlin basics", 2023, 5, 4.0))
        student.addCourse(CourseRecord("Kotlin advanced", 2023, 5, 5.0))
        students.add(student)
    }

    fun major() {
        createStudents()
        val major = Major("True Programming")
        for (student in students) {
            major.addStudent(student)
        }

        println("MAJOR STATS(): ${major.stats()}")
        print("MAJOR STATS(by year): ${major.stats("Kotlin basics")}")
    }
}

