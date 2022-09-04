//  author : Ersin Aydoğmuş
//  since : 08.05.2021
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Assignment03_20190808028 {
}

class DepartmentTest{
    @Test
    public void setIdTest() {
        Department d1 = new Department("CSE","Programming");
        d1.setId("PSE");
        assertEquals("PSE",d1.getId());
    }
    @Test
    public void setIdErrorTest() {
        try{
            Department d1 = new Department("CSEAE","Programming");
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void getIdTest() {
        Department d1 = new Department("CSE","Programming");
        assertEquals("CSE",d1.getId());
    }

    @Test
    public void getNameTest() {
        Department d1 = new Department("CSE","Programming");
        assertEquals("Programming",d1.getName());
    }

    @Test
    public void setNameTest() {
        Department d1 = new Department("CSE","Programming");
        d1.setName("Physics");
        assertEquals("Physics",d1.getName());
    }

    @Test
    public void getChairTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",123456L,d1,2);
        d1.setChair(t1);
        assertEquals(t1,d1.getChair());
    }

    @Test
    public void setChairTest() {
        //I forgot to add "else if" in Assignment 2.
        //The truth is:
        //public void setChair(Teacher chair) {
        //        if (chair == null) this.chair = null;
        //        else if (chair.getDepartment() == this)
        //            this.chair = chair;
        //        else throw new DepartmentMismatchException(this, chair);
        //    }
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",123456L,d1,2);
        d1.setChair(t1);
        assertEquals(t1,d1.getChair());
    }
    @Test
    public void setChairErrorTest() {
        try{Department d1 = new Department("CSE","Programming");
            Department d2 = new Department("MAT","MATH");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",123456L,d1,2);
            Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
            d1.setChair(t2);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void departmentConstructorIdTest(){
        Department d1 = new Department("CSE","Programming");
        assertEquals("CSE",d1.getId());
    }

    @Test
    public void departmentConstructorIdErrorTest(){
        try{Department d1 = new Department("CSEAE","Programming");}
        catch (Exception e){
            assertTrue(true);
        }

    }

    @Test
    public void departmentConstructorNameTest(){
        Department d1 = new Department("CSE","Programming");
        assertEquals("Programming",d1.getName());
    }
}

class CourseTest{
    @Test
    public void getDepartmentTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(d1,c1.getDepartment());
    }

    @Test
    public void setDepartmentTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Department d2 = new Department("CS1","Programming2");
        c1.setDepartment(d2);
        assertEquals(d2,c1.getDepartment());
    }

    @Test
    public void getTeacherTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(t1,c1.getTeacher());
    }

    @Test
    public void setTeacherTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Teacher t2 = new Teacher("Ali Veli","p1ere112@hotmail.com",124L,d1,2);
        c1.setTeacher(t2);
        assertEquals(t2,c1.getTeacher());
    }

    @Test
    public void setTeacherErrorTest() {
        try{Department d1 = new Department("CSE","Programming");
            Department d2 = new Department("MAT","MATH");
            Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Teacher t2 = new Teacher("Ali Veli","p1ere112@hotmail.com",124L,d2,2);
            c1.setTeacher(t2);}
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void getTitleTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals("Programming 1",c1.getTitle());
    }

    @Test
    public void setTitleTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        c1.setTitle("Programming 2");
        assertEquals("Programming 2",c1.getTitle());
    }

    @Test
    public void getNumberTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(123,c1.getNumber());
    }

    @Test
    public void setNumberTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        c1.setNumber(350);
        assertEquals(350,c1.getNumber());
    }

    @Test
    public void setNumberErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            c1.setNumber(15000);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void getAKTSTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(6,c1.getAkts());
    }

    @Test
    public void setAKTSTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        c1.setAkts(7);
        assertEquals(7,c1.getAkts());
    }

    @Test
    public void setAKTSErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            c1.setAkts(-7);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void courseCodeTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals("CSE 123",c1.courseCode());
    }

    @Test
    public void toStringTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals("CSE 123 - Programming 1 (6)",c1.toString());
    }
    @Test
    public void courseConstructorDepartmentTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(d1,c1.getDepartment());
    }
    @Test
    public void courseConstructorNumberTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(123,c1.getNumber());
    }
    @Test
    public void courseConstructorTittleTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals("Programming 1",c1.getTitle());
    }
    @Test
    public void courseConstructorAktsTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(6,c1.getAkts());
    }
    @Test
    public void courseConstructorTeacherTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        assertEquals(t1,c1.getTeacher());
    }
}

