/**
 * В файле содержится строка с данными:
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Напишите метод, который разберёт её на составные части и, используя
 * StringBuilder создаст массив строк такого вида:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */

public class StringConverting {

    public static void main(String[] args) {
        String income = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}";
        String[] test = GetArrayFromString(income, "},");
        RemoveSymbolInArray(test, "{");
        RemoveSymbolInArray(test, "}");
        RemoveSymbolInArray(test, "\"");
        String[] template = { "Студент ", "получил ", "по предмету " };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < test.length; i++) {
            String tmpTest = test[i];
            for (int j = 0; j < template.length; j++) {
                result = result.append(template[j]);
                int start = tmpTest.indexOf(":");
                int end = tmpTest.indexOf(",");
                if (end == -1) {
                    end = tmpTest.length() - 1;
                    result = result.append(tmpTest.substring(start + 1, end + 1));
                    result = result.append(". ");
                }
                else{
                    result = result.append(tmpTest.substring(start + 1, end));
                    result = result.append(" ");
                    String toRemove = tmpTest.substring(0, end + 1);
                    tmpTest = tmpTest.replace(toRemove, "");
                }
            }
        }
        System.out.println(result.toString());
    }

    private static String[] GetArrayFromString(String toDelimit, String withDelimit) {
        String[] result = toDelimit.split(withDelimit, 0);
        return result;
    }

    private static void RemoveSymbolInArray(String[] toUpdate, String toRemove) {
        for (int i = 0; i < toUpdate.length; i++) {
            toUpdate[i] = toUpdate[i].replace(toRemove, "");
        }
    }

}