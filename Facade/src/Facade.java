import subsistema1.CrmService;
import subsistema2.CepApi;

public class Facade {
    public void migrarCliente(String nome, String cep){
        var cidade = CepApi.getCepApi().recuperarCidade(cep);
        var estado = CepApi.getCepApi().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
