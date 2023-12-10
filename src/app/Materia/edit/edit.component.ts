import { Component, OnInit } from '@angular/core';
import { Materia } from '../../Modelo/Materia';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { FormsModule } from '@angular/forms';
import { compileDirectiveFromMetadata } from '@angular/compiler';

@Component({
  selector: 'app-edit',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent implements OnInit{

  materia:Materia = new Materia();
  constructor(private router:Router, private service:ServiceService){}

  ngOnInit(): void{
    this.Edit();
  }

  Edit() {
    let id = localStorage.getItem("id");

    if (id !== null) {
      this.service.getMateriaId(+id)
        .subscribe(data => {
          this.materia = data;
        });
    } else {
      alert("El ID es nulo");
    }
  }

  Actualizar(materia:Materia){
    this.service.updateMaterias(materia)
    .subscribe(data=>{
      alert("Se ha actualizado con exito");
      this.router.navigate(["listar"]);
    })
  }

}
