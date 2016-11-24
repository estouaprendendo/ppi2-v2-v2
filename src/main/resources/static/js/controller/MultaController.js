var multaApp = angular.module("MultaControllers", []);

var urlBase = "http://localhost:8181";

multaApp.controller("MultaController", function($scope, $http) {

	$scope.listar = function() {
		$http.get(urlBase+"/multas").then(
				function mySucess(response) {
					$scope.multas = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}

	$scope.novo = function() {
		$scope.multa = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.multa.identifier) {
			$http.post(urlBase+"/multas/", $scope.multa)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/multas/" + $scope.multa.identifier,
					$scope.multa).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(multaSel) {
		$scope.multa = angular.copy(multaSel);
	}

	$scope.excluir = function(multaSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/multas/"+ multaSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(multaOrdenado) {
		$scope.myOrderBy = multaOrdenado;
	}

});