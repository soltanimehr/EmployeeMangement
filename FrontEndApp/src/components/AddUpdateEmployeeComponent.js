import React, { Component } from "react";
import { Card, Form } from "react-bootstrap";
import EmployeeService from "../Service/EmployeeService";

class AddUpdateEmployeeComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.match.params.id,
      name: "",
      surName: "",
      email: "",
      address: "",
      salary: "",
      companyId:this.props.match.params.companyId,
      companyName: "",
    };
    this.changeNameHandler = this.changeNameHandler.bind(this);
    this.changeSurNameHandler = this.changeSurNameHandler.bind(this);
    this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
  }

  componentDidMount() {
    if (this.state.id === "_add") {
      return;
    } else {
      const EMPLOYEE_REST_API_URL = "http://localhost:9005/api/v1/employees";
      fetch(EMPLOYEE_REST_API_URL + "/" + this.state.id)
        .then((response) => response.json())
        .then((data) =>
          this.setState({
            name: data.employeeRequestDto.name,
            surName: data.employeeRequestDto.surName,
            email: data.employeeRequestDto.email,
            address: data.employeeRequestDto.address,
            salary: data.employeeRequestDto.salary,
            companyId: data.employeeRequestDto.companyId,
            companyName: data.companyDto.name,
          })
        ).catch(function(err) {
          console.log(err);
      });
    }
  }
  saveOrUpdateEmployee = (e) => {
    e.preventDefault();
    let employee = {
      name: this.state.name,
      surName: this.state.surName,
      email: this.state.email,
      address: this.state.address,
      salary: this.state.salary,
      companyId: this.state.companyId,
    };
    console.log("employee => " + JSON.stringify(employee));

    if (this.state.id === "_add") {
      EmployeeService.createEmployee(employee).then((res) => {
        this.props.history.push("/employees");
      });
    } else {
      EmployeeService.updateEmployee(employee, this.state.id).then((res) => {
        this.props.history.push("/employees");
      });
    }
  };

  changeNameHandler = (event) => {
    this.setState({ name: event.target.value });
  };

  changeSurNameHandler = (event) => {
    this.setState({ surName: event.target.value });
  };

  changeEmailHandler = (event) => {
    this.setState({ email: event.target.value });
  };
  changeAddressHandler = (event) => {
    this.setState({ address: event.target.value });
  };
  changeSalaryHandler = (event) => {
    this.setState({ salary: event.target.value });
  };
  cancel() {
    this.props.history.push("/employees");
  }
  getTitle() {
    if (this.state.id === "_add") {
      return <h3 className="text-center">Add Employee</h3>;
    } else {
      return <h3 className="text-center">Update Employee</h3>;
    }
  }
  render() {
    return (
      <div className="card col-md-6 offset-md-3 offset-md-3">
        <div style={{ display: this.state.show ? "block" : "none" }}></div>
        <Card className={"border-dark bg-gray text-Black"}>
          <Card.Header>
            <div className="card col-md-6 offset-md-3 offset-md-3">
              {this.getTitle()}
            </div>
          </Card.Header>
          <Form onSubmit={this.saveOrUpdateEmployee} id="employeeFormId">
            <Card.Body>
              <Form.Row>
                <Form.Label>Name</Form.Label>
                <Form.Control
                  required
                  autoComplete="off"
                  type="test"
                  name="name"
                  value={this.state.name}
                  onChange={this.changeNameHandler}
                  className={"form-control"}
                  placeholder="Enter Name of Employee"
                />
              </Form.Row>
              <Form.Row>
                <Form.Label>Surname</Form.Label>
                <Form.Control
                  required
                  autoComplete="off"
                  type="test"
                  name="surName"
                  value={this.state.surName}
                  onChange={this.changeSurNameHandler}
                  className={"form-control"}
                  placeholder="Enter SurName of Employee"
                />
              </Form.Row>
              <Form.Row>
                <Form.Label>Email</Form.Label>
                <Form.Control
                  required
                  autoComplete="off"
                  type="test"
                  name="name"
                  value={this.state.name}
                  value={this.state.email}
                  onChange={this.changeEmailHandler}
                  placeholder="Enter Email of Employee ex: sample@mydomain.com"
                />
              </Form.Row>
              <Form.Row>
                <Form.Label>Address</Form.Label>
                <Form.Control
                  required
                  autoComplete="off"
                  type="test"
                  name="address"
                  value={this.state.address}
                  onChange={this.changeAddressHandler}
                  placeholder="ex:Straße Number  Post Code City"
                />
              </Form.Row>
              <Form.Row>
                <Form.Label>Salary</Form.Label>
                <Form.Control
                  required
                  autoComplete="off"
                  type="Number"
                  name="salary"
                  value={this.state.salary}
                  onChange={this.changeSalaryHandler}
                  className={"form-control"}
                  placeholder="Salary 50000$"
                />
              </Form.Row>
            </Card.Body>
            <Card.Footer style={{ textAlign: "right" }}>
              <button
                variant="success"
                type="submit"
                className="btn btn-success"
              >
                Save
              </button>
              <button
                className="btn btn-danger"
                onClick={this.cancel.bind(this)}
                style={{ marginLeft: "15px" }}
              >
                Cancel
              </button>
            </Card.Footer>
          </Form>
        </Card>
      </div>
    );
  }
}

export default AddUpdateEmployeeComponent;
