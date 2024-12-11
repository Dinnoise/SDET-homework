import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иван", "Группа 1", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Мария", "Группа 2", 2, Arrays.asList(3, 3, 3)));
        students.add(new Student("Алексей", "Группа 1", 1, Arrays.asList(2, 2, 2)));

        // Удаление студентов со средним баллом < 3
        removeStudentsWithLowAverage(students);

        // Перевод студентов на следующий курс
        promoteStudents(students);

        // Печать студентов на определенном курсе
        printStudents(students, 2);
    }

    public static void removeStudentsWithLowAverage(List<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteStudents(List<Student> students) {
        students.forEach(student -> {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        });
    }

    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}
