angular.module('myApp', [ 'ui.router', 'myApp.controllers' ])

.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/inicio");

	$stateProvider

	.state('inicio', {
		url : "/inicio",
		templateUrl : "partial-inicio.html",
		controller : "LocacaoController"
	})

	.state('sobre', {
		url : "/sobre",
		templateUrl : "partial-sobre.html"
	})

	.state('avarias', {
		url : "/avarias",
		templateUrl : "avarias.html",
		controller : "AvariaController"
	})

	.state('categorias', {
		url : "/categorias",
		templateUrl : "categorias.html",
		controller : "CategoriaController"
	})

	.state('clientes', {
		url : "/clientes",
		templateUrl : "clientes.html",
		controller : "ClienteController"
	})

	.state('funcionarios', {
		url : "/funcionarios",
		templateUrl : "funcionarios.html",
		controller : "FuncionarioController"
	})

	.state('locacoes', {
		url : "/locacoes",
		templateUrl : "locacoes.html",
		controller : "LocacaoController"
	})

	.state('multas', {
		url : "/multas",
		templateUrl : "multas.html",
		controller : "MultaController"
	})

	.state('veiculos', {
		url : "/veiculos",
		templateUrl : "veiculos.html",
		controller : "VeiculoController"
	})

});
