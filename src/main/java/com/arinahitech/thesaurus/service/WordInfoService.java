package com.arinahitech.thesaurus.service;

import com.arinahitech.thesaurus.model.WordInfo;
import com.arinahitech.thesaurus.repository.WordInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordInfoService {

    private final WordInfoRepository wordInfoRepository;

    public List<WordInfo> findAllWordInfo() {
        return wordInfoRepository.findAll().stream()
                .sorted(Comparator.comparing(WordInfo::getCreateDate).reversed())
                .collect(Collectors.toList());
    }

    public WordInfo findWordInfo(Long id) {
        return wordInfoRepository.findAll().stream()
                .filter(wordInfo -> wordInfo.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("WordInfo doesn't exist."));
    }

    public WordInfo createWordInfo(WordInfo wordInfo) {
        boolean isWordInfoExist = findAllWordInfo().stream()
                .anyMatch(w -> wordInfo.getWord().equals(w.getWord()));
        if (!isWordInfoExist) {
            wordInfo.setCreateDate(new Date());
            return wordInfoRepository.save(wordInfo);
        } else {
            throw new RuntimeException("The word `" + wordInfo + "` exists.");
        }
    }

    public WordInfo updateWordInfo(Long id, WordInfo updatedWordInfo) {
        WordInfo wordInfoDB = findWordInfo(id);

        if (updatedWordInfo.getWord() != null) {
            wordInfoDB.setWord(updatedWordInfo.getWord());
        }
        if (updatedWordInfo.getDescription() != null) {
            wordInfoDB.setDescription(updatedWordInfo.getDescription());
        }
        return wordInfoRepository.save(wordInfoDB);
    }

    public void deleteWordInfo(Long id) {
        wordInfoRepository.deleteById(id);
    }
}
