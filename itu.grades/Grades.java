import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grades {

    public final Grade[] grades;

    public Grades(int N) {
        grades = new Grade[N];
    }

    private record Grade(String studentName, String grade, int modifier) implements Comparable<Grade> {

        @Override
        public int compareTo(Grade that) {
            return Comparator.comparing(Grade::grade, new StringComparator())
                    .thenComparing(Grade::modifier, Comparator.reverseOrder())
                    .thenComparing(Grade::studentName)
                    .compare(this, that);
        }

        private static class StringComparator implements Comparator<String> {
            private final Map<String, Integer> order = Map.of(
                    "A", 0,
                    "B", 1,
                    "C", 2,
                    "D", 3,
                    "E", 4,
                    "FX", 5,
                    "F", 6);

            @Override
            public int compare(String s1, String s2) {
                int index1 = order.get(s1);
                int index2 = order.get(s2);
                return Integer.compare(index1, index2);
            }
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
            final String regex = "([abcdefx]+)([+-]+)?";
            final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            final Matcher matcher = pattern.matcher(tokens[1]);
            String grade = tokens[1];
            int modifierValue = 0;
            while (matcher.find()) {
                grade = matcher.group(1);
                String modifier = matcher.group(2);
                if (modifier != null && !modifier.isEmpty()) {
                    modifierValue = modifier.length();
                    if (modifier.contains("-")) {
                        modifierValue = -modifierValue;
                    }
                }
            }
            grades.grades[i] = new Grades.Grade(tokens[0], grade, modifierValue);
        }
        Mergesort.sort(grades.grades);
        grades.print();
    }
}