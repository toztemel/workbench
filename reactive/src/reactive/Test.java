package reactive;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) {
    }

    void test() {

        // synchronous blocking call
        Response response = ClientBuilder.newClient()
                .target("http://localhost:5050/service-url")
                .request()
                .get();

        // jax-rs 2.0 aysnch call

        Future<Response> response2 = ClientBuilder.newClient()
                .target("http://localhost:5050/service-url")
                .request()
                .async()
                .get();

        try {
            response2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // jax-rs 2.1
        CompletionStage<Response> response3 = ClientBuilder.newClient()
                .target("http://localhost:5050/service-url")
                .request()
                .rx()
                .get();

        response3.thenAcceptAsync(res -> {
            Temperature t = res.readEntity(Temperature.class);
            // do stuff with t
        });
    }


}
