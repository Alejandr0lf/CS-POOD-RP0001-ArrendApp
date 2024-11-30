import React from 'react';
import PropTypes from 'prop-types';

const User_Rows = ({user}) => {
    return (
        <tr>
            <td class="table-info">{user.id}</td>
            <td class = "table-info">{user.name}</td>
            <td class = "table-success">{user.lastname}</td>
            <td class = "table-light">{user.phoneNumber}</td>
            <td class = "table-light">{user.email}</td>
        </tr>
    );
};
export default User_Rows;