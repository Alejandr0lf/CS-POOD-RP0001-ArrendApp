import React, { useEffect, useState } from 'react';
import User_Table from '../visualComponents/customTables/allUsers_Table/User_Table';
import axios from 'axios';

const Deliver_ComrTable = () => {
    const [comercials, setComercials] = useState([]);

    useEffect(() => {
        fetchComercials();
    }, []);

    const fetchComercials = async () => {
        try {
            const response = await axios.get("http://localhost:8080/ArrendApp/api/comercial/check/All");
            setComercials(response.data);
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <div style={{ backgroundColor: "rgb(255, 255, 255, 0)" }}>
            <User_Table data={comercials} />
        </div>
    );
};

export default Deliver_ComrTable;