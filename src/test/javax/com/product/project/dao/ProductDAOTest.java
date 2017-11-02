package javax.com.product.project.dao;

import com.product.project.dao.ProductDAO;
import com.product.project.dao.impl.ProductDAOImpl;
import com.product.project.entities.ProductEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Sonikb on 06.09.2017.
 */
@RunWith(value = SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ProductDAOTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private ProductDAO productDao;
    private ProductEntity productEntity;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        productEntity = mock(ProductEntity.class);
        productDao = new ProductDAOImpl(sessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testGetById() throws Exception {
        when(session.get(ProductEntity.class, 1)).thenReturn(productEntity);
        when(productEntity.getId()).thenReturn(1);

        assertEquals(productEntity, productDao.getById(ProductEntity.class, 1));
        assertEquals(1, (long) productEntity.getId());

        verify(session, atLeast(1)).get(ProductEntity.class, 1);
        verify(productEntity, times(1)).getId();
    }

    @Test(expected = NullPointerException.class)
    public void testGetByIdNull() throws Exception {
        when(session.get(ProductEntity.class, 0)).thenReturn(null);
        when(productEntity.getId()).thenThrow(new NullPointerException());

        assertEquals(null, productDao.getById(ProductEntity.class, 0));

        verify(session, atMost(2)).get(ProductEntity.class, 0);
        productEntity.getId();
    }

    @Test
    public void testGetAll() throws Exception {
        List<ProductEntity> mockList = mock(List.class);
        when(mockList.get(0)).thenReturn(productEntity);
        when(mockList.get(1)).thenReturn(null);

        Criteria criteria = mock(Criteria.class);

        when(session.createCriteria(ProductEntity.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(mockList);

        assertEquals(mockList, productDao.getAll(ProductEntity.class));
        assertFalse(mockList.isEmpty());
        assertNull("null", mockList.get(1));
        assertNotNull("товар", mockList.get(0));
        assertEquals(productEntity, mockList.get(0));

        verify(criteria, times(1)).list();
        verify(mockList, atLeast(2)).get(0);
    }

    @Test
    public void testSave() throws Exception {
        when(productEntity.getName()).thenReturn("x");

        doAnswer(invocation -> {
            ProductEntity productEntity1 = invocation.getArgument(0);
            assertEquals("x", productEntity1.getName());
            return null;
        }).when(session).save(productEntity);

        productDao.save(productEntity);

        verify(session, atLeastOnce()).save(productEntity);
    }

    @Test
    public void testSaveSpy() throws Exception {
        ProductDAO dao = new ProductDAOImpl(sessionFactory);
        dao = spy(dao);

        doAnswer(invocation -> null).when(dao).save(productEntity);

        dao.save(productEntity);

        verify(dao, atLeastOnce()).save(productEntity);
    }

    @Test
    public void testUpdate() throws Exception {
        doAnswer(invocation -> null).when(session).update(productEntity);
        productDao.update(productEntity);
        verify(session, timeout(100)).update(productEntity);
    }

    @Test
    public void testRemove() throws Exception {
        doAnswer(invocation -> null).when(session).delete(productEntity);
        productDao.remove(productEntity);
        verify(session, times(1)).delete(any());
    }

}