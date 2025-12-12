let botonAgregar = document.querySelector("#btnAgregar");
let botonLimpiar = document.querySelector("#btnLimpiar");
let botonVaciar = document.querySelector("#btnVaciar");
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputFecha = document.querySelector("#inputFecha");
let listaAgregados = document.querySelector("#divAgregados ul");

let selectEdad = document.querySelector("#selectEdad");

selectEdad.innerHTML = "";

for (let i = 18; i <= 90; i++) {
  let nodoOption = document.createElement("option");
  nodoOption.value = i;
  nodoOption.innerText = i;
  selectEdad.appendChild(nodoOption);
}

botonAgregar.addEventListener("click", (ev) => {
  let nombre = inputNombre.value;
  let apellido = inputApellido.value;
  let fecha = inputFecha.value;

  if (nombre.length == 0 || apellido.length == 0 || fecha.length == 0) {
    lanzarDialogo("Error", "Faltan datos", "warning");
  } else {
    let nodoLI = crearNodo(
      "li",
      `${nombre} ${apellido} ${fecha}`,
      "animate__animated animate__fadeInRight list-group-item d-flex justify-content-between align-items-start"
    );

    let nodoButton = crearNodo("button", `Eliminar`, "btn btn-danger", (e) => {
      nodoLI.classList.remove("animate__fadeInRight");
      nodoLI.classList.add("animate__wobble");
      setTimeout(() => {
        nodoLI.classList.remove("animate__wobble");
        nodoLI.classList.add("animate__fadeOutLeft");
        setTimeout(() => {
          nodoLI.remove();
        }, 600);
      }, 600);
    });

    nodoLI.appendChild(nodoButton);
    listaAgregados.appendChild(nodoLI);
  }
});

botonLimpiar.addEventListener("click", (ev) => {
  limpiarCampos(inputNombre, inputApellido, inputFecha);
  selectEdad.value = "18";
});

botonVaciar.addEventListener("click", (e) => {
  listaAgregados.innerHTML = "";
});

function limpiarCampos() {
  for (let index = 0; index < arguments.length; index++) {
    arguments[index].value = "";
  }
}

function lanzarDialogo(title, text, icon) {
  Swal.fire({
    title: title,
    text: text,
    icon: icon,
  });
}

function crearNodo(tipo, texto, clases, funcion) {
  let nodo = document.createElement(tipo);

  nodo.innerText = texto;
  if (funcion != undefined) {
    nodo.addEventListener("click", funcion);
  }
  nodo.className = clases;
  return nodo;
}
