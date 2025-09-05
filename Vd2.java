using System;
using System.Collections.Generic;
using System.Linq;

// ===== MODEL CLASSES =====
class Student {
    public string Id { get; set; }
    public string Name { get; set; }
    public int Age { get; set; }
    public double GPA { get; set; }

    public Student(string id, string name, int age, double gpa) {
        Id = id; Name = name; Age = age; GPA = gpa;
    }

    public override string ToString() => $"{Id} | {Name} | Age:{Age} | GPA:{GPA}";
}

class Teacher {
    public string Id { get; set; }
    public string Name { get; set; }
    public string Major { get; set; }

    public Teacher(string id, string name, string major) {
        Id = id; Name = name; Major = major;
    }

    public override string ToString() => $"{Id} | {Name} | Major:{Major}";
}

class Course {
    public string Id { get; set; }
    public string Name { get; set; }
    public int Credits { get; set; }

    public Course(string id, string name, int credits) {
        Id = id; Name = name; Credits = credits;
    }

    public override string ToString() => $"{Id} | {Name} | Credits:{Credits}";
}

class Enrollment {
    public string StudentId { get; set; }
    public string CourseId { get; set; }

    public Enrollment(string sid, string cid) {
        StudentId = sid; CourseId = cid;
    }

    public override string ToString() => $"Student {StudentId} -> Course {CourseId}";
}

class Grade {
    public string StudentId { get; set; }
    public string CourseId { get; set; }
    public double Score { get; set; }

    public Grade(string sid, string cid, double score) {
        StudentId = sid; CourseId = cid; Score = score;
    }

    public override string ToString() => $"Student {StudentId} | Course {CourseId} | Score:{Score}";
}

// ===== MAIN PROGRAM =====
class Program {
    static List<Student> students = new();
    static List<Teacher> teachers = new();
    static List<Course> courses = new();
    static List<Enrollment> enrollments = new();
    static List<Grade> grades = new();

    static void Main() {
        int menu = 0;
        while (menu != 99) {
            Console.WriteLine("===== MENU CHINH =====");
            Console.WriteLine("1. Quan ly Sinh vien");
            Console.WriteLine("2. Quan ly Giao vien");
            Console.WriteLine("3. Quan ly Mon hoc");
            Console.WriteLine("4. Quan ly Dang ky hoc");
            Console.WriteLine("5. Quan ly Diem");
            Console.WriteLine("6. Bao cao tong hop");
            Console.WriteLine("99. Thoat");
            Console.Write("Chon: ");
            menu = int.Parse(Console.ReadLine() ?? "0");

            switch (menu) {
                case 1: StudentMenu(); break;
                case 2: TeacherMenu(); break;
                case 3: CourseMenu(); break;
                case 4: EnrollmentMenu(); break;
                case 5: GradeMenu(); break;
                case 6: Report(); break;
                case 99: Console.WriteLine("Thoat chuong trinh."); break;
                default: Console.WriteLine("Lua chon khong hop le."); break;
            }
        }
    }

    // ===== STUDENT MENU =====
    static void StudentMenu() {
        int ch = 0;
        while (ch != 9) {
            Console.WriteLine("=== QUAN LY SINH VIEN ===");
            Console.WriteLine("1. Them | 2. Xoa | 3. Cap nhat | 4. Hien thi | 5. Tim GPA>8 | 9. Quay lai");
            Console.Write("Chon: "); ch = int.Parse(Console.ReadLine() ?? "0");
            switch(ch) {
                case 1: AddStudent(); break;
                case 2: RemoveStudent(); break;
                case 3: UpdateStudent(); break;
                case 4: students.ForEach(Console.WriteLine); break;
                case 5: students.Where(s => s.GPA > 8).ToList().ForEach(Console.WriteLine); break;
            }
        }
    }
    static void AddStudent() {
        Console.Write("ID: "); string id = Console.ReadLine();
        Console.Write("Ten: "); string name = Console.ReadLine();
        Console.Write("Tuoi: "); int age = int.Parse(Console.ReadLine() ?? "0");
        Console.Write("GPA: "); double gpa = double.Parse(Console.ReadLine() ?? "0");
        students.Add(new Student(id, name, age, gpa));
    }
    static void RemoveStudent() {
        Console.Write("Nhap id: "); string id = Console.ReadLine();
        students.RemoveAll(s => s.Id == id);
    }
    static void UpdateStudent() {
        Console.Write("Nhap id: "); string id = Console.ReadLine();
        var s = students.FirstOrDefault(st => st.Id == id);
        if (s != null) {
            Console.Write("Ten moi: "); s.Name = Console.ReadLine();
            Console.Write("Tuoi moi: "); s.Age = int.Parse(Console.ReadLine() ?? "0");
            Console.Write("GPA moi: "); s.GPA = double.Parse(Console.ReadLine() ?? "0");
        }
    }

