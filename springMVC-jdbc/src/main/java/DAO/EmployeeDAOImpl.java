package DAO;

import model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void update(Employee employee) {
        // update
        String sql = "UPDATE Employee SET name=?, WHERE id=?";
        jdbcTemplate.update(sql, employee.getName());
    }
  @Override
    public void insert(Employee employee){
        //insert
      String sql = "INSERT INTO Employee (name, department)"
              + " VALUES (?, ?)";
    jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());

}
    @Override
    public void delete(int id) {
        //delete
        String sql = "DELETE FROM Employee WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public Employee get(int id) {
        //get
        String sql = "SELECT * FROM Employee WHERE id=" + id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public List<Employee> list() {
        //view
        String sql = "SELECT * FROM employee";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));

                return employee;
            }
        });

        return employeeList;
    }
}
