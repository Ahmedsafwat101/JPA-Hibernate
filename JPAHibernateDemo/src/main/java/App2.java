import entities.Student;
import entities.Tutor;
import repositires.StudentRepositoryImp;
import repositires.TutorRepositoryImp;

public class App2 {
    public static void main(String[] args) {
        StudentRepositoryImp studentRepository = new StudentRepositoryImp();
        TutorRepositoryImp tutorRepository = new TutorRepositoryImp();
        Student s1 = studentRepository.addStudent(new Student("Ahmed", "Safwat"));
        Student s2 = studentRepository.addStudent(new Student("Mido", "Safwat"));
        Student s3 = studentRepository.addStudent(new Student("Zizo", "Safwat"));

        studentRepository.getAllStudent().forEach(it -> System.out.println(it.toString()));


        Tutor t1 = tutorRepository.addTutor(new Tutor("Mr. Ali", "Ahmed"));
        Tutor t2 = tutorRepository.addTutor(new Tutor("Mr. Khaled", "Ahmed"));


        studentRepository.addTutor(s1.getId(), t1);
        studentRepository.addTutor(s2.getId(), t2);
        studentRepository.addTutor(s3.getId(),t1);

        tutorRepository.getAllTutors().forEach(it-> System.out.println(it.toString()));

        studentRepository.getAllStudent().forEach(it -> System.out.println(it.toString()));

        studentRepository.tearDownEntityManagerFactory();
    }
}
