package fr.sma.bw.repositories.jdbc;

import fr.sma.bw.entities.JournalTechnique;
import fr.sma.bw.mappers.jdbc.JournalTechniqueMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@Slf4j
public class JournalTechniqueJDBC extends JdbcDaoSupport {

    final String getAllSQL = "SELECT * from JOURNAL_TECHNIQUE FETCH FIRST 10 ROWS ONLY";
    private final JdbcTemplate jdbcTemplate;
    public JournalTechniqueJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostConstruct
    private void initialize() {
        setJdbcTemplate(this.jdbcTemplate);
    }
    public List <JournalTechnique>  getAll() {
        return getJdbcTemplate().query(getAllSQL, new JournalTechniqueMapper());
    }
}
