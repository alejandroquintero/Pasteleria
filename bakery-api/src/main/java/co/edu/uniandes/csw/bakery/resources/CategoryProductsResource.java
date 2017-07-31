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
package co.edu.uniandes.csw.bakery.resources;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.bakery.api.ICategoryLogic;
import co.edu.uniandes.csw.bakery.dtos.detail.ProductDetailDTO;
import co.edu.uniandes.csw.bakery.entities.ProductEntity;
import java.util.ArrayList;
/**
 * URI: categorys/{categorysId: \\d+}/products
 * @generated
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryProductsResource {

    @Inject private ICategoryLogic categoryLogic;
    @Context private HttpServletResponse response;

    /**
     * Convierte una lista de ProductEntity a una lista de ProductDetailDTO.
     *
     * @param entityList Lista de ProductEntity a convertir.
     * @return Lista de ProductDetailDTO convertida.
     * @generated
     */
    private List<ProductDetailDTO> productsListEntity2DTO(List<ProductEntity> entityList){
        List<ProductDetailDTO> list = new ArrayList<>();
        for (ProductEntity entity : entityList) {
            list.add(new ProductDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ProductDetailDTO a una lista de ProductEntity.
     *
     * @param dtos Lista de ProductDetailDTO a convertir.
     * @return Lista de ProductEntity convertida.
     * @generated
     */
    private List<ProductEntity> productsListDTO2Entity(List<ProductDetailDTO> dtos){
        List<ProductEntity> list = new ArrayList<>();
        for (ProductDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ProductDetailDTO asociadas a una
     * instancia de Category
     *
     * @param categorysId Identificador de la instancia de Category
     * @return Colección de instancias de ProductDetailDTO asociadas a la instancia de Category
     * @generated
     */
    @GET
    public List<ProductDetailDTO> listProducts(@PathParam("categorysId") Long categorysId) {
        return productsListEntity2DTO(categoryLogic.listProducts(categorysId));
    }

    /**
     * Obtiene una instancia de Product asociada a una instancia de Category
     *
     * @param categorysId Identificador de la instancia de Category
     * @param productsId Identificador de la instancia de Product
     * @generated
     */
    @GET
    @Path("{productsId: \\d+}")
    public ProductDetailDTO getProducts(@PathParam("categorysId") Long categorysId, @PathParam("productsId") Long productsId) {
        return new ProductDetailDTO(categoryLogic.getProducts(categorysId, productsId));
    }

    /**
     * Asocia un Product existente a un Category
     *
     * @param categorysId Identificador de la instancia de Category
     * @param productsId Identificador de la instancia de Product
     * @return Instancia de ProductDetailDTO que fue asociada a Category
     * @generated
     */
    @POST
    @Path("{productsId: \\d+}")
    public ProductDetailDTO addProducts(@PathParam("categorysId") Long categorysId, @PathParam("productsId") Long productsId) {
        return new ProductDetailDTO(categoryLogic.addProducts(categorysId, productsId));
    }

    /**
     * Remplaza las instancias de Product asociadas a una instancia de Category
     *
     * @param categorysId Identificador de la instancia de Category
     * @param products Colección de instancias de ProductDTO a asociar a instancia de Category
     * @return Nueva colección de ProductDTO asociada a la instancia de Category
     * @generated
     */
    @PUT
    public List<ProductDetailDTO> replaceProducts(@PathParam("categorysId") Long categorysId, List<ProductDetailDTO> products) {
        return productsListEntity2DTO(categoryLogic.replaceProducts(categorysId, productsListDTO2Entity(products)));
    }

    /**
     * Desasocia un Product existente de un Category existente
     *
     * @param categorysId Identificador de la instancia de Category
     * @param productsId Identificador de la instancia de Product
     * @generated
     */
    @DELETE
    @Path("{productsId: \\d+}")
    public void removeProducts(@PathParam("categorysId") Long categorysId, @PathParam("productsId") Long productsId) {
        categoryLogic.removeProducts(categorysId, productsId);
    }

}
