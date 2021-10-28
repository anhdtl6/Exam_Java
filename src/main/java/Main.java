import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        Bai1 bai1 = new Bai1();
        //Câu 1
        List<Student> listNewStudent =  bai1.taoDanhSachSV();

        //Câu 2
        List<Student> top10 = bai1.listTop10Exam(listNewStudent);
        top10.stream().forEach(System.out::println);

        System.out.println("***********************");

        //Câu 3
        Map<Student,Double> studentsWithFinalMark = bai1.diemTongKet(listNewStudent);

        //Câu 4
        Map<Student,Double> top10Lowest = bai1.top10LowesPoint((HashMap<Student, Double>) studentsWithFinalMark);
        for (Map.Entry<Student,Double> item: top10Lowest.entrySet()) {
            System.out.println(item.getKey().toString() + " ,điểm tổng kết: " + item.getValue());
        }
        System.out.println("***********************");

        // Câu 5
        for (Map.Entry<Student,Double> item: studentsWithFinalMark.entrySet()) {
            System.out.println(item.getKey().toString() + " ,điểm tổng kết : " + item.getValue());
        }
        System.out.println("***********************");

       //Câu 6
        bai1.classStatistic(studentsWithFinalMark);

    }
}
