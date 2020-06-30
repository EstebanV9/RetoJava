import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Modelos/Persona';
import { PersonaService } from 'src/app/Service/persona.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  personas: Persona[] = [];

  constructor(
    private personaService: PersonaService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.cargarPersonas();
  }
  
  cargarPersonas(): void {
    this.personaService.Listar().subscribe(
      data => {
        this.personas = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  eliminar(id: number){
    alert('Seguro que desea eliminar el empleado?');//arreglar esta alerta con el cancelar
    this.personaService.Eliminar(id).subscribe(
      data => {
        this.toastr.success('Empleado Eliminado!', 'OK', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.cargarPersonas();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Error', { timeOut: 3000, positionClass: 'toast-top-center' } );
      }
    );
  }

}
