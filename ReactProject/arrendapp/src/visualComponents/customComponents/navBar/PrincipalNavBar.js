import React from "react";
import GlassContainer from "../containers/GlassContainer";

const PrincipalNavBar = () => {
  return (
    <GlassContainer>
      <nav className="navbar navbar-expand-lg transparent-nav">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            ArrendApp
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">
                  Usuarios
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  Arrendadores
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  Arrendatarios
                </a>
              </li>
              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Propiedades
                </a>
                <ul className="dropdown-menu">
                  <li>
                    <a className="dropdown-item" href="#">
                      Direcciones
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      Propiedades
                    </a>
                  </li>
                  <li>
                    <hr className="dropdown-divider" />
                  </li>
                  <li className="nav-link disabled">
                    <a className="dropdown-item" aria-disabled="true" href="#">
                      Bienvenido
                    </a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
          <div className="search-container" style={{ minWidth: "350px" }}>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2 text-wrap flex-grow-1"
                type="search"
                placeholder="Ingrese las coordenadas de la Propiedad"
                aria-label="Search"
                style={{ minWidth: "350px" }}
              />
              <button className="btn btn-outline-success" type="submit">
                Buscar
              </button>
            </form>
          </div>
        </div>
      </nav>
    </GlassContainer>
  );
};

export default PrincipalNavBar;