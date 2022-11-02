package com.arinahitech.thesaurus.repository;

import com.arinahitech.thesaurus.model.WordInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordInfoRepository extends JpaRepository<WordInfo, Long> {
}
