package javax.com.product.project.dao;

import com.product.project.dao.UserRoleDAO;
import com.product.project.dao.impl.UserRoleDAOImpl;
import com.product.project.entities.UserRoleEntity;
import com.product.project.entities.UserRoleTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


@RunWith(value = SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class UserRoleDaoImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private UserRoleDAO userRoleDAO;
    private UserRoleEntity userRoleEntity;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        userRoleDAO = new UserRoleDAOImpl(sessionFactory);
        userRoleEntity = mock(UserRoleEntity.class);
    }

    @Test
    public void testSuccessfully() {
        when(userRoleEntity.getRoleType()).thenReturn(UserRoleTypeEntity.USER.name());
        when(session.get(UserRoleEntity.class, 1)).thenReturn(userRoleEntity);

        assertEquals(userRoleEntity, userRoleDAO.getById(UserRoleEntity.class, 1));
        verify(session, timeout(200)).get(UserRoleEntity.class, 1);

        assertEquals("USER", userRoleEntity.getRoleType());
    }

    @Test
    public void testNull() {
        when(session.get(UserRoleEntity.class, 1)).thenReturn(null);

        assertNull(userRoleDAO.getById(UserRoleEntity.class, 1));
        verify(session, timeout(200)).get(UserRoleEntity.class, 1);
    }

    @Test(expected = Exception.class)
    public void testException() {
        when(session.get(UserRoleEntity.class, -1)).thenThrow(new Exception());

        userRoleDAO.getById(UserRoleEntity.class, -1);
    }
}

