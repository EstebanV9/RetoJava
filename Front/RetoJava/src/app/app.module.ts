import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { PersonaService } from 'src/app/Service/persona.service';
import { DepartamentoService } from './Service/departamento.service';

// External
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,

    ListarPersonaComponent,
    AgregarPersonaComponent,
    EditarPersonaComponent,
    DetallesPersonaComponent,

    ListarDepartamentoComponent,
    AgregarDepartamentoComponent,
    EditarDepartamentoComponent,
    DetallesDepartamentoComponent,

    // ListarFuncionComponent,
    // AgregarFuncionComponent,
    // EditarFuncionComponent,
    // DetallesFuncionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [PersonaService, DepartamentoService], //FuncionService
  bootstrap: [AppComponent]
})
export class AppModule { }
