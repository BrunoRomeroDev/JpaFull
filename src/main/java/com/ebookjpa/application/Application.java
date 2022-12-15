package com.ebookjpa.application;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.ebookjpa.entity.Acessorios;
import com.ebookjpa.entity.Cargos;
import com.ebookjpa.entity.Carro;
import com.ebookjpa.entity.Cliente;
import com.ebookjpa.entity.Condutores;
import com.ebookjpa.entity.Funcionario;
import com.ebookjpa.entity.Gerente;
import com.ebookjpa.entity.Pessoa;
import com.ebookjpa.entity.Proprietario;
import com.ebookjpa.entity.SUV;
import com.ebookjpa.entity.TipoCombustivel;
import com.ebookjpa.entity.Veiculo;
import com.ebookjpa.entity.VeiculoId;
import com.ebookjpa.util.JpaUtil;

public class Application {

	public static void main(String[] args) throws IOException {
		
		
		//cadastrou um novo veiculo
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		Path path = FileSystems.getDefault()
				.getPath("src/main/resources/fotos/fiatpulse.jpg");
				byte[] foto = Files.readAllBytes(path);
		
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Condutores condutor = new Condutores();
		
		condutor.setNome("Juca");
		
		manager.persist(condutor);
		manager.detach(condutor);
		
		Veiculo veiculo1 = new Veiculo();
		
		Proprietario proprietario1 = new Proprietario();
		proprietario1.setNome("João das Couves");
		proprietario1.setTelefone("(34) 1234-5678");
		proprietario1.setEmail("couves@gmail.com");
		
		manager.persist(proprietario1);
		
		// instancia acessórios
		Acessorios roda = new Acessorios();
		roda.setDescricao("Rodas de liga leve");
		Acessorios sensor = new Acessorios();
		sensor.setDescricao("Sensores de estacionamento");
		Acessorios mp3 = new Acessorios();
		mp3.setDescricao("MP3 Player");
		Acessorios pintura = new Acessorios();
		pintura.setDescricao("Pintura metalizada");
		// persiste acessórios
		manager.persist(roda);
		manager.persist(sensor);
		manager.persist(mp3);
		manager.persist(pintura);
		
		veiculo1.setFabricante("Honda");
		veiculo1.setModelo("Civic");
		veiculo1.setAnoFabricacao(2020);
		veiculo1.setAnoModelo(2020);
		veiculo1.setValor(new BigDecimal(90500));
		veiculo1.setCodigo(new VeiculoId("ABC-1234", "Uberlândia"));
		veiculo1.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setProprietario(proprietario1);
		veiculo1.setCondutores(condutor);
		veiculo1.getAcessorios().add(sensor);
		veiculo1.getAcessorios().add(roda);
		
		manager.persist(veiculo1);
		manager.detach(veiculo1);
		
	
		Proprietario proprietario2 = new Proprietario();
		proprietario2.setNome("Maria das Neves");
		proprietario2.setTelefone("(34) 654-987");
		proprietario2.setEmail("Maria@gmail.com");
		
		manager.persist(proprietario2);
		
		Veiculo veiculo2 = new Veiculo();
		
		veiculo2.setFabricante("Fiat");
		veiculo2.setModelo("Toro");
		veiculo2.setAnoFabricacao(2019);
		veiculo2.setAnoModelo(2019);
		veiculo2.setValor(new BigDecimal(12700));
		veiculo2.setCodigo(new VeiculoId("WER-1234", "Sao Paulo"));
		veiculo2.setTipoCombustivel(TipoCombustivel.ALCOOL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.setFoto(foto);
		veiculo2.setProprietario(proprietario2);
		veiculo2.getAcessorios().add(mp3);
		veiculo2.getAcessorios().add(pintura);
		
		manager.persist(veiculo2);
		manager.detach(veiculo2);
		
		
		Veiculo veiculo3 = new Veiculo();
		
		veiculo3.setFabricante("Ford");
		veiculo3.setModelo("Fiesta");
		veiculo3.setAnoFabricacao(2018);
		veiculo3.setAnoModelo(2017);
		veiculo3.setValor(new BigDecimal(54100));
		veiculo3.setCodigo(new VeiculoId("RFG-8763", "Guaruja"));
		veiculo3.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo3.setDataCadastro(new Date());
		veiculo3.setProprietario(proprietario2);
		veiculo3.setCondutores(condutor);
		veiculo3.getAcessorios().add(sensor);
		veiculo3.getAcessorios().add(pintura);
		
		manager.persist(veiculo3);
		manager.detach(veiculo3);
		
		
		Veiculo veiculo4 = new Veiculo();
		
		veiculo4.setFabricante("VW");
		veiculo4.setModelo("Gol");
		veiculo4.setAnoFabricacao(2023);
		veiculo4.setAnoModelo(2023);
		veiculo4.setValor(new BigDecimal(70600));
		veiculo4.setCodigo(new VeiculoId("QWE-953", "Sao vicente"));
		veiculo4.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo4.setDataCadastro(new Date());
		veiculo4.setEspecificacoes(especificacoes.toString());
		veiculo4.getAcessorios().add(sensor);
		veiculo4.getAcessorios().add(pintura);
		
		manager.persist(veiculo4);
		manager.detach(veiculo4);
		
		System.out.println(veiculo1 +"\n"+veiculo2+"\n"+veiculo3+"\n"+veiculo4+"\n");
		
		System.out.println("\n Persisntecia com heranca ---- Single Table");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fernando");
		funcionario.setCargo("Gerente");
		funcionario.setSalario(new BigDecimal(12_000));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setRendaMensal(new BigDecimal(8_500));
		cliente.setLimiteCredito(new BigDecimal(2_000));
		cliente.setBloqueado(true);
		
		Gerente gerente = new Gerente();
		gerente.setDescricao("Gerente comissionado");
		gerente.setNome("Jose alencar");
		gerente.setOcupacao("Gerente de negocios");
		gerente.setSetor("Vendas");
		
		manager.persist(gerente);
		manager.persist(funcionario);
		manager.persist(cliente);
		
		System.out.println(cliente+"\n");
		System.out.println(funcionario+"\n");
		System.out.println(gerente+"\n");
				
		
		List<Pessoa> pessoas = manager
				.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
		for (Pessoa pessoa : pessoas) {
			System.out.print(pessoa.getNome());
			if (pessoa instanceof Cliente) {
				System.out.println(" - é um cliente");
			} else {
				System.out.println(" - é um funcionário");
			}
		}
		
		List<Cargos> cargos = manager
				.createQuery("select c from Cargos c", Cargos.class).getResultList();
		
		cargos.forEach(c -> System.out.println(c));
		
		SUV suv = new SUV();
		suv.setAno(2020);
		suv.setCor("laranja");
		suv.setLugares(7);
		suv.setTamanho(5.43);
		suv.setModelo("long");
		suv.setPreço(123.34);
		
		manager.persist(suv);
		
		List<Carro> listcarro = manager.createQuery("select c from Carro c",Carro.class).getResultList();
		listcarro.forEach(c -> System.out.println(c));
		
		//mostra foto cadastrada
		if (veiculo2.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(
			veiculo2.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(
			new ImageIcon(img)));
			} else {
			System.out.println("Veículo não possui foto.");
			}
		
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
		//veiculos.forEach(v -> System.out.println(v + " \n"));
		
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
		
		
		List<Veiculo> veiculos2 = manager
				.createQuery("select v from Veiculo v", Veiculo.class)
				.getResultList();
				for (Veiculo veiculo : veiculos2) {
				System.out.println(veiculo.getModelo() + " - "
				+ veiculo.getProprietario() == null?veiculo.getProprietario().getNome():" ");
				}
				
		
		System.out.println("-------------------Condutores------------------");
		List<Condutores> Condutores = 	manager
				.createQuery("select c from Condutores c", Condutores.class)
				.getResultList();
				
		//Condutores.forEach(cond->System.out.println(cond+ " \n"));			
	
		for (Condutores v : Condutores) {
			System.out.println(v.getCodigo() + " - "
			+ v.getNome() + " "
			+ v.getCodigo());
			}
		
		
		


		
		manager.close();
		JpaUtil.close();
		
		
	}

}
