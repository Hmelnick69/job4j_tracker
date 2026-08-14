package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "\"name\"" + " : " + "\"" + name + "\""
                + System.lineSeparator()
                + "\"body\"" + " : " + "\"" + body + "\""
                + System.lineSeparator() + "}";
    }

    public static void main(String[] args) {
        TextReport jsonReport = new JSONReport();
        String text = jsonReport.generate("Test",  "Test");
        System.out.println(text);
    }
}
