import java.sql.*;

public class JdbcLab {

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "Woody2003";
        return DriverManager.getConnection(url, username, password);
    }

    public static void query1() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT EMP.EMPNO, EMP.ENAME, DEPT.DNAME " +
                    "FROM EMP " +
                    "INNER JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("%-10s%-15s%-15s%n", "Emp ID", "Emp Name", "Dept Name");
            while (rs.next()) {
                int empNo = rs.getInt("EMPNO");
                String empName = rs.getString("ENAME");
                String deptName = rs.getString("DNAME");
                System.out.printf("%-10d%-15s%-15s%n", empNo, empName, deptName);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void query2(int deptNo) {
        try {
            Connection conn = getConnection();
            String sql = "SELECT DEPT.DNAME, CUSTOMER.NAME, (CUSTOMER.QUANTITY * PRODUCT.PRICE) AS AMOUNT " +
                    "FROM DEPT " +
                    "INNER JOIN PRODUCT ON DEPT.DEPTNO = PRODUCT.MADE_BY " +
                    "INNER JOIN CUSTOMER ON PRODUCT.PRODID = CUSTOMER.PID " +
                    "WHERE DEPT.DEPTNO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptNo);
            ResultSet rs = pstmt.executeQuery();

            System.out.printf("%-15s%-15s%-10s%n", "Dept Name", "Customer Name", "Amount");
            while (rs.next()) {
                String deptName = rs.getString("DNAME");
                String customerName = rs.getString("NAME");
                double amount = rs.getDouble("AMOUNT");
                System.out.printf("%-15s%-15s%-10.2f%n", deptName, customerName, amount);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ser322.JdbcLab <method>");
            return;
        }

        String methodName = args[0];
        if (methodName.equals("query1")) {
            query1();
        } else if (methodName.equals("query2")) {
            if (args.length < 2) {
                System.out.println("Usage: java ser322.JdbcLab query2 <deptNo>");
                return;
            }
            int deptNo = Integer.parseInt(args[1]);
            query2(deptNo);
        } else {
            System.out.println("Invalid method name.");
        }
    }
}