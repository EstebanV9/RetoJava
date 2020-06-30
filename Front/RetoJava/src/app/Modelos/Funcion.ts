export class Funcion{
    
    id?: number;
    nombre: string;
    descripcion: string;
    departamento: number;

    constructor(nombre: string, descripcion: string, departamento: number){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento = departamento;
    }
}

