import axios from "axios";

const EMPLOYEE_REST_API_URL = "http://localhost:9005/api/v1/employees";

class EmployeeService {
  getEmployees() {
    return axios.get(EMPLOYEE_REST_API_URL);
  }

  createEmployee(employee) {
    return axios.post(EMPLOYEE_REST_API_URL, employee);
  }

  getEmployeeById(employeeId) {
    return axios.get(EMPLOYEE_REST_API_URL+"/"+employeeId);
  }

  updateEmployee(employee, employeeId) {
    return axios.put(EMPLOYEE_REST_API_URL + "/" + employeeId, employee);
  }

  deleteEmployee(employeeId) {
    return axios.delete(EMPLOYEE_REST_API_URL + "/" + employeeId);
  }
  deleteEmployee(employeeId) {
    return axios.delete(EMPLOYEE_REST_API_URL + "/" + employeeId);
  }
  findAverageEmployee(companyId)
  {
    return axios.get(EMPLOYEE_REST_API_URL+"/company/"+companyId+"/salary/avg/");
  }
}
export default new EmployeeService();
