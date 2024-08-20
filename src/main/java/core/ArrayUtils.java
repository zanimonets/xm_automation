package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static boolean isListContainsItem(List<String> list, String target) {
        for (String s : list) {
            if (s.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> mergeLists(List<T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static List<String> removeEmptyString(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.toList());
    }
}
