import { Url } from './../models/Url';
import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlGeneratorService {

  private  serverUrl = 'http://localhost:8080/';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  constructor(
    private http : HttpClient
  ) { }

  getShortUrl(url : string) : Observable<Url>{
    return this.http.post<Url>(this.serverUrl, { 'longUrl': url }, this.httpOptions);
  }
}
