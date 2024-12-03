package dad.api;

import retrofit2.Call;
import retrofit2.Response;

public class Prueba {

    public static void main(String[] args) {
//        ApiService apiService = RetrofitClient.getApiService();
//
//        // Llamada al endpoint con parámetros
//        Call<HipotecaResponse> call = ApiService.calcularHipoteca(100000, 5, 20);
//
//        try {
//            Response<HipotecaResponse> response = call.execute(); // Llamada síncrona
//            if (response.isSuccessful() && response.body() != null) {
//                HipotecaResponse hipotecaResponse = response.body();
//
//                System.out.println("Capital: " + hipotecaResponse.hipoteca.capital);
//                System.out.println("Interés: " + hipotecaResponse.hipoteca.interes);
//                System.out.println("Plazos: " + hipotecaResponse.hipoteca.plazos);
//
//                for (HipotecaResponse.Cuota cuota : hipotecaResponse.cuotas) {
//                    System.out.println("Cuota " + cuota.numero + ": " +
//                            "Capital Inicial: " + cuota.capitalInicial +
//                            ", Intereses: " + cuota.intereses +
//                            ", Capital Amortizado: " + cuota.capitalAmortizado +
//                            ", Pendiente: " + cuota.capitalPendiente);
//                }
//            } else {
//                System.err.println("Error: " + response.errorBody().string());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}