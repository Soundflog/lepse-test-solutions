package quest3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IdentifierConverter {

    public static void main(String[] args) throws IOException {
        System.out.println("\nIndetifierConverter конвертирует вашу переменную по формату");
        System.out.println("Если ваша переменная - snake_case, то конвертирует в CamelCase и наоборот");
        System.out.println("Для того чтобы воспользоваться введите название переменной без пробелов");
        System.out.println("Пример:");
        String[] testStrings = {
                "some_variable",
                "tryToConvertMe",
                "unchanged",
                "InvalidMethod",
                "bad_VarName"
        };

        for (String str : testStrings) {
            System.out.println(str + " -> " + convertIdentifier(str));
        }

        System.out.println("\nВведите название вашей переменной:");
        BufferedReader bfn = new BufferedReader(
                new InputStreamReader(System.in));

        String inputString = bfn.readLine();
        System.out.println(inputString + " -> " + convertIdentifier(inputString));
    }

    private static String convertIdentifier(String identifier) {
        if (isSnakeCase(identifier)) {
            return convertSnakeToCamel(identifier);
        } else if (isCamelCase(identifier)) {
            return convertCamelToSnake(identifier);
        } else {
            return "Error!";
        }
    }

    private static boolean isSnakeCase(String identifier) {
        return identifier.matches("^[a-z]+(_[a-z]+)*$");
    }

    private static boolean isCamelCase(String identifier) {
        return identifier.matches("^[a-z]+([A-Z][a-z]*)*$");
    }

    private static String convertSnakeToCamel(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean toUpperCase = false;
        for (char ch : identifier.toCharArray()) {
            if (ch == '_') {
                toUpperCase = true;
            } else {
                if (toUpperCase) {
                    result.append(Character.toUpperCase(ch));
                    toUpperCase = false;
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    private static String convertCamelToSnake(String identifier) {
        StringBuilder result = new StringBuilder();
        for (char ch : identifier.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append('_').append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
