import java.util.HashMap;

public class PhoneBook {

    public static void main(final String[] args) {
        var dict = new HashMap<String, String>();
        dict.put("88001122333", "Иван");
        dict.put("88001662333", "Иван");
        dict.put("88001112333", "Иван");
        dict.put("88001122432", "Ирина");
        dict.put("88001112453", "Мария");
        dict.put("88001632145", "Сергей");
        dict.put("88001424214", "Сергей");

        var a = get(dict);

        a.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }


    public static HashMap<String, Integer> get(HashMap<String, String> dict){
        var result = new HashMap<String, Integer>();
        for (var item : dict.entrySet()) {
            if (result.containsKey(item.getValue())) {
                var key = item.getValue();
                var value = result.get(item.getValue());
                result.replace(key, value + 1);
            } else {
                result.put(item.getValue(), 1);
            }
        }
        return result;
    }
}