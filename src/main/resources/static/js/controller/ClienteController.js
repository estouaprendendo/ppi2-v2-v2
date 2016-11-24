var clienteApp = angular.module("ClienteControllers", []);

var urlBase = "https://ppi2v2v3.herokuapp.com";

clienteApp.controller("ClienteController", function($scope, $http) {

	$scope.listar = function() {
		$http.get(urlBase+"/clientes").then(
				function mySucess(response) {
					$scope.clientes = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}

	$scope.novo = function() {
		$scope.cliente = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.cliente.identifier) {
			$http.post(urlBase+"/clientes/", $scope.cliente)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/clientes/" + $scope.cliente.identifier,
					$scope.cliente).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(clienteSel) {
		$scope.cliente = angular.copy(clienteSel);
	}

	$scope.excluir = function(clienteSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/clientes/"+ clienteSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(clienteOrdenado) {
		$scope.myOrderBy = clienteOrdenado;
	}

});
