package com.luna.frontend.services;

import com.luna.frontend.models.Url;
import com.luna.frontend.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private UrlShoter urlShoter = UrlShoter.getInstance();

    @Autowired
    private UrlRepository urlRepository;

    public Url create(Url url){
        url.setCreated_at();
        url.setShortUrl(urlShoter.toBase10(url.getLongUrl()));
        url.startCount();
        return this.urlRepository.save(url);
    }

    public Optional<Url> readByShortUrl(String shortUrl){
        return this.urlRepository.findByShortUrl(shortUrl);
    }

    public Optional<Url> readByLongUrl(String longUrl){
        return this.urlRepository.findByLongUrl(longUrl);
    }

    public Url update(Url url){
        url.countPlusAccess();
        return this.urlRepository.save(url);
    }

    public void delete(Url url){
        this.urlRepository.delete(url);
    }
}
