import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Departamento } from '../Modelos/Departamento';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {

  departamentoUrl='http://localhost:8080/departamentos/';

  constructor(private httpClient:HttpClient) { }

  public Listar(): Observable<Departamento[]>{
    return this.httpClient.get<Departamento[]>(this.departamentoUrl + 'lista');
  }

  public Detalles(id: number): Observable<Departamento>{
    return this.httpClient.get<Departamento>(this.departamentoUrl + `detalles/${id}`);
  }

  public DetallesNombre(nombre: string): Observable<Departamento>{
    return this.httpClient.get<Departamento>(this.departamentoUrl + `detalles/${nombre}`);
  }

  public Agregar(departamento: Departamento): Observable<any>{
    return this.httpClient.post<any>(this.departamentoUrl + 'crear', departamento);
  }

  public Actualizar(id: number, departamento: Departamento): Observable<any>{
    return this.httpClient.put<any>(this.departamentoUrl + `actualizar/${id}`, departamento);
  }

  public Eliminar(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.departamentoUrl + `eliminar/${id}`);
  }
  
}
