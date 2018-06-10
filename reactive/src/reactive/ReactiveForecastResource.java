package reactive;

import org.glassfish.jersey.server.Uri;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@Path("/reactiveForecast")
public class ReactiveForecastResource {

    @Uri("location")
    private WebTarget locationTarget;

    @Uri("temperature/{city}")
    private WebTarget temperatureTarget;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getLocationsWithTemperature(@Suspended final AsyncResponse async) {

        long startTime = System.currentTimeMillis();

        // Create a stage on retrieving locations
        CompletionStage<List<Location>> locationCS = locationTarget
                .request()
                .rx()
                .get(new GenericType<List<Location>>() {});

        final CompletionStage<List<Forecast>> forecastCS = locationCS.thenCompose(
                locations -> {

                    List<CompletionStage<Forecast>> forecastList = locations.stream().map(
                            location -> {

                                final CompletionStage<Temperature> tempCS =
                                        temperatureTarget
                                                .resolveTemplate("city", location.getName())
                                                .request()
                                                .rx()
                                                .get(Temperature.class);

                                return CompletableFuture
                                        .completedFuture(new Forecast(location))
                                        .thenCombine(tempCS, Forecast::setTemperature);

                            }).collect(Collectors.toList());

                    return CompletableFuture.allOf(forecastList.toArray(new CompletableFuture[forecastList.size()]))
                            .thenApply(
                                    v -> forecastList
                                            .stream()
                                            .map(CompletionStage::toCompletableFuture)
                                            .map(CompletableFuture::join)
                                            .collect(Collectors.toList()));
                });

        CompletableFuture.completedFuture(new ServiceResponse())
                .thenCombine(forecastCS, ServiceResponse::forecasts)
                .whenCompleteAsync(
                        (response, throwable) -> {
                            response.setProcessingTime(System.currentTimeMillis() - startTime);
                            async.resume(response);
                        });

    }
}
