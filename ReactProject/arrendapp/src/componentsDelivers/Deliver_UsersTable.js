import React, { useEffect, useState } from 'react';
import User_Table from '../visualComponents/customTables/allUsers_Table/User_Table';
import axios from 'axios';

const Deliver_UsersTable = () => {
    const [users, setUsers] = useState([]);
    
    useEffect (()=>{
        mostrar();
    }

    )
    const mostrar = async () =>{
        try {
        const response = await axios ({
            url:"http://localhost:8080/ArrendApp/api/user/check/All"

        });
        setUsers(response.data);
    } catch (error){
        console.log (error);

    }
    
    };

    return (
        <div style={{backgroundColor : "rgb(255, 255, 255, 0)"}}>
          <User_Table data = {users}></User_Table>  
            
        </div>
    );
};

export default Deliver_UsersTable;