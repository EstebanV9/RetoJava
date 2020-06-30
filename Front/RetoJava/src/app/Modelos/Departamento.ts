export class Departamento{
    
    id?: number;
    nombre: string;
    descripcion: string;
    codigo: number;

    constructor(nombre: string, descripcion: string, codigo: number){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
}

