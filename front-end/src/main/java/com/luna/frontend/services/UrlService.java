package com.luna.frontend.services;

import com.luna.frontend.models.Url;
import com.luna.frontend.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public void create(Url url){
        this.urlRepository.save(url);
    }

    public void update(Url url){
        url.countPlusAccess();
        this.urlRepository.save(url);
    }

    public void delete(Url url){
        this.urlRepository.delete(url);
    }
}
