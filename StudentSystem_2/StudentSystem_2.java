//  author : Ersin Aydoğmuş
//  since : 4.04.2021

import java.util.ArrayList;

public class Assignment02_20190808028 {

    class Department {
        private String id, name;
        private Teacher chair;

        public Department(String id, String name) {
            setId(id);
            this.name = name;
        }

        public void setId(String id) {
            if (id.length() == 3 || id.length() == 4)
                this.id = id;
            else throw new InvalidIdException(id);
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Teacher getChair() {
            return chair;
        }

        public void setChair(Teacher chair) {
            if (chair.getDepartment() == this)
                this.chair = chair;
            else throw new DepartmentMismatchException(this, chair);
        }
    }

    class Course {
        private String title;
        private int number, akts;
        private Department department;
        private Teacher teacher;

        public Course(Department department, int number,
                      String title, int akts, Teacher teacher) {
            this.title = title;
            this.number = number;
            this.akts = akts;
            this.department = department;
            setTeacher(teacher);
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            if (teacher.getDepartment() == this.department)
                this.teacher = teacher;
            else throw new DepartmentMismatchException(this, teacher);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            if ((number >= 100 && number <= 499) ||
                    (number >= 5000 && number <= 5999) ||
                    (number >= 7000 && number <= 7999))
                this.number = number;
            else throw new InvalidNumberException(number);
        }

        public int getAkts() {
            return akts;
        }

        public void setAkts(int akts) {
            if (akts > 0) this.akts = akts;
            else throw new InvalidAktsException(akts);
        }

        public String courseCode() {
            return department.getId() + " " + getNumber();
        }

        public String toString() {
            return department.getId() + " " + getNumber() +
                    " - " + getTitle() + "(" + getAkts() + ")";
        }
    }

    abstract class Person {
        private String name, email;
        private long id;
        private Department department;

        public Person(String name, String email,
                      long id, Department department) {
            this.name = name;
            setEmail(email);
            this.id = id;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            if (email.contains("@") && email.substring(email.indexOf("@"))
                    .contains(".")) this.email = email;
            else throw new InvalidEmailException(email);
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        public long getID() {
            return id;
        }

        public void setID(long id) {
            this.id = id;
        }

        public String toString() {
            return getName() + " " + getID() + " - " + getEmail();
        }
    }

    class Teacher extends Person {
        private int rank;

        public Teacher(String name, String email, long id,
                       Department department, int rank) {
            super(name, email, id, department);
            if (rank >= 1 && rank <= 4) this.rank = rank;
            else throw new InvalidRankException(rank);
        }

        @Override
        public void setDepartment(Department department) {
            if (this.getDepartment().chair == this) {
                this.getDepartment().setChair(null);
            }
            super.setDepartment(department);
        }

        public int getRank() {
            return rank;
        }

        private String getTitle() {
            if (getRank() == 1) return "Lecturer";
            else if (getRank() == 2) return "Assistant Professor";
            else if (getRank() == 3) return "Associate Professor";
            else if (getRank() == 4) return "Professor";
            else throw new InvalidRankException(rank);
        }

        private void promote() {
            if (getRank() + 1 <= 4 && getRank() + 1 >= 1) rank++;
            else throw new InvalidRankException(rank);
        }

        private void demote() {
            if (getRank() - 1 <= 4 && getRank() - 1 >= 1) rank--;
            else throw new InvalidRankException(rank);
        }

        public String toString() {
            return getTitle() + " " + getName() +
                    " (" + getID() + ") - " + getEmail();
        }
    }

    class Student extends Person {
        private ArrayList<Course> courseList = new ArrayList<Course>();
        private ArrayList<Double> courseGrade = new ArrayList<Double>();

        public Student(String name, String email, long id,
                       Department department) {
            super(name, email, id, department);
        }

        public ArrayList<Course> getCourseList() {
            return courseList;
        }

        public ArrayList<Double> getCourseGrade() {
            return courseGrade;
        }

