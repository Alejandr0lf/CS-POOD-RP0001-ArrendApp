import Deliver_UsersTable from "./componentsDelivers/Deliver_UsersTable";
import "./App.css";
import PrincipalNavBar from "./visualComponents/customComponents/navBar/PrincipalNavBar";
import GlassContainer from "./visualComponents/customComponents/containers/GlassContainer";

function App() {
  return (
    <div className="App">
      <div class="container mt-3">
        <div class="row">
          <div class="col">
            <GlassContainer>
              <img
                alt="Logo"
                src="/Exfora.png"
                className="logo"
                style={{ width: "100%", height: "100%", objectFit: "cover" }}
              />
            </GlassContainer>
          </div>
          <div class="col">
            <PrincipalNavBar></PrincipalNavBar>
          </div>
        </div>
        <div class="row">
          <Deliver_UsersTable></Deliver_UsersTable>
        </div>
      </div>
    </div>
  );
}

export default App;
