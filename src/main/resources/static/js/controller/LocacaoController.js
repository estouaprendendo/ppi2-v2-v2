var locacaoApp = angular.module("LocacaoControllers", []);

var urlBase = "https://ppi2v2v3.herokuapp.com";

locacaoApp.controller("LocacaoController", function($scope, $http) {

	$scope.listar = function() {
		$http.get(urlBase+"/locacoes").then(
				function mySucess(response) {
					$scope.locacoes = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
		
		
		$http.get(urlBase+"/clientes").then(
				function mySucess(response) {
					$scope.clientes = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
		
		$http.get(urlBase+"/funcionarios").then(
				function mySucess(response) {
					$scope.funcionarios = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
		
		$http.get(urlBase+"/veiculos").then(
				function mySucess(response) {
					$scope.veiculos = response.data;
				}, function myError(response) {
					window.alert("Erro de Get!!");
				});
	}

	$scope.novo = function() {
		$scope.locacao = "";
		$scope.cliente = "";
		$scope.funcionario = "";
		$scope.veiculo = "";
	}

	$scope.listar();

	$scope.salvar = function() {

		if (!$scope.locacao.identifier) {
			$http.post(urlBase+"/locacoes/", $scope.locacao)
					.then(function(response) {
						$scope.listar();
						$scope.novo();
					}, function(response) {
						window.alert("Erro de POST!!");
					});
		} else {
			$http.put(
					urlBase+"/locacoes/" + $scope.locacao.identifier,
					$scope.locacao).then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de PUT!!");
			});
		}

	}

	$scope.editar = function(locacaoSel) {
		$scope.locacao = angular.copy(locacaoSel);
		$scope.locacao.data = new Date($scope.locacao.data);
		$scope.cliente = locacaoSel.cliente;
		$scope.funcionario = locacaoSel.funcionario;
		$scope.veiculo = locacaoSel.veiculo;
	}
	
	$scope.$watch('cliente.identifier', function(){
		$scope.locacao.cliente.identifier = $scope.cliente.identifier;
	});
	
	$scope.$watch('funcionarioCad.identifier', function(){
		$scope.locacao.funcionarioCad.identifier = $scope.funcionarioCad.identifier;
	});
	
	$scope.$watch('funcionarioRec.identifier', function(){
		$scope.locacao.funcionarioRec.identifier = $scope.funcionarioRec.identifier;
	});
	
	$scope.$watch('veiculo.identifier', function(){
		$scope.locacao.veiculo.identifier = $scope.veiculo.identifier;
	});

	$scope.excluir = function(locacaoSel) {
		if (window.confirm("Tem certeza?")) {
			$http.delete(urlBase+"/locacoes/"+ locacaoSel.identifier)
			.then(function mySucess(response) {
				$scope.listar();
			}, function myError(response) {
				window.alert("Erro de DELETE!!");
			});
		}
	}

	$scope.orderByMe = function(locacaoOrdenado) {
		$scope.myOrderBy = locacaoOrdenado;
	}

});
