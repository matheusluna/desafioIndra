import { Url } from './../models/Url';
import { UrlGeneratorService } from './../services/url-generator.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-url-generator',
  templateUrl: './url-generator.component.html',
  styleUrls: ['./url-generator.component.css']
})
export class UrlGeneratorComponent implements OnInit {

  public url : string;
  public shortUrl : Url;
  constructor(private servico : UrlGeneratorService) { }

  ngOnInit(): void {
  }

  gerar(){
    this.servico.getShortUrl(this.url).subscribe(shortUrl => this.shortUrl = shortUrl)
  }

}
