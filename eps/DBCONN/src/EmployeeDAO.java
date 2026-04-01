import java.sql.*;

public class EmployeeDAO {

    // ADD EMPLOYEE
    public void addEmployee(Employee e) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO employees(emp_id,name,email,department,salary,bonus) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, e.emp_id);
            ps.setString(2, e.name);
            ps.setString(3, e.email);
            ps.setString(4, e.department);
            ps.setDouble(5, e.salary);
            ps.setDouble(6, e.bonus);

            ps.executeUpdate();
            System.out.println("Employee Added Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // VIEW ALL
    public void getAllEmployees() {
        try {
            Connection conn = DBConnection.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("department") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getDouble("bonus")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW BY ID
    public void getEmployeeById(int id) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM employees WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("department") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getDouble("bonus")
                );
            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 UPDATE EMAIL
    public void updateEmail(int id, String email) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE employees SET email=? WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Email Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 UPDATE DEPARTMENT
    public void updateDepartment(int id, String dept) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE employees SET department=? WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dept);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Department Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 UPDATE SALARY
    public void updateSalary(int id, double salary) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE employees SET salary=? WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Salary Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM employees WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Employee Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD BONUS
    public void addBonus(int id, double amount) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE employees SET bonus = bonus + ? WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Bonus Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DEDUCT SALARY
    public void deductSalary(int id, double amount) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE employees SET salary = salary - ? WHERE emp_id=? AND salary >= ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, id);
            ps.setDouble(3, amount);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Salary Deducted");
            else
                System.out.println("Insufficient Salary");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}