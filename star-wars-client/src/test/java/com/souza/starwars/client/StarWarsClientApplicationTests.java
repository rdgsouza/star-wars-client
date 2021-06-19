package com.souza.starwars.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.souza.starwars.client.controller.FilmsClientController;
import com.souza.starwars.client.controller.PeopleClientController;

@RunWith(SpringRunner.class)
class StarWarsClientApplicationTests {

	    @Test
	 // Testando a listagem de filmes.
	 // Esse método testa a função getAll da categoria de filmes na API SWAPI.
     //	Vamos verificar a quantidade de filmes retornadas na primeira paginação.    
	    public void listaFilmesEverificaQuantidadeTest() {

	        List<String> films = FilmsClientController.listaFilmes();
	        boolean quantidadeAtual = films.get(0).contains("Count: 6");
	        boolean expectativaTrue = true;
	        
	  //Se esse teste falhar é porque a quantidade esperada de filmes na primeira paginação estar errada.' 
	        assertEquals(quantidadeAtual, expectativaTrue);
	    }

	    @Test
	    //Fazendo o teste na busca de um filme por nome.
        //Se esse teste falhar é porque a data de lanlaçamento informada estar errada,
        //Deverar conter na resposta da API: "Release Date: 1977-05-25"
	    public void buscaFilmePorNomeEverificaDataLancamentoTest(){

	    	List<String> films = FilmsClientController.buscarfilmesPorNome("hope");	    	

	    	boolean dataLancamentoFilme = films.get(0)
	    			  .contains("Release Date: 1977-05-25");
	    	
	        boolean expectativaTrue = true;

	        assertEquals(expectativaTrue, dataLancamentoFilme);
	    }
	    
	    @Test
	    //Fazendo o teste na busca de um filme por ID.
        //Se esse teste falhar é porque o título informado estar errado,
        //Deverar conter na resposta da API: "Title: The Empire Strikes Back"
	    public void buscaFilmePorIdEverificaTituloTest() {

	    	List<String> films = FilmsClientController.buscarFilmPorId("2");   	

	    	boolean tituloFilme = films.get(0).contains("Title: The Empire Strikes Back");
	        boolean expectativaTrue = true;
         
	        assertEquals(expectativaTrue, tituloFilme);
	    }
	    	    
	    @Test
		 // Testando a listagem de personagens.
		 // Esse método testa a função getAll da categoria de personagens na API SWAPI.
	     //	Vamos verificar a quantidade de personagens retornados na primeira paginação.  
	    public void listaPersonagensEverificaQuantidadeTest() {

	        List<String> personagens = PeopleClientController.listaPersonagens();
	        boolean quantidadeAtual = personagens.get(0)
	        		  .contains("Count: 82");
	        
	        boolean expectativaTrue = true;
	        
	 //Se esse teste falhar é porque a quantidade esperada de personagens na primeira paginação estar errada.'
	        assertEquals(quantidadeAtual, expectativaTrue);
	    }

	    @Test
	    //Fazendo o teste na busca de um personagem por nome.
        //Se esse teste falhar é porque a data de criação do personagem que foi informada estar errada,
        //Deverar conter na resposta da API: "Created": "2014-12-10T15:18:20.704000Z"
	    public void buscaPersonagemPorNomeEverificaDataCriacaoTest(){

	    	List<String> personagens = PeopleClientController
	    			 .buscarPersonagemPoNome("Darth Vader");	    	

	    	boolean dataCriacaoPersonagem = personagens.get(0)
	    			  .contains("Created: 2014-12-10T15:18:20.704000Z");
	    	
	        boolean expectativaTrue = true;

	        assertEquals(expectativaTrue, dataCriacaoPersonagem);
	    }
	    	    
	    @Test
	    //Fazendo o teste na busca de um personagem por ID.
        //Se esse teste falhar é porque o nome informado estar errado,
        //Deverar conter na resposta da API: "Name: Luke Skywalker"
	    public void buscaPersonagemPorIdEverificaNomeTest() {

	    	List<String> personagem = PeopleClientController.buscarPersonagemPorId("1");   	

	    	boolean nomePersonagem = personagem.get(0)
	    			  .contains("Name: Luke Skywalker");
	    	
	        boolean expectativaTrue = true;

	        assertEquals(expectativaTrue, nomePersonagem);
	    } 
	    
}
