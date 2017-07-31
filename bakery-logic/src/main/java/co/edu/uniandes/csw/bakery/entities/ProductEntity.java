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
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;


/**
 * @generated
 */
@Entity
public class ProductEntity extends BaseEntity implements Serializable {

    private String description;

    private Double price;

    private Integer portions;

    private Double weight;

    private String image;

    @PodamExclude
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<PhotoAlbumEntity> photoAlbums = new ArrayList<>();

    @PodamExclude
    @ManyToOne
    private CategoryEntity category;

    /**
     * Obtiene el atributo description.
     *
     * @return atributo description.
     * @generated
     */
    public String getDescription(){
        return description;
    }

    /**
     * Establece el valor del atributo description.
     *
     * @param description nuevo valor del atributo
     * @generated
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Obtiene el atributo price.
     *
     * @return atributo price.
     * @generated
     */
    public Double getPrice(){
        return price;
    }

    /**
     * Establece el valor del atributo price.
     *
     * @param price nuevo valor del atributo
     * @generated
     */
    public void setPrice(Double price){
        this.price = price;
    }

    /**
     * Obtiene el atributo portions.
     *
     * @return atributo portions.
     * @generated
     */
    public Integer getPortions(){
        return portions;
    }

    /**
     * Establece el valor del atributo portions.
     *
     * @param portions nuevo valor del atributo
     * @generated
     */
    public void setPortions(Integer portions){
        this.portions = portions;
    }

    /**
     * Obtiene el atributo weight.
     *
     * @return atributo weight.
     * @generated
     */
    public Double getWeight(){
        return weight;
    }

    /**
     * Establece el valor del atributo weight.
     *
     * @param weight nuevo valor del atributo
     * @generated
     */
    public void setWeight(Double weight){
        this.weight = weight;
    }

    /**
     * Obtiene el atributo image.
     *
     * @return atributo image.
     * @generated
     */
    public String getImage(){
        return image;
    }

    /**
     * Establece el valor del atributo image.
     *
     * @param image nuevo valor del atributo
     * @generated
     */
    public void setImage(String image){
        this.image = image;
    }

    /**
     * Obtiene el atributo category.
     *
     * @return atributo category.
     * @generated
     */
    public CategoryEntity getCategory() {
        return category;
    }

    /**
     * Establece el valor del atributo category.
     *
     * @param category nuevo valor del atributo
     * @generated
     */
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    /**
     * Obtiene la colección de photoAlbums.
     *
     * @return colección photoAlbums.
     * @generated
     */
    public List<PhotoAlbumEntity> getPhotoAlbums() {
        return photoAlbums;
    }

    /**
     * Establece el valor de la colección de photoAlbums.
     *
     * @param photoAlbums nuevo valor de la colección.
     * @generated
     */
    public void setPhotoAlbums(List<PhotoAlbumEntity> photoalbums) {
        this.photoAlbums = photoalbums;
    }
}
