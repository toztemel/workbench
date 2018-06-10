package reactive;

import java.util.ArrayList;
import java.util.List;

public class ServiceResponse {
    private long processingTime;
    private List<Forecast> forecasts = new ArrayList<>();

    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }

    public ServiceResponse forecasts(List<Forecast> f) {
        this.forecasts = f;
        return this;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }
}


