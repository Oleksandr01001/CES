class Jugador {


    nombre;
    valor;
    posicion;
    nacionalidad;



    constructor(nombre, valor, posicion, nacionalidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
    }


    mostrarDatos() {
        console.log(this.nombre);
        console.log(this.valor);
        console.log(this.posicion);
        console.log(this.nacionalidad);
    }


    getNombre() {
        return this.nombre;
    }

    setNombre(nombre) {
        this.nombre = nombre;
    }

    set setNacionalidad(nacionalidad) {
        this.nacionalidad = nacionalidad;
    }





}