import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Modelos/Persona';
import { PersonaService } from 'src/app/Service/persona.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  persona: Persona = null;

  constructor(
    private personaService: PersonaService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.personaService.Detalles(id).subscribe(
      data => {
        this.persona = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Error', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.router.navigate(['Empleados/listar']);
      }
    );
  }

  actualizar(): void{
    const id = this.activatedRoute.snapshot.params.id;
    this.personaService.Actualizar(id, this.persona).subscribe(
      data => {
        this.toastr.success('Persona Actualizada Exitosamente!', 'OK', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.router.navigate(['Empleados/listar']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Error', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.router.navigate(['Empleados/listar']);
      }
    );
  }

}
