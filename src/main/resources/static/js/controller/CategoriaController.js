var categoriaApp = angular.module("CategoriaControllers", []);

var urlBase = "https://ppi2v2v3.herokuapp.com";

	categoriaApp.controller("CategoriaController", function($scope, $http) {

	$scope.listar = function() {
		$http.get(urlBase+"/categorias").then(
				function mySucess(response) {
					$scope.categorias = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}

	$scope.novo = function() {
		$scope.categoria = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.categoria.identifier) {
			$http.post(urlBase+"/categorias/", $scope.categoria)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/categorias/" + $scope.categoria.identifier,
					$scope.categoria).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(categoriaSel) {
		$scope.categoria = angular.copy(categoriaSel);
	}

	$scope.excluir = function(categoriaSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/categorias/"+ categoriaSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(categoriaOrdenado) {
		$scope.myOrderBy = categoriaOrdenado;
	}

});
