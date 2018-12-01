public class Department implements Comparable {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Object departmentToCompare) {
        Department newDepartment = (Department) departmentToCompare;
        return ((Comparable) name).compareTo(newDepartment.name);
    }
}
