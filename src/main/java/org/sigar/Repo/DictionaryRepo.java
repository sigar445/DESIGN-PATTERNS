package org.sigar.Repo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DictionaryRepo {
    private static final String NOT_FOUND= "WORD IS NOT PRESENT IN THE DICTIONARY";

    private final Map<String, String> dictionary = new ConcurrentHashMap<>();

    public boolean addWord(String word, String meaning) {
        if(word == null || meaning == null) {
            return false;
        }
        return dictionary.putIfAbsent(word, meaning) == null;
    }

    public String getWordMeaning(String word) {
        return dictionary.getOrDefault(word, NOT_FOUND);
    }

    public String deleteWord(String word){
        return dictionary.remove(word);
    }

}
