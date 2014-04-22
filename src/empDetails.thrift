namespace java example
struct Employee {
  1: string    id,
  2: string name,
  3: string address,
  4: string phoneNumber
}
struct EmployeeId {
  1: string    id
}
service EmployeeService {
  Employee getEmployee(1:EmployeeId id)
}
