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

import co.edu.uniandes.csw.auth.filter.StatusCreated;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.bakery.api.IPhotoAlbumLogic;
import co.edu.uniandes.csw.bakery.dtos.detail.PhotoAlbumDetailDTO;
import co.edu.uniandes.csw.bakery.entities.PhotoAlbumEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: products/{productsId: \\d+}/photoAlbums
 * @generated
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PhotoAlbumsResource {

    @Inject private IPhotoAlbumLogic photoAlbumLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;
    @PathParam("productsId") private Long productsId;

   
    /**
     * Convierte una lista de PhotoAlbumEntity a una lista de PhotoAlbumDetailDTO
     *
     * @param entityList Lista de PhotoAlbumEntity a convertir
     * @return Lista de PhotoAlbumDetailDTO convertida
     * @generated
     */
    private List<PhotoAlbumDetailDTO> listEntity2DTO(List<PhotoAlbumEntity> entityList){
        List<PhotoAlbumDetailDTO> list = new ArrayList<>();
        for (PhotoAlbumEntity entity : entityList) {
            list.add(new PhotoAlbumDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de PhotoAlbum asociados a un Product
     *
     * @return Colección de objetos de PhotoAlbumDetailDTO
     * @generated
     */
    @GET
    public List<PhotoAlbumDetailDTO> getPhotoAlbumss() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", photoAlbumLogic.countPhotoAlbums());
            return listEntity2DTO(photoAlbumLogic.getPhotoAlbums(page, maxRecords, productsId));
        }
        return listEntity2DTO(photoAlbumLogic.getPhotoAlbums(productsId));
    }

    /**
     * Obtiene los datos de una instancia de PhotoAlbum a partir de su ID asociado a un Product
     *
     * @param photoAlbumsId Identificador de la instancia a consultar
     * @return Instancia de PhotoAlbumDetailDTO con los datos del PhotoAlbum consultado
     * @generated
     */
    @GET
    @Path("{photoAlbumsId: \\d+}")
    public PhotoAlbumDetailDTO getPhotoAlbums(@PathParam("photoAlbumsId") Long photoAlbumsId) {
        PhotoAlbumEntity entity = photoAlbumLogic.getPhotoAlbum(photoAlbumsId);
        if (entity.getProduct() != null && !productsId.equals(entity.getProduct().getId())) {
            throw new WebApplicationException(404);
        }
        return new PhotoAlbumDetailDTO(entity);
    }

    /**
     * Asocia un PhotoAlbum existente a un Product
     *
     * @param dto Objeto de PhotoAlbumDetailDTO con los datos nuevos
     * @return Objeto de PhotoAlbumDetailDTOcon los datos nuevos y su ID.
     * @generated
     */
    @POST
    @StatusCreated
    public PhotoAlbumDetailDTO createPhotoAlbums(PhotoAlbumDetailDTO dto)  {
        return new PhotoAlbumDetailDTO(photoAlbumLogic.createPhotoAlbum(productsId, dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de PhotoAlbum.
     *
     * @param photoAlbumsId Identificador de la instancia de PhotoAlbum a modificar
     * @param dto Instancia de PhotoAlbumDetailDTO con los nuevos datos.
     * @return Instancia de PhotoAlbumDetailDTO con los datos actualizados.
     * @generated
     */
    @PUT
    @Path("{photoAlbumsId: \\d+}")
    public PhotoAlbumDetailDTO updatePhotoAlbums(@PathParam("photoAlbumsId") Long photoAlbumsId, PhotoAlbumDetailDTO dto) {
        PhotoAlbumEntity entity = dto.toEntity();
        entity.setId(photoAlbumsId);
        return new PhotoAlbumDetailDTO(photoAlbumLogic.updatePhotoAlbum(productsId, entity));
    }

    /**
     * Elimina una instancia de PhotoAlbum de la base de datos.
     *
     * @param photoAlbumId Identificador de la instancia a eliminar.
     * @generated
     */
    @DELETE
    @Path("photoAlbumsId: \\d+}")
    public void deletePhotoAlbums(@PathParam("photoAlbumsId") Long photoAlbumsId) {
        photoAlbumLogic.deletePhotoAlbum(photoAlbumsId);
    }
    


}
