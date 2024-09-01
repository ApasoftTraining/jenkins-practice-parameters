package com.apasoft;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementApp {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -cp target/employee-management-1.0-SNAPSHOT.jar com.apasoft.EmployeeManagementApp <command> [args...]");
            System.out.println("Commands:");
            System.out.println("  add <code> <name> <age>");
            System.out.println("  remove <code>");
            System.out.println("  modify <code> <newName> <newAge>");
            System.out.println("  list");
            return;
        }

        String command = args[0];
        switch (command) {
            case "add":
                addEmployee(args);
                break;
            case "remove":
                removeEmployee(args);
                break;
            case "modify":
                modifyEmployee(args);
                break;
            case "list":
                listEmployees();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }

    private static void addEmployee(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: add <code> <name> <age>");
            return;
        }
        String code = args[1];
        String name = args[2];
        int age = Integer.parseInt(args[3]);
        employees.add(new Employee(code, name, age));
        System.out.println("Employee added successfully.");
        System.out.println("Code:"+newEmployee.getCode());
        System.out.println("Name:"+newEmployee.getName());
        System.out.println("Age:"+newEmployee.getAge());
    }

    private static void removeEmployee(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: remove <code>");
            return;
        }
        String code = args[1];
        boolean removed = employees.removeIf(emp -> emp.getCode().equals(code));
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void modifyEmployee(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: modify <code> <newName> <newAge>");
            return;
        }
        String code = args[1];
        String newName = args[2];
        int newAge = Integer.parseInt(args[3]);
        
        for (Employee emp : employees) {
            if (emp.getCode().equals(code)) {
                emp.setName(newName);
                emp.setAge(newAge);
                System.out.println("Employee modified successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}