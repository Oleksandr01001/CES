export class tarea{
    items: object[];

    constructor(
        private nombre: string,
        private fecha: string,
        private responsable: string,
        private completada: boolean,
        private tipo: string,
    ) {
        this.items = [];
    }

    
}