import java.util.*;
import java.util.stream.Collectors;

public class Bai1 {

    public List<Student> taoDanhSachSV() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(01223230, "Đỗ Thị Hoa", "dothihoa@gmail.com", 8, 8, 7, 8));
        students.add(new Student(01223231, "Đỗ Thị Hải", "dothihai@gmail.com", 3, 1, 2, 1.5));
        students.add(new Student(01223232, "Đỗ Thị Hương", "dothihuong@gmail.com", 5, 3, 9, 2.5));
        students.add(new Student(01223233, "Đỗ Thị Hà", "dothiha@gmail.com", 6, 9, 6.5, 9));
        students.add(new Student(01223234, "Đỗ Thị Hồng", "dothihong@outlook.com", 2, 8, 8, 5.5));
        students.add(new Student(01223235, "Đỗ Thị A", "dothia@gmail.com", 4, 8, 7, 5));
        students.add(new Student(01223236, "Đỗ Thị B", "dothib@gmail.com", 8, 5, 2, 7));
        students.add(new Student(01223237, "Đỗ Thị C", "dothic@gmail.com", 2, 4, 1, 2.5));
        students.add(new Student(01223255, "Đỗ Thị D", "dothid@gmail.com", 9, 7, 0, 7));
        students.add(new Student(01223266, "Đỗ Thị E", "dothie@gmail.com", 5, 4, 6, 4));
        students.add(new Student(01223240, "Đỗ Thị J", "dothij@gmail.com", 1, 4, 4, 3.5));
        students.add(new Student(01223241, "Đỗ Thị K", "dothik@gmail.com", 6, 9, 2, 4));
        students.add(new Student(01223242, "Đỗ Thị L", "dothil@gmail.com", 7, 7, 1, 7.5));
        students.add(new Student(01223243, "Đỗ Thị M", "dothim@gmail.com", 5, 8, 9, 1));
        students.add(new Student(01223244, "Đỗ Thị N", "dothin@gmail.com", 7, 3, 2, 8));
        students.add(new Student(01223245, "Đỗ Thị O", "dothio@gmail.com", 6, 2, 4, 3));
        students.add(new Student(01223246, "Đỗ Thị U", "dothiu@gmail.com", 8, 4, 6, 7.5));
        students.add(new Student(01223247, "Đỗ Thị T", "dothit@gmail.com", 6, 3, 4, 5));
        return students;
    }
    // 2.Liệt kê danh sách 10 sv có điểm thi lý thuyết cao nhất
    public List<Student> listTop10Exam(List<Student> students) throws Exception {
        if(students == null || students.size() < 10) {
            throw new Exception("Invalid size of list student");
        }
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getLT).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // 3. Tính điểm tổng kết cho từng sinh viên
    public Map<Student,Double> diemTongKet(List<Student> students) throws Exception {
        if(students == null || students.size() == 0) {
            throw new Exception("Invalid size of list student");
        }
        Map<Student,Double> result = new HashMap<>();
        for (Student student: students){
            double mark = student.getBonus()*0.1 + student.getReport()*0.3 + student.getApp()*0.15 + student.getLT()*0.45;
            result.put(student,mark);
        }
        return result;
    }

    // 4. Liệt kê danh sách 10 sv có điểm thấp nhất
    public Map<Student,Double> top10LowesPoint(HashMap<Student,Double> finalPoint) throws Exception {
        if(finalPoint == null || finalPoint.isEmpty()) {
            throw new Exception("Invalid size of list student");
        }
        return finalPoint.entrySet().stream().
                sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    // 6. Hiển thị bảng thống kê
    public static void classStatistic(Map<Student,Double> students) throws Exception {
        if(students == null || students.isEmpty()) {
            throw new Exception("Số lượng sinh viên không hợp lệ");
        }
        System.out.println("Số lượng sinh viên: " + students.size());

        long pass = students.entrySet().stream().filter(x -> x.getValue() > 4.5).count();
        System.out.println("Đạt: " + pass + " Tỉ lệ: " + (double) pass/students.size()*100 + "%" );
        int notPass = (int) (students.size() - pass);
        System.out.println("Không đạt: " + notPass + " Tỉ lệ: " + (double) notPass/students.size()*100 + "%" );

        int Gioi = (int)students.entrySet().stream().filter(x -> x.getValue() >=8 && x.getValue() <=10 ).count();
        int Kha = (int)students.entrySet().stream().filter(x -> x.getValue() >=6.5 && x.getValue() <8 ).count();
        int TrungBinh = (int)students.entrySet().stream().filter(x -> x.getValue() >=5 && x.getValue() <6.5 ).count();

        System.out.println("Giỏi (điểm tổng kết 8 - 10) " + Gioi + " Tỉ lệ: " + (double) Gioi/students.size()*100 + "%" );
        System.out.println("Khá (điểm tổng kết 6.5 - 8) " + Kha + " Tỉ lệ: " + (double) Kha/students.size()*100 + "%" );
        System.out.println("Trung bình (điểm tổng kết 5 - 6.5) " + TrungBinh + " Tỉ lệ: " + (double) TrungBinh/students.size()*100 + "%" );
    }
}
