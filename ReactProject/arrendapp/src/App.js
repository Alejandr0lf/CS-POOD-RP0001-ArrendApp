import Deliver_UsersTable from "./componentsDelivers/Deliver_UsersTable";
import "./App.css";
import PrincipalNavBar from "./visualComponents/customComponents/navBar/PrincipalNavBar";
import GlassContainer from "./visualComponents/customComponents/containers/GlassContainer";

function App() {
  return (
    <div
      className="App"
      style={{
        backgroundImage: "url('/backgroundv1.png')",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundAttachment: "fixed",
        backgroundPosition: "center",
      }}
    >
      <div class="container mt-5 mb-5" style={{borderRadius : 20}}>
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
