import React, { useEffect, useState } from 'react';
import User_Table from '../visualComponents/customTables/allUsers_Table/User_Table';
import axios from 'axios';

const Deliver_ClientTable = () => {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        fetchClients();
    }, []);

    const fetchClients = async () => {
        try {
            const response = await axios.get("http://localhost:8080/ArrendApp/api/client/check/All");
            setClients(response.data);
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <div style={{ backgroundColor: "rgb(255, 255, 255, 0)" }}>
            <User_Table data={clients} />
        </div>
    );
};

export default Deliver_ClientTable;