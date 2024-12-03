package dad.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/hipoteca")
    Call<HipotecaResponse> calcularHipoteca(
            @Query("capital") double capital,
            @Query("interes") double interes,
            @Query("plazo") int plazo
    );
}