class PersonTest{
    @Test
    public void getNameTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("Ersin",p1.getName());
    }

    @Test
    public void setNameTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        p1.setName("Ali");
        assertEquals("Ali",p1.getName());
    }

    @Test
    public void getEmailTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("p1ere1@hotmail.com",p1.getEmail());
    }

    @Test
    public void setEmailTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        p1.setEmail("ersinaydogmus.7@gmail.com");
        assertEquals("ersinaydogmus.7@gmail.com",p1.getEmail());
    }

    @Test
    public void setEmailErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            p1.setEmail("kamil");
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void getDepartmentTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(d1,p1.getDepartment());
    }

    @Test
    public void setDepartmentTest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("KLM","Programming 2");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        p1.setDepartment(d2);
        assertEquals(d2,p1.getDepartment());
    }

    @Test
    public void getIDTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(1234L,p1.getID());
    }

    @Test
    public void setIDTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        p1.setID(456L);
        assertEquals(456L,p1.getID());
    }

    @Test
    public void testToStringTest() {
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Person("Ersin","p1ere1@hotmail.com",1234L,d1){};
        assertEquals("Ersin " + 1234L + " - p1ere1@hotmail.com",p1.toString());
    }
    @Test
    public void personConstructorNameTest(){
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("Ersin",p1.getName());

    }

    @Test
    public void personConstructorEmailTest(){
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("p1ere1@hotmail.com",p1.getEmail());
    }

    @Test
    public void personConstructorEmailErrorTest(){
        try{
            Department d1 = new Department("CSE","Programming");
            Person p1 = new Teacher("Ersin","kamil",1234L,d1,3);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void personConstructorIdTest(){
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(1234L,p1.getID());
    }
    @Test
    public void personConstructorDepartmentTest(){
        Department d1 = new Department("CSE","Programming");
        Person p1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(d1,p1.getDepartment());
    }
}

class StudentTest{
    @Test
    public void getCourseListTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Department d2 = new Department("MAT","MATH");
        Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
        Course c2 = new Course(d2,574,"Math 1",5,t2);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.add(c1);
        courseList.add(c2);
        s1.addCourse(c1,76.0);
        s1.addCourse(c2,87.0);
        assertEquals(courseList,s1.getCourseList());
    }

    @Test
    public void getCourseGradeTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Department d2 = new Department("MAT","MATH");
        Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
        Course c2 = new Course(d2,574,"Math 1",5,t2);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        ArrayList<Double> courseGrade = new ArrayList<Double>();
        courseGrade.add(76.0);
        courseGrade.add(87.0);
        s1.addCourse(c1,76.0);
        s1.addCourse(c2,87.0);
        assertEquals(courseGrade,s1.getCourseGrade());
    }

    @Test
    public void getAKTSTest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("MAT","MATH");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Course c2 = new Course(d2,574,"Math 1",5,t2);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,82.0);
        s1.addCourse(c2,54.0);
        assertEquals(6,s1.getAKTS());
    }

    @Test
    public void getAttemptedAKTSTest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("MAT","MATH");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Course c2 = new Course(d2,574,"Math 1",5,t2);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,82.0);
        s1.addCourse(c2,54.0);
        assertEquals(11,s1.getAttemptedAKTS());
    }

    @Test
    public void addCourseTest() {
        //In Homework 2, I forgot to put equality in the boundaries.
        //The truth is:
        //public void addCourse(Course course, Double grade) {
        //        if (grade <= 0 || grade >= 100)
        //            throw new InvalidGradeException(grade);
        //        else {
        //            if (courseList.contains(course)) {
        //                courseList.set(courseList.indexOf(course), course);
        //                courseGrade.set(courseList.indexOf(course), grade);
        //            } else {
        //                courseList.add(course);
        //                courseGrade.add(grade);
        //            }
        //        }
        //    }
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,74.0);
        s1.addCourse(c1,85.0);
        assertEquals(1,s1.getCourseList().size());
    }

    @Test
    public void addCourseErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,-74.0);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void addCourseNullTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Course c1 = null;
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,74.0);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void courseGPAPointsTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,75.0);
        assertEquals(3.0,s1.courseGPAPoints(c1));
    }

    @Test
    public void courseGPAPointsErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Course c2 = new Course(d1,123,"Programming 2",6,t1);
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,75.0);
            s1.courseGPAPoints(c2);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void courseGradeLetterTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,75.0);
        assertEquals("BB",s1.courseGradeLetter(c1));
    }

    @Test
    void courseGradeLetterErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Course c2 = new Course(d1,123,"Programming 2",6,t1);
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,75.0);
            s1.courseGradeLetter(c2);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void courseResultTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,75.0);
        assertEquals("Passed",s1.courseResult(c1));
    }

    @Test
    void courseResultErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Course c2 = new Course(d1,123,"Programming 2",6,t1);
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,75.0);
            s1.courseResult(c2);
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void getGPATest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("MAT","MATH");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
        Course c1 = new Course(d1,123,"Programming 1",3,t1);
        Course c2 = new Course(d2,574,"Math 1",3,t2);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,80.0);
        s1.addCourse(c2,74.0);
        assertEquals(3.0,s1.getGPA());
    }

    @Test
    void toStringTest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("MAT","MATH");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Teacher t2 = new Teacher("Kamil","kamil@hotmail.com",657L,d2,2);
        Course c1 = new Course(d1,123,"Programming 1",3,t1);
        Course c2 = new Course(d2,574,"Math 1",3,t2);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        s1.addCourse(c1,80.0);
        s1.addCourse(c2,74.0);
        assertEquals("Ersin " + 789L + " - ersinaydogmus.7@gmail.com -GPA: 3.0",s1.toString());
    }

    @Test
    void studentConstructorNameTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        assertEquals("Ersin",s1.getName());
    }
    @Test
    void studentConstructorEmailTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        assertEquals("ersinaydogmus.7@gmail.com",s1.getEmail());
    }
    @Test
    void studentConstructorIdTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        assertEquals(789L,s1.getID());
    }
    @Test
    void studentConstructorDepartmentTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
        assertEquals(d1,s1.getDepartment());
    }
}

