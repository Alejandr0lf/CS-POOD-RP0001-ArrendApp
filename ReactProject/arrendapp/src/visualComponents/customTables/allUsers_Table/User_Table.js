import React from "react";
import User_Rows from "./User_Rows";
import "../../../cssStyleSheets/Table_FluentStyle.css";

const User_Table = ({ data }) => {
  return (
    <div className="m-5 table-container">
      <table className="custom-table table">
        <thead className="table-header">
          <tr>
            <th style={{ color: "rgb(0, 0, 0)"}}>ID</th>
            <th style={{ color: "rgb(0, 0, 0)"}}>NOMBRE</th>
            <th style={{ color: "rgb(0, 0, 0)"}}>APELLIDO</th>
            <th style={{ color: "rgb(0, 0, 0)"}}>NUMERO TELEFONICO</th>
            <th style={{ color: "rgb(0, 0, 0)"}}>CORREO</th>
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
