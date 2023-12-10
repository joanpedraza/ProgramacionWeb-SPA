import { Component, OnInit } from '@angular/core';
import { Materia } from '../../Modelo/Materia';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add.component.html',
  styleUrl: './add.component.css'
})
export class AddComponent implements OnInit{

  materia: Materia = new Materia();

  constructor(private router:Router, private service:ServiceService){}

  ngOnInit(): void{
  }

  Guardar(){
    this.service.createMaterias(this.materia)
    .subscribe(data=>{
      alert("Se ha agregado cone exito");
      this.router.navigate(["listar"]);
    })
  }

}
