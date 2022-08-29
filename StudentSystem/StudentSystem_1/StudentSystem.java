//  author : Ersin Aydoğmuş
//  since : 21.03.2021
public class Assignment01_20190808028 {
    public static void main(String[] args) {
        Course math = new Course("MAT", 158,
        "Matematik", 6);
        Teacher selma = new Teacher("Selma", "p123@hotmail.com",
        58956, "MAT", 2);
        Student ersin = new Student("Ersin Aydogmus",
        "ersinaydogmus@hotmail.com", 159753, "CSE", 34);
        GradStudent mahmut = new GradStudent("Mahmut",
        "mahmut123@hotmail.com", 12453, "FIZ", 25,
        "tez123");
        math.setDepartment("CSE");
        math.setNumber(157);
        math.setAKTS(5);
        math.setTitle("Programming 2");
        selma.setRank(3);
        selma.setName("Kaan");
        selma.setEmail("Kaan123@hotmail.com");
        selma.setID(35423);
        selma.setDepartment("CSE");
        ersin.setAKTS(42);
        ersin.setDepartment("MAT");
        ersin.setEmail("erso123@hotmail.com");
        ersin.setID(15945);
        ersin.setName("Ersin");
        selma.demote();
        selma.promote();
        mahmut.setThesis("tez321");
        ersin.passCourse(math);
        System.out.println(ersin.getDepartment());
        System.out.println(mahmut.getThesis());
        System.out.println(math.courseCode());
        System.out.println(ersin);
        System.out.println(selma);
        System.out.println(math);
        System.out.println(mahmut);
    }

    static class Course {
        private String department, title;
        private int number, AKTS;

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            if (department.length() == 3 || department.length() == 4)
                this.department = department;
            else throw new RuntimeException();
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
            else throw new RuntimeException();
        }

        public int getAKTS() {
            return AKTS;
        }

        public void setAKTS(int AKTS) {
            if (AKTS > 0) this.AKTS = AKTS;
            else throw new RuntimeException();
        }

        public Course(String department, int number, String title, int AKTS) {
            if (department.length() == 3 || department.length() == 4)
                this.department = department;
            else throw new RuntimeException();
            this.title = title;
            if ((number >= 100 && number <= 499) ||
                (number >= 5000 && number <= 5999) ||
                (number >= 7000 && number <= 7999))
                this.number = number;
            else throw new RuntimeException();
            if (AKTS > 0) this.AKTS = AKTS;
            else throw new RuntimeException();
        }

        public String courseCode() {
            return getDepartment() + " " + getNumber();
        }

        public String toString() {
            return getDepartment() + " " + getNumber() + " - " +
            getTitle() + " (" + getAKTS() + ")";
        }
    }

    static class Person {
        private String name, email, department;
        private long id;

        public Person(String name, String email, long id, String department) {
            this.name = name;
            if (email.contains("@") && email.contains(".")) this.email = email;
            else throw new RuntimeException();
            if (department.length() == 3 || department.length() == 4)
                this.department = department;
            else throw new RuntimeException();
            this.id = id;
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
            if (email.contains("@") && email.contains(".")) this.email = email;
            else throw new RuntimeException();
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            if (department.length() == 3 || department.length() == 4)
                this.department = department;
            else throw new RuntimeException();
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

    static class Teacher extends Person {
        private int rank;

        public Teacher(String name, String email, long id,
                       String department, int rank) {
            super(name, email, id, department);
            if (rank >= 1 && rank <= 3) this.rank = rank;
            else throw new RuntimeException();

        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            if (rank >= 1 && rank <= 3) this.rank = rank;
            else throw new RuntimeException();
        }

        private String getTitle() {
            if (getRank() == 1) return "Assistant Professor";
            else if (getRank() == 2) return "Associate Professor";
            else if (getRank() == 3) return "Professor";
            else throw new RuntimeException();
        }

        private void promote() {
            if (getRank() + 1 >= 1 && getRank() + 1 <= 3)
                setRank(getRank() + 1);
            else throw new RuntimeException();
        }

        private void demote() {
            if (getRank() - 1 >= 1 && getRank() - 1 <= 3)
                setRank(getRank() - 1);
            else throw new RuntimeException();
        }

        public String toString() {
            return getTitle() + " " + getName() +
             " (" + getID() + ") - " + getEmail();
        }
    }

    static class Student extends Person {
        private int AKTS;

        public Student(String name, String email, long id,
                       String department, int AKTS) {
            super(name, email, id, department);
            if (AKTS >= 0) this.AKTS = AKTS;
            else throw new RuntimeException();

        }

        public int getAKTS() {
            return AKTS;
        }

        public void setAKTS(int AKTS) {
            if (AKTS >= 0) this.AKTS = AKTS;
            else throw new RuntimeException();
        }

        private void passCourse(Course course) {
            setAKTS(getAKTS() + course.getAKTS());
        }

        public String toString() {
            return getName() + " (" + getID() + ") - " + getEmail();
        }
    }

    static class GradStudent extends Student {
        private String Thesis;

        public GradStudent(String name, String email, long id,
                           String department, int AKTS, String thesis) {
            super(name, email, id, department, AKTS);
            Thesis = thesis;
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
}