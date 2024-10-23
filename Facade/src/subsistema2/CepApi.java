package subsistema2;

public class CepApi {
    private static CepApi cepApi = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getCepApi() {
        return cepApi;
    }
    public String recuperarCidade(String cep){
        return "Uberaba";
    }
    public String recuperarEstado(String cep) {
        return "Minas Gerais";
    }
}
