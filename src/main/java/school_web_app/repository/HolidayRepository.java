package school_web_app.repository;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school_web_app.model.Holiday;

import java.util.List;

@Repository
public interface HolidayRepository  extends CrudRepository<Holiday,String> {
}
