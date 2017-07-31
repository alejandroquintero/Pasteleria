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
package co.edu.uniandes.csw.bakery.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.bakery.entities.PhotoAlbumEntity;
import co.edu.uniandes.csw.crud.spi.persistence.CrudPersistence;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 * @generated
 */
@Stateless
public class PhotoAlbumPersistence extends CrudPersistence<PhotoAlbumEntity> {

    @PersistenceContext(unitName="BakeryPU")
    protected EntityManager em;

    /**
     * @generated
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * @generated
     */
    @Override
    protected Class<PhotoAlbumEntity> getEntityClass() {
        return PhotoAlbumEntity.class;
    }

    public PhotoAlbumEntity find(Long productid, Long photoAlbumid) {
        TypedQuery<PhotoAlbumEntity> q = em.createQuery("select p from PhotoAlbumEntity p where (p.product.id = :productid) and (p.id = :photoAlbumid)", PhotoAlbumEntity.class);
        q.setParameter("productid", productid);
        q.setParameter("photoAlbumid", photoAlbumid);
        return q.getSingleResult();
    }
    
    public List<PhotoAlbumEntity> findAll(Integer page, Integer maxRecords, Long productid) {
        TypedQuery<PhotoAlbumEntity> q = em.createQuery("select p from PhotoAlbumEntity p where (p.product.id = :productid)", PhotoAlbumEntity.class);
        q.setParameter("productid", productid);
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return q.getResultList();
    }


}
