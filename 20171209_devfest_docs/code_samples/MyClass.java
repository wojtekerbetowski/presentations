import io.swagger.client.ApiException;
import io.swagger.client.api.ActivityApi;

public class MyClass {

    void x() throws ApiException {
        ActivityApi activityApi = new ActivityApi();

        activityApi.getSandboxesActivity(
                null,
                null,
                null,
                null,
                null
        );
    }
}
