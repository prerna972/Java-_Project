
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    // Attributes
    private String name;
    private String rollNumber;
    private String gradeLevel;
    private int age;
    private String email;
    private String phone;
    private int attendance;
    private List<String> subjects;
    private Map<String, Double> grades;
    
    // Constructor
    public Student(String name, String rollNumber, String gradeLevel, int age, String email) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gradeLevel = gradeLevel;
        this.age = age;
        this.email = email;
        this.attendance = 0;
        this.subjects = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    
    // Overloaded constructor with phone
    public Student(String name, String rollNumber, String gradeLevel, int age, String email, String phone) {
        this(name, rollNumber, gradeLevel, age, email);
        this.phone = phone;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getGradeLevel() {
        return gradeLevel;
    }
    
    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public int getAttendance() {
        return attendance;
    }
    
    public List<String> getSubjects() {
        return new ArrayList<>(subjects); // Return copy to maintain encapsulation
    }
    
    public Map<String, Double> getGrades() {
        return new HashMap<>(grades); // Return copy to maintain encapsulation
    }
    
    // Methods
    public void addSubject(String subjectName) {
        if (!subjects.contains(subjectName)) {
            subjects.add(subjectName);
            grades.put(subjectName, null);
        }
    }
    
    public boolean updateGrade(String subjectName, double grade) {
        if (subjects.contains(subjectName)) {
            grades.put(subjectName, grade);
            return true;
        }
        return false;
    }
    
    public void markAttendance() {
        attendance++;
    }
    
    public Double getAverageGrade() {
        if (grades.isEmpty()) {
            return null;
        }
        
        double sum = 0;
        int count = 0;
        
        for (Double grade : grades.values()) {
            if (grade != null) {
                sum += grade;
                count++;
            }
        }
        
        return count > 0 ? sum / count : null;
    }
    
    public void displayStudentInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + (phone != null ? phone : "Not provided"));
        System.out.println("Attendance: " + attendance + " days");
    }
    
    public void displayReportCard() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("REPORT CARD: " + name);
        System.out.println("=".repeat(50));
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Total Attendance: " + attendance);
        System.out.println("-".repeat(50));
        System.out.println("SUBJECTS AND GRADES:");
        
        for (String subject : subjects) {
            Double grade = grades.get(subject);
            System.out.printf("%-15s: %s%n", subject, (grade != null ? grade : "N/A"));
        }
        
        System.out.println("-".repeat(50));
        Double average = getAverageGrade();
        System.out.printf("Average Grade: %s%n", (average != null ? String.format("%.2f", average) : "N/A"));
        System.out.println("=".repeat(50));
    }
    
    @Override
    public String toString() {
        return String.format("Student: %s (Roll: %s, Grade: %s, Age: %d)", 
                           name, rollNumber, gradeLevel, age);
    }
}