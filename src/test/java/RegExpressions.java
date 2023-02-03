import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.*;

public class RegExpressions {

    @Test
    public void HTMLExpression() {
        String regEx = "^#([A-Fa-f0-9]{6})$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("#ABCDEF");
        boolean b = m.matches();
        Assert.assertTrue(b, "Color isn't specified as #ABCDEF");
    }

    @Test
    public void identifyNumbersExp() {
        String input = "(3+5)-9*4";
        String regEx = "\\d\\+";
        Pattern p = Pattern.compile(regEx);
        Matcher mat = p.matcher(input);
        String befRes = input.replaceAll(p.toString(), "");
        String onlyNumbRegExp = "[^0-9]";
        Pattern p1 = Pattern.compile(onlyNumbRegExp);
        boolean result;
        if (mat.find()) {
            System.out.println(befRes.replaceAll(p1.toString(), " "));
            result = true;
        } else {
            System.out.println(input);
            result = false;
        }
        Assert.assertTrue(result, "The expression doesn't have a + sign");
    }

    @Test
    public void outputCorrectExpressions() {
        String input = "Hello()9()(8+9)";
        Pattern patOpBr = Pattern.compile("\\(");
        Pattern patClBr = Pattern.compile("\\)");
        Matcher matOp = patOpBr.matcher(input);
        Matcher matCl = patClBr.matcher(input);
        boolean result;
        int counterOfOpBr = 0;
        int counterOfClBr = 0;
        while (matOp.find()) {
            counterOfOpBr++;
        }
        while (matCl.find()) {
            counterOfClBr++;
        }
        if (counterOfOpBr == counterOfClBr) {
            result = true;
            System.out.println(input);
        } else {
            result = false;
        }
        Assert.assertTrue(result, "Incorrect");
    }

    @Test
    public void findTheTime() {
        String timeFormat = "(Breakfast at )([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern p = Pattern.compile(timeFormat);
        Matcher m = p.matcher("Breakfast at 66:00");
        boolean b = m.matches();
        Assert.assertTrue(b);
    }

    @Test
    public void selectFractionalNumbers() {
        String input = "Hel56.8lo 57 i8.9 13.22Senorita3 88 19,88";
        String regDecExp = "[-]?[0-9]*\\.+([0-9]+)?";
        Pattern p = Pattern.compile(regDecExp);
        Matcher m = p.matcher(input);
        boolean result = false;
        while (m.find()) {
            result = true;
            System.out.println(m.group());
        }
        Assert.assertTrue(result, "The text doesn't contain fractional numbers");
    }

    @Test
    public void highlightTheText() {
        String input = "Hello \"\"\n" +
                "\n\"next()\" jjjj \"My name\"";
        Pattern patOp = Pattern.compile("\"");
        Matcher matOp = patOp.matcher(input);
        boolean result;
        int counterOfOp = 0;
        while (matOp.find()) {
            counterOfOp++;
        }
        if (counterOfOp % 2 == 0) {
            result = true;
            String regLightText = "\"(.*?)\"";
            Pattern p = Pattern.compile(regLightText);
            Matcher m = p.matcher(input);
            while (m.find()) {
                System.out.println(m.group().replaceAll("\"", ""));
            }
        } else {
            result = false;
        }
        Assert.assertTrue(result, "The text doesn't contain the text enclosed in quotation marks ");
    }
}
