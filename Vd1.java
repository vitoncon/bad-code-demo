// test chien 

import java.util.*;

// ====== MODEL CLASSES ======
class Student {
    String id;
    String name;
    int age;
    double gpa;

    Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | GPA: " + gpa;
    }
}

class Teacher {
    String id;
    String name;
    String major;

    Teacher(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Major: " + major;
    }
}

class Course {
    String id;
    String name;
    int credits;

    Course(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Credits: " + credits;
    }
}

class Enrollment {
    String studentId;
    String courseId;

    Enrollment(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student " + studentId + " -> Course " + courseId;
    }
}

class Grade {
    String studentId;
    String courseId;
    double score;

    Grade(String studentId, String courseId, double score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student " + studentId + " | Course " + courseId + " | Score: " + score;
    }
}

// ====== MAIN PROGRAM ======
public class CleanSchoolProgram {
    private static Scanner sc = new Scanner(System.in);

    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static List<Enrollment> enrollments = new ArrayList<>();
    private static List<Grade> grades = new ArrayList<>();

    public static void main(String[] args) {
        int menu = 0;
        while (menu != 99) {
            System.out.println("===== MENU CHINH =====");
            System.out.println("1. Quan ly sinh vien");
            System.out.println("2. Quan ly giao vien");
            System.out.println("3. Quan ly mon hoc");
            System.out.println("4. Quan ly dang ky hoc");
            System.out.println("5. Quan ly diem");
            System.out.println("6. Bao cao tong hop");
            System.out.println("99. Thoat");
            System.out.print("Chon: ");
            menu = sc.nextInt(); sc.nextLine();

            switch (menu) {
                case 1 -> studentMenu();
                case 2 -> teacherMenu();
                case 3 -> courseMenu();
                case 4 -> enrollmentMenu();
                case 5 -> gradeMenu();
                case 6 -> report();
                case 99 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le.");
            }
        }
    }

