const selectPais = document.getElementById("selectPais");
const contenedorEquipos = document.getElementById("equipos");
const listaPlantilla = document.getElementById("plantilla");

fetch("https://www.thesportsdb.com/api/v1/json/123/all_countries.php")
  .then((res) => res.json())
  .then((data) => {
    data.countries.forEach((pais) => {
      const option = document.createElement("option");
      option.value = pais.name_en;
      option.textContent = pais.name_en;
      selectPais.appendChild(option);
    });
  })
  .catch(() => {
    selectPais.innerHTML = `<option value="">Error cargando países</option>`;
  });

selectPais.addEventListener("change", () => {
  const pais = selectPais.value;

  contenedorEquipos.innerHTML = "";
  listaPlantilla.innerHTML = "";

  if (pais === "") return;

  fetch(
    `https://www.thesportsdb.com/api/v1/json/123/search_all_teams.php?s=Soccer&c=${encodeURIComponent(
      pais
    )}`
  )
    .then((res) => res.json())
    .then((data) => {
      if (!data.teams) {
        contenedorEquipos.innerHTML = `<p class="text-muted">No hay equipos para este país.</p>`;
        return;
      }

      data.teams.forEach((team) => {
        const col = document.createElement("div");
        col.className = "col-md-4";

        col.innerHTML = `
          <div class="card h-100">
            <img src="${team.strTeamBadge}" class="card-img-top p-3" alt="Escudo ${team.strTeam}">
            <div class="card-body text-center">
              <h5 class="card-title">${team.strTeam}</h5>
              <button class="btn btn-primary" onclick="cargarPlantilla(${team.idTeam})">
                Ver plantilla
              </button>
            </div>
          </div>
        `;

        contenedorEquipos.appendChild(col);
      });
    })
    .catch(() => {
      contenedorEquipos.innerHTML = `<p class="text-danger">Error cargando equipos.</p>`;
    });
});

function cargarPlantilla(idEquipo) {
  listaPlantilla.innerHTML = "";

  fetch(
    `https://www.thesportsdb.com/api/v1/json/123/lookup_all_players.php?id=${idEquipo}`
  )
    .then((res) => res.json())
    .then((data) => {
      if (!data.player) {
        listaPlantilla.innerHTML = `<li class="list-group-item text-muted">No hay jugadores disponibles.</li>`;
        return;
      }

      data.player.forEach((jugador) => {
        const li = document.createElement("li");
        li.className = "list-group-item";
        li.textContent = `${jugador.strPlayer} (${
          jugador.strPosition || "Sin posición"
        })`;
        listaPlantilla.appendChild(li);
      });
    })
    .catch(() => {
      listaPlantilla.innerHTML = `<li class="list-group-item text-danger">Error cargando plantilla.</li>`;
    });
}

window.cargarPlantilla = cargarPlantilla;
