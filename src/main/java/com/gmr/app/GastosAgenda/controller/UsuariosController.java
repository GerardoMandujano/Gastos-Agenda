package com.gmr.app.GastosAgenda.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.gmr.app.GastosAgenda.dto.ResponseDto;
import com.gmr.app.GastosAgenda.model.Usuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("ms-usuarios/v1/usuarios")
public class UsuariosController {	
	//squ_bd0a0c713c3bcc3cb93c4d56304fb750d09739c1ss
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> obtenerUsuarios(
			@RequestParam("idUsuario")String idUsuario 
			){
		ResponseDto response = new ResponseDto();

		if(idUsuario.isEmpty()) {
			response.setCode("400");
			response.setMessage("Favor de validar idUsuario");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

		}
		response.setCode("200");
		response.setMessage("Consulta realizada correctamente");
		response.setData(null);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "url para buscar usuario por clave")
	 @RequestMapping(value = "/buscar/{cveUsuario}", method = RequestMethod.GET)
	public  ResponseEntity<ResponseDto> buscarUsuarioa(@PathParam("cveUsuario") String cveUsuario){
			ResponseDto response = new ResponseDto();

		 return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@ApiOperation(value="url para insertar usuario",response = ResponseDto.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = " Usuario Insertado correctamente", response = String.class),

			@ApiResponse(code = 400, message = " Error en los datos del Usuario", response = String.class),
	            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	 @RequestMapping(value = "/", method = RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<ResponseDto> insertarUsuario(@RequestBody Usuario usuario){
	
		ResponseDto response = new ResponseDto();
		if(usuario.getCveUsuario().isEmpty()) {
			response.setCode("400");
			response.setMessage("Favor de verificar datos del usuario");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		

		response.setCode("201");
		response.setMessage("Usuario insertado Correctamente");
		response.setData(null);
		return new ResponseEntity<>(response,HttpStatus.CREATED);	}

}