class TeacherTest{
    @Test
    void setDepartmentTest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("KLM","Programming 2");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        t1.setDepartment(d2);
        assertEquals(d2,t1.getDepartment());
    }
    @Test
    void setDepartmentNullTest() {
        Department d1 = new Department("CSE","Programming");
        Department d2 = new Department("KLM","Programming 2");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        d1.setChair(t1);
        t1.setDepartment(d2);
        assertNull(d1.getChair());
    }

    @Test
    void getRankTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(3,t1.getRank());
    }

    @Test
    void toStringTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(t1.getTitle() + " Ersin (" + 1234L + ") - p1ere1@hotmail.com",t1.toString());
    }

    @Test
    void teacherConstructorNameTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("Ersin",t1.getName());
    }
    @Test
    void teacherConstructorEmailTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("p1ere1@hotmail.com",t1.getEmail());
    }
    @Test
    void teacherConstructorIdTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(1234L,t1.getID());
    }
    @Test
    void teacherConstructorDepartmentTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(d1,t1.getDepartment());
    }
    @Test
    void teacherConstructorRankTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals(3,t1.getRank());
    }

    @Test
    void teacherConstructorErrorRankTest(){
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,7);
        }
        catch (Exception e){
            assertTrue(true);
        }

    }

    @Test
    void getTitleTest1() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,1);
        assertEquals("Lecturer",t1.getTitle());
    }
    @Test
    void getTitleTest2() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,2);
        assertEquals("Assistant Professor",t1.getTitle());
    }
    @Test
    void getTitleTest3() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        assertEquals("Associate Professor",t1.getTitle());
    }
    @Test
    void getTitleTest4() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,4);
        assertEquals("Professor",t1.getTitle());
    }
    @Test
    void getTitleTest5() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,5);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void promoteTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        t1.promote();
        assertEquals(4,t1.getRank());
    }

    @Test
    void promoteErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,4);
            t1.promote();
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void demoteTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        t1.demote();
        assertEquals(2,t1.getRank());
    }

    @Test
    void demoteErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,1);
            t1.demote();
        }
        catch (Exception e){
            assertTrue(true);
        }
    }
}

