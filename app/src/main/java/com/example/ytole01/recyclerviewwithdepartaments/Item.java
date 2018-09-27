package com.example.ytole01.recyclerviewwithdepartaments;

public class Item {
    String name;
    Type type;
    private Department department;
    private boolean isVisible;

    public Item(String name, Type type, Department department, boolean isVisible) {
        this.name = name;
        this.type = type;
        this.department = department;
        this.isVisible = isVisible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    enum Type{
        TITLE,
        ITEM
    }

    enum Department{
        DEP1,
        DEP2,
        DEP3,
        DEP4
    }
}
