import React from "react";
import User_Rows from "./User_Rows";
import "../../../cssStyleSheets/Table_FluentStyle.css";

const User_Table = ({ data }) => {
  return (
    <div class="m-5" className="table-container">
      <table className="custom-table table table-striped-columns">
        <thead className="table-header">
          <tr>
            <th>ID</th>
            <th>NOMBRE</th>
            <th>APELLIDO</th>
            <th>NUMERO TELEFONICO</th>
            <th>CORREO</th>
          </tr>
        </thead>
        <tbody>
          {data.length > 0 ? (
            data.map((user) => <User_Rows key={user.id} user={user} />)
          ) : (
            <tr>
              <td colSpan="5" className="text-center">
                <img
                  alt="Cargando"
                  src="https://cdn.dribbble.com/users/1186261/screenshots/3718681/_______.gif"
                  className="loading-gif"
                />
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default User_Table;