        public int getAKTS() {
            int totalAkts = 0;
            for (int i = 0; i < courseGrade.size(); i++) {
                if (courseGrade.get(i) >= 60)
                    totalAkts += courseList.get(i).getAkts();
            }
            return totalAkts;
        }

        public int getAttemptedAKTS() {
            int sumAkts = 0;
            for (int i = 0; i < courseGrade.size(); i++) {
                sumAkts += courseList.get(i).getAkts();
            }
            return sumAkts;
        }

        public void addCourse(Course course, Double grade) {
            if (grade < 0 || grade > 100)
                throw new InvalidGradeException(grade);
            else {
                if (courseList.contains(course)) {
                    courseList.set(courseList.indexOf(course), course);
                    courseGrade.set(courseList.indexOf(course), grade);
                } else {
                    courseList.add(course);
                    courseGrade.add(grade);
                }
            }
        }

        public double courseGPAPoints(Course course) {
            double gpaPoint = 0;
            if (courseList.contains(course)) {
                if (courseGrade.get(courseList.indexOf(course)) >= 88)
                    gpaPoint = 4;
                else if (courseGrade.get(courseList.indexOf(course)) >= 81)
                    gpaPoint = 3.5;
                else if (courseGrade.get(courseList.indexOf(course)) >= 74)
                    gpaPoint = 3.0;
                else if (courseGrade.get(courseList.indexOf(course)) >= 67)
                    gpaPoint = 2.5;
                else if (courseGrade.get(courseList.indexOf(course)) >= 60)
                    gpaPoint = 2.0;
                else if (courseGrade.get(courseList.indexOf(course)) >= 53)
                    gpaPoint = 1.5;
                else if (courseGrade.get(courseList.indexOf(course)) >= 46)
                    gpaPoint = 1.0;
                else if (courseGrade.get(courseList.indexOf(course)) >= 35)
                    gpaPoint = 0.5;
                else gpaPoint = 0;
            } else throw new CourseNotFoundException();
            return gpaPoint;
        }

        public String courseGradeLetter(Course course) {
            String gradeLetter = "";
            if (courseList.contains(course)) {
                if (courseGrade.get(courseList.indexOf(course)) >= 88)
                    gradeLetter = "AA";
                else if (courseGrade.get(courseList.indexOf(course)) >= 81)
                    gradeLetter = "BA";
                else if (courseGrade.get(courseList.indexOf(course)) >= 74)
                    gradeLetter = "BB";
                else if (courseGrade.get(courseList.indexOf(course)) >= 67)
                    gradeLetter = "CB";
                else if (courseGrade.get(courseList.indexOf(course)) >= 60)
                    gradeLetter = "CC";
                else if (courseGrade.get(courseList.indexOf(course)) >= 53)
                    gradeLetter = "DC";
                else if (courseGrade.get(courseList.indexOf(course)) >= 46)
                    gradeLetter = "DD";
                else if (courseGrade.get(courseList.indexOf(course)) >= 35)
                    gradeLetter = "FD";
                else gradeLetter = "FF";
            } else throw new CourseNotFoundException();
            return gradeLetter;
        }

        public String courseResult(Course course) {
            String status = "";
            if (courseList.contains(course)) {
                if (courseGrade.get(courseList.indexOf(course)) >= 60)
                    status = "Passed";
                else if (courseGrade.get(courseList.indexOf(course)) >= 46)
                    status = "Conditionally Passed";
                else status = "Failed";
            } else throw new CourseNotFoundException();
            return status;
        }

        public double getGPA() {
            double sumTotal = 0;
            int sumAkts = 0;
            for (int i = 0; i < courseList.size(); i++) {
                sumAkts += courseList.get(i).getAkts();
            }
            for (int i = 0; i < courseGrade.size(); i++) {
                double gradePoint;
                sumTotal += courseGPAPoints(courseList.get(i))
                        * courseList.get(i).getAkts();
            }
            sumTotal = sumTotal / sumAkts;
            return sumTotal;
        }

