package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.*;
import com.dcomp.redsaju.domain.enums.Status;
import com.dcomp.redsaju.domain.enums.StatusPag;
import com.dcomp.redsaju.domain.enums.TipoPagamento;
import com.dcomp.redsaju.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ItemProdutoRepository itemProdutoRepository;
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private PagamentoVendaRepository pagamentoVendaRepository;
    @Autowired
    private PagamentoCompraRepository pagamentoCompraRepository;
    @Autowired
    private NotaFiscalVendaRepository notaFiscalVendaRepository;
    @Autowired
    private NotaFiscalCompraRepository notaFiscalCompraRepository;
    @Autowired
    private FornecimentoRepository fornecimentoRepository;

    public void instantiateTestDatabase() throws ParseException {
        Endereco ender1 = new Endereco(null, "logradouro1", "bairro1", "cidade1", "estado1", "complemento1", "cep1");
        Endereco ender2 = new Endereco(null, "logradouro2", "bairro2", "cidade2", "estado2", "complemento2", "cep2");
        Endereco ender3 = new Endereco(null, "logradouro3", "bairro3", "cidade3", "estado3", "complemento3", "cep3");
        enderecoRepository.saveAll(Arrays.asList(ender1, ender2, ender3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cli1 = new Cliente(null, "cliente1", "633.771.490-31",
                "cliente1@gmail.com", sdf.parse("01/01/2000"), "34927349283", ender1);
        clienteRepository.save(cli1);

        Fornecedor forn1 = new Fornecedor(null, "Fornecedor1", "71.414.983/0001-50", "forn1@gmail.com", ender3);
        Fornecedor forn2 = new Fornecedor(null, "Fornecedor2", "64.325.527/0001-79", "forn2@gmail.com", ender2);
        fornecedorRepository.saveAll(Arrays.asList(forn1, forn2));

        Produto prod1 = new Produto(null, "Camisa1", "https://soupain.com.br/image/cache/catalog/UNI%202019/kami-site-1200x1080.png", 150.0, 80.0, "imagine uma descrição aqui");
        Produto prod2 = new Produto(null, "Camisa2", "https://soupain.com.br/image/cache/catalog/UNI%202019/thaiga-site-1200x1080.png", 120.0, 40.0, "imagine uma descrição aqui");
        Produto prod3 = new Produto(null, "Camisa3", "https://soupain.com.br/image/cache/catalog/Casual/Casual-Preta-500x500-04-1200x1080.png", 180.0, 100.0, "imagine uma descrição aqui");
        prod1.setFornecedor(forn1);
        prod1.setFornecedor(forn2);
        prod2.setFornecedor(forn1);
        prod3.setFornecedor(forn2);
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

        Fornecimento fornec1 = new Fornecimento(null, prod2, forn1, new Date(), 5);
        fornecimentoRepository.save(fornec1);

        ItemProduto item1 = new ItemProduto(null, 10, prod1);
        ItemProduto item2 = new ItemProduto(null, 15, prod2);
        ItemProduto item3 = new ItemProduto(null, 8, prod3);
        itemProdutoRepository.saveAll(Arrays.asList(item1, item2, item3));

        Carrinho carr1 = new Carrinho(null, cli1);
        carr1.setItem(item1);
        carr1.setItem(item2);
        carrinhoRepository.save(carr1);

        Funcionario func1 = new Funcionario(null, "Funcionario1", "555.333.440-00");
        Funcionario func2 = new Funcionario(null, "Funcionario2", "444.500.440-08");
        funcionarioRepository.saveAll(Arrays.asList(func1, func2));

        Pedido ped1 = new Pedido(null, func1);
        Pedido ped2 = new Pedido(null, func1);
        Pedido ped3 = new Pedido(null, func2);
        ped1.setItem(item1);
        ped2.setItem(item1);
        ped2.setItem(item2);
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));

        Compra compra1 = new Compra(null, new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), Status.PENDENTE, ped1);
        compraRepository.save(compra1);

        Venda venda1 = new Venda(null, new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), Status.PENDENTE, carr1);
        vendaRepository.save(venda1);

        PagamentoVenda pagVenda1 = new PagamentoVenda(null, new Date(),
                new Date(), TipoPagamento.BOLETO, StatusPag.PENDENTE);
        pagamentoVendaRepository.save(pagVenda1);

        PagamentoCompra pagCompra1 = new PagamentoCompra(null, new Date(),
                new Date(), TipoPagamento.CARTAO, StatusPag.PENDENTE);
        pagamentoCompraRepository.save(pagCompra1);

        NotaFiscalVenda nfVenda1 = new NotaFiscalVenda(null, pagVenda1);
        notaFiscalVendaRepository.save(nfVenda1);

        NotaFiscalCompra nfCompra1 = new NotaFiscalCompra(null, pagCompra1);
        notaFiscalCompraRepository.save(nfCompra1);
    }
}
