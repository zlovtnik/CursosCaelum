package br.com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.thoughtworks.xstream.XStream;

import xtream.Produto;

public class TestXML {
	
	@Test
	public void deveGerarOXmlComONomePrecoEDescricaoAdequados() {
		
		String resultadoEsperado = "<produto codigo=\"1225\">\n"+
								"  <nome>Teste</nome>\n"+
								"  <preco>100.0</preco>\n"+
								"  <descricao>Produto teste</descricao>\n"+
								"</produto>";
		
		Produto produto = new Produto("Teste", 100.0, "Produto teste", 1225);
		XStream xStream = new XStream();
		xStream.alias("produto", Produto.class);
		xStream.useAttributeFor(Produto.class,"codigo");
		String xmlGerado = xStream.toXML(produto);
		
		assertEquals(resultadoEsperado,xmlGerado);
	}

}
