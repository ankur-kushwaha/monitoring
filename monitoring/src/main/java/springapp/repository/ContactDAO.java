package springapp.repository;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springapp.domain.BusDate;
import springapp.domain.Consumers;
import springapp.domain.Contact;
import springapp.domain.Status;
import springapp.mapper.ContactMapper;

@Component 
public class ContactDAO {
	
	@Autowired
    private SqlSessionFactory sqlSessionFactory;
 
 
    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    public List<Contact> selectAll(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ContactMapper mapper = session.getMapper(ContactMapper.class);
            List<Contact> list = mapper.selectAll();
            return list;
        } finally {
            session.close();
        }
    }

	public List<Status> getStatus() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
        try {
            ContactMapper mapper = session.getMapper(ContactMapper.class);
            List<Status> list = mapper.getStatus();
            return list;
        } finally {
            session.close();
        }
	}

	public List<Consumers> getODSConsumers() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
        try {
            ContactMapper mapper = session.getMapper(ContactMapper.class);
            List<Consumers> list = mapper.getODSConsumer();
            return list;
        } finally {
            session.close();
        }
	}

	public List<Consumers> getWHConsumers() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
        try {
            ContactMapper mapper = session.getMapper(ContactMapper.class);
            List<Consumers> list = mapper.getWHConsumer();
            return list;
        } finally {
            session.close();
        }
	}

	public List<BusDate> getBusDate() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
        try {
            ContactMapper mapper = session.getMapper(ContactMapper.class);
            List<BusDate> list = mapper.getBusDate();
            return list;
        } finally {
            session.close();
        }
	}
}