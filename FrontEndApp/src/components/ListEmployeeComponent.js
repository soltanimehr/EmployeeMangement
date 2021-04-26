import React, { Component } from "react";
import EmployeeService from "../Service/EmployeeService";

class ListEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: [],
      avgSalary:0,
      companyId:1000
    };
    this.addEmployee = this.addEmployee.bind(this);
    this.editEmployee = this.editEmployee.bind(this);
    this.deleteEmployee = this.deleteEmployee.bind(this);
  }

  componentDidMount() {
    EmployeeService.getEmployees()
    .then((res) => {
      if(res.status === 200){
        console.log("SUCCESSS")
        this.setState({ employees: res.data });
        console.log(this.state.employees);    
    }         
    }).catch(function(err) {
      console.log(err);
  });
  }
  addEmployee() {
    this.props.history.push("/add-employee/_add/"+this.state.companyId);
  }
  viewEmployee(id) {
    this.props.history.push(`/view-employee/${id}`);
  }
  editEmployee(id) {
    this.props.history.push(`/edit-employee/${id}`);
  }
  deleteEmployee(id) {
  
    return EmployeeService.deleteEmployee(id).then((res) => {
      this.setState({
        employees: this.state.employees.filter(
          (employee) => employee.id !== id
        ),
      });
    });
  }
  findAverageEmployee(companyId) {
    console.log(companyId);
    return EmployeeService.findAverageEmployee(companyId).then((res) => {
      console.log(res.data);
      this.setState({
        avgSalary:res.data
      });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center"> Employee Management System</h2>
        <div className="row">
          <button
            style={{ marginBottom: "5px" }}
            className="btn btn-primary"
            onClick={this.addEmployee}
          >
            Create Employee
          </button>
          <button
            style={{ marginBottom: "5px", marginLeft:"10px", marginRight:"10px"}}
            className="btn btn-primary"
            onClick={() => this.findAverageEmployee(this.state.companyId)}>
            Find Average Salary 
          </button>
          <label>  {this.state.avgSalary===0? "_":"Average Salary :"+this.state.avgSalary } </label>
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th> Id </th>
                <th> Name </th>
                <th> Surname </th>
                <th> Email </th>
                <th> Salary </th>
                <th> Actions </th>
              </tr>
            </thead>
            <tbody>
              {this.state.employees.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.id}</td>
                  <td>{employee.name}</td>
                  <td>{employee.surName}</td>
                  <td>{employee.email}</td>
                  <td>{employee.salary}$</td>
                  <td>
                    <button
                      onClick={() => this.editEmployee(employee.id)}
                      className="btn btn-info"
                    >
                      {" "}
                      Update
                    </button>
                    <button
                      style={{ marginLeft: "8px" }}
                      onClick={() => this.viewEmployee(employee.id)}
                      className="btn btn-info"
                    >
                      View
                    </button>
                    <button
                      style={{ marginLeft: "8px" }}
                      onClick={() => this.deleteEmployee(employee.id)}
                      className="btn btn-danger">
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListEmployeeComponent;
