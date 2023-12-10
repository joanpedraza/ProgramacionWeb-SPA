import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Materia} from '../Modelo/Materia';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/api/v1/materias';

  getMaterias(){
    return this.http.get<Materia[]>(this.Url);
  }

  createMaterias(materia:Materia){
    return this.http.post<Materia>(this.Url,materia);
  }

  getMateriaId(id:number){
    return this.http.get<Materia>(this.Url+"/"+id);
  }

  updateMaterias(materia:Materia){
    return this.http.put<Materia>(this.Url+"/"+materia.id, materia);
  }

  deleteMateria(materia:Materia){
    return this.http.delete<Materia>(this.Url+"/"+materia.id);
  }
}
