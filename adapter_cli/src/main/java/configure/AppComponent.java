package configure;

import application.port.ChangeEventDriverPort;
import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    ChangeEventDriverPort getChangeEventDriverPort();
}
