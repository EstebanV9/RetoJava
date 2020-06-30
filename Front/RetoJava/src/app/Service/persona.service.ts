import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../Modelos/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  personaUrl='http://localhost:8080/personas/';

  constructor(private httpClient:HttpClient) { }

  public Listar(): Observable<Persona[]>{
    return this.httpClient.get<Persona[]>(this.personaUrl + 'lista');
  }

  public Detalles(id: number): Observable<Persona>{
    return this.httpClient.get<Persona>(this.personaUrl + `detalles/${id}`);
  }

  public DetallesNombre(nombre: string): Observable<Persona>{
    return this.httpClient.get<Persona>(this.personaUrl + `detalles/${nombre}`);
  }

  public Agregar(persona: Persona): Observable<any>{
    return this.httpClient.post<any>(this.personaUrl + 'crear', persona);
  }

  public Actualizar(id: number, persona: Persona): Observable<any>{
    return this.httpClient.put<any>(this.personaUrl + `actualizar/${id}`, persona);
  }

  public Eliminar(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.personaUrl + `eliminar/${id}`);
  }
  
}
