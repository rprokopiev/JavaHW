/**
 * В файле содержится строка с исходными данными в такой форме:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Требуется на её основе построить и вывести на экран новую строку, в форме SQL
 * запроса:
 * SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city
 * = "Moscow";
 * Для разбора строки используйте String.split. Сформируйте новую строку,
 * используя StringBuilder.
 * Значения null не включаются в запрос.
 */

public class SQL_StringMaking {

    public static void main(String[] args) {
        // определение входящих данных
        String incomeStr = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";
        String start = "SELECT * FROM ";
        String fileName = "students";
        String initialFilter = " WHERE ";
        String equalsign = " = ";
        String nextFilter = " AND ";
        String exception = "\"null\"";

        // получение массива из строки
        String[] split1 = GetArrayFromCommaDelimitedString(incomeStr);

        // получение двумерного массива из одномерного, путём разеления элементов последнего по знаку ":"
        String[][] split2 = new String[split1.length][2];
        for (int i = 0; i < split1.length; i++) {
            String[] tmp = split1[i].split(":");
            for (int j = 0; j < 2; j++) {
                split2[i][j] = tmp[j];
            }
            // удаление кавычек у элементов расположенных в нулевой колонке 
            split2[i][0] = split2[i][0].replace("\"", "");
        }

        StringBuilder result = new StringBuilder();
        // добавление в строку первых обязательных переменныхх
        result.append(start);
        result.append(fileName);
        Integer count = 0; // счётчик выбора между "WHERE" и "AND"
        for (int i = 0; i < split2.length; i++) {
            Integer a = 0;
            Integer b = 1;
            if (IfStringsEquals(split2[i][b], exception) == false) {
                if (count == 0) {
                    result.append(initialFilter);
                    result.append(split2[i][a]);
                    result.append(equalsign);
                    result.append(split2[i][b]);
                } else {
                    result.append(nextFilter);
                    result.append(split2[i][a]);
                    result.append(equalsign);
                    result.append(split2[i][b]);
                }
                count++;
            }
        }
        System.out.println(result);
    }

    // определение, если 2 строки одинаковые
    private static boolean IfStringsEquals(String one, String two) {
        if (one.length() != two.length()) {
            return false;
        }
        Integer count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) == two.charAt(i)) {
                count++;
            }
        }
        if (count == one.length()) {
            return true;
        } else {
            return false;
        }
    }

    // получение массива из строки, используя запятые как разделители
    private static String[] GetArrayFromCommaDelimitedString(String stringToSplit) {
        String[] result = stringToSplit.split(",", 0);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].trim();
        }
        return result;
    }

}