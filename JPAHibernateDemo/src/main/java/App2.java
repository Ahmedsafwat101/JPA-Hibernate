import entities.School;
import entities.Student;
import entities.Teacher;
import entities.Tutor;
import repositires.SchoolRepositoryImp;
import repositires.StudentRepositoryImp;
import repositires.TeacherRepositoryImp;
import repositires.TutorRepositoryImp;

import java.util.HashSet;
import java.util.Set;

public class App2 {
    public static void main(String[] args) {
        StudentRepositoryImp studentRepository = new StudentRepositoryImp();
        TutorRepositoryImp tutorRepository = new TutorRepositoryImp();
        SchoolRepositoryImp schoolRepository = new SchoolRepositoryImp();
        TeacherRepositoryImp teacherRepository = new TeacherRepositoryImp();

        Tutor t1 = tutorRepository.addTutor(new Tutor("Mr. Ali", "Ahmed"));
        Tutor t2 = tutorRepository.addTutor(new Tutor("Mr. Khaled", "Ahmed"));
        Tutor t3 = tutorRepository.addTutor(new Tutor("Mr. Samir", "Ahmed"));

        Student s1 = studentRepository.addStudent(new Student("Ahmed", "Safwat",t1));
        Student s2 = studentRepository.addStudent(new Student("Mido", "Safwat",t2));
        Student s3 = studentRepository.addStudent(new Student("Zizo", "Safwat",t3));

        studentRepository.getAllStudent().forEach(it -> System.out.println(it.toString()));



        /*s1.setTutor(t1);
        s2.setTutor(t1);
        s3.setTutor(t1);*/

        /*studentRepository.addTutor(s1.getId(), t1);
        studentRepository.addTutor(s2.getId(), t1);
        studentRepository.addTutor(s3.getId(), t1);*/

        /*studentRepository.addStudent(s1);
        studentRepository.addStudent(s2);
        studentRepository.addStudent(s3);*/


        tutorRepository.getAllTutors().forEach(System.out::println);

        studentRepository.getAllStudent().forEach(System.out::println);


        System.out.println("Start Add School");

        School school1 = schoolRepository.add(new School("School1", "Cairo"));

        System.out.println("School1:" + school1.toString());

        schoolRepository.addStudent(school1.getId(), s1);
        schoolRepository.addStudent(school1.getId(), s2);
        schoolRepository.addStudent(school1.getId(), s3);


        studentRepository.getAllStudent().forEach(it -> System.out.println(it.toString()));

        schoolRepository.removeStudent(school1.getId(), s1);

        System.out.println("School1:" + school1);

        System.out.println("Start Add Teachers");

        Teacher teacher1 = teacherRepository.addTeacher(new Teacher("Ms. Aya", "Hasssan"));
        Teacher teacher2 = teacherRepository.addTeacher(new Teacher("Mr. Hassan", "Ali"));

        //teacherRepository.getAllTeachers().forEach(System.out::println);


        System.out.println("add teachers to school ");

        teacher1.setSchool(school1);
        teacher2.setSchool(school1);


        teacherRepository.addTeacher(teacher1);
        teacherRepository.addTeacher(teacher2);



        teacher1.addStudent(s1);
        teacher1.addStudent(s2);
        teacher1.addStudent(s3);

        teacher2.addStudent(s1);
        teacher2.addStudent(s2);
        teacher2.addStudent(s3);

        teacherRepository.addTeacher(teacher1);
        teacherRepository.addTeacher(teacher2);


        System.out.println(teacher1.getStudents());

        studentRepository.tearDownEntityManagerFactory();
    }
}
