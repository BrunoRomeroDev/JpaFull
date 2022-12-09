package com.ebookjpa.application;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ebookjpa.entity.Veiculo;
import com.ebookjpa.entity.VeiculoId;
import com.ebookjpa.util.JpaUtil;

public class Application {

	public static void main(String[] args) {
		
		
		//cadastrou um novo veiculo
		
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2020);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(90500));
		veiculo.setCodigo(new VeiculoId("ABC-1234", "Uberlândia"));
		
		manager.persist(veiculo);
		manager.detach(veiculo);
		
	
		
		Veiculo veiculo2 = new Veiculo();
		
		veiculo2.setFabricante("Fiat");
		veiculo2.setModelo("Toro");
		veiculo2.setAnoFabricacao(2019);
		veiculo2.setAnoModelo(2019);
		veiculo2.setValor(new BigDecimal(12700));
		veiculo2.setCodigo(new VeiculoId("WER-1234", "Sao Paulo"));
		
		manager.persist(veiculo2);
		manager.detach(veiculo2);
		
		
		Veiculo veiculo3 = new Veiculo();
		
		veiculo3.setFabricante("Ford");
		veiculo3.setModelo("Fiesta");
		veiculo3.setAnoFabricacao(2018);
		veiculo3.setAnoModelo(2017);
		veiculo3.setValor(new BigDecimal(54100));
		veiculo3.setCodigo(new VeiculoId("RFG-8763", "Guaruja"));
		
		manager.persist(veiculo3);
		manager.detach(veiculo3);
		
		
		Veiculo veiculo4 = new Veiculo();
		
		veiculo4.setFabricante("VW");
		veiculo4.setModelo("Gol");
		veiculo4.setAnoFabricacao(2023);
		veiculo4.setAnoModelo(2023);
		veiculo4.setValor(new BigDecimal(70600));
		veiculo4.setCodigo(new VeiculoId("QWE-953", "Sao vicente"));
		
		manager.persist(veiculo4);
		manager.detach(veiculo4);
		
		
		
		//buscou uma entidade e manteve o contexto da mesma e na segunda buscou trouxe
		//o objeto nao capturou do banco
		
	
		Veiculo veiculo5 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		Veiculo veiculo6 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		System.out.println("Mesmo veículo? " + (veiculo5 == veiculo6));
		
	
		//removendo do contexto via detach 
		
		
		Veiculo veiculo7 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		System.out.println("Gerenciado? " + manager.contains(veiculo7));
		manager.detach(veiculo7);
		System.out.println("E agora? " + manager.contains(veiculo7));
		Veiculo veiculo8 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		System.out.println("Mesmo veículo? " + (veiculo7 == veiculo8));
	
	
		//sincronizando via commit as transações
	
		
		Veiculo veiculo9 = manager.find(Veiculo.class, 4L);
		System.out.println("Valor atual: " + veiculo9.getValor());
		veiculo9.setValor(veiculo9.getValor().add(new BigDecimal(500)));
		System.out.println("Novo valor: " + veiculo9.getValor());
		
		Veiculo veiculo10 = manager.find(Veiculo.class, 2L);
		System.out.println("Veículo de código " + veiculo10.getCodigo()
		+ " é um " + veiculo10.getModelo());
		
		Query query = manager
				.createQuery("select v from Veiculo v");
				@SuppressWarnings("unchecked")
				List<Veiculo> veiculos = query.getResultList();
		veiculos.forEach(v -> System.out.println(v + " \n"));
		
				for (Veiculo v : veiculos) {
					System.out.println(v.getCodigo() + " - "
					+ v.getFabricante() + " "
					+ v.getModelo() + ", ano "
					+ v.getAnoFabricacao() + "/"
					+ v.getAnoModelo() + " por "
					+ "R$" + v.getValor());
					}

		Veiculo veiculo11 = manager.find(Veiculo.class, 1L);		
		manager.remove(veiculo11);
		
		
		//comando flush executa o update antes do commit
		
		
		Veiculo veiculo12 = manager.find(Veiculo.class, 4L);
		System.out.println("Valor atual: " + veiculo12.getValor());
		veiculo12.setValor(veiculo12.getValor().add(new BigDecimal(500)));
		manager.flush();
		System.out.println("Novo valor: " + veiculo12.getValor());
	
		tx.commit();
		manager.close();
		
		
		//anexando um objeto a um registro do banco
		
		
		veiculo12.setValor(new BigDecimal(112_000));
		manager = JpaUtil.getEntityManager();
		tx = manager.getTransaction();
		tx.begin();
		
		
		// reanexamos o objeto ao novo EntityManager
		
		
		veiculo12 = manager.merge(veiculo12);
		tx.commit();
		manager.close();
		JpaUtil.close();

		
	}

}