class GradStudentTest{
    @Test
    void courseGPAPointsTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        gs1.addCourse(c1,92.0);
        assertEquals(4.0,gs1.courseGPAPoints(c1));
    }

    @Test
    void courseGPAPointsErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
            gs1.addCourse(c1,-92.0);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void courseGradeLetterTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        gs1.addCourse(c1,92.0);
        assertEquals("AA",gs1.courseGradeLetter(c1));
    }

    @Test
    void courseGradeLetterErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
            gs1.addCourse(c1,-92.0);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void courseResultTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        gs1.addCourse(c1,92.0);
        assertEquals("Passed",gs1.courseResult(c1));
    }

    @Test
    void courseResultErrorTest() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
            gs1.addCourse(c1,-92.0);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void getThesisTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        assertEquals("Car",gs1.getThesis());
    }

    @Test
    void setThesisTest() {
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Apple");
        gs1.setThesis("Car");
        assertEquals("Car",gs1.getThesis());
    }

    @Test
    void toStringTest() {//Kendi GradStudentımda GPA Pointi silmişim.
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        gs1.addCourse(c1,90.0);
        assertEquals("Ersin " + 789L + " - " + "ersinaydogmus.7@gmail.com -GPA: 4.0",gs1.toString());
    }

    @Test
    void gradStudentConstructorNameTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        assertEquals("Ersin",gs1.getName());
    }
    @Test
    void gradStudentConstructorEmailTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        assertEquals("ersinaydogmus.7@gmail.com",gs1.getEmail());
    }
    @Test
    void gradStudentConstructorIdTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        assertEquals(789L,gs1.getID());
    }
    @Test
    void gradStudentConstructorDepartmentTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        assertEquals(d1,gs1.getDepartment());
    }
    @Test
    void gradStudentConstructorThesisTest(){
        Department d1 = new Department("CSE","Programming");
        Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
        Course c1 = new Course(d1,123,"Programming 1",6,t1);
        GradStudent gs1 = new GradStudent("Ersin","ersinaydogmus.7@gmail.com",789L,d1,"Car");
        assertEquals("Car",gs1.getThesis());
    }
}

class CourseNotFoundExceptionTest{
    //In Assignment 2, I did not fill in the founding method.
    //The truth is:
    // public CourseNotFoundException(Student student, Course course) {
    //        this.student = student;
    //        this.course = course;
    //    }
    @Test
    void testToString() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Course c2 = new Course(d1,123,"Programming 2",6,t1);
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,75.0);
            s1.courseResult(c2);
        }
        catch (Exception e){
            assertEquals("CourseNotFoundException: " + 789L + " has not yet taken Programming 2",e.toString());
        }
    }
}

class DepartmentMismatchExceptionTest{
    @Test
    void testToString1() {
        try{Department d1 = new Department("CSE","Programming");
            Department d2 = new Department("MAT","MATH");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",123456L,d1,2);
            d2.setChair(t1);
        }
        catch (Exception e){
            assertEquals("DepartmentMismatchException: Ersin(" + 123456L + ") cannot be chair of MAT because he/she is currently assigned to CSE",e.toString());
        }
    }

    @Test
    void testToString2() {
        try{
            Department d1 = new Department("CSE","Programming");
            Department d2 = new Department("MAT","Math");
            Teacher t1 = new Teacher("Ersin Aydogmus","p1ere1@hotmail.com",123L,d1,1);
            Course c1 = new Course(d2,123,"MAT",6,t1);
            c1.setTeacher(t1);
        }
        catch (Exception e){
            assertEquals("DepartmentMismatchException: Ersin Aydogmus(" + 123L + ") cannot teach MAT 123 because he/she is currently assigned to CSE",e.toString());
        }
    }
}

class InvalidGradeExceptionTest{
    @Test
    void testToString() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,3);
            Course c1 = new Course(d1,123,"Programming 1",6,t1);
            Student s1 = new Student("Ersin","ersinaydogmus.7@gmail.com",789L,d1);
            s1.addCourse(c1,-74.0);
        }
        catch (Exception e){
            assertEquals("InvalidGradeException: -74.0",e.toString());
        }
    }
}

class InvalidRankExceptionTest{
    @Test
    void testToString() {
        try{
            Department d1 = new Department("CSE","Programming");
            Teacher t1 = new Teacher("Ersin","p1ere1@hotmail.com",1234L,d1,7);
        }
        catch (Exception e){
            assertEquals("InvalidRankException: 7",e.toString());
        }
    }
}