var avariaApp = angular.module("AvariaControllers", []);

var urlBase = "http://localhost:8181";

avariaApp.controller("AvariaController", function($scope, $http) {

	$scope.listar = function() {
		$http.get(urlBase+"/avarias").then(
				function mySucess(response) {
					$scope.avarias = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}

	$scope.novo = function() {
		$scope.avaria = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.avaria.identifier) {
			$http.post(urlBase+"/avarias/", $scope.avaria)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/avarias/" + $scope.avaria.identifier,
					$scope.avaria).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(avariaSel) {
		$scope.avaria = angular.copy(avariaSel);
	}

	$scope.excluir = function(avariaSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/avarias/"+ avariaSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(avariaOrdenado) {
		$scope.myOrderBy = avariaOrdenado;
	}

});