package org.sigar.service;

import org.sigar.Repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    @Autowired
    private  DictionaryRepo dictionary;

//    @Autowired
//    public DictionaryService(DictionaryRepo dictionaryRepo) {
//        this.dictionary = dictionaryRepo;
//    }

    public boolean addWord(String newWord,String meaning) {
        return dictionary.addWord(newWord, meaning);
    }

    public String getMeaning(String word){
        return dictionary.getWordMeaning(word);
    }

}
