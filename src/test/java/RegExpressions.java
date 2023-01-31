import java.util.Scanner;
import java.util.regex.*;

public class RegExpressions {
    private Scanner scanner = new Scanner(System.in);

    public void HTMLExpression() {
        String regEx = "^#([A-Fa-f0-9]{6})$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("#ABCDEF");
        boolean b = m.matches();
        System.out.println(b);
    }

    public void identifyNumbersExp() {
        System.out.println("Enter numbers with +: ");
        String input = scanner.next();
        String regEx = "\\d\\+";
        Pattern p = Pattern.compile(regEx);
        System.out.println(input.replaceAll(p.toString(), ""));
    }

    public void outputCorrectExpressions() {
        System.out.println("Enter expression with brackets: ");
        String input = scanner.next();
        Pattern patOpBr = Pattern.compile("\\(");
        Pattern patClBr = Pattern.compile("\\)");
        Matcher matOp = patOpBr.matcher(input);
        Matcher matCl = patClBr.matcher(input);
        int counterOfOpBr = 0;
        int counterOfClBr = 0;
        while (matOp.find()) {
            counterOfOpBr++;
        }
        while (matCl.find()) {
            counterOfClBr++;
        }
        if (counterOfOpBr == counterOfClBr) {
            System.out.println(input);
        } else {
            System.out.println("Incorrect");
        }
    }

    public void findTheTime() {
        String timeFormat = "(Breakfast at )([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern p = Pattern.compile(timeFormat);
        Matcher m = p.matcher("Breakfast at 09:00");
        boolean b = m.matches();
        System.out.println(b);
    }

    public void selectFractionalNumbers() {
        System.out.println("Enter expression with brackets: ");
        String input = scanner.next();
        String regDecExp = "[0-9]*\\.[0-9]+";
        Pattern p = Pattern.compile(regDecExp);
        Matcher m = p.matcher(input);
        if (m.find()) {
            System.out.println(m.group());
        } else {
            System.out.println("Error");
        }
    }

    public void highlightTheText() {
        System.out.println("Enter expression: ");
        String input = scanner.next();
        String regLightText = "\"(.*?)\"";
        Pattern p = Pattern.compile(regLightText);
        Matcher m = p.matcher(input);
        if (m.matches()) {
            System.out.println(m.group());
        } else {
            System.out.println("Not found");
        }
    }
}
