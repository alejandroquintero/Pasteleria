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
package co.edu.uniandes.csw.bakery.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


/**
 * @generated
 */
@Entity
public class PhotoAlbumEntity extends BaseEntity implements Serializable {

    private String url;

    @PodamExclude
    @ManyToOne
    private ProductEntity product;

    /**
     * Obtiene el atributo url.
     *
     * @return atributo url.
     * @generated
     */
    public String getUrl(){
        return url;
    }

    /**
     * Establece el valor del atributo url.
     *
     * @param url nuevo valor del atributo
     * @generated
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * Obtiene el atributo product.
     *
     * @return atributo product.
     * @generated
     */
    public ProductEntity getProduct() {
        return product;
    }

    /**
     * Establece el valor del atributo product.
     *
     * @param product nuevo valor del atributo
     * @generated
     */
    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
