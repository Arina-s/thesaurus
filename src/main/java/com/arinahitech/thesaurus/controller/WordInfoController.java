package com.arinahitech.thesaurus.controller;

import com.arinahitech.thesaurus.model.WordInfo;
import com.arinahitech.thesaurus.service.WordInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/wordInfo")
public class WordInfoController {

    private final WordInfoService wordInfoService;

    @GetMapping
    public List<WordInfo> getAllWordInfo() {
        return wordInfoService.findAllWordInfo();
    }

    @PostMapping
    public WordInfo saveWordInfo(@RequestBody WordInfo wordInfo) {
        return wordInfoService.createWordInfo(wordInfo);
    }

    @PatchMapping("/{id}")
    public WordInfo updateWordInfo(@PathVariable("id") Long id, @RequestBody WordInfo wordInfo) {
        return wordInfoService.updateWordInfo(id, wordInfo);
    }

    @DeleteMapping("/{id}")
    public void  deleteWordInfo(@PathVariable("id") Long id) {
        wordInfoService.deleteWordInfo(id);
    }

}
