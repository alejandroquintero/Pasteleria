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
package co.edu.uniandes.csw.bakery.dtos.minimum;

import co.edu.uniandes.csw.bakery.entities.ProductEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class ProductDTO  implements Serializable{

    private String description;
    private Double price;
    private Integer portions;
    private Double weight;
    private String name;
    private String image;
    private Long id;


    /**
     * @generated
     */
    public ProductDTO() {
    }

    /**
     * Crea un objeto ProductDTO a partir de un objeto ProductEntity.
     *
     * @param entity Entidad ProductEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public ProductDTO(ProductEntity entity) {
	   if (entity!=null){
        this.description=entity.getDescription();
        this.price=entity.getPrice();
        this.portions=entity.getPortions();
        this.weight=entity.getWeight();
        this.name=entity.getName();
        this.image=entity.getImage();
        this.id=entity.getId();
       }
    }

    /**
     * Convierte un objeto ProductDTO a ProductEntity.
     *
     * @return Nueva objeto ProductEntity.
     * @generated
     */
    public ProductEntity toEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setDescription(this.getDescription());
        entity.setPrice(this.getPrice());
        entity.setPortions(this.getPortions());
        entity.setWeight(this.getWeight());
        entity.setName(this.getName());
        entity.setImage(this.getImage());
        entity.setId(this.getId());
    return entity;
    }

    /**
     * Obtiene el atributo description.
     *
     * @return atributo description.
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece el valor del atributo description.
     *
     * @param description nuevo valor del atributo
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el atributo price.
     *
     * @return atributo price.
     * @generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Establece el valor del atributo price.
     *
     * @param price nuevo valor del atributo
     * @generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Obtiene el atributo portions.
     *
     * @return atributo portions.
     * @generated
     */
    public Integer getPortions() {
        return portions;
    }

    /**
     * Establece el valor del atributo portions.
     *
     * @param portions nuevo valor del atributo
     * @generated
     */
    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    /**
     * Obtiene el atributo weight.
     *
     * @return atributo weight.
     * @generated
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Establece el valor del atributo weight.
     *
     * @param weight nuevo valor del atributo
     * @generated
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Obtiene el atributo name.
     *
     * @return atributo name.
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el valor del atributo name.
     *
     * @param name nuevo valor del atributo
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el atributo image.
     *
     * @return atributo image.
     * @generated
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece el valor del atributo image.
     *
     * @param image nuevo valor del atributo
     * @generated
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }


}
