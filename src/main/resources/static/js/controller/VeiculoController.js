var veiculoApp = angular.module("VeiculoControllers", []);

var urlBase = "http://localhost:8181";

veiculoApp.controller("VeiculoController", function($scope, $http) {

	$scope.listar = function() {
		
		$http.get(urlBase+"/veiculos").then(
				function mySucess(response) {
					$scope.veiculos = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
		
		$http.get(urlBase+"/categorias").then(
				function mySucess(response) {
					$scope.categorias = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}
	
	$scope.novo = function() {
		$scope.veiculo = "";
		$scope.categoria = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.veiculo.identifier) {
			$http.post(urlBase+"/veiculos/", $scope.veiculo)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/veiculos/" + $scope.veiculo.identifier,
					$scope.veiculo).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(veiculoSel) {
		$scope.veiculo = angular.copy(veiculoSel);
		$scope.categoria = veiculoSel.categoria;
	}
	
	$scope.$watch('categoria.identifier', function(){
		$scope.veiculo.categoria.identifier = $scope.categoria.identifier;
	});

	$scope.excluir = function(veiculoSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/veiculos/"+ veiculoSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(veiculoOrdenado) {
		$scope.myOrderBy = veiculoOrdenado;
	}
	
});