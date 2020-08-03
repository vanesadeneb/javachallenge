package com.urlshortener.restservice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface UrlShortenerRepository extends JpaRepository<UrlShortenerEntity, Long> {
    List<UrlShortenerEntity> findByAlias(String alias);
}