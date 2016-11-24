var funcionarioApp = angular.module("FuncionarioControllers", []);

var urlBase = "http://localhost:8181";

funcionarioApp.controller("FuncionarioController", function($scope, $http) {

	$scope.listar = function() {
		$http.get(urlBase+"/funcionarios").then(
				function mySucess(response) {
					$scope.funcionarios = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}

	$scope.novo = function() {
		$scope.funcionario = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.funcionario.identifier) {
			$http.post(urlBase+"/funcionarios/", $scope.funcionario)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/funcionarios/" + $scope.funcionario.identifier,
					$scope.funcionario).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(funcionarioSel) {
		$scope.funcionario = angular.copy(funcionarioSel);
	}

	$scope.excluir = function(funcionarioSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/funcionarios/"+ funcionarioSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(funcionarioOrdenado) {
		$scope.myOrderBy = funcionarioOrdenado;
	}

});