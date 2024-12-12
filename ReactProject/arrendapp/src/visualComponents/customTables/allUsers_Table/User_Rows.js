import React from "react";
import "../../../cssStyleSheets/Cell_FluentStyle.css";
import PropTypes from "prop-types";

const User_Rows = ({ user }) => {
  return (
    <tr>
      <td style={{ backgroundColor: "rgb(255, 255, 255, 0.5)"}}>{user.id}</td>
      <td style={{ backgroundColor: "rgb(255, 255, 255, 0.2)"}}>{user.name}</td>
      <td style={{ backgroundColor: "rgb(255, 255, 255, 0.2)"}}>{user.lastname}</td>
      <td style={{ backgroundColor: "rgb(255, 255, 255, 0.2)"}}>{user.phoneNumber}</td>
      <td style={{ backgroundColor: "rgb(255, 255, 255, 0.2)"}}>{user.email}</td>
    </tr>
  );
};
export default User_Rows;
