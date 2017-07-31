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
    var mod = ng.module('categoryModule', ['ngCrud', 'ui.router','productModule']);

    mod.constant('categoryModel', {
        name: 'category',
        displayName: 'Categorias',
        url: 'categorys',
        fields: {
            description: {
                displayName: 'Description',
                type: 'String',
                required: true
            },
            name: {
                displayName: 'Name',
                type: 'String',
                required: true
            },
            superCategory: {
                displayName: 'Super Category',
                type: 'Reference',
                model: 'categoryModel',
                options: [],
                required: false
            }}
    });

    mod.config(['$stateProvider',
        function ($sp) {
            var basePath = 'src/modules/category/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('category', {
                url: '/categorys?page&limit',
                abstract: true,
                views: {
                    mainView: {
                        templateUrl: basePath + 'category.tpl.html',
                        controller: 'categoryCtrl'
                    }
                },
                resolve: {
                    references: ['$q', 'Restangular', function ($q, r) {
                            return $q.all({
                                superCategory: r.all('categorys').getList()
                            });
                        }],
                    model: 'categoryModel',
                    categorys: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('categoryList', {
                url: '/list',
                parent: 'category',
                views: {
                    categoryView: {
                        templateUrl: basePath + 'list/category.list.tpl.html',
                        controller: 'categoryListCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                resolve: {
                    model: 'categoryModel'
                },
                ncyBreadcrumb: {
                    label: 'category'
                }
            });
            $sp.state('categoryGallery', {
                url: '/gallery',
                parent: 'category',
                views: {
                    categoryView: {
                        templateUrl: basePath + 'list/category.gallery.tpl.html',
                        controller: 'categoryGalleryCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                resolve: {
                    model: 'categoryModel',
                    pmodel: 'productModel'
                },
                ncyBreadcrumb: {
                    label: 'gallery'
                }
            });
            $sp.state('categoryNew', {
                url: '/new',
                parent: 'category',
                views: {
                    categoryView: {
                        templateUrl: basePath + 'new/category.new.tpl.html',
                        controller: 'categoryNewCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                resolve: {
                    model: 'categoryModel'
                },
                ncyBreadcrumb: {
                    parent: 'categoryList',
                    label: 'new'
                }
            });
            $sp.state('categoryInstance', {
                url: '/{categoryId:int}',
                abstract: true,
                parent: 'category',
                views: {
                    categoryView: {
                        template: '<div ui-view="categoryInstanceView"></div>'
                    }
                },
                resolve: {
                    category: ['categorys', '$stateParams', function (categorys, $params) {
                            return categorys.get($params.categoryId);
                        }]
                }
            });
            $sp.state('categoryDetail', {
                url: '/details',
                parent: 'categoryInstance',
                views: {
                    categoryInstanceView: {
                        templateUrl: baseInstancePath + 'detail/category.detail.tpl.html',
                        controller: 'categoryDetailCtrl'
                    }
                },
                resolve: {
                    model: 'categoryModel'
                },
                ncyBreadcrumb: {
                    parent: 'categoryList',
                    label: 'details'
                }
            });
            $sp.state('categoryEdit', {
                url: '/edit',
                sticky: true,
                parent: 'categoryInstance',
                views: {
                    categoryInstanceView: {
                        templateUrl: baseInstancePath + 'edit/category.edit.tpl.html',
                        controller: 'categoryEditCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                resolve: {
                    model: 'categoryModel'
                },
                ncyBreadcrumb: {
                    parent: 'categoryDetail',
                    label: 'edit'
                }
            });
            $sp.state('categoryDelete', {
                url: '/delete',
                parent: 'categoryInstance',
                views: {
                    categoryInstanceView: {
                        templateUrl: baseInstancePath + 'delete/category.delete.tpl.html',
                        controller: 'categoryDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                resolve: {
                    model: 'categoryModel'
                }
            });
            $sp.state('categoryProducts', {
                url: '/products',
                parent: 'categoryDetail',
                abstract: true,
                views: {
                    categoryChieldView: {
                        template: '<div ui-view="categoryProductsView"></div>'
                    }
                },
                resolve: {
                    products: ['category', function (category) {
                            return category.getList('products');
                        }],
                    model: 'productModel'
                }
            });
            $sp.state('categoryProductsList', {
                url: '/list',
                parent: 'categoryProducts',
                views: {
                    categoryProductsView: {
                        templateUrl: baseInstancePath + 'products/list/category.products.list.tpl.html',
                        controller: 'categoryProductsListCtrl'
                    }
                }
            });
            $sp.state('categoryProductsEdit', {
                url: '/edit',
                parent: 'categoryProducts',
                views: {
                    categoryProductsView: {
                        templateUrl: baseInstancePath + 'products/edit/category.products.edit.tpl.html',
                        controller: 'categoryProductsEditCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                resolve: {
                    model: 'productModel',
                    pool: ['Restangular', 'model', function (r, model) {
                            return r.all(model.url).getList();
                        }]
                }
            });
        }]);
})(window.angular);
