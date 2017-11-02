package javax.com.product.project.dao;

import com.product.project.dao.UserDAO;
import com.product.project.dao.impl.UserDAOImpl;
import com.product.project.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(value = SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class UserDAOImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private UserDAO userDao;
    private UserEntity userEntity;


    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        userDao = new UserDAOImpl(sessionFactory);
        userEntity = mock(UserEntity.class);
    }

    @Test
    public void getByEmail() throws Exception {
        when(userEntity.getEmail()).thenReturn("email");

        Query<UserEntity> query = mock(Query.class);
        when(session.createQuery("select user from UserEntity user where user.email = :email", UserEntity.class)).thenReturn(query);
        Query<UserEntity> userQuery = mock(Query.class);
        when(query.setParameter("email", "email")).thenReturn(userQuery);
        when(userQuery.getSingleResult()).thenReturn(userEntity);

        assertEquals(userEntity, userDao.getByEmail("email"));
        verify(userQuery, atLeast(1)).getSingleResult();
    }

}
