import { Component, OnInit } from '@angular/core';
import { Departamento } from 'src/app/Modelos/Departamento';
import { DepartamentoService } from 'src/app/Service/departamento.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  departamentos: Departamento[] = [];

  constructor(
    private departamentoService: DepartamentoService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.cargarDepartamentos();
  }
  
  cargarDepartamentos(): void {
    this.departamentoService.Listar().subscribe(
      data => {
        this.departamentos = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  eliminar(id: number){
    alert('Seguro que desea eliminar el departamento?');
    this.departamentoService.Eliminar(id).subscribe(
      data => {
        this.toastr.success('Departamento Eliminado!', 'OK', { timeOut: 3000, positionClass: 'toast-top-center' } );
        this.cargarDepartamentos();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Error', { timeOut: 3000, positionClass: 'toast-top-center' } );
      }
    );
  }

}
