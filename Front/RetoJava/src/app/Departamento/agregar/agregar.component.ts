import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Modelos/Persona';
import { PersonaService } from 'src/app/Service/persona.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent implements OnInit {

  nombre = '';
  apellidos = '';
  numeroDocumento = '';
  correo = '';
  telefono = '';
  activo = true;
  salario: number = null;
  departamento: number = null;

  constructor(
    private personaService: PersonaService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  Agregar(): void {
    const persona = new Persona(this.nombre, this.apellidos, this.numeroDocumento, this.correo, this.telefono, this.activo, this.salario, this.departamento);
    this.personaService.Agregar(persona).subscribe(
      data => {
        this.toastr.success(this.nombre+' Se Registró Exitosamente!', 'OK', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.router.navigate(['Empleados/listar']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Error', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.router.navigate(['Empleados/listar']);
      }
    );
  }

}
