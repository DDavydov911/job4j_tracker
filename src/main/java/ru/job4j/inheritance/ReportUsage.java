package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jsonReport = new JSONReport();
        String str2 = jsonReport.generate("Ivan", "Ivanov");
        System.out.println(str2);
    }
}
