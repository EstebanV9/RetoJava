import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
//Persona
import { ListarComponent as ListarPersonaComponent } from './Persona/listar/listar.component';
import { AgregarComponent as AgregarPersonaComponent } from './Persona/agregar/agregar.component';
import { EditarComponent as EditarPersonaComponent } from './Persona/editar/editar.component';
import { DetallesComponent as DetallesPersonaComponent } from './Persona/detalles/detalles.component';
//Departamento
import { ListarComponent as ListarDepartamentoComponent } from './Departamento/listar/listar.component';
import { AgregarComponent as AgregarDepartamentoComponent } from './Departamento/agregar/agregar.component';
import { EditarComponent as EditarDepartamentoComponent } from './Departamento/editar/editar.component';
import { DetallesComponent as DetallesDepartamentoComponent } from './Departamento/detalles/detalles.component';
//Funcion
// import { ListarComponent as ListarFuncionComponent } from './Funcion/listar/listar.component';
// import { AgregarComponent as AgregarFuncionComponent } from './Funcion/agregar/agregar.component';
// import { EditarComponent as EditarFuncionComponent } from './Funcion/editar/editar.component';
// import { DetallesComponent as DetallesFuncionComponent } from './Funcion/detalles/detalles.component';

const routes: Routes = [
  {path:'Empleados/listar', component:ListarPersonaComponent},
  {path:'Empleados/agregar', component:AgregarPersonaComponent},
  {path:'Empleados/editar/:id', component:EditarPersonaComponent},
  {path:'Empleados/detalles/:id', component:DetallesPersonaComponent},
  {path:'**', redirectTo: '', pathMatch: 'full'},

  {path:'Departamentos/listar', component:ListarDepartamentoComponent},
  {path:'Departamentos/agregar', component:AgregarDepartamentoComponent},
  {path:'Departamentos/editar/:id', component:EditarDepartamentoComponent},
  {path:'Departamentos/detalles/:id', component:DetallesDepartamentoComponent},
  {path:'**', redirectTo: '', pathMatch: 'full'}

  // {path:'Funciones/listar', component:ListarFuncionComponent},
  // {path:'Funciones/agregar', component:AgregarFuncionComponent},
  // {path:'Funciones/editar/:id', component:EditarFuncionComponent},
  // {path:'Funciones/detalles/:id', component:DetallesFuncionComponent},
  // {path:'**', redirectTo: '', pathMatch: 'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
