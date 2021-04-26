import "./App.css";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AddUpdateEmployeeComponent from "./components/AddUpdateEmployeeComponent";
import ViewEmployeeComponent from "./components/ViewEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <switch>
            <Route path="/" exact component={ListEmployeeComponent}></Route>
            <Route path="/employees" component={ListEmployeeComponent}></Route>
            <Route
              path="/add-employee/:id/:companyId"
              component={AddUpdateEmployeeComponent}
            ></Route>
            <Route
              path="/edit-employee/:id"
              component={AddUpdateEmployeeComponent}
            ></Route>
             <Route
              path="/view-employee/:id"
              component={ViewEmployeeComponent}
            ></Route>
          </switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
