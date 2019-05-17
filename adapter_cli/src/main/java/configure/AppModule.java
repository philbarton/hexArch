package configure;

import adapter.StdOutDrivenAdapter;
import application.ChangeProcessor;
import application.port.ChangeEventDriverPort;
import application.port.StateChangeDrivenPort;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    ChangeEventDriverPort providesChangeEventDriverPort(ChangeProcessor changeProcessor) {
        return changeProcessor;
    }

    @Provides
    StateChangeDrivenPort providesStateChangeDrivenPort() {
        return new StdOutDrivenAdapter();
    }
}