        public String toString() {
            return super.toString() + "-GPA: " + getGPA();
        }
    }

    class GradStudent extends Student {
        private String Thesis;

        public GradStudent(String name, String email, long id,
                           Department department, String thesis) {
            super(name, email, id, department);
            Thesis = thesis;
        }

        @Override
        public double courseGPAPoints(Course course) {
            double gpaPoint = 0;
            if (getCourseList().contains(course)) {
                if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 90)
                    gpaPoint = 4;
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 85)
                    gpaPoint = 3.5;
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 80)
                    gpaPoint = 3.0;
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 75)
                    gpaPoint = 2.5;
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 70)
                    gpaPoint = 2.0;
                else gpaPoint = 1.5;
            } else throw new CourseNotFoundException();
            return gpaPoint;
        }

        @Override
        public String courseGradeLetter(Course course) {
            String gradeLetter = "";
            if (getCourseList().contains(course)) {
                if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 90)
                    gradeLetter = "AA";
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 85)
                    gradeLetter = "BA";
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 80)
                    gradeLetter = "BB";
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 75)
                    gradeLetter = "CB";
                else if
                (getCourseGrade().get(getCourseList().indexOf(course)) >= 70)
                    gradeLetter = "CC";
                else gradeLetter = "DC";
            } else throw new CourseNotFoundException();
            return gradeLetter;
        }

        @Override
        public String courseResult(Course course) {
            String status = "";
            if (getCourseList().contains(course)) {
                if (getCourseGrade().get(getCourseList().indexOf(course)) >= 70)
                    status = "Passed";
                else status = "Failed";
            } else throw new CourseNotFoundException();
            return status;
        }

        public String getThesis() {
            return Thesis;
        }

        public void setThesis(String thesis) {
            Thesis = thesis;
        }

        public String toString() {
            return getName() + " " + getID() + " - " + getEmail();
        }
    }

    class CourseNotFoundException extends RuntimeException {
        Student student;
        Course course;

        public CourseNotFoundException() {
        }

        @Override
        public String toString() {
            return "CourseNotFoundException: " + student.getID() +
                    " has not yet taken " + course.getTitle() + "";
        }
    }

    class DepartmentMismatchException extends RuntimeException {
        Department department;
        Teacher person;
        Course course;

        public DepartmentMismatchException(Course course, Teacher person) {
            this.department = null;
            this.person = person;
            this.course = course;
        }

        public DepartmentMismatchException(Department department,
                                           Teacher person) {
            this.course = null;
            this.department = department;
            this.person = person;
        }

        @Override
        public String toString() {
            if (course == null)
                return "DepartmentMismatchException: " + person.getName() + "("
                        + person.getID() + ") cannot be chair of " +
                        department.getId() + " because he/she is currently " +
                        "assigned to " + person.getDepartment().getId();
            return "DepartmentMismatchException: " + person.getName() + "(" +
                    person.getID() + ") cannot teach " + course.courseCode() +
                    " because he/she is currently assigned to " +
                    person.getDepartment().getId();
        }
    }

    class InvalidGradeException extends RuntimeException {
        Double grade;

        public InvalidGradeException(Double grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "InvalidGradeException: " + grade;
        }
    }

    class InvalidRankException extends RuntimeException {
        int rank;

        public InvalidRankException(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "InvalidRankException: " + rank;
        }
    }

    class InvalidIdException extends RuntimeException {
        String id;

        public InvalidIdException(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "InvalidIdException" + id;
        }
    }

    class InvalidNumberException extends RuntimeException {
        int number;

        public InvalidNumberException(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "InvalidNumberException" + number;
        }
    }

    class InvalidAktsException extends RuntimeException {
        int akts;

        public InvalidAktsException(int akts) {
            this.akts = akts;
        }

        @Override
        public String toString() {
            return "InvalidAktsException" + akts;
        }
    }

    class InvalidEmailException extends RuntimeException {
        String email;

        public InvalidEmailException(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "InvalidEmailException" + email;
        }
    }

}