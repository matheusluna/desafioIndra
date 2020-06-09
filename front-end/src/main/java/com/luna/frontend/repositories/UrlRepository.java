package com.luna.frontend.repositories;

import com.luna.frontend.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    public Optional<Url> findByShortUrl(String shortUrl);
    public Optional<Url> findByLongUrl(String longUrl);
}
