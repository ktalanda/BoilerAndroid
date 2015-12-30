package pl.k2net.boilerandroid.di;

import dagger.Component;
import pl.k2net.boilerandroid.di.scope.PerActivity;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {}
)
public interface ActivityComponent extends ActivityInjector {
    final class Initializer {
        private Initializer() { }
        public static ActivityComponent init(ApplicationComponent component) {
            return DaggerActivityComponent
                    .builder()
                    .applicationComponent(component)
                    .build();
        }
    }
}
