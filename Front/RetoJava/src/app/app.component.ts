import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'RetoJava';

  constructor(private router:Router){}

  //Personas
  ListarPersona(){
    this.router.navigate(["Empleados/listar"]);
  }
  AgregarPersona(){
    this.router.navigate(["Empleados/agregar"]);
  }
  EditarPersona(){
    this.router.navigate(["Empleados/editar"]);
  }
  DetallesPersona(){
    this.router.navigate(["Empleados/detalles"]);
  }

  //Departamentos
  ListarDepartamento(){
    this.router.navigate(["Departamentos/listar"]);
  }
  AgregarDepartamento(){
    this.router.navigate(["Departamentos/agregar"]);
  }
  EditarDepartamento(){
    this.router.navigate(["Departamentos/editar"]);
  }
  DetallesDepartamento(){
    this.router.navigate(["Departamentos/detalles"]);
  }

  //Funciones
  ListarFuncion(){
    this.router.navigate(["Funciones/listar"]);
  }
  AgregarFuncion(){
    this.router.navigate(["Funciones/agregar"]);
  }
  EditarFuncion(){
    this.router.navigate(["Funciones/editar"]);
  }
  DetallesFuncion(){
    this.router.navigate(["Funciones/detalles"]);
  }

}
