import React from 'react';
import User_Rows from './User_Rows';

const User_Table = ({ data }) => {
  return (
    <div>
      <table class="table table-striped-columns">
        <thead>
          <th>ID</th>
          <th>NOMBRE</th>
          <th>APELLIDO</th>
          <th>NUMERO TELEFONICO</th>
          <th>CORREO</th>
        </thead>
        <tbody>
          {data.length > 0 ? (
            data.map((user) => (
              <User_Rows key={user.id} user={user} />
            ))
          )
          :
          (
            <tr>
              <td>
                <img alt="cargando" src="https://i.redd.it/ubbi1p7z7euc1.gif" />
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};
export default User_Table;
