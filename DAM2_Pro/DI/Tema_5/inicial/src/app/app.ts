import { Component, signal } from '@angular/core';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('inicial');
  nombre: string = 'Olek';
  apellido: string  = 'Hushtyk';
  curso: number = 2;
  nombreCurso: string = 'Desarollo de Aplicaciones Multiplataforma';
  nota: number = 0;



  pulsarComenzar(notaInput: string) {
    /*if (isNaN(Number(notaInput))) {

    } else {

    }*/
    //this.nota = Number(notaInput);
  Swal.fire({
  title: 'Error!',
  text: 'Do you want to continue',
  icon: 'error',
  confirmButtonText: 'Cool'
})


  }

 

}
