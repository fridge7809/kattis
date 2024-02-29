import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Comparator;

public class Grades {

    public final Grade[] grades;

    public Grades(int N) {
        grades = new Grade[N];
    }

    private record Grade(String studentName, String grade, int modifier) implements Comparable<Grade> {
        @Override
        public int compareTo(Grade that) {
            return Comparator.comparing(Grade::grade, new Comparator<String>() {
                public int compare(String x, String y) {
                    if (x.equalsIgnoreCase("f")) {
                        return -1;
                    }
                    if (y.equalsIgnoreCase("f")) {
                        return 1;
                    }
                    return x.compareTo(y);
                }
            })
                    .thenComparing(Grade::modifier, Comparator.reverseOrder())
                    .thenComparing(Grade::studentName)
                    .compare(this, that);
        }
    }

    public void print() {
        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i].studentName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        Grades grades = new Grades(N);

        for (int i = 0; i < N; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Pattern pattern = Pattern.compile("([abcdefx]+)([+-]+)?");
            Matcher matcher = pattern.matcher(tokens[1]);
            int modifierValue = 0;
            // If the grade has a modifier, we need to calculate the modifier value
            if (matcher.find()) {
                String grade = matcher.group(1);
                String modifier = matcher.group(2);
                modifierValue = modifier.length();
                if (modifier.contains("-")) {
                    modifierValue = -modifierValue;
                }
                grades.grades[i] = new Grades.Grade(tokens[0], grade, modifierValue);
                continue;
            }
            // If the grade has no modifier, we just push the grade to the stack
            grades.grades[i] = new Grades.Grade(tokens[0], tokens[1], modifierValue);
        }

        Mergesort.sort(grades.grades);
        grades.print();
    }
}
