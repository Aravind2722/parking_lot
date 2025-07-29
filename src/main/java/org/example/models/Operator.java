package org.example.models;

public class Operator extends BaseModel {
    // Columns:
    // id, name, employee_id
//    private int id;
    private String employeeId;
    private String name;

//    private Gate gate;
    // We dont need gate atttribute here, as Gate class already has operator attribute.
    // Morover we dont see a scenario, where we would get gate id from the operator



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

