public class Student {

    private long id;
    private String name;
    private String email;
    private double bonus;
    private double report;
    private double app;
    private double LT;

    public Student(long id, String name, String email, double bonus, double report, double app, double LT) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.LT = LT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        this.email = email;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getReport() {
        return report;
    }

    public void setReport(double report) {
        this.report = report;
    }

    public double getApp() {
        return app;
    }

    public void setApp(double app) {
        this.app = app;
    }

    public double getLT() {
        return LT;
    }

    public void setLT(double LT) {
        this.LT = LT;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bonus=" + bonus +
                ", report=" + report +
                ", app=" + app +
                ", LT=" + LT +
                '}';
    }
}

