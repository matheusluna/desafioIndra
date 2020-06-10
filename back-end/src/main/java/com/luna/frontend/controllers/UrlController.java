package com.luna.frontend.controllers;

import com.luna.frontend.models.Url;
import com.luna.frontend.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UrlController {

    public static final String HTTP_PREFIX = "http://";
    public static final String HTTPS_PREFIX = "https://";

    @Autowired
    private UrlService urlService;

    @GetMapping("/{shortUrl}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Url> find(@PathVariable String shortUrl) throws URISyntaxException {
        Url url = this.urlService.readByShortUrl(shortUrl).orElse(null);
        if(url == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        this.urlService.update(url);

        String redirectTo = url.getLongUrl();

        if(!redirectTo.substring(0, HTTP_PREFIX.length()).equals(HTTP_PREFIX) && !redirectTo.substring(0, HTTPS_PREFIX.length()).equals(HTTPS_PREFIX)){
            redirectTo = HTTP_PREFIX.concat(redirectTo);
        }

        URI uri = new URI(redirectTo);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Url> create(@RequestBody Url url){

        Url link = this.urlService.readByLongUrl(url.getLongUrl()).orElse(null);
        if (link == null) link = urlService.create(url);

        return ResponseEntity.ok().body(link);
    }
}
