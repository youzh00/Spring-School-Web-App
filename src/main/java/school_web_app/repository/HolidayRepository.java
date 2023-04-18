package school_web_app.repository;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school_web_app.model.Holiday;

import java.util.List;

@Repository
public class HolidayRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidayRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Holiday> findAllHolidays(){
        String sql="SELECT * FROM HOLIDAYS";
        // The Holiday.class in the newInstance() method specifies the type of object that the row mapper should create.
        var rowmapper= BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(sql,rowmapper);
    }
}
