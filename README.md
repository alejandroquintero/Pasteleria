# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-bakery)
  - [Recurso Category](#recurso-category)
    - [GET /categorys](#GET-/categorys)
    - [GET /categorys/{id}](#GET-/categorys/{id})
    - [POST /categorys](#POST-/categorys)
    - [PUT /categorys/{id}](#PUT-/categorys/{id})
    - [DELETE /categorys/{id}](#DELETE-/categorys/{id})
    - [GET categorys/{categorysid}/products](#GET-categorys/{categorysid}/products)
    - [GET categorys/{categorysid}/products/{productsid}](#GET-categorys/{categorysid}/products/{productsid})
    - [POST categorys/{categorysid}/products/{productsid}](#POST-categorys/{categorysid}/products/{productsid})
    - [PUT categorys/{categorysid}/products](#PUT-categorys/{categorysid}/products)
    - [DELETE categorys/{categorysid}/products/{productsid}](#DELETE-categorys/{categorysid}/products/{productsid}])
  - [Recurso Product](#recurso-product)
    - [GET /products](#GET-/products)
    - [GET /products/{id}](#GET-/products/{id})
    - [POST /products](#POST-/products)
    - [PUT /products/{id}](#PUT-/products/{id})
    - [DELETE /products/{id}](#DELETE-/products/{id})
    - [GET products/{productsid}/photoAlbums](#GET-products/{productsid}/photoAlbums)
    - [GET products/{productsid}/photoAlbums/{photoAlbumsid}](#GET-products/{productsid}/photoAlbums/{photoAlbumsid})
    - [POST products/{productsid}/photoAlbums/{photoAlbumsid}](#POST-products/{productsid}/photoAlbums/{photoAlbumsid})
    - [PUT products/{productsid}/photoAlbums](#PUT-products/{productsid}/photoAlbums)
    - [DELETE products/{productsid}/photoAlbums/{photoAlbumsid}](#DELETE-products/{productsid}/photoAlbums/{photoAlbumsid}])
  - [Recurso Client](#recurso-client)
    - [GET /clients](#GET-/clients)
    - [GET /clients/{id}](#GET-/clients/{id})
    - [POST /clients](#POST-/clients)
    - [PUT /clients/{id}](#PUT-/clients/{id})
    - [DELETE /clients/{id}](#DELETE-/clients/{id})

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /Bakery.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación Bakery
### Recurso Category
El objeto Category tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    description: '' /*Tipo String*/,
    name: '' /*Tipo String*/,
    id: '' /*Tipo Long*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    superCategory: {
    description: '' /*Tipo String*/,
    name: '' /*Tipo String*/,
    id: '' /*Tipo Long*/    }
}
```



#### GET /categorys

Retorna una colección de objetos Category en representación Detail.
Cada Category en la colección tiene embebidos los siguientes objetos: Category.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-category)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /categorys/{id}

Retorna una colección de objetos Category en representación Detail.
Cada Category en la colección tiene los siguientes objetos: Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Category en [representaciones Detail](#recurso-category)
404|No existe un objeto Category con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /categorys

Es el encargado de crear objetos Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Category que será creado|Sí|[Representación Detail](#recurso-category)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Category ha sido creado|[Representación Detail](#recurso-category)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Category|Mensaje de error

#### PUT /categorys/{id}

Es el encargado de actualizar objetos Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a actualizar|Sí|Integer
body|body|Objeto Category nuevo|Sí|[Representación Detail](#recurso-category)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Category actualizado|[Representación Detail](#recurso-category)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Category|Mensaje de error

#### DELETE /categorys/{id}

Elimina un objeto Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error

#### GET categorys/{categorysid}/products

Retorna una colección de objetos Product asociados a un objeto Category en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Product en [representación Detail](#recurso-product)
500|Error consultando products |Mensaje de error

#### GET categorys/{categorysid}/products/{productsid}

Retorna un objeto Product asociados a un objeto Category en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
categorysid|Path|ID del objeto Category a consultar|Sí|Integer
productsid|Path|ID del objeto Product a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Product en [representación Detail](#recurso-product)
404|No existe un objeto Product con el ID solicitado asociado al objeto Category indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST categorys/{categorysid}/products/{productsid}

Asocia un objeto Product a un objeto Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
categorysid|PathParam|ID del objeto Category al cual se asociará el objeto Product|Sí|Integer
productsid|PathParam|ID del objeto Product a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Product asociado|[Representación Detail de Product](#recurso-product)
500|No se pudo asociar el objeto Product|Mensaje de error

#### PUT categorys/{categorysid}/products

Es el encargado de remplazar la colección de objetos Product asociada a un objeto Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
categorysid|Path|ID del objeto Category cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Product|Sí|[Representación Detail](#recurso-product)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Product en [Representación Detail](#recurso-product)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE categorys/{categorysid}/products/{productsid}

Remueve un objeto Product de la colección en un objeto Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
categorysid|Path|ID del objeto Category asociado al objeto Product|Sí|Integer
productsid|Path|ID del objeto Product a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso Product
El objeto Product tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    description: '' /*Tipo String*/,
    price: '' /*Tipo Double*/,
    portions: '' /*Tipo Integer*/,
    weight: '' /*Tipo Double*/,
    name: '' /*Tipo String*/,
    image: '' /*Tipo String*/,
    id: '' /*Tipo Long*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    category: {
    description: '' /*Tipo String*/,
    name: '' /*Tipo String*/,
    id: '' /*Tipo Long*/    }
}
```



#### GET /products

Retorna una colección de objetos Product en representación Detail.
Cada Product en la colección tiene embebidos los siguientes objetos: Category.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-product)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /products/{id}

Retorna una colección de objetos Product en representación Detail.
Cada Product en la colección tiene los siguientes objetos: Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Product a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Product en [representaciones Detail](#recurso-product)
404|No existe un objeto Product con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /products

Es el encargado de crear objetos Product.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Product que será creado|Sí|[Representación Detail](#recurso-product)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Product ha sido creado|[Representación Detail](#recurso-product)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Product|Mensaje de error

#### PUT /products/{id}

Es el encargado de actualizar objetos Product.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Product a actualizar|Sí|Integer
body|body|Objeto Product nuevo|Sí|[Representación Detail](#recurso-product)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Product actualizado|[Representación Detail](#recurso-product)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Product|Mensaje de error

#### DELETE /products/{id}

Elimina un objeto Product.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Product a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error


#### GET products/{productsid}/photoAlbums

Retorna una colección de objetos PhotoAlbum asociados a un objeto Product en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Product a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos PhotoAlbum en [representación Detail](#recurso-photoalbum)
500|Error consultando photoAlbums |Mensaje de error

#### GET products/{productsid}/photoAlbums/{photoAlbumsid}

Retorna un objeto PhotoAlbum asociados a un objeto Product en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
productsid|Path|ID del objeto Product a consultar|Sí|Integer
photoAlbumsid|Path|ID del objeto PhotoAlbum a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto PhotoAlbum en [representación Detail](#recurso-photoalbum)
404|No existe un objeto PhotoAlbum con el ID solicitado asociado al objeto Product indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST products/{productsid}/photoAlbums/{photoAlbumsid}

Asocia un objeto PhotoAlbum a un objeto Product.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
productsid|PathParam|ID del objeto Product al cual se asociará el objeto PhotoAlbum|Sí|Integer
photoAlbumsid|PathParam|ID del objeto PhotoAlbum a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto PhotoAlbum asociado|[Representación Detail de PhotoAlbum](#recurso-photoalbum)
500|No se pudo asociar el objeto PhotoAlbum|Mensaje de error

#### PUT products/{productsid}/photoAlbums

Es el encargado de actualizar un objeto PhotoAlbum asociada a un objeto Product.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
productsid|Path|ID del objeto Product cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos PhotoAlbum|Sí|[Representación Detail](#recurso-photoalbum)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto PhotoAlbum en [Representación Detail](#recurso-photoalbum)
500|No se pudo actualizar|Mensaje de error

#### DELETE products/{productsid}/photoAlbums/{photoAlbumsid}

Remueve un objeto PhotoAlbum asociado a un objeto Product.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
productsid|Path|ID del objeto Product asociado al objeto PhotoAlbum|Sí|Integer
photoAlbumsid|Path|ID del objeto PhotoAlbum a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


[Volver arriba](#tabla-de-contenidos)
### Recurso Client
El objeto Client tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```




#### GET /clients

Retorna una colección de objetos Client en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-client)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /clients/{id}

Retorna una colección de objetos Client en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Client en [representaciones Detail](#recurso-client)
404|No existe un objeto Client con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /clients

Es el encargado de crear objetos Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Client que será creado|Sí|[Representación Detail](#recurso-client)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Client ha sido creado|[Representación Detail](#recurso-client)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Client|Mensaje de error

#### PUT /clients/{id}

Es el encargado de actualizar objetos Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a actualizar|Sí|Integer
body|body|Objeto Client nuevo|Sí|[Representación Detail](#recurso-client)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Client actualizado|[Representación Detail](#recurso-client)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Client|Mensaje de error

#### DELETE /clients/{id}

Elimina un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
