import "./App.css";
import React, { useState } from "react";
import Deliver_UsersTable from "./componentsDelivers/Deliver_UsersTable";
import Deliver_ComrTable from "./componentsDelivers/Deliver_ComrTable";
import Deliver_ClientTable from "./componentsDelivers/Deliver_ClientTable";
import PrincipalNavBar from "./visualComponents/customComponents/navBar/PrincipalNavBar";
import GlassContainer from "./visualComponents/customComponents/containers/GlassContainer";

function App() {
  const [dataType, setDataType] = useState("users");

  const handleNavBarClick = (type) => {
    setDataType(type);
  };

  const renderTable = () => {
    switch (dataType) {
      case "users":
        return <Deliver_UsersTable />;
      case "comercials":
        return <Deliver_ComrTable />;
      case "clients":
        return <Deliver_ClientTable />;
      default:
        return <Deliver_UsersTable />;
    }
  };

  return (
    <div
      className="App"
      style={{
        backgroundImage: "url('/backgroundv3.jpg')",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundAttachment: "fixed",
        backgroundPosition: "center",
      }}
    >
      <div className="container mt-5 mb-5" style={{ borderRadius: 20 }}>
        <div className="row" style={{ zIndex: 1000 }}>
          <div className="col">
            <GlassContainer>
              <img
                alt="Logo"
                src="/Exfora.png"
                className="logo"
                style={{ width: "100%", height: "100%", objectFit: "cover" }}
              />
            </GlassContainer>
          </div>
          <div className="col">
            <PrincipalNavBar onNavBarClick={handleNavBarClick} />
          </div>
        </div>
        <div className="row">{renderTable()}</div>
      </div>
    </div>
  );
}

export default App;
