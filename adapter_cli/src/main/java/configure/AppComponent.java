package configure;

import adapter.CliDriverAdapter;
import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    CliDriverAdapter getCliDriverAdapter();
}
