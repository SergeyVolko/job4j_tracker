package oop.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jsonReport = new JSONReport();
        text = jsonReport.generate("\"name\"", "\"body\"");
        System.out.println(text);
    }
}
