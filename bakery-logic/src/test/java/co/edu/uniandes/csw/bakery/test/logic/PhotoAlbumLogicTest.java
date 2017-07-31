/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.bakery.test.logic;

import co.edu.uniandes.csw.bakery.ejbs.PhotoAlbumLogic;
import co.edu.uniandes.csw.bakery.api.IPhotoAlbumLogic;
import co.edu.uniandes.csw.bakery.entities.PhotoAlbumEntity;
import co.edu.uniandes.csw.bakery.entities.ProductEntity;
import co.edu.uniandes.csw.bakery.persistence.PhotoAlbumPersistence;
import co.edu.uniandes.csw.bakery.entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PhotoAlbumLogicTest {

    /**
     * @generated
     */
    ProductEntity fatherEntity;

    /**
     * @generated
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * @generated
     */
    @Inject
    private IPhotoAlbumLogic photoAlbumLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    private UserTransaction utx;

    /**
     * @generated
     */
    private List<PhotoAlbumEntity> data = new ArrayList<PhotoAlbumEntity>();
    /**
     * @generated
     */
    private List<ProductEntity> productData = new ArrayList<>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PhotoAlbumEntity.class.getPackage())
                .addPackage(PhotoAlbumLogic.class.getPackage())
                .addPackage(IPhotoAlbumLogic.class.getPackage())
                .addPackage(PhotoAlbumPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from PhotoAlbumEntity").executeUpdate();
        em.createQuery("delete from ProductEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
    
            fatherEntity = factory.manufacturePojo(ProductEntity.class);
            fatherEntity.setId(1L);
            em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            PhotoAlbumEntity entity = factory.manufacturePojo(PhotoAlbumEntity.class);
                entity.setProduct(fatherEntity);
    

            em.persist(entity);
            data.add(entity);
        }
    }
   /**
     * Prueba para crear un PhotoAlbum
     *
     * @generated
     */
    @Test
    public void createPhotoAlbumTest() {
        PhotoAlbumEntity newEntity = factory.manufacturePojo(PhotoAlbumEntity.class);
        PhotoAlbumEntity result = photoAlbumLogic.createPhotoAlbum(fatherEntity.getId(), newEntity);
        Assert.assertNotNull(result);
        PhotoAlbumEntity entity = em.find(PhotoAlbumEntity.class, result.getId());
        Assert.assertEquals(newEntity.getUrl(), entity.getUrl());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de PhotoAlbums
     *
     * @generated
     */
    @Test
    public void getPhotoAlbumsTest() {
        List<PhotoAlbumEntity> list = photoAlbumLogic.getPhotoAlbums(fatherEntity.getId());
        Assert.assertEquals(data.size(), list.size());
        for (PhotoAlbumEntity entity : list) {
            boolean found = false;
            for (PhotoAlbumEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un PhotoAlbum
     *
     * @generated
     */
    @Test
    public void getPhotoAlbumTest() {
        PhotoAlbumEntity entity = data.get(0);
        PhotoAlbumEntity resultEntity = photoAlbumLogic.getPhotoAlbum(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getUrl(), resultEntity.getUrl());
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    /**
     * Prueba para eliminar un PhotoAlbum
     *
     * @generated
     */
    @Test
    public void deletePhotoAlbumTest() {
        PhotoAlbumEntity entity = data.get(0);
        photoAlbumLogic.deletePhotoAlbum(entity.getId());
        PhotoAlbumEntity deleted = em.find(PhotoAlbumEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un PhotoAlbum
     *
     * @generated
     */
    @Test
    public void updatePhotoAlbumTest() {
        PhotoAlbumEntity entity = data.get(0);
        PhotoAlbumEntity pojoEntity = factory.manufacturePojo(PhotoAlbumEntity.class);

        pojoEntity.setId(entity.getId());

        photoAlbumLogic.updatePhotoAlbum(fatherEntity.getId(), pojoEntity);

        PhotoAlbumEntity resp = em.find(PhotoAlbumEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getUrl(), resp.getUrl());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
}

