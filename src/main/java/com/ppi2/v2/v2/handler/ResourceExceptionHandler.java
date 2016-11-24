package com.ppi2.v2.v2.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ppi2.v2.v2.exception.AvariaAlreadyExistException;
import com.ppi2.v2.v2.exception.AvariaNotFoundException;
import com.ppi2.v2.v2.exception.CategoriaAlreadyExistException;
import com.ppi2.v2.v2.exception.CategoriaNotFoundException;
import com.ppi2.v2.v2.exception.ClienteAlreadyExistException;
import com.ppi2.v2.v2.exception.ClienteNotFoundException;
import com.ppi2.v2.v2.exception.FuncionarioAlreadyExistException;
import com.ppi2.v2.v2.exception.FuncionarioNotFoundException;
import com.ppi2.v2.v2.exception.LocacaoAlreadyExistException;
import com.ppi2.v2.v2.exception.LocacaoNotFoundException;
import com.ppi2.v2.v2.exception.MultaAlreadyExistException;
import com.ppi2.v2.v2.exception.MultaNotFoundException;
import com.ppi2.v2.v2.exception.VeiculoAlreadyExistException;
import com.ppi2.v2.v2.exception.VeiculoNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	// Avaria

	@ExceptionHandler(AvariaNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerAvariaNotFoundException(AvariaNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Avaria not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(AvariaAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerAvariaAlreadyExistException(AvariaAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Avaria already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	// Categoria

	@ExceptionHandler(CategoriaNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerCategoriaNotFoundException(CategoriaNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Categoria not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(CategoriaAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerCategoriaAlreadyExistException(CategoriaAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Categoria already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	// Cliente

	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerClienteNotFoundException(ClienteNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Cliente not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(ClienteAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerClienteAlreadyExistException(ClienteAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Cliente already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	// Funcionario

	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerFuncionarioNotFoundException(FuncionarioNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Funcionario not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(FuncionarioAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerFuncionarioAlreadyExistException(FuncionarioAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Funcionario already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	// Locacao

	@ExceptionHandler(LocacaoNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerLocacaoNotFoundException(LocacaoNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Locacao not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(LocacaoAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerLocacaoAlreadyExistException(LocacaoAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Locacao already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	// Multa

	@ExceptionHandler(MultaNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerMultaNotFoundException(MultaNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Multa not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MultaAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerMultaAlreadyExistException(MultaAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Multa already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	// Veiculo

	@ExceptionHandler(VeiculoNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerVeiculoNotFoundException(VeiculoNotFoundException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Veiculo not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(VeiculoAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerVeiculoAlreadyExistException(VeiculoAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Veiculo already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}