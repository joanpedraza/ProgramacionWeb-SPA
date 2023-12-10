import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service'
import { Materia } from '../../Modelo/Materia';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit{

  materias: Materia[] = [];
  constructor(private service:ServiceService, private router:Router){}

  ngOnInit(): void {
    this.service.getMaterias()
    .subscribe(data=>{
       this.materias = data;
    }) 
  }

  Edit(materia:Materia):void{
    localStorage.setItem("id",materia.id.toString());
    this.router.navigate(["edit"]);
  }  

  Delete(materia:Materia){
    this.service.deleteMateria(materia)
    .subscribe(data=>{
      this.materias= this.materias.filter(p=>p!==materia);
      alert("Materia Eliminada");
    })
  }
}
