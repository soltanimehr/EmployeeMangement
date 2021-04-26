import React, { Component } from "react";
import EmployeeService from "../Service/EmployeeService";
import ReactTable from "react-table";
import 'react-table/react-table.css'
import axios from "axios";

class EmployeeListViaTable extends Component 
{  
    
    constructor(props) {
    super(props);
    this.state = {
      employees: [],
      loading:true
     
    };
    this.addemployee = this.addemployee.bind(this);
  }
  
 
  async componentWillMount() {
    await this.getEmloyeesData();
  }
  async getEmloyeesData(page = 0) {
    const EMPLOYEE_REST_API_URL =
      "http://localhost:9005/api/v1/employees?page="+ page;
       
    try {
        const response = await axios.get(EMPLOYEE_REST_API_URL);
        console.log(response.data);
        console.log(response.data.content);
    
        this.setState({ employees: response.data,items:response.data.content });
      } catch (error) {

        console.error('tEST' + error);
      }

    
  }

  viewEmployee(id) {
    this.props.history.push(`/view-employee/${id}`);
  }
  editEmployee(id) {
    this.props.history.push(`/add-employee/${id}`);
  }
  addemployee() {
   this.props.history.push("/add-employee/_add");
  
  }

  renderEmployeeList() {
     const columns = [{  
        Header: 'ID',  
        accessor: 'id',
       }
       ,{  
        Header: 'Name',  
        accessor: 'name' ,
        }
       
       ,{  
       Header: 'Surname',  
       accessor: 'surName' ,
       }
       ,{  
       Header: 'Email',  
       accessor: 'email',
       },
       {  
        Header: 'Address',  
        accessor: 'address',
        },
        {  
          Header: 'Salary',  
          accessor: 'salary',
          }
    ]

    return (
      <React.Fragment>
   
   <ReactTable  
      data={this.state.employees}  
      columns={columns}  pageSize="5"/>
   

       
      </React.Fragment>
    );
  }

}
export default EmployeeListViaTable;