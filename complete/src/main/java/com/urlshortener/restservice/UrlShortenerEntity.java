package com.urlshortener.restservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class UrlShortenerEntity {

  private @Id @GeneratedValue Long id;
  private String alias;
  private String url;

  UrlShortenerEntity() {}

  UrlShortenerEntity(String alias, String url) {
    this.alias = alias;
    this.url = url;
  }
}