    // ====== STUDENT MENU ======
    private static void studentMenu() {
        int ch = 0;
        while (ch != 9) {
            System.out.println("=== QUAN LY SINH VIEN ===");
            System.out.println("1. Them");
            System.out.println("2. Xoa");
            System.out.println("3. Cap nhat");
            System.out.println("4. Hien thi tat ca");
            System.out.println("5. Tim GPA > 8");
            System.out.println("9. Quay lai");
            System.out.print("Chon: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Nhap id: "); String id = sc.nextLine();
                    System.out.print("Nhap ten: "); String name = sc.nextLine();
                    System.out.print("Nhap tuoi: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Nhap GPA: "); double gpa = sc.nextDouble(); sc.nextLine();
                    students.add(new Student(id, name, age, gpa));
                }
                case 2 -> {
                    System.out.print("Nhap id can xoa: ");
                    String id = sc.nextLine();
                    students.removeIf(s -> s.id.equals(id));
                }
                case 3 -> {
                    System.out.print("Nhap id cap nhat: "); String id = sc.nextLine();
                    for (Student s : students) {
                        if (s.id.equals(id)) {
                            System.out.print("Nhap ten moi: "); s.name = sc.nextLine();
                            System.out.print("Nhap tuoi moi: "); s.age = sc.nextInt(); sc.nextLine();
                            System.out.print("Nhap GPA moi: "); s.gpa = sc.nextDouble(); sc.nextLine();
                            break;
                        }
                    }
                }
                case 4 -> students.forEach(System.out::println);
                case 5 -> students.stream().filter(s -> s.gpa > 8).forEach(System.out::println);
            }
        }
    }

    // ====== TEACHER MENU ======
    private static void teacherMenu() {
        int ch = 0;
        while (ch != 9) {
            System.out.println("=== QUAN LY GIAO VIEN ===");
            System.out.println("1. Them");
            System.out.println("2. Xoa");
            System.out.println("3. Cap nhat");
            System.out.println("4. Hien thi tat ca");
            System.out.println("9. Quay lai");
            System.out.print("Chon: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Nhap id: "); String id = sc.nextLine();
                    System.out.print("Nhap ten: "); String name = sc.nextLine();
                    System.out.print("Nhap chuyen mon: "); String major = sc.nextLine();
                    teachers.add(new Teacher(id, name, major));
                }
                case 2 -> {
                    System.out.print("Nhap id can xoa: ");
                    String id = sc.nextLine();
                    teachers.removeIf(t -> t.id.equals(id));
                }
                case 3 -> {
                    System.out.print("Nhap id cap nhat: "); String id = sc.nextLine();
                    for (Teacher t : teachers) {
                        if (t.id.equals(id)) {
                            System.out.print("Nhap ten moi: "); t.name = sc.nextLine();
                            System.out.print("Nhap chuyen mon moi: "); t.major = sc.nextLine();
                            break;
                        }
                    }
                }
                case 4 -> teachers.forEach(System.out::println);
            }
        }
    }

    // ====== COURSE MENU ======
    private static void courseMenu() {
        int ch = 0;
        while (ch != 9) {
            System.out.println("=== QUAN LY MON HOC ===");
            System.out.println("1. Them");
            System.out.println("2. Xoa");
            System.out.println("3. Cap nhat");
            System.out.println("4. Hien thi tat ca");
            System.out.println("9. Quay lai");
            System.out.print("Chon: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Nhap id: "); String id = sc.nextLine();
                    System.out.print("Nhap ten: "); String name = sc.nextLine();
                    System.out.print("Nhap so tin chi: "); int credits = sc.nextInt(); sc.nextLine();
                    courses.add(new Course(id, name, credits));
                }
                case 2 -> {
                    System.out.print("Nhap id can xoa: "); String id = sc.nextLine();
                    courses.removeIf(c -> c.id.equals(id));
                }
                case 3 -> {
                    System.out.print("Nhap id cap nhat: "); String id = sc.nextLine();
                    for (Course c : courses) {
                        if (c.id.equals(id)) {
                            System.out.print("Nhap ten moi: "); c.name = sc.nextLine();
                            System.out.print("Nhap tin chi moi: "); c.credits = sc.nextInt(); sc.nextLine();
                            break;
                        }
                    }
                }
                case 4 -> courses.forEach(System.out::println);
            }
        }
    }

    // ====== ENROLLMENT MENU ======
    private static void enrollmentMenu() {
        int ch = 0;
        while (ch != 9) {
            System.out.println("=== QUAN LY DANG KY ===");
            System.out.println("1. Dang ky mon");
            System.out.println("2. Huy dang ky");
            System.out.println("3. Hien thi tat ca");
            System.out.println("9. Quay lai");
            System.out.print("Chon: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Nhap id SV: "); String sid = sc.nextLine();
                    System.out.print("Nhap id MH: "); String cid = sc.nextLine();
                    enrollments.add(new Enrollment(sid, cid));
                }
                case 2 -> {
                    System.out.print("Nhap id SV: "); String sid = sc.nextLine();
                    System.out.print("Nhap id MH: "); String cid = sc.nextLine();
                    enrollments.removeIf(e -> e.studentId.equals(sid) && e.courseId.equals(cid));
                }
                case 3 -> enrollments.forEach(System.out::println);
            }
        }
    }

    // ====== GRADE MENU ======
    private static void gradeMenu() {
        int ch = 0;
        while (ch != 9) {
            System.out.println("=== QUAN LY DIEM ===");
            System.out.println("1. Nhap diem");
            System.out.println("2. Cap nhat diem");
            System.out.println("3. Hien thi tat ca");
            System.out.println("9. Quay lai");
            System.out.print("Chon: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Nhap id SV: "); String sid = sc.nextLine();
                    System.out.print("Nhap id MH: "); String cid = sc.nextLine();
                    System.out.print("Nhap diem: "); double score = sc.nextDouble(); sc.nextLine();
                    grades.add(new Grade(sid, cid, score));
                }
                case 2 -> {
                    System.out.print("Nhap id SV: "); String sid = sc.nextLine();
                    System.out.print("Nhap id MH: "); String cid = sc.nextLine();
                    for (Grade g : grades) {
                        if (g.studentId.equals(sid) && g.courseId.equals(cid)) {
                            System.out.print("Nhap diem moi: "); g.score = sc.nextDouble(); sc.nextLine();
                            break;
                        }
                    }
                }
                case 3 -> grades.forEach(System.out::println);
            }
        }
    }

    // ====== REPORT ======
    private static void report() {
        System.out.println("=== BAO CAO TONG HOP ===");
        for (Student s : students) {
            System.out.println("Sinh vien: " + s.name);
            for (Enrollment e : enrollments) {
                if (e.studentId.equals(s.id)) {
                    Course c = courses.stream().filter(cs -> cs.id.equals(e.courseId)).findFirst().orElse(null);
                    if (c != null) {
                        System.out.print(" - Mon: " + c.name);
                        for (Grade g : grades) {
                            if (g.studentId.equals(s.id) && g.courseId.equals(c.id)) {
                                System.out.print(" | Diem: " + g.score);
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