    // ===== TEACHER MENU =====
    static void TeacherMenu() {
        int ch = 0;
        while (ch != 9) {
            Console.WriteLine("=== QUAN LY GIAO VIEN ===");
            Console.WriteLine("1. Them | 2. Xoa | 3. Cap nhat | 4. Hien thi | 9. Quay lai");
            Console.Write("Chon: "); ch = int.Parse(Console.ReadLine() ?? "0");
            switch(ch) {
                case 1: 
                    Console.Write("ID: "); string id = Console.ReadLine();
                    Console.Write("Ten: "); string name = Console.ReadLine();
                    Console.Write("Chuyen mon: "); string major = Console.ReadLine();
                    teachers.Add(new Teacher(id, name, major)); break;
                case 2:
                    Console.Write("Nhap id: "); id = Console.ReadLine();
                    teachers.RemoveAll(t => t.Id == id); break;
                case 3:
                    Console.Write("Nhap id: "); id = Console.ReadLine();
                    var t = teachers.FirstOrDefault(tt => tt.Id == id);
                    if (t != null) {
                        Console.Write("Ten moi: "); t.Name = Console.ReadLine();
                        Console.Write("Chuyen mon moi: "); t.Major = Console.ReadLine();
                    } break;
                case 4: teachers.ForEach(Console.WriteLine); break;
            }
        }
    }

    // ===== COURSE MENU =====
    static void CourseMenu() {
        int ch = 0;
        while (ch != 9) {
            Console.WriteLine("=== QUAN LY MON HOC ===");
            Console.WriteLine("1. Them | 2. Xoa | 3. Cap nhat | 4. Hien thi | 9. Quay lai");
            Console.Write("Chon: "); ch = int.Parse(Console.ReadLine() ?? "0");
            switch(ch) {
                case 1:
                    Console.Write("ID: "); string id = Console.ReadLine();
                    Console.Write("Ten: "); string name = Console.ReadLine();
                    Console.Write("So tin chi: "); int credits = int.Parse(Console.ReadLine() ?? "0");
                    courses.Add(new Course(id, name, credits)); break;
                case 2:
                    Console.Write("Nhap id: "); id = Console.ReadLine();
                    courses.RemoveAll(c => c.Id == id); break;
                case 3:
                    Console.Write("Nhap id: "); id = Console.ReadLine();
                    var c = courses.FirstOrDefault(cc => cc.Id == id);
                    if (c != null) {
                        Console.Write("Ten moi: "); c.Name = Console.ReadLine();
                        Console.Write("Tin chi moi: "); c.Credits = int.Parse(Console.ReadLine() ?? "0");
                    } break;
                case 4: courses.ForEach(Console.WriteLine); break;
            }
        }
    }

    // ===== ENROLLMENT MENU =====
    static void EnrollmentMenu() {
        int ch = 0;
        while (ch != 9) {
            Console.WriteLine("=== QUAN LY DANG KY ===");
            Console.WriteLine("1. Dang ky | 2. Huy | 3. Hien thi | 9. Quay lai");
            Console.Write("Chon: "); ch = int.Parse(Console.ReadLine() ?? "0");
            switch(ch) {
                case 1:
                    Console.Write("ID SV: "); string sid = Console.ReadLine();
                    Console.Write("ID MH: "); string cid = Console.ReadLine();
                    enrollments.Add(new Enrollment(sid, cid)); break;
                case 2:
                    Console.Write("ID SV: "); sid = Console.ReadLine();
                    Console.Write("ID MH: "); cid = Console.ReadLine();
                    enrollments.RemoveAll(e => e.StudentId == sid && e.CourseId == cid); break;
                case 3: enrollments.ForEach(Console.WriteLine); break;
            }
        }
    }

    // ===== GRADE MENU =====
    static void GradeMenu() {
        int ch = 0;
        while (ch != 9) {
            Console.WriteLine("=== QUAN LY DIEM ===");
            Console.WriteLine("1. Nhap | 2. Cap nhat | 3. Hien thi | 9. Quay lai");
            Console.Write("Chon: "); ch = int.Parse(Console.ReadLine() ?? "0");
            switch(ch) {
                case 1:
                    Console.Write("ID SV: "); string sid = Console.ReadLine();
                    Console.Write("ID MH: "); string cid = Console.ReadLine();
                    Console.Write("Diem: "); double score = double.Parse(Console.ReadLine() ?? "0");
                    grades.Add(new Grade(sid, cid, score)); break;
                case 2:
                    Console.Write("ID SV: "); sid = Console.ReadLine();
                    Console.Write("ID MH: "); cid = Console.ReadLine();
                    var g = grades.FirstOrDefault(gr => gr.StudentId == sid && gr.CourseId == cid);
                    if (g != null) {
                        Console.Write("Diem moi: "); g.Score = double.Parse(Console.ReadLine() ?? "0");
                    } break;
                case 3: grades.ForEach(Console.WriteLine); break;
            }
        }
    }

    // ===== REPORT =====
    static void Report() {
        Console.WriteLine("=== BAO CAO TONG HOP ===");
        foreach (var s in students) {
            Console.WriteLine($"Sinh vien: {s.Name}");
            foreach (var e in enrollments.Where(en => en.StudentId == s.Id)) {
                var c = courses.FirstOrDefault(cc => cc.Id == e.CourseId);
                if (c != null) {
                    Console.Write($" - Mon: {c.Name}");
                    var g = grades.FirstOrDefault(gr => gr.StudentId == s.Id && gr.CourseId == c.Id);
                    if (g != null) Console.Write($" | Diem: {g.Score}");
                    Console.WriteLine();
                }
            }
        }
    }
}
