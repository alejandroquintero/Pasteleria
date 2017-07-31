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
(function (ng) {
    var mod = ng.module('photoAlbumModule', ['ngCrud', 'ui.router']);

    mod.constant('photoAlbumModel', {
        name: 'photoAlbum',
        displayName:  'Photo Album',
        url: 'photoAlbums',
        fields: {
            url: {
                
                displayName: 'Url',
                type: 'Imagen',
                required: true 
            },
            name: {
                
                displayName: 'Name',
                type:  'String',
                required: true 
            }        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/photoAlbum/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('photoAlbum', {
                url: '/photoAlbums?page&limit',
                abstract: true,
                parent: 'productDetail',
                views: {
                     productChieldView: {
                        templateUrl: basePath + 'photoAlbum.tpl.html',
                        controller: 'photoAlbumCtrl'
                    }
                },
                resolve: {
                    model: 'photoAlbumModel',
                    photoAlbums: ['product', '$stateParams', 'model', function (product, $params, model) {
                            return product.getList(model.url, $params);
                        }]                }
            });
            $sp.state('photoAlbumList', {
                url: '/list',
                parent: 'photoAlbum',
                views: {
                     'productInstanceView@productInstance': {
                        templateUrl: basePath + 'list/photoAlbum.list.tpl.html',
                        controller: 'photoAlbumListCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                 resolve:{
				   model: 'photoAlbumModel'
					},
                 ncyBreadcrumb: {
                   label: 'photoAlbum'
                    }
            });
            $sp.state('photoAlbumNew', {
                url: '/new',
                parent: 'photoAlbum',
                views: {
                    'productInstanceView@productInstance': {
                        templateUrl: basePath + 'new/photoAlbum.new.tpl.html',
                        controller: 'photoAlbumNewCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                  resolve:{
						model: 'photoAlbumModel'
					},
                  ncyBreadcrumb: {
                        parent :'photoAlbumList', 
                        label: 'new'
                   }
            });
            $sp.state('photoAlbumInstance', {
                url: '/{photoAlbumId:int}',
                abstract: true,
                parent: 'photoAlbum',
                views: {
                    'productInstanceView@productInstance': {
                        template: '<div ui-view="photoAlbumInstanceView"></div>'
                    }
                },
                resolve: {
                    photoAlbum: ['photoAlbums', '$stateParams', function (photoAlbums, $params) {
                            return photoAlbums.get($params.photoAlbumId);
                        }]
                }
            });
            $sp.state('photoAlbumDetail', {
                url: '/details',
                parent: 'photoAlbumInstance',
                views: {
                    photoAlbumInstanceView: {
                        templateUrl: baseInstancePath + 'detail/photoAlbum.detail.tpl.html',
                        controller: 'photoAlbumDetailCtrl'
                    }
                },
                  resolve:{
						model: 'photoAlbumModel'
					},
                  ncyBreadcrumb: {
                        parent :'photoAlbumList', 
                        label: 'details'
                    }
            });
            $sp.state('photoAlbumEdit', {
                url: '/edit',
                sticky: true,
                parent: 'photoAlbumInstance',
                views: {
                    photoAlbumInstanceView: {
                        templateUrl: baseInstancePath + 'edit/photoAlbum.edit.tpl.html',
                        controller: 'photoAlbumEditCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                  resolve:{
						model: 'photoAlbumModel'
					},
                  ncyBreadcrumb: {
                        parent :'photoAlbumDetail', 
                        label: 'edit'
                    }
            });
            $sp.state('photoAlbumDelete', {
                url: '/delete',
                parent: 'photoAlbumInstance',
                views: {
                    photoAlbumInstanceView: {
                        templateUrl: baseInstancePath + 'delete/photoAlbum.delete.tpl.html',
                        controller: 'photoAlbumDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                  resolve:{
				      model: 'photoAlbumModel'
					}
            });
	}]);
})(window.angular);
