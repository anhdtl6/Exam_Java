import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class B1Test {
    Bai1 bai1 = new Bai1();
    @Test
    void taoDanhSachSV_01() {
        List<Student> student = bai1.taoDanhSachSV();
        Assert.assertTrue(student != null);
    }
    @Test
    void taoDanhSachSV_02() {
        List<Student> student = bai1.taoDanhSachSV();
        Assert.assertTrue(student.size() >= 10);
    }

    @Test
    void listTop10Exam() throws Exception {
        List<Student> students = bai1.taoDanhSachSV();
        List<Student> result = bai1.listTop10Exam(students);
        Assert.assertTrue(result.size() == 10);
    }

    @Test
    void diemTongKet() {
        List<Student> students = bai1.taoDanhSachSV();
        Map<Student, Double> result = new HashMap<>();
        try {
            result = bai1.diemTongKet(students);
        } catch (Exception ex) {
            Assert.fail();
        }

        Assert.assertTrue(result.size() == 18);
    }

    @Test
    void top10LowesPoint() throws Exception {
        List<Student> sv = bai1.taoDanhSachSV();
        Map<Student, Double> kq = bai1.diemTongKet(sv);
        try {
            Map<Student, Double> top10 = bai1.top10LowesPoint((HashMap<Student, Double>) kq);
            Assert.assertTrue(top10.size() == 10);
        } catch (Exception ex) {
            Assert.fail();
        }
    }
}