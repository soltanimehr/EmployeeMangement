import React, { Component } from "react";
import EmployeeService from "../Service/EmployeeService";

class ViewEmployeeComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.match.params.id,
      employee: {},
    };
  }

  componentDidMount() {
    EmployeeService.getEmployeeById(this.state.id).then((res) => {
      console.log("res.data.employeeRequestDto" + res.data.employeeRequestDto);
      this.setState({ employee: res.data.employeeRequestDto });
    }).catch(function(err) {
      console.log(err);
  });
  }

  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Employee Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Employee Id: </label>
              <div style={{ marginLeft: "5px" }}> {this.state.employee.id}</div>
            </div>
            <div className="row">
              <label> Employee Name: </label>
              <div style={{ marginLeft: "5px" }}>
                {" "}
                {this.state.employee.name}
              </div>
            </div>
            <div className="row">
              <label> Employee Sur Name: </label>
              <div style={{ marginLeft: "5px" }}>
                {" "}
                {this.state.employee.surName}
              </div>
            </div>
            <div className="row">
              <label> Employee Email: </label>
              <div style={{ marginLeft: "5px" }}>
                {" "}
                {this.state.employee.email}
              </div>
            </div>
            <div className="row">
              <label> Employee Address: </label>
              <div style={{ marginLeft: "5px" }}>
                {" "}
                {this.state.employee.address}
              </div>
            </div>
            <div className="row">
              <label> Employee Salary: </label>
              <div style={{ marginLeft: "5px" }}>
                {" "}
                {this.state.employee.salary}
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ViewEmployeeComponent;
