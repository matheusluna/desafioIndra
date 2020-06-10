package com.luna.frontend.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String longUrl;
    @Column(nullable = false, unique = true)
    private String shortUrl;
    @Temporal(TemporalType.DATE)
    private Date created_at;
    private Long contador;

    public Url() {
    }

    public Url(Long id, String longUrl, String shortUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.created_at = new Date();
        this.contador = Long.valueOf(0);
    }

    public void countPlusAccess(){
        this.contador += 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at() {
        this.created_at = new Date();
    }

    public Long getContador() {
        return contador;
    }

    public void setContador(Long contador) {
        this.contador = contador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(id, url.id) &&
                Objects.equals(longUrl, url.longUrl) &&
                Objects.equals(shortUrl, url.shortUrl) &&
                Objects.equals(created_at, url.created_at) &&
                Objects.equals(contador, url.contador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longUrl, shortUrl, created_at, contador);
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", created_at=" + created_at +
                ", contador=" + contador +
                '}';
    }
}
