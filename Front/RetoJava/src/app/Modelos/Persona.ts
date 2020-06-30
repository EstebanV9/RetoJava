export class Persona{
    
    id?: number;
    nombre: string;
    apellidos: string;
    numeroDocumento: string;
    correo: string;
    telefono: string;
    activo: boolean;
    salario: number;
    departamento: number;

    constructor(nombre: string, apellidos: string, numeroDocumento: string, correo: string, telefono: string, activo: boolean, salario: number, departamento: number){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.telefono = telefono;
        this.activo = activo;
        this.salario = salario;
        this.departamento = departamento;
    }
}

