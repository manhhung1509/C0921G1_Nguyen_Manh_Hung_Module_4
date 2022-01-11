package dictionary.service.impl;

import dictionary.service.IsDictionary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Service
public class DictionaryImpl implements IsDictionary {
    @Override
    public String translate(String word) {
        boolean flag = false;
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        Set<String> set = dictionary.keySet();
        for (String key : set) {
            if (word.equals(key)) {
                return dictionary.get(key);
            }
        }
        return "Word is not found";
    }
}
